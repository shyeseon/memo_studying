package com.example.speedrun.memo.model;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import com.example.speedrun.memo.dto.MemoRequestDto;
import com.example.speedrun.memo.dto.MemoResponseDto;
import com.example.speedrun.memo.dto.MemoUpdateDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Board implements Serializable {

	 @ManyToOne(cascade = CascadeType.PERSIST)  // Lazy 로딩 적용
	 @JoinColumn( referencedColumnName = "member_name" ) //조인하고자 하는 컬럼명 
	private Member member;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="board_id")
	private Long boardId;
	
	private String title;
	
	private String board_content;
	
	@CreationTimestamp
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="created_at")
	private Date createdAt;

	  
	@Builder
	public Board (Long id, String title, String content, String userName,Date createdAt) {
		this.boardId=id;
		this.title = title;
		this.board_content = content;
		this.member = new Member(userName);
		this.createdAt = createdAt;
	}
	 public static Board RequestDtotoEntity(MemoRequestDto dto) {
	        return Board.builder()
	        		.id(dto.getId())
	        		.title(dto.getTitle())
	        		.content(dto.getContents())
	        		.userName(dto.getUserName())
	        		.createdAt(dto.getCreatedAt())
	                .build();
	    }
	 public static Board ResponseDtotoEntity(MemoResponseDto dto) {
	        return Board.builder()
	        		.id(dto.getId())
	        		.title(dto.getTitle())
	        		.content(dto.getContents())
	        		.userName(dto.getUsername())
	        		.createdAt(dto.getCreatedAt())
	                .build();
	    }
	 public static Board updateDtotoEntity(MemoUpdateDto dto) {
		 return Board.builder()
				 .title(dto.getTitle())
				 .content(dto.getContents())
				 .build();
	 }
	
	
}
