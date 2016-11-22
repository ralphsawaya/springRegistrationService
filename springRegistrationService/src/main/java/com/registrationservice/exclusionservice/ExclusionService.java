package com.registrationservice.exclusionservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ComponentScan
public class ExclusionService {
	private List<String> blackList = new ArrayList<String>();

	@RequestMapping(path = "/registrationservice/exclusionresource/{dob}/{ssn}", method = RequestMethod.GET)
	public boolean validate(@PathVariable("dob") String dob, @PathVariable("ssn") String ssn) {
		return isBlackListedUser(dob, ssn);
	}
	
	@RequestMapping(path = "/registrationservice/exclusionresource")
	public boolean validate2( String dob, String ssn) {
		//return isBlackListedUser(dob, ssn);
		return true;
	}

	private boolean isBlackListedUser(String dob, String ssn) {
		List<String> blackList = getBlackList();
		if (blackList.contains(dob + ssn)) {
			return true;
		}
		return false;
	}

	private List<String> getBlackList() {
		blackList.add("20-05-1990XJohn");
		blackList.add("25-07-1989XRobert%*?");
		blackList.add("13-03-2001XTheresa");
		blackList.add("18-12-1987XClinton");
		blackList.add("31-05-1995XTrump");
		blackList.add("05-03-2003XBush");
		return blackList;
	}
	
	
}
