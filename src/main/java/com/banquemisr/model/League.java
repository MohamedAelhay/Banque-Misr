package com.banquemisr.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "league")
public class League extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "champion", referencedColumnName = "id")
    private Participant champion;
}
