package com.example.speedrun.memo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.speedrun.memo.dto.MemoRequestDto;
import com.example.speedrun.memo.dto.MemoResponseDto;
import com.example.speedrun.memo.model.Member;
import com.example.speedrun.memo.service.BoardService;
import com.example.speedrun.memo.service.MemberService;

import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/api")
@Slf4j
public class MemoController {
	
	private final BoardService boardService;
	private final MemberService memberService;

	public MemoController(BoardService boardService,MemberService memberService) {
		this.boardService = boardService;
		this.memberService = memberService;
	}
 
	
	@PostMapping("/memos")
	public MemoResponseDto createMemo(@RequestBody MemoRequestDto requestDto) {
		return boardService.createMemo(requestDto);
		
	}
	@GetMapping("/memos")
	public List<MemoResponseDto> getMemos() {
	// Map To List
	List<MemoResponseDto> responseList = boardService.getMemo();
	//List<MemoResponseDto> responseList = memoList.values().stream().map(MemoResponseDto::new).toList();
	return responseList;
	}
	
//	@PutMapping("/memos/{id}")
//	public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
//	// 해당 메모가 DB에 존재하는지 확인
//	if(memoList.containsKey(id)) {
//	// 해당 메모 가져오기
//	Memo memo = memoList.get(id);
//	// memo 수정
//	memo.update(requestDto);
//	return memo.getId();
//	} else {
//	throw new IllegalArgumentException("선택한 메모는 존재하지 않습니다.");
//	}
//	}
//	
//	@DeleteMapping("/memos/{id}")
//	public Long deleteMemo(@PathVariable Long id) {
//	// 해당 메모가 DB에 존재하는지 확인
//	if(memoList.containsKey(id)) {
//	// 해당 메모 삭제하기
//	memoList.remove(id);
//	return id;
//	} else {
//	throw new IllegalArgumentException("선택한 메모는 존재하지 않습니다.");
//	}
//	}


	
	

	
	

}
