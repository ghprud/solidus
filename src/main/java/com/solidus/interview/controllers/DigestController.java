package com.solidus.interview.controllers;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.solidus.interview.entities.MsgDigest;
import com.solidus.interview.exceptions.MessageNotFoundException;
import com.solidus.interview.pojos.Digest;
import com.solidus.interview.pojos.Message;
import com.solidus.interview.repositories.MsgDigestRepository;
 
@SuppressWarnings("unused")
@RestController
public class DigestController 
{
	
   @Autowired
   private MsgDigestRepository repository;
   
   //support for one message or lot of messages
   @PostMapping(path = "/messages", consumes = "application/json", produces = "application/json")
   @ResponseBody
   public Digest getFoos(@RequestBody Message message){
       MessageDigest digest = null;
       System.out.println("message 1" + message.getMessage());
       StringBuffer hexString = null;
       
		try {
			digest = MessageDigest.getInstance("SHA-256");
			
			byte[] encodedhash = digest.digest(
			   message.getMessage().getBytes(StandardCharsets.UTF_8));
			       
	       hexString = new StringBuffer();
	       for (int i = 0; i < encodedhash.length; i++) {
	       String hex = Integer.toHexString(0xff & encodedhash[i]);
	       if(hex.length() == 1) hexString.append('0');
	           hexString.append(hex);
	       }
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		MsgDigest digest2 = new MsgDigest(message.getMessage(),hexString.toString() );
		    
	    repository.save(digest2);
	    
	    Digest digest3 = new Digest(hexString.toString());
		return digest3;
   }
   
   
   @GetMapping("/messages/{digest}")
   public Message one(@PathVariable String digest) {
	   System.out.println("digest: " + digest);
	   MsgDigest test = repository.findByDigest(digest);
	   
	   if (test == null) {
		   throw new MessageNotFoundException(digest);
	   }
	   
	   System.out.println(test.toString());
	  
	   return new Message(test.getMessage());
   }
   
}