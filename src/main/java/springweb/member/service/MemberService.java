package springweb.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springweb.member.repository.MemberRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {
    public MemberRepository memberRepository;
}
