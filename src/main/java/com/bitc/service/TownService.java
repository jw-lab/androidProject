package com.bitc.service;

import java.util.List;

import com.bitc.dto.TownBoardDto;
import com.bitc.dto.TownCommentDto;

public interface TownService {

	List<TownBoardDto> selectTownBoardList() throws Exception;

	List<TownCommentDto> selectTownCommentList(int idx) throws Exception;

	void writeBoard(TownBoardDto dto) throws Exception;

	void writeComment(TownCommentDto dto) throws Exception;

	void deleteBoard(int idx) throws Exception;

}
