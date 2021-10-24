package com.collage.api;

import java.io.IOException;
import java.security.Principal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;




import com.collage.dto.GroupUserRepository;
import com.collage.model.AuthRequest;
import com.collage.model.TokenResponse;
import com.collage.service.GroupUserDetailService;
import com.collage.utility.AccessRole;
import com.collage.utility.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.collage.dto.PostRepo;
import com.collage.dto.UserRepo;
import com.collage.entity.PostEntity;
import com.collage.entity.Users;
import com.collage.exception.ErrorInfo;
import com.collage.exception.ExceptionHandlerAdvice;

import com.collage.model.Post;
import com.collage.model.User;
import com.collage.service.UserService;


@CrossOrigin(origins="http://localhost:4200")
@RestController
 
public class UserApi {


	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepo repo;
	@Autowired
	private GroupUserRepository groupRepo;
	@Autowired
	private GroupUserDetailService groupUserDetailService;
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	Environment environment;
	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private AuthenticationManager authManager;

	@RequestMapping(value="/userLogin", method = RequestMethod.POST)
	public ResponseEntity<User> authenticateUser(@RequestBody User user){
		try {
			System.out.println("Mobile --"+ user.getContact());
			User userDB = userService.authenticateUser(user.getContact(), user.getPassword());
			
			return new  ResponseEntity<User>(userDB, HttpStatus.OK);
		}
		catch(Exception e){
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, (e.getMessage()));
		}
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public ResponseEntity<?> loginUser(@RequestBody User user) throws Exception{
		
		if(user.getContact() ==null && user.getPassword()==null ) {
//			throw new Exception("Contact or password cann't be null");
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Contact or password cann't be null");
		}
		else {
			System.out.println(user.getPassword());
		Users userDB = userService.loginUser(user.getContact(), user.getPassword());
		String token = jwtUtil.generateToken(user.getContact());
		return ResponseEntity.ok(new TokenResponse(token));
		}
	}
	
	@RequestMapping(value= "register", method = RequestMethod.POST)
	public ResponseEntity<String> registerUser(@RequestBody User user) throws ExceptionHandlerAdvice{
		
		try {

			if(user.getUserName()==null && user.getEmailId()==null && user.getContact()==null && user.getPassword()==null) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Fields Cann't be null");
			}
			user.setRoles(AccessRole.DEFAULT_ROLE);
			String userName = userService.registerUser(user);
			String msg = "Hi  "+userName+"  You have registered Successfully";
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		}
		catch(ResponseStatusException  e)
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, (e.getMessage()));

		}
		catch(Exception e){
			System.out.println("Exception");
			System.out.println((e.getMessage()));
			ErrorInfo error = new ErrorInfo();
			error.setErrorCode(HttpStatus.ALREADY_REPORTED.value());
			throw new ResponseStatusException(HttpStatus.ALREADY_REPORTED, environment.getProperty(e.getMessage()));
		}
		
	}

	private  List<String> geRolesByLoggedUser(Principal principal){
		String roles = getLoggedInUser(principal).getRoles();
		List<String> assignRoles = Arrays.stream(roles.split(",")).collect(Collectors.toList());
		if(assignRoles.contains("ROLE_ADMIN")){
			return Arrays.stream(AccessRole.ADMIN_ACCESS).collect(Collectors.toList());
		}
		if(assignRoles.contains("ROLE_MODERATOR")){
			return Arrays.stream(AccessRole.MODERATOR_ACCESS).collect(Collectors.toList());
		}
		return Collections.emptyList();
	}
	private Users getLoggedInUser(Principal principal){
		return groupRepo.findByContact(principal.getName()).get();
	}

	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@RequestMapping(value= "data", method = RequestMethod.GET)
	public List<Users> findAll(Principal p) throws Exception {
		try {
			System.out.println("======= " + p.getName());
			return repo.findAll();
		}
		catch(Exception ex){
			System.out.println("======= " + p.getName());
			ex.printStackTrace();
			System.out.println("====================");
			throw new Exception("Access Denied");
		}
	}
	
	
	@RequestMapping(value= "post", method = RequestMethod.GET)
	public List<PostEntity> getPost(){
		return postRepo.findAll();
	}

	@RequestMapping(value="post", method=RequestMethod.POST)
	public ResponseEntity<String> post(@RequestBody Post post) throws IOException {
		
		try {
			System.out.println(post.getTitle());
			System.out.println(post.getDescription());
			String userName = userService.post(post);
			String msg = "Posted Successfully";
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		}
		
		catch(Exception e){
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, environment.getProperty(e.getMessage()));
		}
	}
	
	@RequestMapping(value= "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> generateToken(@RequestBody AuthRequest auth) throws Exception {
		try{
			authManager.authenticate(
					new UsernamePasswordAuthenticationToken(auth.getContact(),auth.getPassword())
			);
		}
		catch (Exception ex){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Contact/Password");
		}
		
		String token = jwtUtil.generateToken(auth.getContact());
		return ResponseEntity.ok(new TokenResponse(token));
	}
	
	@RequestMapping(value="/current-user", method=RequestMethod.GET)
	public Users getLoggedUser(Principal principal) {
		
		UserDetails userDetails= this.groupUserDetailService.loadUserByUsername(principal.getName());
		
		Users user =repo.findByContact(principal.getName());
		
		return user;
	}
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public List<Users> home() {
		
		return repo.findAll();
	}
	 
	@RequestMapping("/")
	public String index() {
		return "index"; 
	}
}
