package ru.devstend.kafkaproducer.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.devstend.kafkaproducer.dto.MessageDto;
import ru.devstend.kafkaproducer.service.ProducerService;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MessageController {

  private final ProducerService producerService;

  @PostMapping("/send")
  public ResponseEntity send(@RequestBody MessageDto message) {

    producerService.produce(message);

    return ResponseEntity.ok().body("Message sending");
  }

}
