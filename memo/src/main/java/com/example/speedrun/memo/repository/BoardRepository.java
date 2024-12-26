package com.example.speedrun.memo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.speedrun.memo.model.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {

}
