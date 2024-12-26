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
public class MemoRequestDto {
	private Long id;
	private String username;
	private String contents;
	
	public static MemoRequestDto EntityToRequestDto(Board board) {
		return MemoRequestDto.builder()
				.id(board.getBoard_id())
				.username(board.getMember_id())
				.contents(board.getBoard_content())
				.build();
	}
	

}
