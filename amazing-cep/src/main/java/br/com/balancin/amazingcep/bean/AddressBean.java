package br.com.balancin.amazingcep.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import br.com.balancin.amazingcep.data.Address;
import br.com.balancin.amazingcep.repository.AddressRepository;
import br.com.balancin.amazingcep.validator.Zipcode;

@Component("addressBean")
public class AddressBean {
	
	AddressRepository addressRepository;

	@Zipcode
	private String zipcode;

	public AddressRepository getAddressRepository() {
		return addressRepository;
	}

	public void setAddressRepository(AddressRepository addressRepository) {
		this.addressRepository = addressRepository;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	public Address save(Address address){

		Address savedAddress = addressRepository.save(address);
		return savedAddress;
		
	}
	
	public void remove(Address address){
		
		addressRepository.delete(address);
		
	}
	
	public Address getAddress(Address address){
		
		Address retAddress = null;
		
		if(address.getAddressId() != null){
			
			List<Address> addressList = addressRepository.findByAddressId(address.getAddressId());
			
			if(addressList.size() > 0)
				retAddress = addressList.get(0);
			
		} else if(address.getZipcode() != null){
			
			String zipcode = address.getZipcode().replace("-", "");
			
			List<Address> mock = mockResults();
			zipcode = address.getZipcode().replace("-", "");
			for(int i = 0; i < zipcode.length(); i++){
				
				zipcode = zipcode.replaceAll("[0-9]{1}([0-9]{"+i+"})$", "0$1");
				for(int j = 0; j < mock.size(); j++)
					if(mock.get(j).getZipcode().equals(zipcode))
						retAddress = mock.get(j);
				
			}

		}
		
		return retAddress;
		
	}
	
	private List<Address> mockResults(){
		
		List<Address> addresses = new ArrayList<Address>();
		
		Address mockedA = new Address();
		mockedA.setZipcode("14578000");
		mockedA.setStreet("Rua joao santos");
		mockedA.setState("Sao jose");
		mockedA.setCity("Sao jose");
		mockedA.setNeighborhood("Jd. Maravilhoso");
		addresses.add(mockedA);
		
		Address mockedB = new Address();
		mockedB.setZipcode("14320000");
		mockedB.setStreet("Rua joao oliveira");
		mockedB.setState("Sao Paulo");
		mockedB.setCity("Sao Paulo");
		mockedB.setNeighborhood("Jd. Bonito");
		addresses.add(mockedB);
		
		Address mockedC = new Address();
		mockedC.setZipcode("22200000");
		mockedC.setStreet("Rua joao silva");
		mockedC.setState("Sao manuel");
		mockedC.setCity("Sao manuel");
		mockedC.setNeighborhood("Jd. Belo");
		addresses.add(mockedC);
		
		return addresses;
		
	}
}
