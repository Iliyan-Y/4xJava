package com.x.game.buildings;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingsRepository extends JpaRepository<Buildings, Long> {
}
