package com.jinhyeok.assignment4.member.mapper;

import com.jinhyeok.assignment4.member.dto.request.MemberSignupRequest;
import com.jinhyeok.assignment4.member.entity.Member;

public class MemberMapper {
    public static Member from (MemberSignupRequest request) {
        return Member.builder()
                .memberId(request.memberId())
                .password(request.password())
                .userName(request.userName())
                .build();
    }
}
