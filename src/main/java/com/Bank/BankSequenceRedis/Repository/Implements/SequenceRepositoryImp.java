package com.Bank.BankSequenceRedis.Repository.Implements;

import com.Bank.BankSequenceRedis.Model.Sequence;
import com.Bank.BankSequenceRedis.Repository.RedisRepository;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@Service
public class SequenceRepositoryImp implements RedisRepository {
    private static final String KEY = "sequence";
    private RedisTemplate<String, Sequence> redisTemplate;
    private HashOperations hashOperations;

    public SequenceRepositoryImp(RedisTemplate<String, Sequence> redisTemplate){
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init(){
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public Map<String, Sequence> findAll() {
        return hashOperations.entries(KEY);
    }

    @Override
    public Sequence findById(String id) {
        return (Sequence) hashOperations.get(KEY, id);
    }

    @Override
    public void save(Sequence sequence) {
        hashOperations.put(KEY, UUID.randomUUID().toString(), sequence);
    }

    @Override
    public void delete(String id) {
        hashOperations.delete(KEY, UUID.randomUUID().toString(), id);
    }

    @Override
    public Sequence getNextId(String id) {
        Object response = hashOperations.get(KEY, id);
        Sequence sequence = new Sequence();
        if (response == null){
            sequence.setId(id);
            sequence.setSequence(1);
        }else {
            sequence = (Sequence) response;
            sequence.setSequence(sequence.getSequence() +1);
        }
        hashOperations.put(KEY, id, sequence);
        return (Sequence) hashOperations.get(KEY, id);
    }
}
