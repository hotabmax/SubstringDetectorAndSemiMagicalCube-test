package com.hotabmax.JPArepositories;

import com.hotabmax.models.HistoryOfInputSemiMagicalCube;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryOfInputSemiMagicalCubeRepository extends JpaRepository<HistoryOfInputSemiMagicalCube, Long> {
}
