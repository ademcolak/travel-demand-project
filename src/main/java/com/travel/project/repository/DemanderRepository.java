package com.travel.project.repository;

import com.travel.project.entity.Demander;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemanderRepository extends JpaRepository<Demander, Integer> {
  List<Demander> findAllByOrderBySicilNoAsc();

  List<Demander> findByIsimContainsAllIgnoreCase(String name);

}
