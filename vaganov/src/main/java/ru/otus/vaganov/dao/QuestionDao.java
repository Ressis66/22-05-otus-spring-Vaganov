package ru.otus.vaganov.dao;



import ru.otus.vaganov.domain.Question;

import java.util.List;

public interface QuestionDao {
  List<Question> getList();
  Question getQuestion(int id);

}
