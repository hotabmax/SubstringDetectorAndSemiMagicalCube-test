package com.hotabmax.controller;

import com.google.gson.Gson;
import com.hotabmax.JPAservices.HistoryOfInputSemiMagicalCubeService;
import com.hotabmax.JPAservices.HistoryOfInputStringsService;
import com.hotabmax.gameLogic.SemiMagicalCubeConverterLogic;
import com.hotabmax.gameLogic.SubstringDetectorLogic;
import com.hotabmax.models.HistoryOfInputStrings;
import com.hotabmax.readAndWriteTXTLogic.ReaderInputMatrixFromTXT;
import com.hotabmax.readAndWriteTXTLogic.ReaderInputStringsFromTXT;
import com.hotabmax.readAndWriteTXTLogic.WriterInputMatrixInTXT;
import com.hotabmax.readAndWriteTXTLogic.WriterInputStringsInTXT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
public class MainController {
    private Gson gson = new Gson();

    @Autowired
    private SubstringDetectorLogic substringDetectorLogic;
    @Autowired
    private SemiMagicalCubeConverterLogic semiMagicalCubeConverterLogic;
    @Autowired
    private HistoryOfInputStringsService historyOfInputStringsService;
    @Autowired
    private HistoryOfInputSemiMagicalCubeService historyOfInputSemiMagicalCubeService;
    @Autowired
    private ReaderInputMatrixFromTXT readerInputMatrixFromTXT;
    @Autowired
    private ReaderInputStringsFromTXT readerInputStringsFromTXT;
    @Autowired
    private WriterInputMatrixInTXT writerInputMatrixInTXT;
    @Autowired
    private WriterInputStringsInTXT writerInputStringsInTXT;

    @GetMapping("/")
    private String getPage(){
        return "player";
    }

    @PostMapping("/playSubstring")
    @ResponseBody
    private String playSubstring(@RequestBody String data){
        HistoryOfInputStrings historyOfInputStrings = gson.fromJson(data, HistoryOfInputStrings.class);
        return substringDetectorLogic.detect(historyOfInputStrings.getInputsubstrings(),
                            historyOfInputStrings.getInputstrings());
    }

    @PostMapping("/playSemiMagicalCube")
    @ResponseBody
    private String playSemiMagicalCube(@RequestBody String data){
        int[] matrix = gson.fromJson(data, int[].class);
        return gson.toJson(semiMagicalCubeConverterLogic.convert(matrix));
    }

    @PostMapping("/saveStringsInDataBase")
    @ResponseBody
    private String saveStrings(@RequestBody String data){
        HistoryOfInputStrings historyOfInputStrings = gson.fromJson(data, HistoryOfInputStrings.class);
        historyOfInputStringsService.create(historyOfInputStrings.getInputsubstrings(),
                                            historyOfInputStrings.getInputstrings());
        return "Успех";
    }

    @PostMapping("/saveInputMatrixInDataBase")
    @ResponseBody
    private String saveInputMatrix(@RequestBody String data){
        int[] matrix = gson.fromJson(data, int[].class);
        historyOfInputSemiMagicalCubeService.create(matrix);
        return "Успех";
    }

    @PostMapping("/loadHistoryOfInputMatrixFromDataBase")
    @ResponseBody
    private String loadHistoryOfSemiMagicalCube(){
        return gson.toJson(historyOfInputSemiMagicalCubeService.findAllMatrix());
    }

    @PostMapping("/loadHistoryOfStringsFromDataBase")
    @ResponseBody
    private String loadStrings(){
        return gson.toJson(historyOfInputStringsService.findAll());
    }

    @PostMapping("/saveHistoryOfStringsInTXT")
    @ResponseBody
    private String saveStringsInTXT(@RequestBody String data) throws IOException {
        HistoryOfInputStrings historyOfInputStrings = gson.fromJson(data, HistoryOfInputStrings.class);
        writerInputStringsInTXT.writeInputStringsInTXT(historyOfInputStrings);
        return "Успех";
    }

    @PostMapping("/saveInputMatrixInTXT")
    @ResponseBody
    private String saveInputMatrixInTXT(@RequestBody String data) throws IOException{
        int[] matrix = gson.fromJson(data, int[].class);
        writerInputMatrixInTXT.writeInputMatrixInTXT(matrix);
        return "Успех";
    }

    @PostMapping("/loadHistoryOfStringsFromTXT")
    @ResponseBody
    private String loadHistoryOfStringsFromTXT() throws IOException{
        return gson.toJson(readerInputStringsFromTXT.readInputStringsFromTXT());
    }

    @PostMapping("/loadHistoryOfInputMatrixFromTXT")
    @ResponseBody
    private String loadHistoryOfInputMatrixFromTXT() throws IOException{
        return gson.toJson(readerInputMatrixFromTXT.readStringsInTXT());
    }
}
