package com.Bank.BankSequenceRedis.Repository;

import com.Bank.BankSequenceRedis.Model.Sequence;

import java.util.Map;

public interface RedisRepository {
    Map<String, Sequence> findAll();
    Sequence findById(String id);
    void save(Sequence afiliado);
    void delete(String id);
    Sequence getNextId(String id);
}
