package com.example.speedrun.memo.model;

import java.io.Serializable;
import java.util.List;

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
import lombok.ToString;

@Entity
@Getter
@NoArgsConstructor
@Builder
@ToString
@AllArgsConstructor

public class Member implements Serializable {

	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	@Column(name="member_id")
	public Long memberId;
	
	@Column(name = "member_name")
	public String memberName;
	
	@Column(name="member_pw")
	public String memberPw;
	
	@OneToMany
	public List<Board> boards;
}
