package com.bitc.common;

import java.io.File;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.bitc.dto.ProfileDto;

@Component
public class FileUtils {

	public ProfileDto parseProfileInfo(int userIdx,MultipartHttpServletRequest multiFiles) throws Exception{
		if(ObjectUtils.isEmpty(multiFiles)) {
			return null;
		}
		ProfileDto profileDto = new ProfileDto();
		
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd");
		ZonedDateTime current = ZonedDateTime.now();
		//경로 설정
		String path = "/images/"+current.format(format);
		File file = new File(path);
		
		if(file.exists()==false) {
			file.mkdir();// 폴더가 없으면 생성
		}
		
		Iterator<String> iterator = multiFiles.getFileNames();
		String newFileName; // 파일이름이 저장되는 변수
		
		while (iterator.hasNext()) {
			String name = iterator.next();
			List<MultipartFile> list = multiFiles.getFiles(name);
			for(MultipartFile mFile : list) {

				if(mFile.isEmpty()==false) {
				
				//현재 시간을 기준으로 파일 이름 설정
				newFileName = Long.toString(System.nanoTime())+ ".jpg";
				
				profileDto.setUserIdx(userIdx);
				profileDto.setFileSize(Long.toString(mFile.getSize()));
				profileDto.setOriginalFileName(mFile.getOriginalFilename());
				profileDto.setStoredFilePath(path + "/" + newFileName);

				//업로드 경로 : C:\Users\USER\images\20220302
				file = new File(System.getProperty("user.home") + path + "/" + newFileName);
				mFile.transferTo(file);
				}
			}
		}
		return profileDto;
	}
}

