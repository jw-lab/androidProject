package com.bitc.dto;

import lombok.Data;

@Data
public class UserDto {

	private int idx;
	private String userNickname;
	private String userPw;
	private String userEmail;
	private String userAddress;
	private String userPhone;
	private int level;
}
