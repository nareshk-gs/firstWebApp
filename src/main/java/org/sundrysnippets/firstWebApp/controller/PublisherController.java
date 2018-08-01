package org.sundrysnippets.firstWebApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.sundrysnippets.firstWebApp.repositories.PublisherRepository;

@Controller
public class PublisherController {
  
  private PublisherRepository publisherRepository;
  
  public PublisherController(PublisherRepository publisherRepository) {
    this.publisherRepository = publisherRepository;
  }
  
  @RequestMapping("/publishers")
  public String getPublishers(Model model){
    model.addAttribute("publishers", publisherRepository.findAll());
    return "publishers";
  }
  
}
