package com.pironeer.week2.repository;

import com.pironeer.week2.repository.domain.ComComment;
import com.pironeer.week2.repository.domain.Comment;
import com.pironeer.week2.repository.domain.Topic;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@RequiredArgsConstructor
@Repository
public class CommentRepository {
    private final AtomicLong commentIdxGenerator = new AtomicLong(0);
    private final Map<Long, Comment> commentMap =  new HashMap<>();
    private final ComCommentRepository comCommentRepository;

    public void save(Comment comment) {
        if(comment.getId() == null) {
            Long id = commentIdxGenerator.incrementAndGet();
            comment.setId(id);
            commentMap.put(id, comment);
        } else {
            commentMap.replace(comment.getId(), comment);
        }
    }

    public Optional<Comment> findById(Long id) {
        return Optional.of(commentMap.get(id));
    }

    public void deleteById(Long id) {
        Assert.notNull(id, "ID MUST NOT BE NULL");
        comCommentRepository.deleteAllByCommentId(id);
        commentMap.remove(id);
    }

    public List<Comment> findAll() {
        return commentMap.values().stream().toList();
    }

    public void deleteAllByTopicId(Long topicId) {
        Assert.notNull(topicId, "Comment ID MUST NOT BE NULL");

        Iterator<Map.Entry<Long, Comment>> iterator = commentMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Long, Comment> entry = iterator.next();
            if (entry.getValue().getTopicId().equals(topicId)) {
                comCommentRepository.deleteAllByCommentId(entry.getValue().getId());
                iterator.remove();
            }
        }
    }

}
