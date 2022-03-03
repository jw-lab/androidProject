package com.bitc.service;

import java.util.List;

import com.bitc.dto.BoardDto;

public interface MarketService {
	
	int insertMarket(BoardDto market)throws Exception;

	List<BoardDto> selectMarketList()throws Exception;
//	MarketDto selectMarketList(MarketDto market) throws Exception;
//
//	void insertMarket(MarketDto market)throws Exception;;
//
//	MarketDto selectMarketDetail(int seq)throws Exception;;
//
//	void deleteMarket(int seq)throws Exception;;
//	
//	void updateMarket(MarketDto market)throws Exception;;



	



}
