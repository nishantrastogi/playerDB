package com.nishant.playerDB.repository;

import com.nishant.playerDB.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player, String> {

    Optional<Player> findById(String playerID);

}
