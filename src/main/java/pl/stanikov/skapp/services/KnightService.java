package pl.stanikov.skapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.stanikov.skapp.model.Knight;
import pl.stanikov.skapp.model.PlayerInformation;
import pl.stanikov.skapp.model.repository.KnightRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class KnightService {

    @Autowired
    KnightRepository knightRepository;

    public List<Knight> getAllKnights(){
        return new ArrayList<>(knightRepository.getAllKnights());
    }

    public void saveKnight(Knight knight){
        knightRepository.createKnight(knight.getName(),knight.getAge());
    }

    public Knight getKnight(Integer id) {
        return knightRepository.getKnightById(id);
    }

    public void deleteKnight(Integer id) {
        knightRepository.deleteKnight(id);
    }

    public void updateKnight(Knight knight) {
        knightRepository.updateKnight(knight.getId(), knight);
    }

    public int collectRewards() {
        int sum = knightRepository.getAllKnights().stream().filter(knight -> knight.getQuest().isCompleted())
                .mapToInt(knight -> knight.getQuest().getReward())
                .sum();
        knightRepository.getAllKnights().stream().filter(knight -> knight.getQuest().isCompleted()).forEach(knight ->
        {
            knight.setQuest(null);
        });
        return sum;
    }
}
