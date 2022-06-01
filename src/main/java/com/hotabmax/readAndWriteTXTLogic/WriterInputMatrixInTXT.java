package com.hotabmax.readAndWriteTXTLogic;

import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;

@Service
public class WriterInputMatrixInTXT {
    public void writeInputMatrixInTXT(int[] matrix) throws IOException {
        FileWriter fileWriter = null;
        try{
            fileWriter = new FileWriter("InputMatrix.txt",true);
            for (Integer i : matrix){
                fileWriter.write("" + i + "");
            }
            fileWriter.write("\n");
        } finally {
            if (fileWriter != null) {
                fileWriter.close();
            }
        }
    }
}
