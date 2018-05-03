package com.infor.hnlmnl.genesis.soho.controller;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.infor.hnlmnl.genesis.soho.dto.Icon;
import com.infor.hnlmnl.genesis.soho.dto.IconBundle;
import com.infor.hnlmnl.genesis.soho.dto.IconDownloadReport;
import com.infor.hnlmnl.genesis.soho.dto.IconDownloadUpdate;
import com.infor.hnlmnl.genesis.soho.dto.IconTag;
import com.infor.hnlmnl.genesis.soho.dto.IconType;
import com.infor.hnlmnl.genesis.soho.dto.Product;
import com.infor.hnlmnl.genesis.soho.dto.SoHoResponse;
import com.infor.hnlmnl.genesis.soho.dto.Version;
import com.infor.hnlmnl.genesis.soho.service.IconService;
import com.infor.hnlmnl.genesis.soho.utility.Common;
import com.infor.hnlmnl.genesis.soho.service.CommonService;

@Controller
public class HNLWebServiceController {
	
	@Autowired
	private IconService iconService;
	
	@Autowired
	private CommonService commonService;
	
	
	/* WEB PAGES */
	@RequestMapping(value = "/getVersion", method = RequestMethod.GET)
	public ModelAndView version() {
		Version version = commonService.getVersion();
		return new ModelAndView("version", "version", version);
	}
	
	/* WEB CALLS */
	@RequestMapping(value = "/getIcons", method = RequestMethod.GET)
	public @ResponseBody List<Icon> getIcons() {
		List<Icon> icons = iconService.getIcons();
		icons = iconService.getIconProducts(icons);
		icons = iconService.getIconProperties(icons);
		return icons;
	}
	
	@RequestMapping(value = "/getTypes", method = RequestMethod.GET)
	public @ResponseBody List<IconType> getTypes() {
		List<IconType> types = iconService.getTypes();
		return types;
	}
	
	@RequestMapping(value = "/getProducts", method = RequestMethod.GET)
	public @ResponseBody List<Product> getProducts() {
		List<Product> products = commonService.getProducts();
		return products;
	}
	
	@RequestMapping(value = "/getIconInfoById", method = RequestMethod.POST)
	public @ResponseBody Icon getIconInfoById(@RequestParam(value = "iconId", required = false) String iconId) {
		Common.getDataReport("getIconInfoById", iconId);
		Icon icon = iconService.getIconInfoById(iconId);
		List<Icon> icons = new ArrayList<Icon>();
		icons.add(icon);
		
		icons = iconService.getIconProducts(icons);
		icons = iconService.getIconProperties(icons);
		return (Icon) icons.get(0);
	}
	
	@RequestMapping(value = "/getIconBundle", method = RequestMethod.GET)
	public @ResponseBody IconBundle getIconBundle() {
		List<Icon> icons = iconService.getIcons();
		icons = iconService.getIconProducts(icons);
		List<IconType> types = iconService.getTypes();
		List<Product> products = commonService.getProducts();
		
		IconBundle starter = new IconBundle(icons, types, products);
		return starter;
	}
	
	@RequestMapping(value = "/getTags", method = RequestMethod.GET)
	public @ResponseBody List<IconTag> getTags() {
		List<IconTag> tags = iconService.getTags();
		return tags;
	}
	
	@RequestMapping(value = "/getDownloadReport", method = RequestMethod.GET)
	public @ResponseBody List<IconDownloadReport> getDownloadReport() {
		List<IconDownloadReport> downloads = iconService.getDownloadReport();
		return downloads;
	}
	
	@RequestMapping(value = "/getDownloadUpdate", method = RequestMethod.GET)
	public @ResponseBody IconDownloadUpdate getDownloadUpdate(@QueryParam("data") String data) {
		Common.getDataReport("getDownloadUpdate", data);
		IconDownloadUpdate iconDownloadUpdate = iconService.getDownloadUpdate(data);
		iconDownloadUpdate.setIcons(iconService.getIconProducts(iconDownloadUpdate.getIcons()));
		iconDownloadUpdate.setIcons(iconService.getIconProperties(iconDownloadUpdate.getIcons()));
		iconDownloadUpdate.setIconZip(commonService.getZipPath(iconDownloadUpdate.getIcons()));
		return iconDownloadUpdate;
	}
	
	@RequestMapping(value = "/saveIcon", method = RequestMethod.POST)
	public @ResponseBody SoHoResponse saveIcon(@RequestParam("mode") String mode,
			@RequestParam("iconData") String iconData, 
			@RequestParam(value = "iconImage1", required = false) MultipartFile iconImage1,
			@RequestParam(value = "iconImage2", required = false) MultipartFile iconImage2, 
			@RequestParam(value = "iconImage3", required = false) MultipartFile iconImage3, 
			@RequestParam(value = "iconImage4", required = false) MultipartFile iconImage4) {
		
		Common.getDataReport("saveIcon", iconData);
		Common.getDataReport("saveIcon", mode);
		
		SoHoResponse response = iconService.saveIcon(iconData, mode);
		List<MultipartFile> imageList = Common.createImageList(iconImage1, iconImage2, iconImage3, iconImage4);
		response = commonService.saveIconImage(imageList, iconData, mode);
		
		return response;
	}
	
	@RequestMapping(value = "/getIconPack", method = RequestMethod.GET)
	public ResponseEntity<InputStreamResource> getIconPack(
			@QueryParam("zipPath") String zipPath) throws IOException {

		Common.getDataReport("getIconPack", zipPath);
		
		File file = new File(zipPath);
		InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

		return ResponseEntity.ok()
	        .header(HttpHeaders.CONTENT_DISPOSITION,
	              "attachment;filename=" + file.getName())
	        .contentType(MediaType.MULTIPART_FORM_DATA).contentLength(file.length())
	        .body(resource);
   }
}
