package com.hotabmax.models;



import javax.persistence.*;

@Entity
@Table(name = "historyofinputstrings")
public class HistoryOfInputStrings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String inputsubstrings;
    @Column
    private String inputstrings;

    public HistoryOfInputStrings(String inputsubstrings, String inputstrings) {
        this.inputsubstrings = inputsubstrings;
        this.inputstrings = inputstrings;
    }

    public HistoryOfInputStrings() {
    }

    public String getInputsubstrings() {
        return inputsubstrings;
    }

    public void setInputsubstrings(String inputsubstrings) {
        this.inputsubstrings = inputsubstrings;
    }

    public String getInputstrings() {
        return inputstrings;
    }

    public void setInputstrings(String inputstrings) {
        this.inputstrings = inputstrings;
    }
}
