package com.example.speedrun.memo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.speedrun.memo.model.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {


}
