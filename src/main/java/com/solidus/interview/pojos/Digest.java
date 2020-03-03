package com.solidus.interview.pojos;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@Data
public class Digest {
	public String digest;
	
	public Digest() {
		
	}
	
	public Digest(String digest) {
		this.digest = digest;
	}

}