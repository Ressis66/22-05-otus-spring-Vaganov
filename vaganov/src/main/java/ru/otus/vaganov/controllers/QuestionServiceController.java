package ru.otus.vaganov.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.vaganov.domain.Question;
import ru.otus.vaganov.domain.User;
import ru.otus.vaganov.service.QuestionService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = QuestionServiceController.REST_URL)
public class QuestionServiceController {
  public static final String REST_URL = "/api/v1/questions";

  @Autowired
  QuestionService service;

  User user = new User("USER", "VOOD");

  @GetMapping
  public ResponseEntity<List<Question>> getAll(){

    return new ResponseEntity<>(service.getQuestionsList(user), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public Question getQuestion(@PathVariable("id") int id)  {

    return service.getQuestionAccordingToId(id);
  }

  @PostMapping("/ask/{questionId}")
  public ResponseEntity<String> admin(

      @PathVariable("questionId") int id ,
      @RequestParam(value = "answer") String answer) throws IOException {
      if (service.initTesting(id, answer)) {
      return new ResponseEntity<String>("Good",HttpStatus.OK);
    } else {
      return new ResponseEntity<String>("Bad", HttpStatus.FORBIDDEN);
    }
  }

}
