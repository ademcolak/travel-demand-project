package com.travel.project.service;

import com.travel.project.entity.Demander;
import com.travel.project.repository.DemanderRepository;
import com.travel.project.service.base.DemanderService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemanderServiceImpl implements DemanderService {

  private DemanderRepository demanderRepository;

  @Autowired
  public DemanderServiceImpl(DemanderRepository theDemanderRepository) {
    demanderRepository = theDemanderRepository;
  }

  @Override
  public List<Demander> findAll() {
    return demanderRepository.findAllByOrderBySicilNoAsc();
  }

  @Override
  public Demander findById(int theId) {
    Optional<Demander> result = demanderRepository.findById(theId);

    Demander theDemander = null;

    if (result.isPresent()) {
      theDemander = result.get();
    } else {

      throw new RuntimeException("Did not find employee id - " + theId);
    }

    return theDemander;
  }

  @Override
  public void save(Demander theDemander) {
    demanderRepository.save(theDemander);
  }

  @Override
  public void deleteById(int theId) {
    demanderRepository.deleteById(theId);
  }

  @Override
  public List<Demander> searchBy(String theName) {

    List<Demander> results = null;

    if (theName != null && (theName.trim().length() > 0)) {
      results = demanderRepository.findByIsimContainsAllIgnoreCase(theName);
    }
    else {
      results = findAll();
    }

    return results;
  }
}
