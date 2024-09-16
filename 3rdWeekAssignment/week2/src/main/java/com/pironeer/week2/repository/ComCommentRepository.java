package com.pironeer.week2.repository;

import com.pironeer.week2.repository.domain.ComComment;
import com.pironeer.week2.repository.domain.Comment;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ComCommentRepository {
    private final AtomicLong comCommentIdxGenerator = new AtomicLong(0);
    private final Map<Long, ComComment> comCommentMap =  new HashMap<>();

    public void save(ComComment comComment) {
        if(comComment.getId() == null) {
            Long id = comCommentIdxGenerator.incrementAndGet();
            comComment.setId(id);
            comCommentMap.put(id, comComment);
        } else {
            comCommentMap.replace(comComment.getId(), comComment);
        }
    }

    public Optional<ComComment> findById(Long id) {
        return Optional.of(comCommentMap.get(id));
    }

    public void deleteById(Long id) {
        Assert.notNull(id, "ID MUST NOT BE NULL");
        comCommentMap.remove(id);
    }

    public List<ComComment> findAll() {
        return comCommentMap.values().stream().toList();
    }

    public void deleteAllByCommentId(Long commentId) {
        Assert.notNull(commentId, "Comment ID MUST NOT BE NULL");

        Iterator<Map.Entry<Long, ComComment>> iterator = comCommentMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Long, ComComment> entry = iterator.next();
            if (entry.getValue().getCommentId().equals(commentId)) {
                iterator.remove();
            }
        }
    }

}