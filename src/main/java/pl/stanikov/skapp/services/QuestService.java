package pl.stanikov.skapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pl.stanikov.skapp.model.Quest;
import pl.stanikov.skapp.model.repository.InMemoryRepository;
import pl.stanikov.skapp.model.repository.KnightRepository;
import pl.stanikov.skapp.model.repository.QuestRepository;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class QuestService {

    @Autowired
    KnightRepository knightRepository;

    QuestRepository questRepository;

    final static Random rand=new Random();

    public void assignRandomQuest(String knightName){
        Quest randomQuest = questRepository.getAll().get(rand.nextInt(questRepository.getAll().size()));
        knightRepository.getKnight(knightName).ifPresent(knight -> knight.setQuest(randomQuest));
        questRepository.removeQuest(randomQuest);
    }

    public List<Quest> getAllNotStartedQuests() {
        return questRepository.getAll().stream().filter(quest -> !quest.isStarted()).collect(Collectors.toList());
    }

    @Autowired
    public void setQuestRepository(QuestRepository questRepository){
        this.questRepository=questRepository;
    }

    public void update(Quest pomQuest) {
        questRepository.update(pomQuest);
    }

    public boolean isQuestCompleted(Quest quest){
        return quest.isCompleted();
    }
}
