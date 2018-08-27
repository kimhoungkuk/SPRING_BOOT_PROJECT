package examples.boot.jpaexam.service;

import examples.boot.jpaexam.domain.Member;
import examples.boot.jpaexam.domain.MemberRole;
import examples.boot.jpaexam.repository.MemberRepository;
import examples.boot.jpaexam.repository.MemberRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    MemberRoleRepository memberRoleRepository;

    @Override
    @Transactional
    public Member addMember(Member member) {
        // 파라미터로 들어오는 member (name, email, password)
        // password는 암호화하여 다시 설정
        // 비밀번호 암호화
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        member.setPassword(passwordEncoder.encode(member.getPassword()));
        // 날짜정보도 설정
        member.setJoinDate(LocalDateTime.now());
        // MemberRole에 대한 설정도 해야한다. MemberRoleRepository를 만든다.
        // role name이 "ROLE_USER"인 것을 읽어와서 Member의 memberRoles에 설정
        Set<MemberRole> memberroles = new HashSet<>();
        memberroles.add(memberRoleRepository.findByName("ROLE_USER"));
        member.setMemberRoles(memberroles);
        // Member를 저장하고 리턴한다.
        member = memberRepository.save(member);
        return member;
    }

    @Override
    @Transactional(readOnly = true)
    public Member getMemberbyEmail(String email) {
        return memberRepository.findByEmail(email);
    }
}
