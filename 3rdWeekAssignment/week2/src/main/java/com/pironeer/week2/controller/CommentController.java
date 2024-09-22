package com.pironeer.week2.controller;

import com.pironeer.week2.dto.request.CommentCreateRequest;
import com.pironeer.week2.dto.request.CommentUpdateRequest;
import com.pironeer.week2.dto.request.TopicUpdateRequest;
import com.pironeer.week2.dto.response.CommentResponse;
import com.pironeer.week2.dto.response.TopicResponse;
import com.pironeer.week2.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comment")
public class CommentController {
    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CommentCreateRequest request) {
        commentService.save(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{commentId}")
    public ResponseEntity<CommentResponse> read(@PathVariable("commentId") Long id) {
        CommentResponse response = commentService.findById(id);
        return ResponseEntity.ok().body(response);
    }

    @PatchMapping
    public ResponseEntity<CommentResponse> update(@RequestBody CommentUpdateRequest request) {
        CommentResponse commentResponse = commentService.update(request);
        return ResponseEntity.ok().body(commentResponse);
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<?> delete(@PathVariable("commentId") Long id) {
        commentService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<CommentResponse>> readAll() {
        List<CommentResponse> responses = commentService.findAll();
        return ResponseEntity.ok().body(responses);
    }
}
