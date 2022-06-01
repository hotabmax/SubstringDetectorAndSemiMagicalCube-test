package com.hotabmax.gameLogic;

import com.hotabmax.JPAservices.HistoryOfInputSemiMagicalCubeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


@Service
public class SemiMagicalCubeConverterLogic {
    @Autowired
    private HistoryOfInputSemiMagicalCubeService historyOfInputSemiMagicalCubeService;
    public int[] convert(int[] matrix){
        int[] middleNumbers = new int[4];
        int[] resultMatrix = new int[9];
        int cost = 0;
        int count = 0;
        middleNumbers[0] = 1;
        middleNumbers[1] = 3;
        middleNumbers[2] = 7;
        middleNumbers[3] = 9;
        for (int i = 0; i < middleNumbers.length; i++){
            int temporaryCost = 0;
            int[] temporaryMatrix = new int[9];
            int[] turnedMatrix = new int[9];
            List<Integer> exceptedNumbers = new LinkedList<>();
            temporaryMatrix[4] = middleNumbers[i];
            exceptedNumbers.add(middleNumbers[i]);

            cycle:for (int a = 0; a < matrix.length; a++){
                if (matrix[a] == middleNumbers[i]) continue;
                for (int b = 0; b < matrix.length; b++){
                    if (b == a) continue;
                    if (matrix[b] == middleNumbers[i]) continue;
                    if (matrix[a] + matrix[b] + middleNumbers[i] == 15) {
                        temporaryMatrix[1] = matrix[a];
                        temporaryMatrix[7] = matrix[b];
                        exceptedNumbers.add(matrix[a]);
                        exceptedNumbers.add(matrix[b]);
                        break cycle;
                    };
                }
            }
            cycle:for (int a = 0; a < matrix.length; a++){
                Iterator iteratorA = exceptedNumbers.iterator();
                boolean nextA = false;

                while (iteratorA.hasNext()){
                    int num = (int) iteratorA.next();
                    if (matrix[a] == num) nextA = true;
                }
                if (nextA) continue;
                if (matrix[a] == middleNumbers[i]) continue;
                for (int b = 0; b < matrix.length; b++){
                    Iterator iteratorB = exceptedNumbers.iterator();
                    boolean nextB = false;

                    while (iteratorB.hasNext()){
                        int num = (int) iteratorB.next();
                        if (matrix[b] == num) nextB = true;
                    }
                    if (nextB) continue;
                    if (b == a) continue;
                    if (matrix[b] == middleNumbers[i]) continue;
                    if (matrix[a] + matrix[b] + middleNumbers[i] == 15) {
                        temporaryMatrix[3] = matrix[a];
                        temporaryMatrix[5] = matrix[b];
                        exceptedNumbers.add(matrix[a]);
                        exceptedNumbers.add(matrix[b]);
                        break cycle;
                    };
                }
            }

            cycle:for (int a = 0; a < matrix.length; a++){
                Iterator iteratorA = exceptedNumbers.iterator();
                boolean nextA = false;

                while (iteratorA.hasNext()){
                    int numA = (int) iteratorA.next();
                    if (matrix[a] == numA) nextA = true;
                }
                if (nextA) continue;
                if (matrix[a] == middleNumbers[i]) continue;
                for (int b = 0; b < matrix.length; b++){
                    Iterator iteratorB = exceptedNumbers.iterator();
                    boolean nextB = false;

                    while (iteratorB.hasNext()){
                        int numB = (int) iteratorB.next();
                        if (matrix[b] == numB) nextB = true;
                    }
                    if (b == a) continue;
                    if (nextB) continue;
                    for (int c = 0; c < matrix.length; c++){
                        Iterator iteratorC = exceptedNumbers.iterator();
                        boolean nextC = false;

                        while (iteratorC.hasNext()){
                            int numC = (int) iteratorC.next();
                            if (matrix[c] == numC) nextC = true;
                        }
                        if (c == a || c == b) continue;
                        if (nextC) continue;
                        for (int d = 0; d < matrix.length; d++){
                            Iterator iteratorD = exceptedNumbers.iterator();
                            boolean nextD = false;

                            while (iteratorD.hasNext()){
                                int numD = (int) iteratorD.next();
                                if (matrix[c] == numD) nextD = true;
                            }
                            if (d == c || d == b || d == a) continue;
                            if (nextD) continue;

                            if (matrix[a] + temporaryMatrix[1] < 15 && matrix[a] + temporaryMatrix[3] < 15 &&
                                    matrix[b] + temporaryMatrix[1] < 15 && matrix[b] + temporaryMatrix[5] < 15 &&
                                        matrix[a] + temporaryMatrix[1] + matrix[b] == 15 &&
                                            matrix[a] + temporaryMatrix[3] + matrix[c] == 15 &&
                                                matrix[b] + temporaryMatrix[5] + matrix[d] == 15){
                                temporaryMatrix[0] = matrix[a];
                                temporaryMatrix[2] = matrix[b];
                                temporaryMatrix[6] = matrix[c];
                                temporaryMatrix[8] = matrix[d];
                                break cycle;
                            } else if (matrix[b] + temporaryMatrix[1] < 15 && matrix[b] + temporaryMatrix[3] < 15 &&
                                        matrix[a] + temporaryMatrix[1] < 15 && matrix[a] + temporaryMatrix[5] < 15 &&
                                            matrix[a] + temporaryMatrix[1] + matrix[b] == 15 &&
                                                matrix[b] + temporaryMatrix[3] + matrix[c] == 15 &&
                                                    matrix[a] + temporaryMatrix[5] + matrix[d] == 15) {
                                temporaryMatrix[0] = matrix[b];
                                temporaryMatrix[2] = matrix[a];
                                temporaryMatrix[6] = matrix[c];
                                temporaryMatrix[8] = matrix[d];
                                break cycle;
                            } else if (matrix[b] + temporaryMatrix[1] < 15 && matrix[b] + temporaryMatrix[3] < 15 &&
                                        matrix[a] + temporaryMatrix[1] < 15 && matrix[a] + temporaryMatrix[5] < 15 &&
                                            matrix[a] + temporaryMatrix[1] + matrix[b] == 15 &&
                                                matrix[b] + temporaryMatrix[3] + matrix[d] == 15 &&
                                                    matrix[a] + temporaryMatrix[5] + matrix[c] == 15) {
                                temporaryMatrix[0] = matrix[b];
                                temporaryMatrix[2] = matrix[a];
                                temporaryMatrix[6] = matrix[d];
                                temporaryMatrix[8] = matrix[c];
                                break cycle;
                            } else if (matrix[a] + temporaryMatrix[1] < 15 && matrix[a] + temporaryMatrix[3] < 15 &&
                                        matrix[b] + temporaryMatrix[1] < 15 && matrix[b] + temporaryMatrix[5] < 15 &&
                                            matrix[a] + temporaryMatrix[1] + matrix[b] == 15 &&
                                                matrix[a] + temporaryMatrix[3] + matrix[d] == 15 &&
                                                    matrix[b] + temporaryMatrix[5] + matrix[c] == 15) {
                                temporaryMatrix[0] = matrix[a];
                                temporaryMatrix[2] = matrix[b];
                                temporaryMatrix[6] = matrix[d];
                                temporaryMatrix[8] = matrix[c];
                                break cycle;
                            }
                        }
                    }
                }
            }
            for(int a = 0; a < matrix.length; a++){
                for(int b = 0; b < temporaryMatrix.length; b++){
                    if (matrix[a] == temporaryMatrix[b]) temporaryCost += Math.abs(a - b);
                }
            }
            if (cost == 0){
                cost = temporaryCost;
                resultMatrix = temporaryMatrix;
            }
            if (temporaryCost < cost) {
                cost = temporaryCost;
                resultMatrix = turnedMatrix;
            }
            for (int a = 0; a < 4; a++){
                int temporaryTurnedMatrixCost = 0;

                turnedMatrix[2] = temporaryMatrix[0];
                turnedMatrix[5] = temporaryMatrix[1];
                turnedMatrix[8] = temporaryMatrix[2];
                turnedMatrix[1] = temporaryMatrix[3];
                turnedMatrix[4] = temporaryMatrix[4];
                turnedMatrix[7] = temporaryMatrix[5];
                turnedMatrix[0] = temporaryMatrix[6];
                turnedMatrix[3] = temporaryMatrix[7];
                turnedMatrix[6] = temporaryMatrix[8];

                temporaryMatrix[0]= turnedMatrix[0];
                temporaryMatrix[1] = turnedMatrix[1];
                temporaryMatrix[2] = turnedMatrix[2];
                temporaryMatrix[3] = turnedMatrix[3];
                temporaryMatrix[4] = turnedMatrix[4];
                temporaryMatrix[5] = turnedMatrix[5];
                temporaryMatrix[6] = turnedMatrix[6];
                temporaryMatrix[7] = turnedMatrix[7];
                temporaryMatrix[8] = turnedMatrix[8];
                if (a != 3){
                    for(int b = 0; b < matrix.length; b++){
                        for(int c = 0; c < turnedMatrix.length; c++){
                            if (matrix[b] == turnedMatrix[c]) temporaryTurnedMatrixCost += Math.abs(b - c);
                        }
                    }
                    if (temporaryTurnedMatrixCost < cost) {
                        cost = temporaryTurnedMatrixCost;
                        resultMatrix = turnedMatrix;
                    }
                }
            }
            for (int a = 0; a < 2; a++){
                int temporaryTurnedMatrixCost = 0;

                turnedMatrix[2] = temporaryMatrix[0];
                turnedMatrix[1] = temporaryMatrix[1];
                turnedMatrix[0] = temporaryMatrix[2];
                turnedMatrix[5] = temporaryMatrix[3];
                turnedMatrix[4] = temporaryMatrix[4];
                turnedMatrix[3] = temporaryMatrix[5];
                turnedMatrix[8] = temporaryMatrix[6];
                turnedMatrix[7] = temporaryMatrix[7];
                turnedMatrix[6] = temporaryMatrix[8];

                temporaryMatrix[0]= turnedMatrix[0];
                temporaryMatrix[1] = turnedMatrix[1];
                temporaryMatrix[2] = turnedMatrix[2];
                temporaryMatrix[3] = turnedMatrix[3];
                temporaryMatrix[4] = turnedMatrix[4];
                temporaryMatrix[5] = turnedMatrix[5];
                temporaryMatrix[6] = turnedMatrix[6];
                temporaryMatrix[7] = turnedMatrix[7];
                temporaryMatrix[8] = turnedMatrix[8];
                if (a != 1){
                    for(int b = 0; b < matrix.length; b++){
                        for(int c = 0; c < turnedMatrix.length; c++){
                            if (matrix[b] == turnedMatrix[c]) temporaryTurnedMatrixCost += Math.abs(b - c);
                        }
                    }
                    if (temporaryTurnedMatrixCost < cost) {
                        cost = temporaryCost;
                        resultMatrix = turnedMatrix;
                    }
                }
            }
            for (int a = 0; a < 2; a++){
                int temporaryTurnedMatrixCost = 0;

                turnedMatrix[6] = temporaryMatrix[0];
                turnedMatrix[7] = temporaryMatrix[1];
                turnedMatrix[8] = temporaryMatrix[2];
                turnedMatrix[3] = temporaryMatrix[3];
                turnedMatrix[4] = temporaryMatrix[4];
                turnedMatrix[5] = temporaryMatrix[5];
                turnedMatrix[0] = temporaryMatrix[6];
                turnedMatrix[1] = temporaryMatrix[7];
                turnedMatrix[2] = temporaryMatrix[8];

                temporaryMatrix[0]= turnedMatrix[0];
                temporaryMatrix[1] = turnedMatrix[1];
                temporaryMatrix[2] = turnedMatrix[2];
                temporaryMatrix[3] = turnedMatrix[3];
                temporaryMatrix[4] = turnedMatrix[4];
                temporaryMatrix[5] = turnedMatrix[5];
                temporaryMatrix[6] = turnedMatrix[6];
                temporaryMatrix[7] = turnedMatrix[7];
                temporaryMatrix[8] = turnedMatrix[8];
                if (a != 1){
                    for(int b = 0; b < matrix.length; b++){
                        for(int c = 0; c < turnedMatrix.length; c++){
                            if (matrix[b] == turnedMatrix[c]) temporaryTurnedMatrixCost += Math.abs(b - c);
                        }
                    }
                    if (temporaryTurnedMatrixCost < cost) {
                        cost = temporaryCost;
                        resultMatrix = turnedMatrix;
                    }
                }
            }
        }
        return resultMatrix;
    }
}
