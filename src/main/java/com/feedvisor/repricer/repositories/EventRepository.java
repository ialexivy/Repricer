package com.feedvisor.repricer.repositories;

import com.feedvisor.repricer.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EventRepository extends JpaRepository<Event, Integer> {
  @Query("from Event where name like %:keyword%")
  Event findByName(@Param("keyword") String keyword);
}
