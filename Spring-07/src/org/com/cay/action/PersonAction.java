package org.com.cay.action;

import org.com.cay.service.PersonService;

import com.opensymphony.xwork2.ActionSupport;

public class PersonAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private PersonService personService;
	
	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}
	
	public String execute(){
		System.out.println("PersonAction execute...");
		personService.save();
		return SUCCESS;
	}
}
