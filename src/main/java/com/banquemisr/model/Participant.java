package com.banquemisr.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "participant")
public class Participant extends BaseEntity{

    @Column(name = "name")
    private String name;
}
