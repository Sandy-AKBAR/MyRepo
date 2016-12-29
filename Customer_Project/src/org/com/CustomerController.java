package org.com;

import org.com.dao.CustomerDao;
import org.com.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomerController {
	@Autowired
	private CustomerDao customerDao;

	public CustomerDao getCustomerDao() {
		return customerDao;
	}

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@RequestMapping(value = "customer_form")
	public String Customer_Form() {
		return "customer_form";
	}
@RequestMapping(value = "/showallCustomer")
		public String showallCustomer(ModelMap map){
		map.addAttribute("Cust",customerDao.getAllCustomer() );
		map.addAttribute("message", "show all Customer called");
		return "customer_result";
		}
	
	
	
	
	@RequestMapping(value = "/addCustomer")
	public String addCustomer(ModelMap map, @RequestParam("button") String button, @RequestParam("id") int id,
			@RequestParam("name") String name, @RequestParam("location") String location) {
		if (button.equals("AddCustomer")) {

			Customer customer = new Customer();
			customer.setId(id);
			customer.setName(name);
			customer.setLocation(location);
			try {
				customerDao.addCustomer(customer);
				map.addAttribute("message", "addCustomer called");
			} catch (DuplicateKeyException e) {
				map.addAttribute("message", "duplicate id error");
			}
		} else if (button.equals("RemoveCustomer"))
			map.addAttribute("message", "RemoveCustomer called");
				
		else if (button.equals("UpdateCustomer")){
		
			Customer customer = new Customer();
			customer.setId(id);
			customer.setName(name);
			customer.setLocation(location);
			try {
				customerDao.updateCustomer(customer);
				map.addAttribute("message", "Customer  updated");
			} catch (DuplicateKeyException e) {
				map.addAttribute("message", "duplicate id error");
			}
			
		}
		return "customer_result";
	}

}
