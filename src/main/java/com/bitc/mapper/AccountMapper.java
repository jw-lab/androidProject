package com.bitc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bitc.dto.AccountDto;
import com.bitc.dto.BoardDto;
import com.bitc.dto.ProfileDto;

@Mapper
public interface AccountMapper {

	int checkId(String userEmail) throws Exception;

	void signup(AccountDto account) throws Exception;

	int loginCheck(AccountDto account) throws Exception;

	AccountDto getUserData(String userEmail) throws Exception;

	void editUser(AccountDto account) throws Exception;

	void deleteUser(String userEmail) throws Exception;

	void proflieUpload(ProfileDto profile) throws Exception;

	int countProfile(int userIdx) throws Exception;

	ProfileDto getProfile(int userIdx) throws Exception;

	List<BoardDto> getUserboard(int userIdx) throws Exception;

	List<BoardDto> getBoard() throws Exception;

	
}
