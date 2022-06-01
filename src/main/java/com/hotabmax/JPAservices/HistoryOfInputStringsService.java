package com.hotabmax.JPAservices;

import com.hotabmax.JPArepositories.HistoryOfInputStringsRepository;
import com.hotabmax.models.HistoryOfInputStrings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryOfInputStringsService {
    @Autowired
    private HistoryOfInputStringsRepository historyOfInputStringsRepository;

    public List<HistoryOfInputStrings> findAll(){
        return historyOfInputStringsRepository.findAll();
    }

    public void create(String substrings, String strings){
        historyOfInputStringsRepository.save(new HistoryOfInputStrings(substrings, strings));
    }
}
