package com.taniafontcuberta.basketballoauth2.repository;

import com.taniafontcuberta.basketballoauth2.domain.Player;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

/**
 * Spring Data JPA repository for the Player entity.
 */
public interface PlayerRepository extends JpaRepository<Player,Long> {

    List<Player> findByNameEquals(String name);
    List<Player> findByBasketsGreaterThanEqual(Integer baskets);
    List<Player> findByBirthdateAfter(LocalDate birthdate);

}
