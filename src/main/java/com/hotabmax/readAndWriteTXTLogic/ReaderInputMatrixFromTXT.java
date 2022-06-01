package com.hotabmax.readAndWriteTXTLogic;

import com.hotabmax.readAndWriteTXTLogic.converterFromUTF8ToInteger.ConverterFromUTF8ToInteger;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@Service
public class ReaderInputMatrixFromTXT {
    public List<int[]> readStringsInTXT() throws IOException {
        FileReader fileReader = null;
        List<int[]> arrays = new LinkedList();
        try{
            fileReader = new FileReader("InputMatrix.txt");
            int data;
            int[] matrix = new int[9];
            while ((data = fileReader.read()) != -1){
                if(data == 10){
                    arrays.add(matrix);
                    matrix = new int[9];
                } else{
                    if(matrix[0] == 0){
                        matrix[0] = ConverterFromUTF8ToInteger.convert(data);
                    } else if(matrix[1] == 0){
                        matrix[1] = ConverterFromUTF8ToInteger.convert(data);
                    } else if(matrix[2] == 0){
                        matrix[2] = ConverterFromUTF8ToInteger.convert(data);
                    } else if(matrix[3] == 0){
                        matrix[3] = ConverterFromUTF8ToInteger.convert(data);
                    } else if(matrix[4] == 0){
                        matrix[4] = ConverterFromUTF8ToInteger.convert(data);
                    } else if(matrix[5] == 0){
                        matrix[5] = ConverterFromUTF8ToInteger.convert(data);
                    } else if(matrix[6] == 0){
                        matrix[6] = ConverterFromUTF8ToInteger.convert(data);
                    } else if(matrix[7] == 0){
                        matrix[7] = ConverterFromUTF8ToInteger.convert(data);
                    } else if(matrix[8] == 0){
                        matrix[8] = ConverterFromUTF8ToInteger.convert(data);
                    }
                }
            }
        } finally {
            if (fileReader != null) {
                fileReader.close();
            }
        }
        return arrays;
    }
}
