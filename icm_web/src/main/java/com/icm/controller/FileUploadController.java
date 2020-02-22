package com.icm.controller;



import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.mail.Multipart;

import org.apache.catalina.webresources.FileResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.icm.model.requestDTO.FileUrl;
import com.icm.model.responseDTO.Response;
import com.icm.service.StorageService;
@RestController
@RequestMapping("api/v1/upload-file/")
public class FileUploadController {
//	Autowired
//	StorageService storageService;
	private static final Logger logger=LoggerFactory.getLogger(FileUploadController.class);
	
	

	
	
	

	
	
	//@PostMapping("/bannerUpload")
	@PostMapping("/upload")
	public ResponseEntity uploadToLocalFileSystem(@RequestParam("file") MultipartFile file) {
		
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());

String[] docExtension={"DOC","DOCX"
		,"HTML","HTM"
		,"ODT"
		,"PDF"
		,"XLS","XLSX"
		,"ODS"
		,"PPT","PPTX"
		,"TXT","CSV"};
String[] imageExtension={"JPG",
	"PNG"
	,"GIF"
	,"WEBP"
	,"TIFF"
	,"PSD"
	,"RAW"
	,"BMP"
	,"HEIF"
	,"INDD"
	,"JPEG"};

if(fileName!=null)
{
	

for(int i=0;i<fileName.length();i++)
{
try{
	switch (getFileExtension(fileName)) {
	

//if(getFileExtension(fileName).equalsIgnoreCase((imageExtension[i].toString())))	
//{
//	
//	logger.info("entered");
//new File(FileUrl.setUPLOAD_URL(FileUrl.getIMAGES())).mkdir();
//
//if(getFileExtension(fileName).equalsIgnoreCase((docExtension[i].toString())))	
//{
//	logger.info("entered");
//new File(FileUrl.setUPLOAD_URL(FileUrl.getDOCS())).mkdirs();
//
//break;
//}

}


}
catch(ArrayIndexOutOfBoundsException e){
	e.printStackTrace();
}

}}
	// new File(FileUrl.getIMAGES()).mkdirs();
	logger.info(FileUrl.getUPLOAD_URL());
		Path path = Paths.get(FileUrl.getUPLOAD_URL() + fileName);
		try {
			Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
				.path("/files/download/")
				.path(fileName)
				.toUriString();
		return ResponseEntity.ok(fileDownloadUri);
	}
	
	
	
	@PostMapping("/multi-upload")
	public ResponseEntity multiUpload(@RequestParam("files") MultipartFile[] files) {
		
		
		List<Object> fileDownloadUrls = new ArrayList<>();
		Arrays.asList(files)
				.stream()
				.forEach(file -> fileDownloadUrls.add(uploadToLocalFileSystem(file).getBody()));
		return ResponseEntity.ok(fileDownloadUrls);
	}
	



private static String getFileExtension(String fileName) {
   // String fileName = file.getName();
    if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
    return fileName.substring(fileName.lastIndexOf(".")+1);
    else return "";
}

}


