package com.codecool.characterhandlerservice.repository;

import com.codecool.characterhandlerservice.model.GameCharacter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CharacterRepository extends JpaRepository<GameCharacter, Long> {

    Optional<GameCharacter> getCharacterByUserId(Long userId);

}
