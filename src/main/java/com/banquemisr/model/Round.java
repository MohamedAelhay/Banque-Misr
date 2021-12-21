package com.banquemisr.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "round")
public class Round extends BaseEntity {

    @Column(name= "is_active")
    private boolean isActive;

    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "round")
    @JsonIgnoreProperties("round")
    private Set<Game> games = new HashSet<>();
}
