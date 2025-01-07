package com.example.speedrun.memo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.speedrun.memo.model.Member;
import com.example.speedrun.memo.repository.MemberRepository;

import jakarta.transaction.Transactional;

@Service
public class MemberService {
	
	@Autowired
	private MemberRepository memberRepo;

	@Transactional
	public void saveMember1(Member member) {
		memberRepo.save(member);
	
	}
}
