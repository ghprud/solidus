package com.solidus.interview.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class MsgDigest {
	
	private @Id @GeneratedValue Long id;
	private String message;
	private String digest;
	
	MsgDigest(){
		
	}
	
	public MsgDigest(String message, String digest){
		this.setMessage(message);
		this.setDigest(digest);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDigest() {
		return digest;
	}

	public void setDigest(String digest) {
		this.digest = digest;
	}
	
	
}
