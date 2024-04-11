package org.acme.kafka.processor;

import java.util.Random;

import jakarta.enterprise.context.ApplicationScoped;

import jakarta.inject.Inject;
import org.acme.kafka.model.Quote;
import org.acme.kafka.repository.QuoteRepository;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import io.smallrye.reactive.messaging.annotations.Blocking;

/**
 * A bean consuming data from the "quote-requests" Kafka topic (mapped to "requests" channel) and giving out a random quote.
 * The result is pushed to the "quotes" Kafka topic.
 */
@ApplicationScoped
public class QuotesProcessor {
    @Inject
    QuoteRepository quoteRepository;

    private Random random = new Random();

    @Incoming("requests")
    @Outgoing("quotes")
    @Blocking
    public Quote process(String quoteRequest) throws InterruptedException {
        // simulate some hard working task
        Thread.sleep(200);
        Quote quote = new Quote(quoteRequest, random.nextInt(100));
        quoteRepository.save(quote);
        return quote;
    }
}
