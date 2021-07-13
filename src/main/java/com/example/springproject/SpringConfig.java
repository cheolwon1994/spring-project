package com.example.springproject;

import com.example.springproject.repository.JdbcMemberRepository;
import com.example.springproject.repository.MemberRepository;
import com.example.springproject.repository.MemoryMemberRepository;
import com.example.springproject.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){

        //return new MemoryMemberRepository();
        return new JdbcMemberRepository(dataSource);
    }
}
