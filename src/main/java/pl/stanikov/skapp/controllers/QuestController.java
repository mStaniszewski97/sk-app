package pl.stanikov.skapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.stanikov.skapp.model.Knight;
import pl.stanikov.skapp.model.PlayerInformation;
import pl.stanikov.skapp.model.Quest;
import pl.stanikov.skapp.services.KnightService;
import pl.stanikov.skapp.services.QuestService;

import java.util.List;

@Controller
public class QuestController {

    @Autowired
    KnightService knightService;

    @Autowired
    QuestService questService;

    @Autowired
    PlayerInformation playerInformation;

    @RequestMapping("/assignQuest")
    public String assignQuest(@RequestParam("knightId") Integer id, Model model){
        Knight knight = knightService.getKnight(id);
        List<Quest> notStartedQuests = questService.getAllNotStartedQuests();
        model.addAttribute("knight", knight);
        model.addAttribute("notStartedQuests", notStartedQuests);
        return "assignQuest";
}

    @RequestMapping(value = "/assignQuest", method = RequestMethod.POST)
    public String assignQuest(Knight knight){
        knightService.updateKnight(knight);
        Quest pomQuest = knight.getQuest();
        questService.update(pomQuest);
        return "redirect:/knights";
    }

    @RequestMapping(value = "/checkQuests")
    public String checkQuest(){
        List<Knight> allKnights = knightService.getAllKnights();
        allKnights.forEach(knight -> {
            knight.getQuest().isCompleted();
                }
        );
        int currentGold = playerInformation.getGold();

        playerInformation.setGold(currentGold + knightService.collectRewards());

        return "redirect:/knights";
    }
}
