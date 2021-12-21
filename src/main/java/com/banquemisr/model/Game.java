package com.banquemisr.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "game")
public class Game extends BaseEntity {

    @ManyToOne
    @EqualsAndHashCode.Exclude
    @JsonIgnoreProperties("games")
    @JoinColumn(name = "round_id")
    private Round round;

    @OneToOne
    @JoinColumn(name = "winner_id", referencedColumnName = "id")
    private Participant winner;

    @OneToOne
    @JoinColumn(name = "participant_one_id", referencedColumnName = "id")
    private Participant participantOne;

    @OneToOne
    @JoinColumn(name = "participant_two_id", referencedColumnName = "id")
    private Participant participantTwo;

    @Column(name = "match_date")
    @Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
    private LocalDateTime matchDate;
}
