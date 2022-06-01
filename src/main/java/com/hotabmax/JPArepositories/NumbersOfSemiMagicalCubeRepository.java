package com.hotabmax.JPArepositories;

import com.hotabmax.models.NumbersOfSemiMagicalCube;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NumbersOfSemiMagicalCubeRepository extends JpaRepository<NumbersOfSemiMagicalCube, Long> {
    @Query(value = "select id, number, position, historyofsemimagicalcubeid from numbersofsemimagicalcube where historyofsemimagicalcubeid = :id",
            nativeQuery = true)
    List<NumbersOfSemiMagicalCube> findByHistoryOfInputMagicalCubeId(Integer id);
}
