package com.bitc.service;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.bitc.dto.AccountDto;
import com.bitc.dto.BoardDto;
import com.bitc.dto.ProfileDto;

public interface AccountService {

	boolean checkId(String userEmail) throws Exception;

	void signup(AccountDto account) throws Exception;

	boolean loginCheck(AccountDto account) throws Exception;

	AccountDto getUserData(AccountDto account) throws Exception;

	void editUser(AccountDto account) throws Exception;

	void deleteUser(AccountDto account) throws Exception;

	ProfileDto editUser(AccountDto account, MultipartHttpServletRequest image) throws Exception;

	int countProfile(int userIdx) throws Exception;

	ProfileDto getProfile(int userIdx) throws Exception;

	List<BoardDto> getUserboard(AccountDto account) throws Exception;

	List<BoardDto> getBoard() throws Exception;

}
