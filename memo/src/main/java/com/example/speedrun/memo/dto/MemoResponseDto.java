package com.example.speedrun.memo.dto;

import java.util.Date;

import com.example.speedrun.memo.model.Board;

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
	private Date createdAt;
	
	public static MemoResponseDto EntityToResponseDto(Board board) {
		return MemoResponseDto.builder()
				.id(board.getBoardId())
				.username(board.getMember().getMemberName())
				.title(board.getTitle())
				.contents(board.getBoard_content())
				.createdAt(board.getCreatedAt())
				.build();
	}
	
}
