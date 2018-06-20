package com.infor.hnlmnl.genesis.design.utility;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.springframework.web.multipart.MultipartFile;

public class Common {
	// STATIC INTEGER VARIABLES
	public static final int ZERO = 0;
	public static final int ONE = 1;
	
	// STATIC STRING VARIABLES
	public static final String ACTIVE = "active";
	public static final String ADMIN = "ADMIN";
	public static final String ALL = "all";
	public static final String BACKSLASH = "/";
	public static final String BIG_Y = "Y";
	public static final String COMMA = ",";
	public static final String DOWNLOAD_ID = "downloadId";
	public static final String DOWNLOAD_TIME = "downloadTime";
	public static final String EMAIL_ADDRESS = "emailAddress";
	public static final String EXTENSION_PNG = ".png";
	public static final String EXTENSION_SVG = ".svg";
	public static final String EXTENSION_ZIP = ".zip";
	public static final String EXTENSION_TXT = ".txt";
	public static final String HAS_PNG = "hasPng";
	public static final String HAS_NEW_PNG = "hasNewPng";
	public static final String HAS_NEW_SVG = "hasNewSvg";
	public static final String HAS_PRODUCT_NEW = "hasProductNew";
	public static final String HAS_SVG = "hasSvg";
	public static final String ICON_COUNTER = "iconCounter";
	public static final String ICON_ID = "iconId";
	public static final String ICON_NAME = "iconName";
	public static final String ICON_STATUS = "iconStatus";
	public static final String ICON_TYPE = "iconType";
	public static final String ICONPACK = "iconpack";
	public static final String IMAGE_PNG = "png";
	public static final String IS_NEW_PRODUCT = "isNewProduct";
	public static final String MODE_ADD = "add";
	public static final String MODE_EDIT = "edit";
	public static final String PATH_ASSET = "assets/";
	public static final String PATH_DEV = "E:/hnlmnl/genesis-dev/";
	public static final String PATH_FEATURE = "designlibrary/src/";
	public static final String PATH_ICON = PATH_FEATURE + PATH_ASSET + "icons/";
	public static final String PATH_ICONPACKS = "iconpacks/";
	public static final String PATH_PROD = "E:/hnlmnl/genesis-prd/";
	public static final String PATH_QA = "E:/hnlmnl/genesis-qa/";
	public static final String PATH_TEST = "C:/Users/jtadique/Documents/hnlmnl/genesis/";
	public static final String PRODUCT_ID = "productId";
	public static final String PRODUCT_NAME = "productName";
	public static final String PRODUCT_NEW = "productNew";
	public static final String PROPERTY_FORMAT = "propertyFormat";
	public static final String PROPERTY_ID = "propertyId";
	public static final String PROPERTY_PREFIX = "propertyPrefix";
	public static final String PROPERTY_SIZE = "propertySize";
	public static final String S_18 = "s18";
	public static final String S_22 = "s22";
	public static final String S_29 = "s29";
	public static final String S_40 = "s40";
	public static final String S_48 = "s48";
	public static final String S_50 = "s50";
	public static final String S_57 = "s57";
	public static final String S_58 = "s58";
	public static final String S_72 = "s72";
	public static final String S_76 = "s76";
	public static final String S_80 = "s80";
	public static final String S_100 = "s100";
	public static final String S_114 = "s114";
	public static final String S_120 = "s120";
	public static final String S_144 = "s144";
	public static final String S_152 = "s152";
	public static final String S_512 = "s512";
	public static final String S_1024 = "s1024";
	public static final String SIZE_100 = "100x100";
	public static final String SIZE_18 = "18x18";
	public static final String SIZE_22 = "22x22";
	public static final String SIZE_29 = "29x29";
	public static final String SIZE_40 = "40x40";
	public static final String SIZE_48 = "48x48";
	public static final String SIZE_50 = "50x50";
	public static final String SIZE_57 = "57x57";
	public static final String SIZE_58 = "58x58";
	public static final String SIZE_72 = "72x72";
	public static final String SIZE_76 = "76x76";
	public static final String SIZE_80 = "80x80";
	public static final String SIZE_114 = "114x114";
	public static final String SIZE_120 = "120x120";
	public static final String SIZE_144 = "144x144";
	public static final String SIZE_152 = "152x152";
	public static final String SIZE_512 = "512x512";
	public static final String SIZE_1024 = "1024x1024";
	public static final String SMALL_G = "g";
	public static final String SMALL_X = "x";
	public static final String STRING_EMPTY = "";
	public static final String TAG_ID = "tagId";
	public static final String TAG_NAME = "tagName";
	public static final String TAG_STATUS = "tagStatus";
	public static final String TAGS = "tags";
	public static final String TYPE_CLASS = "typeClass";
	public static final String TYPE_COUNT = "typeCount";
	public static final String TYPE_ID = "typeId";
	public static final String TYPE_NAME = "typeName";
	public static final String TYPE_SIZE = "typeSize";
	public static final String VERSION_DATE_TIME = "versionDateTime";
	public static final String VERSION_ID = "versionId";
	public static final String VERSION_NAME = "versionName";
	public static final String WEB_MESSAGE_ERROR = "ERROR";
	public static final String WEB_MESSAGE_OK = "OK";

