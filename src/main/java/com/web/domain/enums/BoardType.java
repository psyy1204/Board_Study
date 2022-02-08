package com.web.domain.enums;
//enum class: 서로 연관된 상수들의 집합
// final static string 과 같이 문자열이나 숫자들을 나타내는 기본자료형의 값을 enum을 이용해서 같은 효과를 낼 수 있다
public enum BoardType {
    notice("공지사항"),
    free("자유게시판");

    private String value;

    BoardType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
