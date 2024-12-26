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
@Builder
@ToString
@AllArgsConstructor

public class Board implements Serializable {

	 @ManyToOne(fetch = FetchType.LAZY)  // Lazy 로딩 적용
	 @JoinColumn(name = "member_id")
	private String member_id;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long board_id;
	
	private String board_content;
	
	
	@CurrentTimestamp
	private Date created_at;
	
	 public static Board RequestDtotoEntity(MemoRequestDto dto) {
	        return Board.builder()
	        		.board_id(dto.getId())
	        		.board_content(dto.getContents())
	        		.member_id(dto.getUsername())
	                .build();
	    }
	 public static Board ResponseDtotoEntity(MemoResponseDto dto) {
	        return Board.builder()
	        		.board_id(dto.getId())
	        		.board_content(dto.getContents())
	        		.member_id(dto.getUsername())
	                .build();
	    }
	
	
}
