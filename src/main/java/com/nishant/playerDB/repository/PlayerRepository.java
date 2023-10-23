package com.nishant.playerDB.repository;

import com.nishant.playerDB.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player, String> {

    Optional<Player> findById(String playerID);

}
