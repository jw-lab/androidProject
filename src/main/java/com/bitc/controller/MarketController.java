
package com.bitc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bitc.dto.BoardDto;
import com.bitc.service.AccountService;
import com.bitc.service.MarketService;
import com.google.gson.Gson;

@RestController
public class MarketController {

	@Autowired
	MarketService marketService;
	AccountService accountService;
//
//	@RequestMapping("/")
//	public String index() throws Exception {
//		return "index";
//	}

	@ResponseBody
	@RequestMapping(value = "/board", method = RequestMethod.GET)
	public Object selectBoard(BoardDto board) throws Exception {
		List<BoardDto> boardList = marketService.selectMarketList();
//		Map<String, Object> map = new HashMap<>();
//		// 해당 유저 프로필 사진 가져오기
//		AccountDto userData = accountService.getUserData(account);
//		ProfileDto profile = new ProfileDto();
//		int count = accountService.countProfile(userData.getIdx());
//		map.put("count", count);
//		if (count != 0) {
//			profile = accountService.getProfile(userData.getIdx());
//			map.put("profilePath", profile.getStoredFilePath());
//		}
		Gson gson = new Gson();
		return gson.toJson(boardList);
	}

	@ResponseBody
	@RequestMapping("write")
	public String InsertMarket(BoardDto market) throws Exception {

		Map<String, String> result = new HashMap<String, String>();

		if (marketService.insertMarket(market) > 0) {
			result.put("success", "true");
		} else {
			result.put("success", "false");
		}

		Gson gson = new Gson();

		return gson.toJson(result);
	}

//    @ResponseBody
//    @RequestMapping(value = "/board", method = RequestMethod.GET)
//    public Object selectboard(BoardDto board) throws Exception {
//        List<BoardDto> boardList= marketService.selectMarketList();
//        Gson gson = new Gson();
//        return gson.toJson(boardList);
//    }

//	@ResponseBody
//	@RequestMapping(value = "/board", method = RequestMethod.POST)
//	public List<MarketDto> openpMarketList() throws Exception {
//		return marketService.selectMarketList();
//	}

//	@ResponseBody
//	@RequestMapping(value = "board", method = RequestMethod.GET)
//	public String loginPost(MarketDto market) throws Exception {
//		
//		Map<String, String> result = new HashMap<String, String>();
////		Map<String, String> result2 = new HashMap<String, String>();
//
//		market = marketService.selectMarketList(market);
////		result.put("success", "true");
//		result.put("price", market.getPrice());
//		result.put("title", market.getTitle());
////		result.put("seq", Integer.toString(market.getSeq()));
////		result.put("local", market.getLocal());
//
//		Gson gson = new Gson();
//		
////		Map<String<result1>, String> result = new HashMap<String, String>();
////		result.put("result1",result1);
////		result.put("result1",result1);
//
//		return gson.toJson(result);
//	}

//	@RequestMapping(value = "/market/board", method = RequestMethod.GET)
//	public List<MarketDto> openMarketList() throws Exception {
//		return marketService.selectMarketList();
//	}
//
//
//	@RequestMapping(value = "/market/board/insert", method = RequestMethod.POST)
//	public void insertMarket(@RequestBody MarketDto market) throws Exception {
//		marketService.insertMarket(market);
//	}
//
//
//	@RequestMapping(value = "/market/board/{seq}", method = RequestMethod.GET)
//	public MarketDto openMarketDetail(@PathVariable("seq") int seq) throws Exception {
//		return marketService.selectMarketDetail(seq);
//	}
//
//
//	@RequestMapping(value = "market/board/{seq}", method = RequestMethod.DELETE)
//	public String deleteMarketList(@PathVariable("seq") int seq) throws Exception {
//		marketService.deleteMarket(seq);
//		return "redirect:market";
//	}
//
//
//	@RequestMapping(value = "market/board/{seq}", method = RequestMethod.PUT)
//	public String updateMarketList(@RequestBody MarketDto market) throws Exception {
//		marketService.updateMarket(market);
//		return "redirect:market";
//	}

}
