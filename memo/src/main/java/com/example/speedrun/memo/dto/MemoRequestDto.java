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
public class MemoRequestDto {
	private Long id;
	private String username;
	private String title;
	private String contents;
	
	public static MemoRequestDto EntityToRequestDto(Board board) {
		return MemoRequestDto.builder()
				.id(board.getBoard_id())
				.title(board.getTitle())
				.contents(board.getBoard_content())
				.build();
	}
	

}
