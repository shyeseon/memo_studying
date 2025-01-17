package com.example.speedrun.memo.model;

import java.io.Serializable;
import java.util.List;

import com.example.speedrun.memo.dto.MemberRequestDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Builder
public class Member implements Serializable {

	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	@Column(name="id")
	public Long id;
	
	@Column(name = "member_id", unique=true)
	public String memberId;
	
	@Column(name = "member_name")
	public String memberName;
	
	@Column(name="member_pw")
	public String memberPw;
	
	@OneToMany
	public List<Board> boards;
	
	public Member(Long id, String memberId, String memberName, String memberPw) {
		this.id=id;
		this.memberId = memberId;
		this.memberName = memberName;
		this.memberPw = memberPw;
	}
	
	public Member(String userName) {
		this.memberName = userName;
	}
	public static  MemberRequestDto toEntity(MemberRequestDto dto) {
		return MemberRequestDto.builder()
				.memberId(dto.getMemberId())
				.memberName(dto.getMemberName())
				.memberPw(dto.getMemberPw())
				.build();
	}
}
