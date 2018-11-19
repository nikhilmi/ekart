package com.teamsankya.ekart.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.teamsankya.ekart.dao.EkartDao;
import com.teamsankya.ekart.dao.EkartDaoHibernateImpl;
import com.teamsankya.ekart.dto.EkartBean;

@Controller
public class EkartController {

	/*
	 * @Autowired private EkartService eservice;
	 */
	@Autowired
	EkartDaoHibernateImpl ekartDaoImpl;
	

	final static Logger LOGGER = Logger.getLogger(EkartController.class);

	@RequestMapping(path = "/viewemp/{pageid}", method = RequestMethod.GET)
	public ModelAndView getProduct(@RequestParam(value="category",required=false) String productcategory, @PathVariable int pageid,
			ModelAndView view) throws IOException {
		
		LOGGER.info("inside"+this.getClass().getSimpleName());
		LOGGER.info("inside productSearch() method");
		LOGGER.info("calling getDataFromDao() method");
		
		int total = 10;

		if (pageid == 0) {
			/* pageid=(pageid-1)*total+0; */} else {
			pageid = (pageid - 1) * total + 1;
		}

		EkartBean ebean = new EkartBean();
		List<EkartBean> plist = ekartDaoImpl.getDataFromDao(productcategory, pageid, total);

		return new ModelAndView("Hello", "productdetail", plist);
	}



}
