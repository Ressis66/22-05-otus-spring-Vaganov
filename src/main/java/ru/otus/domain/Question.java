package ru.otus.domain;

import com.opencsv.bean.CsvBindByName;
import org.springframework.stereotype.Component;

@Component
public class Question {

  @CsvBindByName
  private int question_id;

  @CsvBindByName
  private String question_content;

  @CsvBindByName
  private String a_answer;

  @CsvBindByName
  private String b_answer;

  @CsvBindByName
  private  String right_answer;

  public Question(int question_id, String question_content, String a_answer, String b_answer, String right_answer) {
    this.question_id = question_id;
    this.question_content = question_content;
    this.a_answer = a_answer;
    this.b_answer = b_answer;
    this.right_answer = right_answer;
  }

  public Question(int question_id) {
    this.question_id = question_id;
  }
  public Question() {
  }

  public int getQuestion_id() {
    return question_id;
  }

  public void setQuestion_id(int question_id) {
    this.question_id = question_id;
  }

  public String getQuestion_content() {
    return question_content;
  }

  public void setQuestion_content(String question_content) {
    this.question_content = question_content;
  }

  public String getA_answer() {
    return a_answer;
  }

  public void setA_answer(String a_answer) {
    this.a_answer = a_answer;
  }

  public String getB_answer() {
    return b_answer;
  }

  public void setB_answer(String b_answer) {
    this.b_answer = b_answer;
  }

  public String getRight_answer() {
    return right_answer;
  }

  public void setRight_answer(String right_answer) {
    this.right_answer = right_answer;
  }

  @Override
  public String toString() {
    return "Question{" +
        "question_id=" + question_id +
        ", question_content='" + question_content + '\'' +
        ", a_answer='" + a_answer + '\'' +
        ", b_answer='" + b_answer + '\'' +
        '}';
  }
}
