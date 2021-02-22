package com.x.game.player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// responsible for the database queries
@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
  Optional<Player> findPlayerByEmail(String email);
}
