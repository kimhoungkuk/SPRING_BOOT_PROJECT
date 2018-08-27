package examples.boot.jpaexam.service;

import examples.boot.jpaexam.domain.Member;
import examples.boot.jpaexam.domain.MemberRole;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Test
    public void addMember() throws  Exception{
        Member member = new Member();
        member.setName("hong");
        member.setEmail("hong@naver.com");
        member.setPassword("1234");
        member = memberService.addMember(member);

        System.out.println(member.getId());

        Member member2 = memberService.getMemberbyEmail("hong@naver.com");

        System.out.println(member2);
        for(MemberRole memberRole : member2.getMemberRoles()){
            System.out.println(memberRole.getName());
        }

    }
}
