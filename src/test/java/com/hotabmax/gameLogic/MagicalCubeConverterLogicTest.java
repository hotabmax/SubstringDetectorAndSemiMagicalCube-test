package com.hotabmax.gameLogic;

import com.hotabmax.JPAservices.HistoryOfInputSemiMagicalCubeService;
import com.hotabmax.models.HistoryOfInputSemiMagicalCube;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MagicalCubeConverterLogicTest {

    @Autowired
    private SemiMagicalCubeConverterLogic semiMagicalCubeConverterLogic;
    @Autowired
    private HistoryOfInputSemiMagicalCubeService historyOfInputSemiMagicalCubeService;

    @Test
    void convert() {
        int[] matrix = new int[9];
        int[] resultMatrix;
        matrix[0] = 9;
        matrix[1] = 8;
        matrix[2] = 7;
        matrix[3] = 6;
        matrix[4] = 5;
        matrix[5] = 4;
        matrix[6] = 3;
        matrix[7] = 2;
        matrix[8] = 1;
        resultMatrix = semiMagicalCubeConverterLogic.convert(matrix);

        assertEquals(resultMatrix[0], 6);
        assertEquals(resultMatrix[1], 8);
        assertEquals(resultMatrix[2], 1);
        assertEquals(resultMatrix[3], 7);
        assertEquals(resultMatrix[4], 3);
        assertEquals(resultMatrix[5], 5);
        assertEquals(resultMatrix[6], 2);
        assertEquals(resultMatrix[7], 4);
        assertEquals(resultMatrix[8], 9);
    }

    @Test
    void test() {
        System.out.println((char) 11);
    }

}