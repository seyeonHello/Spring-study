package hello.hellospring.service;

import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import javax.swing.*;

@Configuration
public class SpringConfig {
//    private DataSource dataSource;
//    //di 스프링부트가 db정보보고 datasource를 만들어주고 주입해줌
//    @Autowired
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource=dataSource;
//    }
    private EntityManager em;
    public SpringConfig(EntityManager em){
        this.em=em;
    }
    // memberService가 spring bean에 등록됨
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new JpaMemberRepository(em);
    }
}
