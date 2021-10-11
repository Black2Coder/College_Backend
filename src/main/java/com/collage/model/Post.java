package com.collage.model;

import java.time.LocalDateTime;

public class Post {
	

	private Integer postId;
	private String title;
	private String description;
//	private String docName;
//	private long size;
//	private byte[] content;
	private LocalDateTime posetedOn;
	
	
	public Integer getPostId() {
		return postId;
	}
	public void setPostId(Integer postId) {
		this.postId = postId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
//	public String getDocName() {
//		return docName;
//	}
//	public void setDocName(String docName) {
//		this.docName = docName;
//	}
//	public long getSize() {
//		return size;
//	}
//	public void setSize(long size) {
//		this.size = size;
//	}
//	public byte[] getContent() {
//		return content;
//	}
//	public void setContent(byte[] content) {
//		this.content = content;
//	}
	public LocalDateTime getPosetedOn() {
		return posetedOn;
	}
	public void setPosetedOn(LocalDateTime posetedOn) {
		this.posetedOn = posetedOn;
	}
}
