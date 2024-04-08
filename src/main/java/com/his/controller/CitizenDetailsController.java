package com.his.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.his.common.ApiResponse;
import com.his.dto.RequestDTO;
import com.his.model.CitizenDetails;
import com.his.services.ICitizenDetailsServices;

@RestController
@RequestMapping("/us/citizen")
public class CitizenDetailsController {

	@Autowired
	private ICitizenDetailsServices service;
	
	 
	@PostMapping("/registerUSCitizen")
	public ResponseEntity<ApiResponse> save(@RequestBody RequestDTO requestDTO) {
		
		return new ResponseEntity<ApiResponse>(service.save(requestDTO), HttpStatus.OK);
	}

    @GetMapping("/getAllUSCitizens")
	public ResponseEntity<ApiResponse> getAllCitizens() {
		  
		return new ResponseEntity<ApiResponse>(service.getAllCitizens(), HttpStatus.OK);
	}

	@GetMapping("/getStateNameBySSNID") 
	public ResponseEntity<String> getCitizenBySsnId(@RequestParam("Id") Long ssnId) {
		
	      ApiResponse  response =	service.getCitizenBySsnId(ssnId);
	      String state = response.getResponseDTO().getCitizenState();
	      
		return new ResponseEntity<String>(state, HttpStatus.OK);
	}

	@PostMapping("/registerAllUSCitizens")
	public ResponseEntity<ApiResponse> saveAll(@RequestBody List<RequestDTO> requestDTOs)
	{
		return new ResponseEntity<ApiResponse>(service.saveAll(requestDTOs), HttpStatus.OK);
	}
}
