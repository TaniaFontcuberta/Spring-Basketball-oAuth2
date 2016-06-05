package com.taniafontcuberta.basketballoauth2.repository;

import com.taniafontcuberta.basketballoauth2.domain.Team;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the Team entity.
 */
public interface TeamRepository extends JpaRepository<Team,Long> {

}
