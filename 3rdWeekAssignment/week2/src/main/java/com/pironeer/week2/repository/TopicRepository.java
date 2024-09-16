package com.pironeer.week2.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import com.pironeer.week2.repository.domain.Topic;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
@RequiredArgsConstructor
public class TopicRepository {
    private final AtomicLong topicIdxGenerator = new AtomicLong(0);
    private final Map<Long, Topic> topicMap =  new HashMap<>();
    private final CommentRepository commentRepository;

    public void save(Topic topic) {
        if(topic.getId() == null) {
            Long id = topicIdxGenerator.incrementAndGet();
            topic.setId(id);
            topicMap.put(id, topic);
        } else {
            topicMap.replace(topic.getId(), topic);
        }
    }

    public Optional<Topic> findById(Long id) {
        return Optional.of(topicMap.get(id));
    }

    public List<Topic> findAll() {
        return topicMap.values().stream().toList();
    }

    public void deleteById(Long id) {
        Assert.notNull(id, "ID MUST NOT BE NULL");
        commentRepository.deleteAllByTopicId(id);
        topicMap.remove(id);
    }
}
