package com.x.game.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// perform actions
@Service
public class PlayerService {

  private final PlayerRepository playerRepository;

  @Autowired
  public PlayerService(PlayerRepository playerRepository) {
    this.playerRepository = playerRepository;
  }

  public List<Player> getPlayer() {
    return playerRepository.findAll();
  }

  public void addNewPlayer(Player player) {
    Optional<Player> playerByEmail =
        playerRepository.findPlayerByEmail(player.getEmail());

    if(playerByEmail.isPresent()) {
      throw new IllegalStateException("Email taken");
    }

    playerRepository.save(player);
  }
}
