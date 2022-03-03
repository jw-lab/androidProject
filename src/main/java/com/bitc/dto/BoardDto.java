package com.bitc.dto;

import lombok.Data;

@Data
public class BoardDto {
	private int seq;
	private int userIdx;
	private String title;
	private String price;
	private String contents;
	private String local;
}
