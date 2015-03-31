package br.com.balancin.amazingcep.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;

import br.com.balancin.amazingcep.data.Address;

public class AddressRepositoryImpl implements AddressRepositoryCustom {

    @Autowired
    private ApplicationContext context;

    @Autowired
    MongoTemplate mongoTemplate;

	@Override
	public void createCollection() {
		if (!mongoTemplate.collectionExists(Address.class)) {
			mongoTemplate.createCollection(Address.class);
		}
	}
	
}
