package com.jinhyeok.assignment4.member.service;

import com.jinhyeok.assignment4.board.dto.response.BoardResponse;
import com.jinhyeok.assignment4.global.dto.response.result.JwtTokenSet;
import com.jinhyeok.assignment4.global.dto.response.result.ListResult;
import com.jinhyeok.assignment4.global.dto.response.result.SingleResult;
import com.jinhyeok.assignment4.global.exception.CustomException;
import com.jinhyeok.assignment4.global.exception.ErrorCode;
import com.jinhyeok.assignment4.global.service.AuthService;
import com.jinhyeok.assignment4.global.service.ResponseService;
import com.jinhyeok.assignment4.member.dto.request.MemberLoginRequest;
import com.jinhyeok.assignment4.member.dto.request.MemberSignupRequest;
import com.jinhyeok.assignment4.member.dto.response.MemberResponse;
import com.jinhyeok.assignment4.member.entity.Member;
import com.jinhyeok.assignment4.member.mapper.MemberMapper;
import com.jinhyeok.assignment4.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final AuthService authService;

    public SingleResult<JwtTokenSet> save(MemberSignupRequest request) {
        if(memberRepository.existByMemberId(request.memberId()))
            throw new CustomException(ErrorCode.USER_ALREADY_EXIST);

        Member newMember = memberRepository.save(MemberMapper.from(request));

        JwtTokenSet jwtTokenSet = authService.generateToken(newMember.getId());
        return ResponseService.getSingleResult(jwtTokenSet);
    }

    public SingleResult<JwtTokenSet> login(MemberLoginRequest request) {
        Member member = memberRepository.findByMemberId(request.memberId())
               .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_EXIST));

        if (!member.getPassword().equals(request.password())){
            throw new CustomException(ErrorCode.USER_WRONG_PASSWORD);
        }

        JwtTokenSet jwtTokenSet = authService.generateToken(member.getId());

        return ResponseService.getSingleResult(jwtTokenSet);
    }

    public ListResult<MemberResponse> findAllMembers() {
        List<Member> members = memberRepository.findAll();
        List<MemberResponse> memberResponseList = members.stream().map(MemberResponse::of).toList();
        return ResponseService.getListResult(memberResponseList);
    }

    public SingleResult<MemberResponse> findById(Long id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_EXIST));
        return ResponseService.getSingleResult(MemberResponse.of(member));
    }
}
