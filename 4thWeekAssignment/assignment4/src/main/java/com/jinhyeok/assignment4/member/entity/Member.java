package com.jinhyeok.assignment4.member.entity;

import lombok.Builder;
import lombok.Data;

@Data
public class Member {
    private Long id;
    private String memberId;
    private String password;
    private String userName;

    @Builder
    public Member(Long id,
                  String memberId,
                  String password,
                  String userName) {
        this.id = id;
        this.memberId = memberId;
        this.password = password;
        this.userName = userName;
    }
}
