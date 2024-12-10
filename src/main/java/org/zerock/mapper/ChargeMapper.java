package org.zerock.mapper;

import java.util.List;

import org.zerock.dto.ChargeDTO;

public interface ChargeMapper {
	List<ChargeDTO> getList(ChargeDTO cdto);
	 
	public int getTotalCount(ChargeDTO cdto);

	public List<ChargeDTO> getDetail(ChargeDTO cdto);
	
	public List<ChargeDTO> getPast(ChargeDTO cdto);
	
	public ChargeDTO getThisMonthCharge(ChargeDTO cdto);
}