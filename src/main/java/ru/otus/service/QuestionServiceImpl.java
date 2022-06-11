package ru.otus.service;

import ru.otus.dao.QuestionDao;
import ru.otus.domain.Question;
import ru.otus.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

  @Autowired
  private QuestionDao questionDao;

  public QuestionServiceImpl(QuestionDao questionDao){
    this.questionDao=questionDao;
  }

  @Override
  public List<Question> getQuestionsList(User user) {
    if(user==null) return null;
    else return questionDao.getList();
  }

  @Override
  public Question getQuestionAccordingToId(int id){ return questionDao.getQuestion(id); }


  @Override
  public void initTesting(String answer)  {

    List<String> items = Arrays.asList(answer.split("\\s*,\\s*"));
    Question question = questionDao.getQuestion(Integer.parseInt(items.get(0)));
    if (question.getRight_answer().equals(items.get(1)))
      System.out.println("You are lucky boy!");
    else System.out.println("You are stupid boy!");

  }

}
