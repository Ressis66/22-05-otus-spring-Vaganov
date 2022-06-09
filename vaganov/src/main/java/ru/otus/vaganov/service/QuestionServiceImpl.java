package ru.otus.vaganov.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.vaganov.dao.QuestionDao;
import ru.otus.vaganov.domain.Question;
import ru.otus.vaganov.domain.User;


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
  public boolean initTesting(int id, String answer) throws IOException {

    Question question = getQuestionAccordingToId(id);
    if (question.getRight_answer().equals(answer))
      return true;
    else return false;
  }



}


