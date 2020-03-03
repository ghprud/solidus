package com.solidus.interview.repositories;

import com.solidus.interview.entities.MsgDigest;

public interface MDigestRepository{
	MsgDigest findByDigest(String digest);
}
