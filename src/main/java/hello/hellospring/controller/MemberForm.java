package hello.hellospring.controller;

public class MemberForm {
    private String name;

    public String getName() {
        return name;
    }
//spring이 setName으로 넣어줌
    public void setName(String name) {
        this.name = name;
    }
}
