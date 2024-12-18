package com.example.speedrun.memo.entity;

import com.example.speedrun.memo.dto.MemoRequestDto;
import com.example.speedrun.memo.dto.MemoResponseDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Memo {
	private Long id;
	private String username;
	private String contents;
	
	   public Memo(MemoRequestDto memoRequestDto) {
	        this.username = memoRequestDto.getUsername();
	        this.contents = memoRequestDto.getContents();
	    }
	   
	   public Memo(MemoResponseDto memoResponseDto) {
		   	this.id = memoResponseDto.getId();
	        this.username = memoResponseDto.getUsername();
	        this.contents = memoResponseDto.getContents();
	    }
	   public void update(MemoRequestDto requestDto) {
		   this.username = requestDto.getUsername();
		   this.contents = requestDto.getContents();
		   }

	   

}
