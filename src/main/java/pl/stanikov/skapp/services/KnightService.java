package pl.stanikov.skapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.stanikov.skapp.model.Knight;
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
}
