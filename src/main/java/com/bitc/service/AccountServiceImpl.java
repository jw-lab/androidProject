package com.bitc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.bitc.common.FileUtils;
import com.bitc.dto.AccountDto;
import com.bitc.dto.BoardDto;
import com.bitc.dto.ProfileDto;
import com.bitc.mapper.AccountMapper;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountMapper accountMapper;
	
	@Autowired
	private FileUtils fileUtils;
	
	//아이디 중복 체크
	@Override
	public boolean checkId(String userEmail) throws Exception {
		int count = accountMapper.checkId(userEmail);
		// 중복이 없는 경우
		if(count == 0) {
			return true;
		}
		return false;
	}

//	회원가입
	@Override
	public void signup(AccountDto account) throws Exception {
		accountMapper.signup(account);
		
	}

//	아이디, 비밀번호 체크
	@Override
	public boolean loginCheck(AccountDto account) throws Exception {
		int count = accountMapper.loginCheck(account);
		//아이디와 비밀번호가 일치하는 경우
		if (count == 1) {
			return true;
		}
		return false;
	}
//	해당 유저 데이터 가져오기
	@Override
	public AccountDto getUserData(AccountDto account) throws Exception {
		String userEmail = account.getUserEmail();
		return accountMapper.getUserData(userEmail);
	}
//	회원정보 수정하기
	@Override
	public void editUser(AccountDto account) throws Exception {
		accountMapper.editUser(account);
		
	}
//	회원탈퇴
	@Override
	public void deleteUser(AccountDto account) throws Exception {
		String userEmail = account.getUserEmail();
		accountMapper.deleteUser(userEmail);
	}

//	회원정보 수정하기 - 프로필 사진 추가
	@Override
	public ProfileDto editUser(AccountDto account, MultipartHttpServletRequest image) throws Exception {
		
		ProfileDto profile = fileUtils.parseProfileInfo(account.getIdx(),image);
		if(profile!=null) {
			accountMapper.proflieUpload(profile);
		}
		return profile;
	}

//	프로필 존재 유무 체크
	@Override
	public int countProfile(int userIdx) throws Exception {
		
		return accountMapper.countProfile(userIdx);
	}
//	최근 프로필 사진만 가져오기
	@Override
	public ProfileDto getProfile(int userIdx) throws Exception {
		
		return accountMapper.getProfile(userIdx);
	}
//	내 게시글 목록 불러오기
	@Override
	public List<BoardDto> getUserboard(AccountDto account) throws Exception {
		return accountMapper.getUserboard(account.getIdx());
		
	}

	
	//전체 게시글 목록 불러오기
	@Override
	public List<BoardDto> getBoard() throws Exception {
		return accountMapper.getBoard();
	}
}
