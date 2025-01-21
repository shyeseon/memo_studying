package com.example.speedrun.memo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.speedrun.memo.dto.MemberRequestDto;
import com.example.speedrun.memo.model.Member;
import com.example.speedrun.memo.repository.MemberRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;


@Service
public class MemberService {
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private MemberRepository memberRepo;

	@Transactional
	public void saveMember1(Member member) {
		memberRepo.save(member);
	
	}

	public boolean findmem(MemberRequestDto dto) {
		Member member = memberRepo.findByMemberId(dto.getMemberId()).orElseThrow(()-> new EntityNotFoundException("존재하는 계정이 없습니다."));	
		return passwordEncoder.matches( dto.getMemberPw(), member.getMemberPw());
		
	}

	public void createMem(MemberRequestDto dto) {
		Member member = new Member();
		member.setMemberId(dto.getMemberId());
		member.setMemberName(dto.getMemberName());
		System.out.println("bfencode"+dto.getMemberPw());
		String encodePassword = passwordEncoder.encode(dto.getMemberPw());
		member.setMemberPw(encodePassword);
		memberRepo.save(member);
	}
}
