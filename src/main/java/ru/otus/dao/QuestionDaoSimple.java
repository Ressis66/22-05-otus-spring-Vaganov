package ru.otus.dao;

import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import ru.otus.domain.Question;

import org.springframework.beans.factory.annotation.Value;

import java.io.FileNotFoundException;
import java.io.FileReader;


import java.util.List;

@PropertySource("classpath:application.properties")
@Component
public class QuestionDaoSimple implements QuestionDao {

  private List<Question> beans;

  @Autowired
  public QuestionDaoSimple(@Value("${questions.file}") String path) throws FileNotFoundException {
    List<Question> beans = new CsvToBeanBuilder<Question>
        (new FileReader(path)).withType(Question.class)
        .build()
        .parse();
    this.beans=beans;
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
