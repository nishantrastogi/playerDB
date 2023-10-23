package com.nishant.playerDB.service;

import com.nishant.playerDB.model.Player;
import com.nishant.playerDB.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    private PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> findAll(){
        return playerRepository.findAll();
    }

    public Optional<Player> findById(String playerId){
        return playerRepository.findById(playerId);
    }
}
