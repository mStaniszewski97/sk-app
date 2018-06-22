package pl.stanikov.skapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pl.stanikov.skapp.model.Quest;
import pl.stanikov.skapp.model.repository.InMemoryRepository;
import pl.stanikov.skapp.model.repository.KnightRepository;
import pl.stanikov.skapp.model.repository.QuestRepository;

import java.util.Random;

@Service
public class QuestService {

    @Autowired
    KnightRepository knightRepository;

    @Autowired
    QuestRepository questRepository;

    final static Random rand=new Random();

    public void assignRandomQuest(String knightName){
        Quest randomQuest = questRepository.getAll().get(rand.nextInt(questRepository.getAll().size()));
        knightRepository.getKnight(knightName).ifPresent(knight -> knight.setQuest(randomQuest));
        questRepository.removeQuest(randomQuest);
    }

}
