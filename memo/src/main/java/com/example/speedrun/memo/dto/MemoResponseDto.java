package com.example.speedrun.memo.dto;

import com.example.speedrun.memo.model.Board;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Getter
@NoArgsConstructor
@Builder
@ToString
@AllArgsConstructor

public class MemoResponseDto {

	private Long id;
	private String username;
	private String title;
	private String contents;
	
	
	public static MemoResponseDto EntityToResponseDto(Board board) {
		return MemoResponseDto.builder()
				.id(board.getBoard_id())
				.title(board.getTitle())
				.contents(board.getBoard_content())
				.build();
	}
	
	
}
