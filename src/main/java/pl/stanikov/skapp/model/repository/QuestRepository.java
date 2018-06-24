package pl.stanikov.skapp.model.repository;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;
import pl.stanikov.skapp.model.Quest;
import pl.stanikov.skapp.utils.Ids;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
public class QuestRepository {

    Random rand=new Random();

    Map<Integer, Quest> quests = new HashMap<>();

    public void createQuest(String description){
        int questId = Ids.getNewIdQuest(quests);
        quests.put(questId, new Quest(questId, description));
    }

    public List<Quest> getAll(){
        return new ArrayList<>(quests.values());
    }

    public void removeQuest(Quest quest){
        quests.remove(quest.getId());
    }

    @PostConstruct
    public void init(){

    }

    @Override
    public String toString() {
        return "QuestRepository{" +
                "quests=" + quests +
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

    public void update(Quest pomQuest) {
        quests.put(pomQuest.getId(),pomQuest);
    }

    public Quest getQuest(Integer id) {
        return quests.get(id);
    }
}
