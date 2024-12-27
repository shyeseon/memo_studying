package com.example.speedrun.memo.model;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.annotations.CurrentTimestamp;

import com.example.speedrun.memo.dto.MemoRequestDto;
import com.example.speedrun.memo.dto.MemoResponseDto;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Builder
public class Board implements Serializable {

	 @ManyToOne(fetch = FetchType.LAZY)  // Lazy 로딩 적용
	 @JoinColumn(name = "member_name")
	private Member member;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long board_id;
	
	private String title;
	
	private String board_content;
	
	@CurrentTimestamp
	private Date created_at;

	 public static Board RequestDtotoEntity(MemoRequestDto dto, Member member) {
	        return Board.builder()
	        		.board_id(dto.getId())
	        		.board_content(dto.getContents())
	        		.member(member)
	                .build();
	    }
	 public static Board ResponseDtotoEntity(MemoResponseDto dto) {
	        return Board.builder()
	        		.board_id(dto.getId())
	        		.board_content(dto.getContents())
	                .build();
	    }
	
	
}
