package pl.stanikov.skapp.model.repository;

import pl.stanikov.skapp.model.Knight;

import java.util.Collection;
import java.util.Optional;

public class DBKnightRepository implements KnightRepository {
    @Override
    public void createKnight(String name, int age) {
        System.out.println("Uzywam DB");
    }

    @Override
    public Collection<Knight> getAllKnights() {
        System.out.println("Uzywam DB");
        return null;
    }

    @Override
    public Optional<Knight> getKnight(String name) {
        System.out.println("Uzywam DB");
        return null;
    }

    @Override
    public void deleteKnight(Integer id) {
        System.out.println("Uzywam DB");
    }

    @Override
    public void build() {

    }

    @Override
    public Knight getKnightById(Integer id) {
        return null;
    }
}
