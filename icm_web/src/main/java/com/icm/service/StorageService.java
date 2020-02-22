package com.icm.service;

import org.springframework.web.multipart.MultipartFile;

public interface StorageService {
	
	void store(MultipartFile banner);

}
