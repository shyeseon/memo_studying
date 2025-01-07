package com.example.speedrun.memo.dto;

import java.util.Date;

import com.example.speedrun.memo.model.Board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@NoArgsConstructor
@Builder
@ToString
@AllArgsConstructor
@Setter
public class MemoRequestDto {
	private Long id;
	private String title;
	private String userName;
	private String contents;
	private Date createdAt;
	
	public static MemoRequestDto EntityToRequestDto(Board board) {
		return MemoRequestDto.builder()
				.id(board.getBoardId())
				.title(board.getTitle())
				.contents(board.getBoard_content())
				.createdAt(board.getCreatedAt())
				.build();
	}
	

}
