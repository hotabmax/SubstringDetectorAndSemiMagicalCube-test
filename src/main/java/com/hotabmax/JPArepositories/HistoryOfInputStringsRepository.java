package com.hotabmax.JPArepositories;

import com.hotabmax.models.HistoryOfInputStrings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryOfInputStringsRepository extends JpaRepository<HistoryOfInputStrings, Long> {
}
