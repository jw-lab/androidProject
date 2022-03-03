package com.bitc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.bitc.dto.AccountDto;
import com.bitc.dto.BoardDto;
import com.bitc.dto.ProfileDto;
import com.bitc.service.AccountService;
import com.google.gson.Gson;

@Controller
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@RequestMapping("/")
	public String index() throws Exception {
		return "index";
	}
	
	//아이디 중복 확인
	@ResponseBody
	@RequestMapping(value = "/user/checkId", method = RequestMethod.POST)
	public Object checkId(AccountDto account) throws Exception {
		Map<String, Boolean> map = new HashMap<>();
		boolean validate = accountService.checkId(account.getUserEmail());
		map.put("success", validate);
		Gson gson = new Gson();
		return gson.toJson(map);
	}
	
	//회원가입
	@ResponseBody
	@RequestMapping(value = "/user/signup", method = RequestMethod.POST)
	public void signup(AccountDto account) throws Exception {
		accountService.signup(account);
	}
	
	//로그인
	@ResponseBody
	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
	public Object login(AccountDto account) throws Exception {
		Map<String, Object> map = new HashMap<>();
		//아이디, 비밀번호 체크
		boolean loginCheck = accountService.loginCheck(account);
		map.put("success", loginCheck);
		if (loginCheck == true) {
			//해당 유저 데이터 가져오기
			AccountDto userData = accountService.getUserData(account);
			map.put("userIdx", userData.getIdx());
			map.put("userEmail", userData.getUserEmail());
			map.put("userPassword", userData.getUserPassword());
			map.put("userName", userData.getUserName());
			map.put("userPhone", userData.getUserPhone());
			map.put("userAddress", userData.getUserAddress());
			
			//해당 유저 프로필 사진 가져오기
			ProfileDto profile = new ProfileDto();
			int count = accountService.countProfile(userData.getIdx());
			map.put("count", count);
			if (count != 0 ) {
				profile = accountService.getProfile(userData.getIdx());
				map.put("profilePath", profile.getStoredFilePath());
			} 
		}
		Gson gson = new Gson();
		return gson.toJson(map);
	}
	
	//회원정보 수정
	@ResponseBody
	@RequestMapping(value = "/user/edit", method = RequestMethod.PUT)
	public Object editUser(AccountDto account) throws Exception {
		Map<String, Object> map = new HashMap<>();
		accountService.editUser(account);
		//수정 후 데이터 다시 가져오기
		AccountDto userData = accountService.getUserData(account);
		map.put("userEmail", userData.getUserEmail());
		map.put("userPassword", userData.getUserPassword());
		map.put("userName", userData.getUserName());
		map.put("userPhone", userData.getUserPhone());
		map.put("userAddress", userData.getUserAddress());
		
		//해당 유저 프로필 사진 가져오기
		ProfileDto profile = new ProfileDto();
		int count = accountService.countProfile(userData.getIdx());
		map.put("count", count);
		if (count != 0 ) {
			profile = accountService.getProfile(userData.getIdx());
			map.put("profilePath", profile.getStoredFilePath());
		}
		
		Gson gson = new Gson();
		return gson.toJson(map);
	}
	
	//회원정보 수정 - 프로필 사진 추가
	@ResponseBody
	@RequestMapping(value = "/user/upload", method = RequestMethod.POST)
	public Object editUser(AccountDto account,MultipartHttpServletRequest image) throws Exception {
		Map<String, Object> map = new HashMap<>();
		ProfileDto profile = accountService.editUser(account,image);
		Gson gson = new Gson();
		map.put("profilePath", profile.getStoredFilePath());
		return gson.toJson(map);
	}
	
	//회원탈퇴
	@ResponseBody
	@RequestMapping(value = "/user/del", method = RequestMethod.PUT)
	public void deleteUser(AccountDto account) throws Exception {
		accountService.deleteUser(account);
	}

	//작성한 게시글 목록 불러오기
	@ResponseBody
	@RequestMapping(value = "/userboard", method = RequestMethod.POST)
	public Object getUserboard(AccountDto account) throws Exception {
		List<BoardDto> boardList= accountService.getUserboard(account);
		Gson gson = new Gson();
		return gson.toJson(boardList);
	}
	
}
