package com.taniafontcuberta.basketballoauth2.domain;


import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import com.taniafontcuberta.basketballoauth2.domain.enumeration.PlayerPositions;

/**
 * A Player.
 */
@Entity
@Table(name = "player")
public class Player implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Min(value = 0)
    @Column(name = "baskets", nullable = false)
    private Integer baskets;

    @NotNull
    @Min(value = 0)
    @Column(name = "rebounds", nullable = false)
    private Integer rebounds;

    @NotNull
    @Min(value = 0)
    @Column(name = "assists", nullable = false)
    private Integer assists;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "field_position", nullable = false)
    private PlayerPositions fieldPosition;

    @NotNull
    @Column(name = "birthdate", nullable = false)
    private LocalDate birthdate;

    @ManyToOne
    private Team team;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBaskets() {
        return baskets;
    }

    public void setBaskets(Integer baskets) {
        this.baskets = baskets;
    }

    public Integer getRebounds() {
        return rebounds;
    }

    public void setRebounds(Integer rebounds) {
        this.rebounds = rebounds;
    }

    public Integer getAssists() {
        return assists;
    }

    public void setAssists(Integer assists) {
        this.assists = assists;
    }

    public PlayerPositions getFieldPosition() {
        return fieldPosition;
    }

    public void setFieldPosition(PlayerPositions fieldPosition) {
        this.fieldPosition = fieldPosition;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Player player = (Player) o;
        if(player.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, player.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Player{" +
            "id=" + id +
            ", name='" + name + "'" +
            ", baskets='" + baskets + "'" +
            ", rebounds='" + rebounds + "'" +
            ", assists='" + assists + "'" +
            ", fieldPosition='" + fieldPosition + "'" +
            ", birthdate='" + birthdate + "'" +
            '}';
    }
}
