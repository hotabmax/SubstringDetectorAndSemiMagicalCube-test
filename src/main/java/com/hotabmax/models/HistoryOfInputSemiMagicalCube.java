package com.hotabmax.models;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Table(name = "historyofsemimagicalcube")
public class HistoryOfInputSemiMagicalCube {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public HistoryOfInputSemiMagicalCube() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
