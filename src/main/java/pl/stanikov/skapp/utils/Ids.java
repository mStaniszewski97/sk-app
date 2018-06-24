package pl.stanikov.skapp.utils;

import pl.stanikov.skapp.model.Knight;
import pl.stanikov.skapp.model.Quest;

import java.util.Map;
import java.util.Set;

public class Ids {
    static public int getNewId(Map<Integer, Knight> keys){
        if(keys.isEmpty()){
            return 0;
        }
        else {
            int licz=0;
            for (Map.Entry<Integer, Knight> test:keys.entrySet()) {
                licz = test.getKey();
                System.out.println(licz);
            }
            licz=licz+1;
            return licz;
        }
    }

    static public int getNewIdQuest(Map<Integer, Quest> keys){
        if(keys.isEmpty()){
            return 0;
        }
        else {
            int licz=0;
            for (Map.Entry<Integer, Quest> test:keys.entrySet()) {
                licz = test.getKey();
                System.out.println(licz);
            }
            licz=licz+1;
            return licz;
        }
    }
}
