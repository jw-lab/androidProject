package com.bitc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitc.dto.TownBoardDto;
import com.bitc.dto.TownCommentDto;
import com.bitc.mapper.TownMapper;

@Service
public class TownServiceImpl implements TownService{

	@Autowired
	TownMapper townMapper;
	


	@Override
	public List<TownCommentDto> selectTownCommentList(int idx)throws Exception {
		// TODO Auto-generated method stub
		return townMapper.selectTownCommentList(idx);
	}


	@Override
	public void writeBoard(TownBoardDto dto) throws Exception {
		townMapper.writeBoard(dto);
		
	}


	@Override
	public List<TownBoardDto> selectTownBoardList() throws Exception {
		// TODO Auto-generated method stub
		return townMapper.selectTownBoardList();
	}


	@Override
	public void writeComment(TownCommentDto dto) throws Exception {
		townMapper.writeComment(dto);
		
	}


	@Override
	public void deleteBoard(int idx) throws Exception {
	
		townMapper.deleteBoard(idx);
		
	}

}
