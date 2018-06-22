package pl.stanikov.skapp.model;

import org.springframework.stereotype.Component;

@Component
public class Knight {

    private int id;
    private String name;
    private int age;
    private int level;

    private Quest quest;

    public Knight(){
    }

    public Knight(String name, int age){
        this.name=name;
        this.age=age;
        this.level=1;
    }

    public Knight(String name, int age, Quest quest){
        this.name=name;
        this.age=age;
        this.quest=quest;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setQuest(Quest quest) {
        this.quest = quest;
    }


    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return this.name +  " " + this.age+" zadanie "+this.quest;
    }
}
