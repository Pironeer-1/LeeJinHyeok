package com.jinhyeok.assignment4.member.repository;

import com.jinhyeok.assignment4.board.entity.Board;
import com.jinhyeok.assignment4.member.entity.Member;
import io.jsonwebtoken.lang.Assert;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class MemberRepository {
    private final AtomicLong memberIdxGenerator = new AtomicLong(0);
    private final Map<Long, Member> memberMap = new HashMap<>();



    public Member save(Member member) {
        if (member.getId() == null) {
            Long id = memberIdxGenerator.incrementAndGet();
            member.setId(id);
            memberMap.put(id, member);
            return member;
        }
        else {
            memberMap.replace(member.getId(), member);
            return member;
        }
    }

    public Optional<Member> findByMemberId(String memberId) {
        return memberMap.values().stream()
                .filter(data -> data.getMemberId().equals(memberId))
                .findAny();

    }

    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(memberMap.get(id));
    }

    public Boolean existByMemberId(String memberId) {
        return memberMap.values().stream()
                .anyMatch(data -> data.getMemberId().equals(memberId));
    }

    public List<Member> findAll() {
        return memberMap.values().stream().toList();
    }
}
