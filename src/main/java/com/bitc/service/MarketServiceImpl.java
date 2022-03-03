package com.bitc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitc.dto.BoardDto;
import com.bitc.mapper.MarketMapper;

@Service
public class MarketServiceImpl implements MarketService {
	
	@Autowired
	private MarketMapper marketMapper;
	
	@Override
	public int insertMarket(BoardDto market) throws Exception {
		return marketMapper.insertMarket(market);		
	}

//	@Override
//	public MarketDto selectMarketList(MarketDto market) throws Exception {
//		// TODO Auto-generated method stub
//		return marketMapper.selectMarketList(market);
//	}
	@Override
	public List<BoardDto> selectMarketList() throws Exception {
		return marketMapper.selectMarketList();
	}




//
//	@Override
//	public void insertMarket(MarketDto market) throws Exception {
//		marketMapper.insertMarket(market);		
//	}
//
//	@Override
//	public MarketDto selectMarketDetail(int seq) throws Exception {
//		return marketMapper.selectMarketDetail(seq);
//	}
//
//	@Override
//	public void deleteMarket(int seq) throws Exception {
//		marketMapper.deleteMarket(seq);
//	}
//
//	@Override
//	public void updateMarket(MarketDto market) throws Exception {
//		marketMapper.updateMarket(market);
//		
//	}

	
}
