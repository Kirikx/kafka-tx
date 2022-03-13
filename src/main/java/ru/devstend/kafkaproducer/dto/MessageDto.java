package ru.devstend.kafkaproducer.dto;

import java.math.BigInteger;
import lombok.Data;

@Data
public class MessageDto {

  private String message;
  private BigInteger amount;

}
