package org.zerock.mapper;

import java.util.List;

import org.zerock.dto.ChargeDTO;

public interface ChargeMapper {
	public List<ChargeDTO> getList();
	
	public ChargeDTO getDetail(int code);
}