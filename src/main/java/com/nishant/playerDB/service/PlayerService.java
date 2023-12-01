package com.nishant.playerDB.service;

import com.nishant.playerDB.model.entity.Player;
import com.nishant.playerDB.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    private PlayerRepository playerRepository ;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    public List<Player> findAllByHeight() {
        return playerRepository.findAllByOrderByHeightAsc();
    }

    public Optional<Player> findById(String playerId) {
        return playerRepository.findById(playerId);
    }

    public Page<Player> findPlayerWithPagination(int pageNumber, int pageSize) {
        Page<Player> players = playerRepository.findAll(PageRequest.of(pageNumber, pageSize));
        return players;
    }

    public Player createPlayer(Player player){
        return playerRepository.save(player);
    }

    public void deletePlayer(String playerId){
        playerRepository.deleteById(playerId);
    }
}
