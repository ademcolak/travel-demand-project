package com.travel.project.service.base;

import com.travel.project.entity.Demander;
import java.util.List;

public interface DemanderService {

  public List<Demander> findAll();

  public Demander findById(int theId);

  public void save(Demander theDemander);

  public void deleteById(int theId);

  public List<Demander> searchBy(String theName);
}
