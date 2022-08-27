package com.Bank.BankSequenceRedis.Controller;


import com.Bank.BankSequenceRedis.Model.Sequence;
import com.Bank.BankSequenceRedis.Repository.Implements.SequenceRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/api/sequence/")
public class SequenceController {

    @Autowired
        private SequenceRepositoryImp sequenceRepositoryImp;

        public SequenceController(SequenceRepositoryImp sequenceRepositoryImp){
            this.sequenceRepositoryImp = sequenceRepositoryImp;
        }

        @GetMapping
        public Map<String, Sequence> findAll(){
            return sequenceRepositoryImp.findAll();
        }

        @GetMapping("/{id}")
        public Sequence findById(@PathVariable String id){
            return sequenceRepositoryImp.findById(id);
        }

        @PostMapping
        public void create(@RequestBody Sequence afiliado){
            sequenceRepositoryImp.save(afiliado);
        }

        @DeleteMapping("/{id}")
        public void delete(@PathVariable String id){
            sequenceRepositoryImp.delete(id);
        }

        @GetMapping("/getNext/{id}")
        public Sequence getNextId(@PathVariable String id){
        return sequenceRepositoryImp.getNextId(id);
    }

}
