package com.codecool.userhandlerservice.repository;

import com.codecool.userhandlerservice.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, String> {
}
