package com.lamda.web.soccer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// jpa 구조를 따른다.
@Repository
public interface PlayerRepository extends JpaRepository<Player,Long> {

}