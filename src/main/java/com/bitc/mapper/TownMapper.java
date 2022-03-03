package com.bitc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bitc.dto.TownBoardDto;
import com.bitc.dto.TownCommentDto;

@Mapper
public interface TownMapper {

	
	public List<TownBoardDto> selectTownBoardList()throws Exception;

	public List<TownCommentDto> selectTownCommentList(int idx) throws Exception;

	public void writeBoard(TownBoardDto dto)throws Exception;

	public void writeComment(TownCommentDto dto) throws Exception;

	public void deleteBoard(int idx) throws Exception;

}
