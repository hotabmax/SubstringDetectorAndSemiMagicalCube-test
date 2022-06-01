package com.hotabmax.readAndWriteTXTLogic;

import com.hotabmax.models.HistoryOfInputStrings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.LinkedList;
import java.util.List;

@Service
public class ReaderInputStringsFromTXT {
    public List<HistoryOfInputStrings> readInputStringsFromTXT() throws IOException {
        FileReader fileReader = null;
        List<HistoryOfInputStrings> historyOfInputStrings = new LinkedList<>();
        try {
            fileReader = new FileReader("SubstringAndString.txt");
            int data;
            StringBuilder substrings = new StringBuilder();
            StringBuilder strings = new StringBuilder();
            boolean flag = true;
            while ((data = fileReader.read()) != -1){
                if (data == 45){
                    flag = false;
                }
                if(data == 10){
                    flag = true;
                    historyOfInputStrings.add(new HistoryOfInputStrings(substrings.toString(),
                            strings.toString()));
                    substrings.delete(0, substrings.length());
                    strings.delete(0, strings.length());
                }
                if(flag && data != 45 && data != 10){
                    substrings.append((char) data);
                } else if(data != 45 && data != 10) strings.append((char) data);
            }
        } finally {
            if (fileReader != null) {
                fileReader.close();
            }
        }
        return historyOfInputStrings;
    }
}
