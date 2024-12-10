package org.zerock.mapper;

import org.zerock.dto.ChargeDTO;

public interface HomeMapper {
	
	public ChargeDTO getThisMonthCharge(ChargeDTO cdto);
}
