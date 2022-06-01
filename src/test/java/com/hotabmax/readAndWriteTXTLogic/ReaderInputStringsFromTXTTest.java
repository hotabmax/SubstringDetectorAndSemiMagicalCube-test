package com.hotabmax.readAndWriteTXTLogic;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ReaderInputStringsFromTXTTest {
    @Autowired
    private ReaderInputStringsFromTXT readerInputStringsFromTXT;

    @Test
    void readInputStringsFromTXT() throws IOException {
        readerInputStringsFromTXT.readInputStringsFromTXT();
    }
}