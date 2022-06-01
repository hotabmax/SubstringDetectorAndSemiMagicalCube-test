package com.hotabmax.gameLogic;

import com.hotabmax.JPAservices.HistoryOfInputStringsService;
import com.hotabmax.models.HistoryOfInputStrings;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SubstringDetectorLogicTest {
    @Autowired
    private SubstringDetectorLogic substringDetectorLogic;
    @Autowired
    private HistoryOfInputStringsService historyOfInputStringsService;

    @Test
    void detect() {
        String strings = substringDetectorLogic.detect("Яб Аб Ар", "Яблоко Абрикос");
        assertEquals(strings, "Яб Аб");
    }
}