package com.x.game.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

// takes params from the controller ->
// perform all the logic
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
    String email = player.getEmail();
    checkForEmail(email);
    playerRepository.save(player);
  }

  public void deletePlayer(Long playerId) {
    if (!playerRepository.existsById(playerId)) {
      throw new IllegalStateException("Player does NOT exists");
    }
    playerRepository.deleteById(playerId);
  }

  @Transactional // -> manage the state directly without using the Repository !
  public void updatePlayer(Long playerId, String name, String email) {
    Player player = playerRepository.findById(playerId)
        .orElseThrow(() -> new IllegalStateException("Player does NOT exists"));

    if (name != null && name.length() > 0 && !Objects.equals(player.getName()
        , name)) {
      player.setName(name); // this state is managed by @Transactional
    }

    if (email != null && email.length() > 0 && !Objects.equals(player.getEmail()
        , email)) {
      checkForEmail(email);
      player.setEmail(email); // this state is managed by @Transactional
    }
  }

  private void checkForEmail(String email) {
    Optional<Player> playerByEmail =
        playerRepository.findPlayerByEmail(email);

    if (playerByEmail.isPresent()) {
      throw new IllegalStateException("Email taken");
    }
  }
}
