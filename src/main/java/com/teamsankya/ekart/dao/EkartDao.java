package com.teamsankya.ekart.dao;

import java.util.List;

import com.teamsankya.ekart.dto.EkartBean;

public interface EkartDao {

public List<EkartBean> getDataFromDao(String productcategory,int pageid,int total);
}
