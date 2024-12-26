package com.example.speedrun.memo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.speedrun.memo.model.Member;

public interface MemberRepository extends JpaRepository<Member, String> {

}
