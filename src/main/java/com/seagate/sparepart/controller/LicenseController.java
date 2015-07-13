package com.seagate.sparepart.controller;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.seagate.sparepart.domain.Assignment;
import com.seagate.sparepart.domain.LicenseCreationForm;
import com.seagate.sparepart.domain.LicenseInventoryEntry;
import com.seagate.sparepart.domain.LicenseOpEntry;
import com.seagate.sparepart.ldap.LoginInfo;
import com.seagate.sparepart.service.HostService;
import com.seagate.sparepart.service.LicenseService;


@Controller
@RequestMapping("/license")
public class LicenseController {

	private LicenseService licenseService;
	private HostService hostService;
	
	@Autowired
	public LicenseController(LicenseService licenseService, HostService hostService){
		this.licenseService = licenseService;
		this.hostService = hostService;
	}
	
	@RequestMapping(method=RequestMethod.GET, params="new")
	public String showCreateLicenseForm(Model model){
		model.addAttribute("licenseCreationForm", new LicenseCreationForm());
		List<String> licenseNameList = licenseService.getLicNameList();
		model.addAttribute("licenseNameList", licenseNameList);
		return "createLicense";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String createLicense(@ModelAttribute("licenseCreationForm") LicenseCreationForm lcf, Authentication authentication){
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
		LoginInfo loginInfo = (LoginInfo) authentication.getDetails();
		loe.setOpName(loginInfo.getName());
		loe.setOpGid(Integer.parseInt(loginInfo.getUid()));
		licenseService.addLicenseOpEntry(loe);
		return "redirect:/license/records";
	}
	
	@RequestMapping("/records")
	public String showOpRecord(Model model){
		List<LicenseOpEntry> loeList = licenseService.getLicenseOpListAct();
		model.addAttribute("loeList", loeList);
		return "editLicense";
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	public void delOpRecord(@PathVariable("id") int invOpId, Authentication auth){
		LoginInfo loginInfo = (LoginInfo) auth.getDetails();		
		licenseService.delLicenseOpEntry(invOpId, Integer.parseInt(loginInfo.getUid()), loginInfo.getName());
	}
	
	@RequestMapping("/assignment")
	public String applyForm(Model model){		
		Map<Integer, String> licNameList = licenseService.getLicNameListAct();
		Map<Integer, String> hostnameList = hostService.getHostnameListAct();
		Map<Integer, Integer> leftNum = licenseService.getLeftNumOfLic();
		model.addAttribute("asn", new Assignment());
		model.addAttribute("licNameList", licNameList);
		model.addAttribute("hostnameList", hostnameList);
		model.addAttribute("leftNum", leftNum);
		return "applyLicense";
	}
	
	@RequestMapping(value="/assignment", method=RequestMethod.POST)
	public String assign(@ModelAttribute("asn") Assignment asn, Authentication auth){
		Map<Integer, String> licNameList = licenseService.getLicNameListAct();
		Map<Integer, String> hostnameList = hostService.getHostnameListAct();
		asn.setLicenseName(licNameList.get(asn.getInvId()));
		asn.setHostname(hostnameList.get(asn.getHostId()));
		LoginInfo loginInfo = (LoginInfo) auth.getDetails();
		asn.setApplicantGid(Integer.parseInt(loginInfo.getUid()));
		asn.setApplicantName(loginInfo.getName());
		licenseService.aplyLicense(asn);
		return "redirect:/license/assignment/records";
	}
	
	@RequestMapping("/assignment/records")
	public String release(Model model){
		List<Assignment> asnList = licenseService.getAssignedLicense();
		model.addAttribute("asnList", asnList);
		return "releaseLicense";
	}
	
	@RequestMapping(value="/assignment/{id}",method=RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	public void rlsAssignment(@PathVariable("id") int asnId, Authentication auth){
		LoginInfo loginInfo = (LoginInfo) auth.getDetails();
		
		licenseService.rlsLicense(asnId, Integer.parseInt(loginInfo.getUid()), loginInfo.getName());
	}
	
	@RequestMapping(value={"/dashboard","","/"})
	public String showDashboard(Model model){
		List<LicenseInventoryEntry> lieList = licenseService.getLicenseInvList();
		String chartData = "";
		for(LicenseInventoryEntry lie : lieList){
			int occupied = lie.getTotalQuantity() - lie.getSpareQuantity();
			chartData += "{name:'" + lie.getLicenseName() + "', available:" + lie.getSpareQuantity() + ", occupied:" + occupied + "},";
		}
		if(chartData.length() > 0){
			chartData = chartData.substring(0,chartData.length() - 1);
		}
		model.addAttribute("data", chartData);
		List<LicenseInventoryEntry> excessedLieList = licenseService.getExcessedLic();
		model.addAttribute("lieList", excessedLieList);
		return "dashboard";
	}

}
