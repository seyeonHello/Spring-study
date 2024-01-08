package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

//컴포넌트스캔
@Controller
public class MemberController {
    private final MemberService memberService;

    //autowired -> spring빈에 등록되어있는 memberservice를 딱 연결시켜줌? => di
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
