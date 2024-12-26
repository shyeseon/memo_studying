package com.example.speedrun.memo.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.speedrun.memo.dto.MemoRequestDto;
import com.example.speedrun.memo.dto.MemoResponseDto;
import com.example.speedrun.memo.model.Board;
import com.example.speedrun.memo.repository.BoardRepository;

public class BoardService {
	
	@Autowired
	private BoardRepository boardRepo;

	public MemoResponseDto createMemo(MemoRequestDto requestDto) {
		Board result = boardRepo.save(Board.RequestDtotoEntity(requestDto));
		return board.ResponseDtotoEntity(result);
	}

}
