package com.example.speedrun.memo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.speedrun.memo.dto.MemoRequestDto;
import com.example.speedrun.memo.dto.MemoResponseDto;
import com.example.speedrun.memo.model.Board;
import com.example.speedrun.memo.model.Member;
import com.example.speedrun.memo.repository.BoardRepository;
import com.example.speedrun.memo.repository.MemberRepository;

@Service
public class BoardService {
	
	@Autowired
	private BoardRepository boardRepo;
	
	@Autowired
	private MemberRepository memberRepo;
	

	public MemoResponseDto createMemo(MemoRequestDto requestDto) {
		Optional<Member> member = memberRepo.findByMemberName(requestDto.getUsername());
		
		if(member.isPresent()) {
			Board result = boardRepo.save(Board.RequestDtotoEntity(requestDto,member.get()));
		     return boardRepo.save(result);
        } else {
            throw new IllegalArgumentException("Member not found with name: " + requestDto.getUsername());
        }
	}

	public List<MemoResponseDto> getMemo() {
		return boardRepo.findAll().stream().map(MemoResponseDto::EntityToResponseDto).collect(Collectors.toList());
	}

}
