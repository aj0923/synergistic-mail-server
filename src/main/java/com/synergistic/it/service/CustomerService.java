package com.synergistic.it.service;

import java.util.List;

import com.synergistic.it.email.spring.form.CustomerForm;
import com.synergistic.it.email.spring.form.FolderForm;
import com.synergistic.it.hibernate.entity.CustomerEntity;

/**
 * 
 * @author Nagendra
 * 
 */
public interface CustomerService {
	public String uploadCustomer(CustomerForm customerForm);
	public String authUser(String username, String password);
	public List<CustomerForm> findUsers();
	public boolean addFolder(String userName, String folderName);
	public List<FolderForm> findallfolders(String userName);
}