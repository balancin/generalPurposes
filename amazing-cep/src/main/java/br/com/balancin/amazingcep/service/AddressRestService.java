package br.com.balancin.amazingcep.service;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.balancin.amazingcep.NSResponse;
import br.com.balancin.amazingcep.bean.AddressBean;
import br.com.balancin.amazingcep.data.Address; 
import br.com.balancin.amazingcep.repository.AddressRepository;

@EnableAutoConfiguration
@ComponentScan
@RestController
@RequestMapping("/address")
public class AddressRestService {
	
	Logger logger = Logger.getLogger(AddressRestService.class);

    @Autowired
    private AddressRepository repository;  
    
	@RequestMapping("/get")
	public NSResponse getAddress(
			@Valid AddressBean addressBean, 
            BindingResult errors
	){

		NSResponse response = new NSResponse();
		
		if (errors.hasErrors()) {
			List<FieldError> lerr = errors.getFieldErrors();
			for (FieldError err: lerr) {
				System.err.println(err);
				response.setError(1);
				response.setErrorDescription(err.getDefaultMessage());
			}
		} else {
			
			Address address = new Address();
			address.setZipcode(addressBean.getZipcode());
			Address outputAddress = addressBean.getAddress(address);
			response.setResponseObject(outputAddress);
			
		}
		
		return response;
      
	}
	
}