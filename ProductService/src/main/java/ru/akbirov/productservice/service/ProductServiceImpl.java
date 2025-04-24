package ru.akbirov.productservice.service;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import ru.akbirov.productservice.service.dto.CreateProductDto;
import ru.akbirov.core.ProductCreatedEvent;

import java.util.UUID;

import java.util.concurrent.ExecutionException;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final KafkaTemplate<String, ProductCreatedEvent> kafkaTemplate;
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());


    @Override
    public String createProduct(CreateProductDto createProductDto) throws ExecutionException, InterruptedException {
        //TODO save to DB
        String productId = UUID.randomUUID().toString();

        ProductCreatedEvent productCreatedEvent =
                new ProductCreatedEvent(productId, createProductDto.getTitle(),
                        createProductDto.getPrice(), createProductDto.getQuantity());

        ProducerRecord<String, ProductCreatedEvent> record = new ProducerRecord<>(
                "product-created-events-topic",
                productId,
                productCreatedEvent
        );

        record.headers().add("messageId", "UUID.randomUUID().toString()".getBytes());

        SendResult<String, ProductCreatedEvent> result =
                kafkaTemplate.send(record).get();

        LOGGER.info("Topic: {}", result.getRecordMetadata().topic());
        LOGGER.info("Partition: {}", result.getRecordMetadata().partition());
        LOGGER.info("Offset: {}", result.getRecordMetadata().offset());

        LOGGER.info("Return: {}", productId);


        return productId;
    }
}
