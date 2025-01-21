package com.example.speedrun.memo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.speedrun.memo.dto.MemberRequestDto;
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
	
	@RequestMapping("/login")
	public ResponseEntity<?> login(@RequestBody MemberRequestDto dto) {
		boolean exist = memberService.findmem(dto);
		return exist? "success":"fail";
	}
	@RequestMapping("/signUp")
	public void signUp(@RequestBody MemberRequestDto dto) {
		memberService.createMem(dto);
	}
	
}
