package ru.devstend.kafkaproducer.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.devstend.kafkaproducer.dto.MessageDto;
import ru.devstend.kafkaproducer.entity.MessageEntity;
import ru.devstend.kafkaproducer.repository.MessageRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProducerService {

  private static final String TOPIC = "messages";

  private final KafkaTemplate<String, MessageDto> kafkaTemplate;
  private final MessageRepository messageRepository;

  @Transactional
  public void produce(MessageDto message) {

    saveMessage(message);

    log.info("Producing the message: {}", message);

    kafkaTemplate.send(TOPIC, message);

    postProcess(message);
  }

  private MessageEntity saveMessage(MessageDto message) {

    log.info("Save message");

    MessageEntity messageEntity = new MessageEntity();
    messageEntity.setMessage(message.getMessage());
    messageEntity.setAmount(message.getAmount());

    return messageRepository.save(messageEntity);
  }

  @SneakyThrows
  private void postProcess(MessageDto message) {
    // Error in post process

    log.info("Post process");
    Thread.sleep(1000);
    throw new RuntimeException();
  }

}
