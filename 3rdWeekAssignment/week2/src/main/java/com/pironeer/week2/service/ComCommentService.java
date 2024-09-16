package com.pironeer.week2.service;

import com.pironeer.week2.dto.request.ComCommentCreateRequest;
import com.pironeer.week2.dto.request.CommentUpdateRequest;
import com.pironeer.week2.dto.response.ComCommentResponse;
import com.pironeer.week2.dto.response.CommentResponse;
import com.pironeer.week2.repository.ComCommentRepository;
import com.pironeer.week2.repository.CommentRepository;
import com.pironeer.week2.repository.domain.ComComment;
import com.pironeer.week2.repository.domain.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ComCommentService {
    private final ComCommentRepository comCommentRepository;
    private final CommentRepository commentRepository;

    public void save(ComCommentCreateRequest request) {
        if (commentRepository.findById(request.commentId()).isEmpty()) {
            throw new RuntimeException("COMMENT NOT FOUND");
        }

        ComComment comComment = ComComment.builder()
                .commentId(request.commentId())
                .content(request.content())
                .updatedAt(LocalDateTime.now())
                .build();

        comCommentRepository.save(comComment);
    }

    public ComCommentResponse findById(Long id) {
        ComComment comComment = comCommentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("COMCOMMENT NOT FOUND"));
        return ComCommentResponse.of(comComment);
    }

    public ComCommentResponse update(CommentUpdateRequest request) {
        ComComment comComment = comCommentRepository.findById(request.id())
                .orElseThrow(()-> new RuntimeException("COMCOMMENT NOT FOUND"));

        comComment.setContent(request.content());
        comComment.setUpdatedAt(LocalDateTime.now());
        comCommentRepository.save(comComment);
        return ComCommentResponse.of(comComment);
    }

    public void deleteById(Long id) {
        comCommentRepository.deleteById(id);
    }

    public List<ComCommentResponse> findAll() {
        List<ComComment> comComments = comCommentRepository.findAll();
        return comComments.stream().map(ComCommentResponse::of).toList();
    }
}
