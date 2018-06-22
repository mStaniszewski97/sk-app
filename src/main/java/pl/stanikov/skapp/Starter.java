package pl.stanikov.skapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.stanikov.skapp.model.repository.InMemoryRepository;
import pl.stanikov.skapp.model.repository.KnightRepository;
import pl.stanikov.skapp.model.repository.QuestRepository;
import pl.stanikov.skapp.services.QuestService;

@Component
public class Starter implements CommandLineRunner {

    @Autowired
    KnightRepository knightRepository;

    @Autowired
    QuestRepository questRepository;

    @Autowired
    QuestService questService;

    @Override
    public void run(String... args) {

        questRepository.createRandomQuest();
        questRepository.createRandomQuest();
        questRepository.createRandomQuest();

    }
}
