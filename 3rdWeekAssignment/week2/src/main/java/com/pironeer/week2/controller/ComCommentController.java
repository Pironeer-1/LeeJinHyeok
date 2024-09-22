package com.pironeer.week2.controller;

import com.pironeer.week2.dto.request.ComCommentCreateRequest;
import com.pironeer.week2.dto.request.CommentCreateRequest;
import com.pironeer.week2.dto.request.CommentUpdateRequest;
import com.pironeer.week2.dto.response.ComCommentResponse;
import com.pironeer.week2.dto.response.CommentResponse;
import com.pironeer.week2.service.ComCommentService;
import com.pironeer.week2.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/com_comment")
public class ComCommentController {
    private final ComCommentService comCommentService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ComCommentCreateRequest request) {
        comCommentService.save(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{comCommentId}")
    public ResponseEntity<ComCommentResponse> read(@PathVariable("comCommentId") Long id) {
        ComCommentResponse response = comCommentService.findById(id);
        return ResponseEntity.ok().body(response);
    }

    @PatchMapping
    public ResponseEntity<ComCommentResponse> update(@RequestBody CommentUpdateRequest request) {
        ComCommentResponse response = comCommentService.update(request);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{comCommentId}")
    public ResponseEntity<?> delete(@PathVariable("comCommentId") Long id) {
        comCommentService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<ComCommentResponse>> readAll() {
        List<ComCommentResponse> responses = comCommentService.findAll();
        return ResponseEntity.ok().body(responses);
    }

}