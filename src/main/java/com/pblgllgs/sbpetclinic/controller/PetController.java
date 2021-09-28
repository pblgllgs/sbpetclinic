package com.pblgllgs.sbpetclinic.controller;

import com.pblgllgs.sbpetclinic.service.PetService;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/pets")
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @RequestMapping({"","/","/index","/index.html"})
    public String index(Model model){
        model.addAttribute("pets", petService.findAll());
        return "pets/index";
    }
}
