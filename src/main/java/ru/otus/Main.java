package ru.otus;

import ru.otus.domain.Question;
import ru.otus.domain.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.springframework.context.annotation.ComponentScan;

import org.springframework.context.annotation.PropertySource;
import ru.otus.service.QuestionService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;


@ComponentScan
public class Main {

  public static void main(String[] args) throws IOException {

    User user = new User("Jack", "Daniels");
    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(Main.class);
    QuestionService service = context.getBean(QuestionService.class);
    List<Question> questions = service.getQuestionsList(user);
    for (Question q : questions) {
      System.out.println(q.toString());
    }
    System.out.println("______________________________________________");
    System.out.println(user.getName() + ", please, enter question_id and, after comma, name of the right answer");
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String answer = reader.readLine();
    service.initTesting(answer);
  }
}
