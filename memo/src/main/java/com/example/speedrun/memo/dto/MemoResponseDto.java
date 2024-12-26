package com.example.speedrun.memo.dto;

import com.example.speedrun.memo.model.Board;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@NoArgsConstructor
@Builder
@ToString
@AllArgsConstructor

public class MemoResponseDto {

	private Long id;
	private String username;
	private String contents;
	
	
	public static MemoResponseDto EntityToResponseDto(Board board) {
		return MemoResponseDto.builder()
				.id(board.getBoard_id())
				.username(board.getMember_id())
				.contents(board.getBoard_content())
				.build();
	}
	
	
}
