package com.seagate.sparepart.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.seagate.sparepart.domain.LicenseCreationForm;
import com.seagate.sparepart.domain.LicenseOpEntry;
import com.seagate.sparepart.service.LicenseService;


@Controller
@RequestMapping("/license")
public class LicenseController {

	private LicenseService licenseService;
	
	@Autowired
	public LicenseController(LicenseService licenseService){
		this.licenseService = licenseService;
	}
	
	@RequestMapping(method=RequestMethod.GET, params="new")
	public String showCreateLicenseForm(Model model){
		model.addAttribute("licenseCreationForm", new LicenseCreationForm());
		return "createLicense";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String createLicense(@ModelAttribute("licenseCreationForm") LicenseCreationForm lcf){
		LicenseOpEntry loe = new LicenseOpEntry();
		loe.setLicenseName(lcf.getLicenseName());
		loe.setLicenseKey(lcf.getLicenseKey());
		loe.setLicenseType(lcf.getLicenseType());
		loe.setFromSite(lcf.getFromSite());
		loe.setQuantity(Integer.parseInt(lcf.getQuantity()));
		if(lcf.getTotalPrice() != ""){
			loe.setTotalPrice(Float.parseFloat(lcf.getTotalPrice()));
		}
		if(lcf.getExpireDate() != ""){
			loe.setExpireDate(Date.valueOf(lcf.getExpireDate()));
		}		
		licenseService.addLicenseOpEntry(loe);
		return "createLicense";
	}
	
	@RequestMapping("/records")
	public String showOpRecord(Model model){
		List<LicenseOpEntry> loeList = licenseService.getLicenseOpListAct();
		model.addAttribute("loeList", loeList);
		return "editLicense";
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	public void delOpRecord(@PathVariable("id") int invOpId){
		licenseService.delLicenseOpEntry(invOpId);
	}

}
