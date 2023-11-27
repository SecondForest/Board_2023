package com.devsecond.board;

import com.devsecond.board.question.Question;
import com.devsecond.board.question.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class BoardApplicationTests {

	@Autowired
	private QuestionRepository questionRepository;
	@Test
	void testJpa() {
		Question q1 = new Question();
		q1.setSubject("board가 무엇인가?");
		q1.setContent("board에 대해서 알고 싶습니다.");
		q1.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q1); // 첫번째 질문 저장

		Question q2 = new Question();
		q2.setSubject("스프링부트 모델 질문입니다.");
		q2.setContent("id는 자동으로 생성되나요?");
		q2.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q2); // 2번째 질문 저장
	}

}
