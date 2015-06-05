package com.seagate.sparepart.controller;

import java.util.List;

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

import com.seagate.sparepart.domain.HostInvEntry;
import com.seagate.sparepart.domain.HostOpEntry;
import com.seagate.sparepart.ldap.LoginInfo;
import com.seagate.sparepart.service.HostService;
import com.seagate.sparepart.service.LicenseService;

@Controller
@RequestMapping("/host")
public class HostController {

	private HostService hostService;
	private LicenseService licenseService;
	
	@Autowired
	public HostController(HostService hostService, LicenseService licenseService){
		this.hostService = hostService;
		this.licenseService = licenseService;
	}
	
	@RequestMapping(method=RequestMethod.GET, params="new")
	public String showCreatHostForm(Model model){
		HostOpEntry hoe = new HostOpEntry();
		model.addAttribute("hoe", hoe);
		return "createHost";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String createHost(@ModelAttribute("hoe") HostOpEntry hoe, Authentication auth){
		LoginInfo loginInfo = (LoginInfo) auth.getDetails();
		hoe.setOperatorGid(Integer.parseInt(loginInfo.getUid()));
		hoe.setOperatorName(loginInfo.getName());
		hoe.setOwnerGid(Integer.parseInt(loginInfo.getUid()));
		hoe.setOwnerName(loginInfo.getName());
		hostService.addHostOp(hoe);
		return "redirect:/host/records";
	}
	
	@RequestMapping("/records")
	public String showHostRecords(Model model){
		List<HostOpEntry> hoeList = hostService.getHostOpListAct();
		model.addAttribute("hoeList", hoeList);
		return "editHost";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	public void delHostOp(@PathVariable("id") int hostOpId, Authentication auth){
		int hostId = hostService.getHostOp(hostOpId).getHostId();
		List<Integer> asnIds = licenseService.getAssignmentsByHost(hostId);
		LoginInfo loginInfo = (LoginInfo) auth.getDetails();
		for(int asnId : asnIds){
			licenseService.rlsLicense(asnId, Integer.parseInt(loginInfo.getUid()), loginInfo.getName());
		}
		hostService.delHostOp(hostOpId);
	}
	
}
