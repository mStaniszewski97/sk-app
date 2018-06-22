package pl.stanikov.skapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.stanikov.skapp.model.Knight;
import pl.stanikov.skapp.model.repository.KnightRepository;
import pl.stanikov.skapp.services.KnightService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class KnightController {

    @Autowired
    KnightService knightService;

    @RequestMapping("/knights")
    public String getKnights(Model model){
        List<Knight> pom = knightService.getAllKnights();
        model.addAttribute("knights", pom);
        model.addAttribute("hello", "Witaj swiecie");
        return "knights";
    }

    @RequestMapping("/knight")
    public String getKnight(@RequestParam("id") Integer id, Model model){
        Knight pom = knightService.getKnight(id);
        model.addAttribute("knight", pom);
        return "knight";
    }

    @RequestMapping("/newknight")
    public String createKnight(Model model){
        model.addAttribute("knight", new Knight());
        return "knightform";
    }

    @RequestMapping(value = "/knights", method = RequestMethod.POST)
    public String saveKnights(Knight knight){
        knightService.saveKnight(knight);
        return "redirect:/knights";
    }
}
