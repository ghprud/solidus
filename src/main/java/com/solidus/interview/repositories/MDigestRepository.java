package com.solidus.interview.repositories;

import com.solidus.interview.entities.MsgDigest;
import java.util.List;

public interface MDigestRepository{
	MsgDigest findByDigest(String digest);
	List<MsgDigest> findListByDigest(String digest);
}
