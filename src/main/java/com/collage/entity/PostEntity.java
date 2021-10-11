package com.collage.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="post")
public class PostEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer postId;
	private String title;
	private String description;
//	private String docName;
//	private long size;
//	private byte[] content;
	private LocalDateTime postedOn;
	
	
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
	public LocalDateTime getPostedOn() {
		return postedOn;
	}
	public void setPostedOn(LocalDateTime posetedOn) {
		this.postedOn = posetedOn;
	}
	
	
	
}
