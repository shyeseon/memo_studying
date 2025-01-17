package com.example.speedrun.memo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.speedrun.memo.dto.MemberRequestDto;
import com.example.speedrun.memo.model.Member;
import com.example.speedrun.memo.repository.MemberRepository;

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
		Member member = memberRepo.findByMemberId(dto.getMemberId()).orElseThrow();

		System.out.println("member"+member);
		if(member.getId()==null) {
			return false;
		}
		System.out.println("id"+member.getId());
		return passwordEncoder.matches(member.getMemberPw(), dto.getMemberPw());
	}

	public void createMem(MemberRequestDto dto) {
		Member member = new Member();
		member.setMemberId(dto.getMemberId());
		member.setMemberName(dto.getMemberName());
		String encodePassword = passwordEncoder.encode(dto.getMemberPw());
		member.setMemberPw(encodePassword);
		memberRepo.save(member);
	}
}
