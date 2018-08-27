package examples.boot.jpaexam.service;

import examples.boot.jpaexam.domain.Member;

public interface MemberService {

    public Member addMember(Member member);
    public Member getMemberbyEmail(String email);

}
