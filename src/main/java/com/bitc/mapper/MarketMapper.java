package com.bitc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bitc.dto.BoardDto;

@Mapper
public interface MarketMapper {
	
	int insertMarket(BoardDto market) throws Exception;
	
	List<BoardDto> selectMarketList()throws Exception;
//	MarketDto selectMarketList(MarketDto market) throws Exception;
//	
//	void insertMarket(MarketDto market)throws Exception;
//	
//	MarketDto selectMarketDetail(int seq)throws Exception;
//	
//	void deleteMarket(int seq)throws Exception;
//	
//	void updateMarket(MarketDto market)throws Exception;
	

}
