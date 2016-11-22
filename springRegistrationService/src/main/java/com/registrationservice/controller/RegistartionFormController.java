package com.registrationservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.registrationservice.model.Registration;

@RestController
public class RegistartionFormController {
	@Autowired
	private RegistrationFormImpl regImpl;

	public RegistartionFormController(RegistrationFormImpl regImpl) {
		this.regImpl = regImpl;
	}

	@RequestMapping(path = "/registrationservice/register", method = RequestMethod.POST)
	public String registerCandidate(@RequestBody Registration reg) {
		String result = "";
		try {
			result = regImpl.validateRegistration(reg);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			result = e.getMessage();
		}
		return result;
	}

}
