package pl.stanikov.skapp.model.repository;

import org.springframework.stereotype.Repository;
import pl.stanikov.skapp.model.Knight;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryRepository implements KnightRepository {


    Map<Integer, Knight> knights = new HashMap<>();

    public InMemoryRepository(){
    }

    @Override
    public void createKnight(String name, int age){
        Knight newKnight = new Knight(name, age);
        newKnight.setId(getNewId());
        knights.put(newKnight.getId(), newKnight);
    }

    @Override
    public Collection<Knight> getAllKnights(){
        return knights.values();
    }

    @Override
    public Optional<Knight> getKnight(String name){

        Optional<Knight> knightByName = knights.values().stream().filter(knight -> knight.getName().equals(name)).findAny();

        return knightByName;
    }

    @Override
    public void deleteKnight(Integer id){
        knights.remove(id);
    }


    @Override
    @PostConstruct
    public void build(){
        createKnight("Lancelot", 29);
        createKnight("Stanikov", 20);
    }

    @Override
    public Knight getKnightById(Integer id) {
        return knights.get(id);
    }

    @Override
    public String toString() {
        return "KnightRepository{" +
                "knights=" + knights +
                '}';
    }

    public int getNewId(){
        if(knights.isEmpty()){
            return 0;
        }
        else {
            Integer pom = knights.keySet().stream().max(Integer::max).get();
            System.out.println(pom);
            return pom+1;
        }
    }
}
