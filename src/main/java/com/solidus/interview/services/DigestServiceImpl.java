package com.solidus.interview.services;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Service;

@Service
public class DigestServiceImpl implements DigestService{
public String getMessageDigest(String message) {
		
		MessageDigest digest = null;
		StringBuffer hexString = null;
		   
		try {
			digest = MessageDigest.getInstance("SHA-256");
		
			byte[] encodedhash = digest.digest(
			   message.getBytes(StandardCharsets.UTF_8));
			       
		   hexString = new StringBuffer();
		   for (int i = 0; i < encodedhash.length; i++) {
			   String hex = Integer.toHexString(0xff & encodedhash[i]);
			   if(hex.length() == 1) hexString.append('0');
			       hexString.append(hex);
		   }
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return hexString.toString();
	}

}
