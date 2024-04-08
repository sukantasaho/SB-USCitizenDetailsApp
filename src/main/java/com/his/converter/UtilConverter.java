package com.his.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import com.his.dto.RequestDTO;
import com.his.dto.ResponseDTO;
import com.his.model.CitizenDetails;

public class UtilConverter {

	private static Logger logger = LoggerFactory.getLogger(UtilConverter.class);
	public static CitizenDetails convertDTOToDBO(RequestDTO reqDTO)
	{
		CitizenDetails dbo = null;
		try
		{
			if(reqDTO!=null)
			{
				dbo = new CitizenDetails();
				BeanUtils.copyProperties(reqDTO, dbo);
				dbo.setCreatedBy(reqDTO.getFullName());
				dbo.setModifiedBy(reqDTO.getFullName());
			}
		}
		catch (Exception e) {
			logger.error("Error Occured::UtilConverter.class->convertDTOToDBO method");
		}
		return dbo;
	}
	
	public static List<CitizenDetails> convertDTOListToDBOList(List<RequestDTO> dtoList)
	{
		List<CitizenDetails> dboList = null;
		try
		{
			if(dtoList!=null)
			{
				dboList = dtoList.stream()
	                    .map(UtilConverter::convertDTOToDBO)
	                    .collect(Collectors.toList()); 
			}
		}
		catch (Exception e) {
			logger.error("Error Occured::UtilConverter.class->convertDTOListToDBOList method");
		}
		
		return dboList;
	}
	public static List<ResponseDTO> convertDBOListToDTOList(List<CitizenDetails> dboList)
	{
		List<ResponseDTO> dtoList = null;
		try
		{
		    if(dboList!=null)
		    {
			     dtoList = dboList.stream()
                          .map(UtilConverter::convertDBOToDTO)
                          .collect(Collectors.toList()); 
		    }
		}
		catch (Exception e) {
			logger.error("Error Occured::UtilConverter.class->convertDBOListToDTOList method");
		}
		return dtoList;
	}
	public static ResponseDTO convertDBOToDTO(CitizenDetails dbo)
	{
		ResponseDTO dto = null;
		try
		{
			if(dbo!=null)
			{
				dto = new ResponseDTO();
				BeanUtils.copyProperties(dbo, dto);
			}
		}
		catch (Exception e) {
			logger.error("Error Occured::UtilConverter.class->convertDBOToDTO method");
		}
		return dto;
	}
	
}
