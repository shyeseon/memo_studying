package com.example.speedrun.memo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.speedrun.memo.dto.MemberRequestDto;
import com.example.speedrun.memo.dto.MemberResponseDto;
import com.example.speedrun.memo.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j
public class MemberController {
	
	private final MemberService memberService;
	
	public MemberController(MemberService memberService) {
		this.memberService=memberService;
	}
	
	public ResponseEntity<?> createMem(MemberRequestDto dto) {
		
		return ResponseEntity.ok().body("회원가입에 성공하셨습니다");
	}
	
}
