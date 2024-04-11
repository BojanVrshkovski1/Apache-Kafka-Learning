package org.acme.kafka.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.acme.kafka.model.Quote;
import jakarta.persistence.EntityManager;

@ApplicationScoped
public class QuoteRepository {
	@Inject
	EntityManager entityManager;


	@Transactional(Transactional.TxType.REQUIRED)
	public Quote save(Quote quote){
		entityManager.persist(quote);
		return quote;
	}

}
