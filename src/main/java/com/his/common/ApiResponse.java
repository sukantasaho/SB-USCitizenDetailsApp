package com.his.common;

import java.util.List;

import org.springframework.stereotype.Component;

import com.his.dto.ResponseDTO;

@Component
public class ApiResponse 
{
    private boolean status;
    private String message;
    private ResponseDTO responseDTO;
    private List<ResponseDTO> responseDTOs;
    
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ResponseDTO getResponseDTO() {
		return responseDTO;
	}
	public void setResponseDTO(ResponseDTO responseDTO) {
		this.responseDTO = responseDTO;
	}
	public List<ResponseDTO> getResponseDTOs() {
		return responseDTOs;
	}
	public void setResponseDTOs(List<ResponseDTO> responseDTOs) {
		this.responseDTOs = responseDTOs;
	}
    
	
    
    
}