	// FOR FIX
	public static final String STRING_TRUE = "true";
	
	// STATIC STRING VARIABLES
	public static final String[] ARRAY_ICON_TYPES = {
			"alert",
			"application",
			"badge",
			"grid",
			"ming.le",
			"status",
			"toolbar",
			"tree",
			"widget",
			"all"
	};
	
	public static List<File> generateFileListFromFileArray(String[] fileArray) {
		List<File> fileList = new ArrayList<File>();
		
		for (int i = 0; i < fileArray.length; i++) {
			fileList.add(new File(fileArray[i]));
		}
		
		return fileList;
	}
	
	public static String generateBaseZipPath(String iconPack) {
		
		String zipPath = PATH_ASSET + PATH_ICONPACKS + iconPack;
		return zipPath;
	}
	
	public static String generateZipPath(String iconPack) {
		String zipPath = PATH_DEV + PATH_FEATURE + PATH_ASSET + PATH_ICONPACKS + iconPack;
		return zipPath;
	}
	
	public static File zip(List<File> files, String zipPath) {
	    File zipfile = new File(zipPath);
	    byte[] buf = new byte[1024];
	    try {
	        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipfile));
	        for(int i=0; i<files.size(); i++) {
	            FileInputStream in = new FileInputStream(files.get(i));
	            out.putNextEntry(new ZipEntry(files.get(i).getName()));
	            int len;
	            while((len = in.read(buf)) > 0) {
	                out.write(buf, 0, len);
	            }
	            out.closeEntry();
	            in.close();
	        }
	        out.close();
	        return zipfile;
	    } catch (IOException ex) {
	        System.err.println(ex.getMessage());
	    }
	    return null;
	}
	
	public static List<MultipartFile> createImageList(MultipartFile iconImage1, MultipartFile iconImage2, MultipartFile iconImage3, MultipartFile iconImage4) {
		ArrayList<MultipartFile> imageList = new ArrayList<MultipartFile>();
		
		if (iconImage1 != null && !iconImage1.isEmpty()) {
			imageList.add(iconImage1);
		}
		
		if (iconImage2 != null && !iconImage2.isEmpty()) {
			imageList.add(iconImage2);
		}
		
		if (iconImage3 != null && !iconImage3.isEmpty()) {
			imageList.add(iconImage3);
		}
		
		if (iconImage4 != null && !iconImage4.isEmpty()) {
			imageList.add(iconImage4);
		}
		
		return imageList;
	}
	
	public static void getQueryReport(String funct, String sql) {
		String headerLine = "Query Report for (" + funct + ") [" + getCurrentDateTime() + "]"; 
		System.out.println(headerLine);
		System.out.println(sql);
		writeLog(headerLine + "\n" + sql);
	}
	
	public static void getDataReport(String funct, String data) {
		String headerLine = "Data Report for (" + funct + ") [" + getCurrentDateTime() + "]";
		System.out.println(headerLine);
		System.out.println(data);
		writeLog(headerLine + "\n" + data);
	}
	
	public static void getErrorReport(String funct, String message) {
		String headerLine = "Error Report for (" + funct + ") [" + getCurrentDateTime() + "]";
		System.out.println(headerLine);
		System.out.println(message);
	}
	
	public static String getCurrentDateTime() {
		return new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new Date());
	}
	
	public static String getCurrentDate() {
		return new SimpleDateFormat("MMddyyyy").format(new Date());
	}
	
	public static synchronized void writeLog(String msg) {
		String logFile = "hnl-weblog/hnl-weblog-" + getCurrentDate() + Common.EXTENSION_TXT;
		PrintWriter printWriter = null;
		try {
			FileWriter fileWriter = new FileWriter(logFile, true);
		    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		    printWriter = new PrintWriter(bufferedWriter);
		    printWriter.write(msg);
		    printWriter.write("\r\n");
		    printWriter.close();
		} catch (IOException e) {
			getErrorReport("writeLog", "Unable to write to logfile.");
		}
	}
}
