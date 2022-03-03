package com.bitc.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitc.dto.TownBoardDto;
import com.bitc.dto.TownCommentDto;
import com.bitc.service.TownService;
import com.google.gson.Gson;

@Controller
public class TownController {

	@Autowired
	private TownService townService;
	
	@ResponseBody
	@RequestMapping(value="/townBoard",method=RequestMethod.GET)
	public String selectTownBoardList()throws Exception{
		
		List<TownBoardDto> boardList = townService.selectTownBoardList();
		
		String json = new Gson().toJson(boardList);
		
		
		return json;
		
	}

	@ResponseBody
	@RequestMapping(value="/townBoard",method=RequestMethod.POST)
	public void writeBoard(TownBoardDto dto)throws Exception {
				
		townService.writeBoard(dto);
		
		
	}
	
	@ResponseBody
	@RequestMapping(value="/townBoard",method=RequestMethod.DELETE)
	public void deleteBoard(Map<String,String> map)throws Exception{
		int idx=Integer.parseInt(map.get("idx"));
		
		townService.deleteBoard(idx);
		
	}
	
	
	@ResponseBody
	@RequestMapping(value="/townComment",method=RequestMethod.GET)
	public String selectTownCommentList(int idx)throws Exception{
		List<TownCommentDto> commentList = townService.selectTownCommentList(idx);
		
		String json = new Gson().toJson(commentList);
		
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value="/townComment",method=RequestMethod.POST)
	public void writeComment(TownCommentDto dto)throws Exception {
		
		townService.writeComment(dto);
		
		
	}

}
