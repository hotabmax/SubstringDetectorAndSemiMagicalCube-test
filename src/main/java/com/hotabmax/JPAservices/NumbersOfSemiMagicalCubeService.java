package com.hotabmax.JPAservices;

import com.hotabmax.JPArepositories.NumbersOfSemiMagicalCubeRepository;
import com.hotabmax.models.NumbersOfSemiMagicalCube;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NumbersOfSemiMagicalCubeService {
    @Autowired
    private NumbersOfSemiMagicalCubeRepository numbersOfSemiMagicalCubeRepository;

    public List<NumbersOfSemiMagicalCube> findByHistoryOfInputMagicalCubeId(Integer id){
        return numbersOfSemiMagicalCubeRepository.findByHistoryOfInputMagicalCubeId(id);
    }
}
