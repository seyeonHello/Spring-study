package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
// spring이 memberservice를 컨테이너에 등록시킴
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    // memberservice를 스프링이 생성할 때, 스프링컨테이너에있는 memberrepository 등록
    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository=memberRepository; //DI
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }
    //회원가입
    public Long join(Member member) {
        //중복회원x
        validateDuplicateMember(member);
        System.out.println(memberRepository);

        memberRepository.save(member);
        return member.getId();
    }
    //전체회원조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
