package ru.otus;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.otus.dao.QuestionDao;
import ru.otus.dao.QuestionDaoSimple;
import ru.otus.domain.Question;
import ru.otus.domain.User;
import ru.otus.service.QuestionService;
import ru.otus.service.QuestionServiceImpl;

import java.io.FileNotFoundException;

public class ApplicationTest {

  ApplicationTest() throws FileNotFoundException {
  }

  QuestionDao simple = new QuestionDaoSimple("src/main/resources/QuestionsList.csv");
  QuestionService service = new QuestionServiceImpl(simple);

  @Test
  void contextLoads()  {
    Question question = new Question(4, "They arrived in the neighbourhood ......................... days ......................... .",
        "few … since", "a few … ago", "b_answer");
    Question question2 = new Question(5, "She was ......................... dark glasses because she didn’t want to be recognised.",
        "carrying", "wearing", "b_answer");
    User user = new User("Dave", "Server");
    Assertions.assertEquals(simple.getQuestion(3).getQuestion_id(), question.getQuestion_id());
    Assertions.assertNotNull(service.getQuestionsList(user));
    Assertions.assertEquals(service.getQuestionAccordingToId(3).getQuestion_id(), question.getQuestion_id());

  }
}
