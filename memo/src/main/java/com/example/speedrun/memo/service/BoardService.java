package com.example.speedrun.memo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.speedrun.memo.dto.MemoRequestDto;
import com.example.speedrun.memo.dto.MemoResponseDto;
import com.example.speedrun.memo.dto.MemoUpdateDto;
import com.example.speedrun.memo.model.Board;
import com.example.speedrun.memo.model.Member;
import com.example.speedrun.memo.repository.BoardRepository;
import com.example.speedrun.memo.repository.MemberRepository;

import jakarta.transaction.Transactional;

@Service
public class BoardService {
	
	@Autowired
	private BoardRepository boardRepo;
	
	@Autowired
	private MemberRepository memberRepo;
	

	@Transactional
	public MemoResponseDto createMemo(MemoRequestDto requestDto) {
		// 기존 Member 조회
	    Member existingMember = memberRepo.findById(1L).get();
	    
	    // Memo에 기존 Member 설정
	    if(existingMember.memberId==null) {
	    	throw new IllegalArgumentException("존재하지 않는 사용자입니다.");
	    }
	    Board result = Board.RequestDtotoEntity(requestDto);
		result.setMember(existingMember);
		
	    return MemoResponseDto.EntityToResponseDto(boardRepo.save(result));	
		
	}

	public List<MemoResponseDto> getMemo() {
		List<MemoResponseDto> response = boardRepo.findAll().stream().map(MemoResponseDto::EntityToResponseDto).collect(Collectors.toList());
		return response;
	}


	@Transactional
	public void updateMemo(MemoUpdateDto requestDto) {
		Board board = boardRepo.findById(requestDto.getId()).orElseThrow(()-> new IllegalArgumentException("메모를 찾을 수 없습니다."));
		board.setTitle(requestDto.getTitle());
		board.setBoard_content(requestDto.getContents());
		boardRepo.save(board);
	}

	public void deleteMemo(Long id) {
		Board board = boardRepo.findById(id).orElseThrow(()-> new IllegalArgumentException("메모를 찾을 수 없습니다."));
		boardRepo.delete(board);
	}

}
