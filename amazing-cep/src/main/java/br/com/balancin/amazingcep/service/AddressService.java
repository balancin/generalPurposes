package br.com.balancin.amazingcep.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.balancin.amazingcep.NSResponse;
import br.com.balancin.amazingcep.bean.AddressBean;
import br.com.balancin.amazingcep.data.Address;
import br.com.balancin.amazingcep.repository.AddressRepository;

@EnableAutoConfiguration
@ComponentScan
@Controller
@RequestMapping("/address_crud")
public class AddressService {

    @Autowired
    private AddressRepository repository;  
    
	@RequestMapping("/get")
    public String get(
    		Model model,
            Address address
    ){
		
		AddressBean addressBean = new AddressBean();
		addressBean.setAddressRepository(repository);
		Address outputAddress = addressBean.getAddress(address);
		NSResponse response = new NSResponse();
		response.setResponseObject(outputAddress);
		List<Address> addressList = addressBean.getAddressRepository().findAll();

    	model.addAttribute("address",outputAddress);
    	model.addAttribute("addressList",addressList);
    	
        return "address";
        
    }
	
	@RequestMapping("/remove")
	public String remove(
			Model model,
			Address address
	){

		AddressBean addressBean = new AddressBean();
		addressBean.setAddressRepository(repository);
		
		List<Address> addressList = addressBean.getAddressRepository().findByAddressId(address.getAddressId());
		addressBean.getAddressRepository().delete(addressList.get(0));
		
		return "redirect:get";
		
	}

	@RequestMapping("/save")
	public String saveAddress(
			Model model,
			@Valid Address address,
			BindingResult errors
	){

		AddressBean addressBean = new AddressBean();
		addressBean.setAddressRepository(repository);
		
		Address savedAddress = null;
		if (errors.hasErrors()) {
			
			List<FieldError> lerr = errors.getFieldErrors();
			for (FieldError err: lerr) {
				model.addAttribute("errorMessage",err.getDefaultMessage());
			}
			model.addAttribute("address",null);
			
		} 
		else {
			
			try {
				
				savedAddress = addressBean.save(address); 
		    	model.addAttribute("address",savedAddress);
				
			} catch(Exception e){
				
				model.addAttribute("errorMessage","Houve um erro no cadastro.");
				
			}
				
		}
		
		List<Address> addressList = addressBean.getAddressRepository().findAll();
    	model.addAttribute("addressList",addressList);
		
		return "address";
		
	}
	
}
