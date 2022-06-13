package ru.otus.vaganov.dao;

import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import ru.otus.vaganov.domain.Question;

import java.io.FileNotFoundException;
import java.io.FileReader;


import java.util.List;


@Component
public class QuestionDaoSimple implements QuestionDao {

  private List<Question> beans;

  public QuestionDaoSimple(@Value("${datasource.data}") String data) throws FileNotFoundException {
    List<Question> beans = new CsvToBeanBuilder<Question>
        (new FileReader(data)).withType(Question.class)
        .build()
        .parse();
    this.beans= beans;
    }



  @Override
  public List<Question> getList() {
    return beans;
  }

  @Override
  public Question getQuestion(int id) {
    return beans.get(id);
  }


}
