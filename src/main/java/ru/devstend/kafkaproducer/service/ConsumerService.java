package ru.devstend.kafkaproducer.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.devstend.kafkaproducer.dto.MessageDto;
import ru.devstend.kafkaproducer.entity.MessageConsumeEntity;
import ru.devstend.kafkaproducer.repository.MessageConsumeRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class ConsumerService {

  private final MessageConsumeRepository messageConsumeRepository;

  @Transactional
  @KafkaListener(topics = "messages", groupId = "message_group_id")
  public void consume(MessageDto message){

    saveMessageConsume(message);

    log.info("Consuming the message: {}", message);
  }

  private void saveMessageConsume(MessageDto message) {

    log.info("Save consume message");

    MessageConsumeEntity messageConsumeEntity = new MessageConsumeEntity();
    messageConsumeEntity.setMessage(message.getMessage());
    messageConsumeEntity.setAmount(message.getAmount());

    messageConsumeRepository.save(messageConsumeEntity);
  }
}
