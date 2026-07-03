package com.jpmc.midascore.component;

import com.jpmc.midascore.foundation.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class TransactionListener {

    @Autowired
    private TransactionHandler transactionHandler;

    @KafkaListener(topics = "${general.kafka-topic}")
    public void listen(Transaction transaction) {
        System.out.println("Received transaction: " + transaction);
        transactionHandler.handle(transaction);
    }
}