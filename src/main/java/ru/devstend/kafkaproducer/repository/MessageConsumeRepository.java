package ru.devstend.kafkaproducer.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.devstend.kafkaproducer.entity.MessageConsumeEntity;
import ru.devstend.kafkaproducer.entity.MessageEntity;

@Repository
public interface MessageConsumeRepository extends JpaRepository<MessageConsumeEntity, UUID> {

}
