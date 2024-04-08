package com.his.services;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.his.common.ApiResponse;
import com.his.converter.UtilConverter;
import com.his.dto.RequestDTO;
import com.his.dto.ResponseDTO;
import com.his.model.CitizenDetails;
import com.his.repository.ICitizenDetailsRepo;

@Component("citizenService")
public class CitizenServiceImp implements ICitizenDetailsServices {

	@Autowired
	private ICitizenDetailsRepo repo;
	
	@Autowired
	private ApiResponse apiResponse;
	
	private Logger logger = LoggerFactory.getLogger(CitizenDetails.class);
	
	@Override
	public ApiResponse save(RequestDTO requestDTO) {
		
		try
		{
		    CitizenDetails dbo = UtilConverter.convertDTOToDBO(requestDTO);
			  if(dbo!=null)
			  {
				 repo.save(dbo);
				 apiResponse.setStatus(true);
				 apiResponse.setMessage("Success");
				 logger.info("record saved success");
			  }
			  else
			  {
					 apiResponse.setMessage("Failed");
					 logger.info("record saved failure In Save Method In Service Class");
		      }
		}
		catch (Exception e) {
			 apiResponse.setMessage("Failed");
			 logger.error("Error Occurred::Save Method In Service Class-"+e.getMessage());
		}
		return apiResponse;
	}

	@Override
	public ApiResponse getAllCitizens() {
		List<CitizenDetails> dboList = repo.findAll();
		List<ResponseDTO> dtoList = UtilConverter.convertDBOListToDTOList(dboList);
		try
		{
			if(dtoList!=null)
			{
				apiResponse.setMessage("Success");
				apiResponse.setStatus(true);
				apiResponse.setResponseDTOs(dtoList);
				logger.info("All records fetched Successfully completed");
			}
		}
		catch (Exception e) {
			 apiResponse.setMessage("Failed");
			 logger.error("Error Occurred::getAllCitizens Method In Service Class-"+e.getMessage());
		}
		
		return apiResponse;
	}

	@Override
	public ApiResponse getCitizenBySsnId(Long ssnId) {
		try
		{
			if(ssnId!=null)
			{
				 Optional<CitizenDetails> opt = repo.findById(ssnId);
				 if(opt.isPresent())
				 {
					ResponseDTO responseDTO = UtilConverter.convertDBOToDTO(opt.get());
					apiResponse.setMessage("Success");
					apiResponse.setStatus(true);
					apiResponse.setResponseDTO(responseDTO);
					logger.info("Record Fetched By Id Successfully Completed");
				 }
			}
			
		}
		catch (Exception e) {
			apiResponse.setMessage("Failed");
			logger.error("Error Occurred::getCitizenBySsnId Method In Service Class-"+e.getMessage());
		}
		
		return apiResponse;
	}

	@Override
	public ApiResponse saveAll(List<RequestDTO> requestDTOs) {
		try
		{
			List<CitizenDetails> dboList = UtilConverter.convertDTOListToDBOList(requestDTOs);
		    if(dboList!=null && !dboList.isEmpty())
		    {
		       repo.saveAll(dboList);
		       apiResponse.setStatus(true);
		       apiResponse.setMessage("Success");
		       logger.info("record savedAll success");
		    }
		    else
			{
					 apiResponse.setMessage("Failed");
					 logger.info("record saved failure In saveAll Method In Service Class");
		    }
		}
		catch (Exception e) {
		     apiResponse.setMessage("Failed");
		     logger.error("Error Occurred::saveAll Method In Service Class-"+e.getMessage());
		}
		return apiResponse;
	}

}
