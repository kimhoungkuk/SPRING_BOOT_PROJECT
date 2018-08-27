package examples.boot.jpaexam.repository;

import examples.boot.jpaexam.domain.Member;
import examples.boot.jpaexam.domain.MemberRole;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

@RunWith(SpringRunner.class)
@DataJpaTest
@TestPropertySource(locations = "classpath:application.yml")
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class MemberRepositoryTest {
    @Autowired
    MemberRepository memberRepository;

    @Test
    public void getRoles() throws Exception{
        Member member = memberRepository.getOne(1L);
        Set<MemberRole> memberRoles = member.getMemberRoles();
        for(MemberRole memberRole : memberRoles){
            System.out.println(memberRole.getId());
            System.out.println(memberRole.getName());
        }
        System.out.println("---------------------------");
    }
}
