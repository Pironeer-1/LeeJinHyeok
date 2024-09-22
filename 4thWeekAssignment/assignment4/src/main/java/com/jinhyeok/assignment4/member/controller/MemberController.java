package com.jinhyeok.assignment4.member.controller;

import com.jinhyeok.assignment4.global.dto.response.SuccessResponse;
import com.jinhyeok.assignment4.global.dto.response.result.JwtTokenSet;
import com.jinhyeok.assignment4.global.dto.response.result.ListResult;
import com.jinhyeok.assignment4.global.dto.response.result.SingleResult;
import com.jinhyeok.assignment4.member.dto.request.MemberLoginRequest;
import com.jinhyeok.assignment4.member.dto.request.MemberSignupRequest;
import com.jinhyeok.assignment4.member.dto.response.MemberResponse;
import com.jinhyeok.assignment4.member.entity.Member;
import com.jinhyeok.assignment4.member.service.MemberService;
import com.sun.net.httpserver.Authenticator;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
@Tag(name = "Member")
public class MemberController {
    private final MemberService memberService;

    @PostMapping
    public SuccessResponse<SingleResult<JwtTokenSet>> signup(@Valid @RequestBody MemberSignupRequest request) {
        SingleResult<JwtTokenSet> jwtTokenSet = memberService.save(request);
        return SuccessResponse.ok(jwtTokenSet);
    }

    @PostMapping("/login")
    public SuccessResponse<SingleResult<JwtTokenSet>> login(@Valid @RequestBody MemberLoginRequest request) {
        SingleResult<JwtTokenSet> jwtTokenSet = memberService.login(request);
        return SuccessResponse.ok(jwtTokenSet);
    }

    @GetMapping
    public SuccessResponse<ListResult<MemberResponse>> readAllMembers() {
        ListResult<MemberResponse> memberResponseList = memberService.findAllMembers();
        return SuccessResponse.ok(memberResponseList);
    }

    @GetMapping("/{memberId}")
    public SuccessResponse<SingleResult<MemberResponse>> read(@PathVariable("memberId") Long id) {
        SingleResult<MemberResponse> response = memberService.findById(id);
        return SuccessResponse.ok(response);
    }
}
