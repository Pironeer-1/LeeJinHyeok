package com.pironeer.week2.service;

import com.pironeer.week2.dto.request.CommentCreateRequest;
import com.pironeer.week2.dto.request.CommentUpdateRequest;
import com.pironeer.week2.dto.request.TopicCreateRequest;
import com.pironeer.week2.dto.response.ComCommentResponse;
import com.pironeer.week2.dto.response.CommentResponse;
import com.pironeer.week2.dto.response.TopicResponse;
import com.pironeer.week2.repository.ComCommentRepository;
import com.pironeer.week2.repository.CommentRepository;
import com.pironeer.week2.repository.TopicRepository;
import com.pironeer.week2.repository.domain.Comment;
import com.pironeer.week2.repository.domain.Topic;
import lombok.RequiredArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final TopicRepository topicRepository;
    private final ComCommentRepository comCommentRepository;
    public void save(CommentCreateRequest request) {
        if (topicRepository.findById(request.topicId()).isEmpty()) {
            throw new RuntimeException("TOPIC NOT FOUND");
        }

        Comment comment = Comment.builder()
                        .topicId(request.topicId())
                                .content(request.content())
                                        .updatedAt(LocalDateTime.now())
                                                .build();
        commentRepository.save(comment);
    }

    public CommentResponse findById(Long commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(()-> new RuntimeException("COMMENT NOT FOUND"));

        return CommentResponse.of(comment);
    }

    public CommentResponse update(CommentUpdateRequest request) {
        Comment comment = commentRepository.findById(request.id())
                .orElseThrow(()-> new RuntimeException("COMMENT NOT FOUND"));

        comment.setContent(request.content());
        comment.setUpdatedAt(LocalDateTime.now());
        commentRepository.save(comment);
        return CommentResponse.of(comment);
    }

    public void deleteById(Long id) {
        commentRepository.deleteById(id);
    }

    public List<CommentResponse> findAll() {
        List<Comment> comments = commentRepository.findAll();
        return comments.stream().map(CommentResponse::of).toList();
    }
}
