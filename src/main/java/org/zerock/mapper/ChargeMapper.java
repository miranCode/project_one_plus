package org.zerock.mapper;

import java.util.List;

import org.zerock.dto.ChargeDTO;

public interface ChargeMapper {
	 List<ChargeDTO> getList(ChargeDTO cdto);
	
	public List<ChargeDTO> getDetail(String uname, String email, String phone_num);
	
	public List<ChargeDTO> getPast(String uname);
}