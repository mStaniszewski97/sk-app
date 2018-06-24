package pl.stanikov.skapp.model.repository;

import pl.stanikov.skapp.model.Knight;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Optional;

public interface KnightRepository {
    void createKnight(String name, int age);

    Collection<Knight> getAllKnights();

    Optional<Knight> getKnight(String name);

    void deleteKnight(Integer id);

    void build();

    Knight getKnightById(Integer id);

    default void updateKnight(int id, Knight knight){

    }
}
