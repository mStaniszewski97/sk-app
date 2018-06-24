package pl.stanikov.skapp.model;

import org.hibernate.validator.constraints.Range;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Component
public class Knight {

    private int id;

    @NotNull
    @Size(min = 2,max = 40, message = "Bledne imie")
    private String name;
    @NotNull
    @Range(min = 14, max = 80, message = "Bledny wiek")
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
        quest.setStarted(true);
        this.quest = quest;
    }

    public Quest getQuest() {
        return quest;
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
