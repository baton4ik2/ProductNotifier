package ru.akbirov.emailnotificationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.akbirov.emailnotificationservice.entity.ProcessedEventEntity;

@Repository
public interface ProcessedEventRepository extends JpaRepository<ProcessedEventEntity, Long> {

    ProcessedEventEntity findByMessageId(String messageId);

}
