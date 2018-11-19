package com.teamsankya.ekart.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.teamsankya.ekart.dto.EkartBean;

@Repository
public class EkartDaoHibernateImpl implements EkartDao {

	@Autowired
	private SessionFactory sessionFactory;

	final static Logger LOGGER = Logger.getLogger(EkartDaoHibernateImpl.class);
	
	public EkartDaoHibernateImpl() {
	}

	public List<EkartBean> getDataFromDao(String productcategory, int pageid, int total) {
		
		LOGGER.info("inside getDataFromDao() of"+this.getClass().getSimpleName());
		
		// select * from product where pcategory='pen' limit 1,5;
		// "select * from Emp limit "+(pageid-1)+","+total;
		// String hql="from EkartBean E where E.productcategory='"+productcategory+"'";
		// String hql="from EkartBean E where E.productcategory='"+productcategory+"'
		// limit "+(pageid-1)+","+total;

		int pageFrom = pageid;
		String hql = "from EkartBean E where E.productcategory='" + productcategory + "'";
		@SuppressWarnings("unchecked")
		org.hibernate.query.Query<EkartBean> q = sessionFactory.openSession().createQuery(hql).setFirstResult(pageFrom)
				.setMaxResults(total);
		List<EkartBean> res = q.list();

		LOGGER.info("db results returning from getDataFromDao() of"+this.getClass().getSimpleName());
		
		return res;

	}
}
