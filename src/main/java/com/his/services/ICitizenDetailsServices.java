package com.his.services;

import java.util.List;
import com.his.common.ApiResponse;
import com.his.dto.RequestDTO;

public interface ICitizenDetailsServices {

	public ApiResponse save(RequestDTO requestDTO);
	public ApiResponse getAllCitizens();
	public ApiResponse getCitizenBySsnId(Long ssnId);
	public ApiResponse saveAll(List<RequestDTO> requestDTOs);
	
}
