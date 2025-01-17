package com.example.speedrun.memo.dto;

import java.util.Date;

import com.example.speedrun.memo.model.Member;

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
public class MemberRequestDto {

	private String memberId;
	private String memberName;
	private String memberPw;
	
	

}
