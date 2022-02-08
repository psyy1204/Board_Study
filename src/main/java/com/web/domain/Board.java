package com.web.domain;

import com.web.domain.enums.BoardType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
//Getter메서드를 자동생성해준다
@NoArgsConstructor
@Entity
//JPA가 관리하는 클래스, JPA를 사용해서 테이블과 매핑할 클래스는 반드시 붙여야함
@Table
//엔티티와 매핑할 테이블을 지정
public class Board implements Serializable {

    @Id
    //기본키 매핑
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //기본키가 자동으로 할당되도록 설정-> 키생성을 DB에 위임하는 identity 전략
    private Long idx;

    @Column
    //객체 필드를 테이블 컬럼에 매핑
    private String title;

    @Column
    private String subTitle;

    @Column
    private String content;

    @Column
    @Enumerated(EnumType.STRING)
    private BoardType boardType;
    //Enum 타입 매핑용, enum형과 DB의 데이터 변환을 지원
    //실제로 자바 enum형이지만 String으로 저장하겠다고 선언한것

    @Column
    private LocalDateTime createdDate;

    @Column
    private  LocalDateTime updatedDate;

    @Builder
    public Board(String title, String subTitle,String content, BoardType boardType,
                 LocalDateTime createdDate, LocalDateTime updatedDate, User user) {
        this.title = title;
        this.subTitle = subTitle;
        this.content = content;
        this.boardType = boardType;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.user = user;
    }

    @OneToOne(fetch = FetchType.LAZY)
    //도메인 Board와 User 도메인을 1:1 관계로 설정, user PK인 user_idx값이 저장된다
    //eager 처음 board도메인 조회시 즉시 관련 user 함께 조회
    //lazy user가 실제로 사용될때 조회
    private User user;
}
