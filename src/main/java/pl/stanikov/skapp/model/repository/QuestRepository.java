package pl.stanikov.skapp.model.repository;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;
import pl.stanikov.skapp.model.Quest;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class QuestRepository {

    Random rand=new Random();

    List<Quest> questList = new ArrayList<>();

    public void createQuest(String description){
        questList.add(new Quest(description));
    }

    public List<Quest> getAll(){
        return questList;
    }

    public void removeQuest(Quest quest){
        questList.remove(quest);
    }

    @PostConstruct
    public void init(){

    }

    @Override
    public String toString() {
        return "QuestRepository{" +
                "questList=" + questList +
                '}';
    }

    @Scheduled(fixedDelayString = "${questCreationDelay}")
    public void createRandomQuest(){
        List<String> descriptions = new ArrayList<>();
        descriptions.add("Zabij smoka");
        descriptions.add("Przynies 10 jablek");
        descriptions.add("Zabij corke kowala");
        descriptions.add("Znajdz skarb");
        descriptions.add("Zabij dzikie psy");

        String pom = descriptions.get(rand.nextInt(descriptions.size()));
        System.out.println("Utworzono: "+ pom);
        createQuest(descriptions.get(rand.nextInt(descriptions.size())));
    }
}
