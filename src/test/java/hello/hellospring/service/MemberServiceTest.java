package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemoryMemberRepository memberRepository;

    MemberService memberService;
    @BeforeEach
    public void beforeEach() {
        memberRepository=new MemoryMemberRepository();
        memberService=new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach() {
        System.out.println(memberRepository);
        memberRepository.clearStore();
    }

    @Test
    void join() {
        //given
        Member member = new Member();
        member.setName("hello");
        //when
        Long saveId=memberService.join(member);
        //then
        Member findMember=memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }
    @Test
    void duplicate_join() {
        Member member1 = new Member();
        member1.setName("hello");

        Member member2 = new Member();
        member2.setName("hello");

        memberService.join(member1);
        assertThrows(IllegalStateException.class, ()->memberService.join(member2)); //오른쪽 실행하면 왼쪽이 발생
//        try {
//            memberService.join(member2);
//            fail();
//        } catch (IllegalStateException e) {
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        }
    }
    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}