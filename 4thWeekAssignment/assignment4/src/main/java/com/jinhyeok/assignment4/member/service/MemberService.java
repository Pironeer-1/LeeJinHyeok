package com.jinhyeok.assignment4.member.service;

import com.jinhyeok.assignment4.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
}
