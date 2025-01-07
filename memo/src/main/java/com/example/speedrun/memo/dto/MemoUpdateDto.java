package com.example.speedrun.memo.dto;

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
public class MemoUpdateDto {

	private Long id;
	private String title;
	private String contents;
		


}
