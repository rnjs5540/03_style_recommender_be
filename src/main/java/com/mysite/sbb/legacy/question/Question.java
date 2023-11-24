package com.mysite.sbb.legacy.question;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.mysite.sbb.legacy.answer.Answer;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Question {
    @Id
    // GeneratedValue: 1씩 자동으로 증가하여 저장
    // strategy: 고유번호를 생성하는 옵션
    // GenerationType.IDENTITY: 해당 컬럼만의 독립적인 시퀀스를 생성하여 번호를 증가시킬 때 사용
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String subject;

    @Column(columnDefinition = "TEXT")  // 글자 수를 제한할 수 없는 경우
    private String content;

    private LocalDateTime createDate;

    // mappedBy: Answer 엔티티에서 참조한 속성
    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<Answer> answerList;
    // question 객체에서 답변을 참조하려면 question.getAnswerList()를 호출
}