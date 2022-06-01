package com.hotabmax.gameLogic;

import com.google.gson.Gson;
import com.hotabmax.JPAservices.HistoryOfInputStringsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubstringDetectorLogic {
    @Autowired
    private HistoryOfInputStringsService historyOfInputStringsService;
    public String detect(String substrings, String strings){
        String[] substringsArray = substrings.split("\\s+");
        String[] stringsArray = strings.split("\\s+");
        StringBuilder outputStrings = new StringBuilder();
        for (int i = 0; i < substringsArray.length; i++){
            for (String string : stringsArray){
                if (string.regionMatches(0, substringsArray[i], 0, substringsArray[i].length())){
                    outputStrings.append(substringsArray[i]);
                    outputStrings.append(" ");
                };
            }
        }
        return outputStrings.toString();
    }
}
