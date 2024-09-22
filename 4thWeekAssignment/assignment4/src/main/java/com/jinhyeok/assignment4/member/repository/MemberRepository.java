package com.jinhyeok.assignment4.member.repository;

import com.jinhyeok.assignment4.board.entity.Board;
import com.jinhyeok.assignment4.member.entity.Member;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class MemberRepository {
    private final AtomicLong memberIdxGenerator = new AtomicLong(0);
    private final Map<Long, Member> memberMap = new HashMap<Long, Member>();

}
