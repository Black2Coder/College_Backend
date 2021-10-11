package com.collage.unofficial;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import com.collage.dto.UserDAO;
import com.collage.entity.PostEntity;





@DataJpaTest
//@SpringBootTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class UnofficialApplicationTests {
	
	@Autowired
	private UserDAO userService;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testDocument() throws IOException {
		File file = new File("D:\\Download\\axis.pdf");
		
		PostEntity post = new PostEntity();
//		post.setDocName(file.getName());
//		
//		byte[] bytes = Files.readAllBytes(file.toPath());
//		post.setContent(bytes);
//		long fileSize = bytes.length;
//		post.setSize(fileSize);
		
//		Post savePost = userService.save(post);
		
//		Post p1 = entityManager.find(Post.class, savePost.getPostId());
		
//		assertThat(p1.getSize()).isEqualTo(fileSize);
		
		
	}

}
