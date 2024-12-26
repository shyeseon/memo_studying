package com.example.speedrun.memo.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
	public String member_id;
	
	public String member_pw;
}
