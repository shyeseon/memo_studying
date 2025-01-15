package com.example.speedrun.memo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.speedrun.memo.dto.MemoRequestDto;
import com.example.speedrun.memo.dto.MemoResponseDto;
import com.example.speedrun.memo.dto.MemoUpdateDto;
import com.example.speedrun.memo.service.BoardService;
import com.example.speedrun.memo.service.MemberService;

import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/api")
@Slf4j
public class MemoController {
	
	private final BoardService boardService;

	public MemoController(BoardService boardService,MemberService memberService) {
		this.boardService = boardService;
	}
 
	
	@PostMapping("/memos")
	public MemoResponseDto createMemo(@RequestBody MemoRequestDto requestDto) {
		return boardService.createMemo(requestDto);
		
	}
	@GetMapping("/memos")
	public List<MemoResponseDto> getMemos() {
		return boardService.getMemo();
	}
	
	@PutMapping("/memos/{id}")
	public void updateMemo(@RequestBody MemoUpdateDto requestDto) {
		boardService.updateMemo(requestDto);
	}

	@DeleteMapping("/memos/{id}")
	public void deleteMemo(@PathVariable("id") Long id) {
		boardService.deleteMemo(id);
	}


	
	

	
	

}
