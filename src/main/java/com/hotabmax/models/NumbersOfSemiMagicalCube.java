package com.hotabmax.models;

import javax.persistence.*;

@Entity
@Table(name = "numbersofsemimagicalcube")
public class NumbersOfSemiMagicalCube {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Integer number;
    @Column
    private Integer position;
    @Column
    private Integer historyofsemimagicalcubeid;

    public NumbersOfSemiMagicalCube() {
    }

    public NumbersOfSemiMagicalCube(Integer number, Integer position, Integer historyofsemimagicalcubeid) {
        this.number = number;
        this.position = position;
        this.historyofsemimagicalcubeid = historyofsemimagicalcubeid;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Integer getHistoryofsemimagicalcubeid() {
        return historyofsemimagicalcubeid;
    }

    public void setHistoryofsemimagicalcubeid(Integer historyofsemimagicalcubeid) {
        this.historyofsemimagicalcubeid = historyofsemimagicalcubeid;
    }
}
