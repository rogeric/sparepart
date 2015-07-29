package com.seagate.sparepart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.seagate.sparepart.contract.domain.ContractEntity;
import com.seagate.sparepart.contract.domain.ContractForm;

@Controller
@RequestMapping("/contract")
public class ContractController {

	@RequestMapping(method=RequestMethod.GET, params="new")
	public String showCreateContractForm(Model model){
		model.addAttribute("contractForm", new ContractForm());
		return "contract/createContract";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String createContract(@ModelAttribute("contractForm") ContractForm cf){
		System.out.println(cf.getEndDate());
		return "contract/createContract";		
	}
}
