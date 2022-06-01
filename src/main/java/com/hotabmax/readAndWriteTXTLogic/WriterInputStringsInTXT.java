package com.hotabmax.readAndWriteTXTLogic;

import com.hotabmax.models.HistoryOfInputStrings;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;

@Service
public class WriterInputStringsInTXT {
    public void writeInputStringsInTXT(HistoryOfInputStrings historyOfInputStrings) throws IOException {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("SubstringAndString.txt", true);
            fileWriter.write(historyOfInputStrings.getInputsubstrings());
            fileWriter.write("-");
            fileWriter.write(historyOfInputStrings.getInputstrings());
            fileWriter.write("\n");
        } finally{
            if (fileWriter != null) {
                fileWriter.close();
            }
        }
    }
}
