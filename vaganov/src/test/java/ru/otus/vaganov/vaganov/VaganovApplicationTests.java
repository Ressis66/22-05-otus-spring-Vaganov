package ru.otus.vaganov.vaganov;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.vaganov.dao.QuestionDao;
import ru.otus.vaganov.dao.QuestionDaoSimple;
import ru.otus.vaganov.domain.Question;
import ru.otus.vaganov.domain.User;
import ru.otus.vaganov.service.QuestionService;
import ru.otus.vaganov.service.QuestionServiceImpl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class VaganovApplicationTests {

	VaganovApplicationTests() throws FileNotFoundException {
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

	@Test
	void testingLoads() throws IOException {
		int id = 2;
		String answer = "b_answer";
		Assertions.assertTrue(service.initTesting(2,answer));

	}

}
