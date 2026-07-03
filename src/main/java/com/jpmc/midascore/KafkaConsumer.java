package com.jpmc.midascore;

import com.jpmc.midascore.foundation.Transaction;
import com.jpmc.midascore.component.TransactionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @Autowired
    private TransactionHandler transactionHandler;

    @KafkaListener(topics = "${general.kafka-topic}")
    public void listen(Transaction transaction) {
        System.out.println("Received: " + transaction);
        transactionHandler.handle(transaction);
    }
}