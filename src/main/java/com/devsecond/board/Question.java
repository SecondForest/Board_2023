package com.devsecond.board;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Question {
//	@Id DB 기본키 지정! 동일한 값으로 저장 못함!!
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 200)
	private String subject;

	@Column(columnDefinition = "TEXT")
	private String content;

	private LocalDateTime createDate;

//	CascadeType.REMOVE : 질문 하나에는 여러개의 답변이 작성될 수 있기에, 이때 질문을 삭제하면
//	그에 달린 답변들도 모두 함께 삭제하기 위해서 @OneToMany의 속성으로 사용함
	@OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
	private List<Answer> answerList;
}
