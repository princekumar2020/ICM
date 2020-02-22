package com.icm.model.requestDTO;

import org.springframework.web.multipart.MultipartFile;

public class FileUrl {
	private static String IMAGES="C://Users//Rishabh-Moptra//Desktop//uploaded_data//images//";
	private static String VIDEO="C://Users//Rishabh-Moptra//Desktop//uploaded_data//video//";
	private static String AUDIO="C://Users//Rishabh-Moptra//Desktop//uploaded_data//audio//";
	private static String DOCS="C://Users//Rishabh-Moptra//Desktop//uploaded_data//documents//";
	private String fileName;
	private static  String UPLOAD_URL="";
	public static String getIMAGES() {
		return IMAGES;
	}
	public static void setIMAGES(String iMAGES) {
		IMAGES = iMAGES;
	}
	public static String getVIDEO() {
		return VIDEO;
	}
	public static void setVIDEO(String vIDEO) {
		VIDEO = vIDEO;
	}
	public static String getAUDIO() {
		return AUDIO;
	}
	public static void setAUDIO(String aUDIO) {
		AUDIO = aUDIO;
	}
	public static String getDOCS() {
		return DOCS;
	}
	public static void setDOCS(String dOCS) {
		DOCS = dOCS;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public static String getUPLOAD_URL() {
		return UPLOAD_URL;
	}
	public static String setUPLOAD_URL(String uPLOAD_URL) {
		return UPLOAD_URL = uPLOAD_URL;
	}

	
	

}
