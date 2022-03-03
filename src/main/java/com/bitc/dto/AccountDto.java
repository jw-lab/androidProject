package com.bitc.dto;

import lombok.Data;

@Data
public class AccountDto {
	private int idx;
	private String userEmail;
	private String userPassword;
	private String userName;
	private String userPhone;
	private String userAddress;
}
