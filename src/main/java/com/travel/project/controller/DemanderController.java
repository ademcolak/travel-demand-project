package com.travel.project.controller;

import com.travel.project.entity.Demander;
import com.travel.project.service.base.DemanderService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/demanders")
public class DemanderController {

  private final DemanderService demanderService;

  public DemanderController(DemanderService theDemanderService) {
    demanderService = theDemanderService;
  }

  @GetMapping("/list")
  public String listDemander(Model theModel) {

    // get employees from db
    List<Demander> theDemander = demanderService.findAll();

    // add to the spring model
    theModel.addAttribute("demander", theDemander);

    return "demanders/list-demanders";
  }

  @GetMapping("/showFormForAdd")
  public String showFormForAdd(Model theModel) {

    // create model attribute to bind form data
    Demander theDemander = new Demander();

    theModel.addAttribute("demander", theDemander);

    return "demanders/demander-form";
  }

  @GetMapping("/showFormForUpdate")
  public String showFormForUpdate(@RequestParam("demanderId") int theId, Model theModel) {

    // get the employee from the service
    Demander theDemander = demanderService.findById(theId);

    // set employee as a model attribute to pre-populate the form
    theModel.addAttribute("demander", theDemander);

    // send over to our form
    return "demanders/demander-form";
  }

  @PostMapping("/save")
  public String saveEmployee(@ModelAttribute("demander") Demander theDemander) {

    // save the employee
    demanderService.save(theDemander);

    // use a redirect to prevent duplicate submissions
    return "redirect:/demanders/list";
  }

  @GetMapping("/delete")
  public String delete(@RequestParam("demanderId") int theId) {

    // delete the employee
    demanderService.deleteById(theId);

    // redirect to /employees/list
    return "redirect:/demanders/list";

  }

  @GetMapping("/search")
  public String delete(@RequestParam("demanderName") String theName,
      Model theModel) {

    // delete the employee
    List<Demander> theDemander = demanderService.searchBy(theName);

    // add to the spring model
    theModel.addAttribute("demander", theDemander);

    // send to /employees/list
    return "/demanders/list-demanders";

  }

}
