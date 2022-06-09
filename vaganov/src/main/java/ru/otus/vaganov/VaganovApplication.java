package ru.otus.vaganov;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.otus.vaganov.domain.User;
import ru.otus.vaganov.service.QuestionService;
import ru.otus.vaganov.service.QuestionServiceImpl;

import java.io.BufferedReader;
import java.io.InputStreamReader;


@SpringBootApplication
public class VaganovApplication {

	public static void main(String[] args) {

		SpringApplication.run(VaganovApplication.class, args);


	}
	}


