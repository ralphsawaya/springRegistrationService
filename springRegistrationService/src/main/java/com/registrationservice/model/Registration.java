package com.registrationservice.model;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
@Component
@ComponentScan
public class Registration {
	@Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Invalid username. Must be alphanumeric and no space!")
	private String username;
	@Pattern(regexp = "^(?=.*\\d)(?=.*[A-Z]).{4,}$", message = "Password must contain at least one upper case and one number and be longer or equal to 4!")
	private String password;
	// (dd-mm-yyyy)
	@Pattern(regexp = "(0[1-9]|[12][0-9]|3[01])[ \\.-](0[1-9]|1[012])[ \\.-](19|20|)\\d\\d", message = "Invalid Date Of Birth!")
	private String dob;
	@Length(min = 1, message = "SSN should at least be 1 character!")
	private String ssn;

	public Registration() {
	}

	public Registration(String username, String password, String dob, String ssn) {
		this.username = username;
		this.password = password;
		this.dob = dob;
		this.ssn = ssn;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
