package pl.stanikov.skapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.stanikov.skapp.components.TimeComponent;
import pl.stanikov.skapp.model.Knight;
import pl.stanikov.skapp.model.PlayerInformation;
import pl.stanikov.skapp.model.repository.KnightRepository;
import pl.stanikov.skapp.services.KnightService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class KnightController {

    @Autowired
    TimeComponent timecomponent;

    @Autowired
    PlayerInformation playerInformation;

    @Autowired
    KnightService knightService;

    @RequestMapping("/knights")
    public String getKnights(Model model){
        List<Knight> pom = knightService.getAllKnights();
        model.addAttribute("knights", pom);
        model.addAttribute("timecomponent", timecomponent);
        model.addAttribute("playerInformation", playerInformation);
        return "knights";
    }

    @RequestMapping("/knight")
    public String getKnight(@RequestParam("id") Integer id, Model model){
        Knight pom = knightService.getKnight(id);
        model.addAttribute("knight", pom);
        model.addAttribute("timecomponent", timecomponent);
        model.addAttribute("playerInformation", playerInformation);
        return "knight";
    }

    @RequestMapping("/newknight")
    public String createKnight(Model model){
        model.addAttribute("knight", new Knight());
        model.addAttribute("timecomponent", timecomponent);
        model.addAttribute("playerInformation", playerInformation);
        return "knightform";
    }

    @RequestMapping(value = "/knights", method = RequestMethod.POST)
    public String saveKnights(@Valid Knight knight, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            System.out.println("Error");
            return "knightform";
        }
        else{
            knightService.saveKnight(knight);
            return "redirect:/knights";
        }
    }

    @RequestMapping(value = "/knight/delete/{id}")
    public String deleteKnight(@PathVariable("id") Integer id){
        knightService.deleteKnight(id);
        return "redirect:/knights";
    }
}
