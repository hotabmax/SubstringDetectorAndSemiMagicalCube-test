package com.hotabmax.JPAservices;

import com.hotabmax.JPArepositories.HistoryOfInputSemiMagicalCubeRepository;
import com.hotabmax.JPArepositories.NumbersOfSemiMagicalCubeRepository;
import com.hotabmax.models.HistoryOfInputSemiMagicalCube;
import com.hotabmax.models.NumbersOfSemiMagicalCube;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class HistoryOfInputSemiMagicalCubeService {
    @Autowired
    private HistoryOfInputSemiMagicalCubeRepository historyOfInputSemiMagicalCubeRepository;
    @Autowired
    private NumbersOfSemiMagicalCubeRepository numbersOfSemiMagicalCubeRepository;

    public List<HistoryOfInputSemiMagicalCube> findAll(){
        return historyOfInputSemiMagicalCubeRepository.findAll();
    }

    public void create(int[] matrix){
        historyOfInputSemiMagicalCubeRepository.save(new HistoryOfInputSemiMagicalCube());
        List<HistoryOfInputSemiMagicalCube> historyOfInputSemiMagicalCubes =
                historyOfInputSemiMagicalCubeRepository.findAll();
        for (HistoryOfInputSemiMagicalCube h : historyOfInputSemiMagicalCubes){
            if (numbersOfSemiMagicalCubeRepository
                    .findByHistoryOfInputMagicalCubeId(h.getId().intValue()).size() == 0){
                for(int a = 0; a < matrix.length; a++){
                    numbersOfSemiMagicalCubeRepository.save(
                            new NumbersOfSemiMagicalCube(
                                    matrix[a], a + 1, h.getId().intValue()));
                }
            }
        }
    }

    private HistoryOfInputSemiMagicalCube findById(Long id){
        return historyOfInputSemiMagicalCubeRepository.findById(id).orElse(null);
    }

    public List<int[]> findAllMatrix(){
        List<int[]> arrays = new LinkedList();
        List<HistoryOfInputSemiMagicalCube> historyOfInputMagicalCubes =
                historyOfInputSemiMagicalCubeRepository.findAll();
        for (int i = 0; i < historyOfInputMagicalCubes.size(); i++){
            int[] temporaryArray = new int[9];
            List<NumbersOfSemiMagicalCube> numbersOfSemiMagicalCubes
                    = numbersOfSemiMagicalCubeRepository
                    .findByHistoryOfInputMagicalCubeId(historyOfInputMagicalCubes.get(i).getId().intValue());
            for (int a = 0; a < numbersOfSemiMagicalCubes.size(); a++){
                temporaryArray[numbersOfSemiMagicalCubes.get(a).getPosition() - 1]
                        = numbersOfSemiMagicalCubes.get(a).getNumber();
            }
            arrays.add(temporaryArray);
        }
        return arrays;
    }
}
