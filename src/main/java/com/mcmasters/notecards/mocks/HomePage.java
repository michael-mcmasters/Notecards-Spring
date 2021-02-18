package com.mcmasters.notecards.mocks;

import javax.persistence.*;

@Entity
@Table(name = "homepage")
public class HomePage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

}
