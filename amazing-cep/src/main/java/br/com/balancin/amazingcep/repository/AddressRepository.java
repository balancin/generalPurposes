package br.com.balancin.amazingcep.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import br.com.balancin.amazingcep.data.Address;

@Component
public interface AddressRepository extends MongoRepository<Address, String>, AddressRepositoryCustom {

	public List<Address> findByAddressId(String id);
	
}
