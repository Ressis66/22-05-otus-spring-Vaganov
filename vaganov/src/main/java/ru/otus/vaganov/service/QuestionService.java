package ru.otus.vaganov.service;






import ru.otus.vaganov.dao.QuestionDao;
import ru.otus.vaganov.domain.Question;
import ru.otus.vaganov.domain.User;

import java.io.IOException;
import java.util.List;


public interface QuestionService {
     List<Question> getQuestionsList(User user);
     Question getQuestionAccordingToId(int id);
     boolean initTesting(int id, String answer) throws IOException;



}
