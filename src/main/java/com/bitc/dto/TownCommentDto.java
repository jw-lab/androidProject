package com.bitc.dto;

import lombok.Data;

@Data
public class TownCommentDto {
	
	int idx;
	String createdUser;
	String userAdress;

	int boardKey;
	String comment;
	int originNum;
	int groupOrd;
	String createDt;

}
