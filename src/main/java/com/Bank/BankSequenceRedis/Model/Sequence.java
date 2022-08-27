package com.Bank.BankSequenceRedis.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sequence implements Serializable {

    private String  id;
    private int sequence;

}
