package pl.stanikov.skapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Service;
import pl.stanikov.skapp.model.Quest;
import pl.stanikov.skapp.model.repository.QuestRepository;

import java.text.ParseException;
import java.util.Locale;

@Service
public class QuestFormatter implements Formatter<Quest> {

    @Autowired
    QuestRepository questRepository;

    @Override
    public Quest parse(String idString, Locale locale) throws ParseException {
        Integer id= Integer.parseInt(idString);
        return questRepository.getQuest(id);
    }

    @Override
    public String print(Quest object, Locale locale) {
        return object.toString();
    }
}
