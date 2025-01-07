package com.example.speedrun.memo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.speedrun.memo.model.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {


}
