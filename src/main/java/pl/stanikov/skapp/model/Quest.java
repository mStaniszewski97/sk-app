package pl.stanikov.skapp.model;


import jdk.vm.ci.meta.Local;

import java.time.LocalDateTime;

public class Quest {

    private int id;

    private String description;

    private int reward = 100;

    private int lenghtInSeconds = 5;

    private boolean started=false;

    private boolean completed=false;

    private LocalDateTime startDate;

    public Quest(int id, String description){
        this.id=id;
        this.description=description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public int getLenght() {
        return lenghtInSeconds;
    }

    public void setLenght(int lenght) {
        this.lenghtInSeconds = lenght;
    }

    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {
        if(started){
            this.startDate= LocalDateTime.now();
        }
        this.started = started;
    }

    public boolean isCompleted() {

        if(this.completed){
            return this.completed;
        }
        LocalDateTime now = LocalDateTime.now();

        LocalDateTime pom = this.startDate.plusSeconds(lenghtInSeconds);

        boolean isAfter = now.isAfter(pom);

        if(isAfter){
            this.completed=true;
        }

        return isAfter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id=id;
    }

    @Override
    public String toString() {
        return description;
    }
}
