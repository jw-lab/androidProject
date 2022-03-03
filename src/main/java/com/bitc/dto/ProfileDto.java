package com.bitc.dto;

import lombok.Data;

@Data
public class ProfileDto {
	private int idx;
	private int userIdx;
	private String originalFileName;
	private String storedFilePath;
	private String fileSize;
	private String createdDt;
}
