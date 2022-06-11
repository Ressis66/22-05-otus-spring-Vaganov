package ru.otus.service;



import ru.otus.domain.Question;
import ru.otus.domain.User;


import java.io.IOException;
import java.util.List;


public interface QuestionService {
     List<Question> getQuestionsList(User user);
     Question getQuestionAccordingToId(int id);
     void initTesting(String answer) throws IOException;
}
