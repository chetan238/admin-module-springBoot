package com.demo.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.demo.VO.adminResponse;
import com.demo.VO.adminVO;

@Repository

public class adminDAOImpl implements adminDAO {

	@Autowired
	private SessionFactory sf;

	@Override
	public void insert(adminVO av) {
		try {
			Session s = sf.getCurrentSession();
			s.saveOrUpdate(av);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List search() {
		// TODO Auto-generated method stub
		List<adminVO> ls = new ArrayList<adminVO>();
		try {
			Session s = sf.getCurrentSession();
			Query q = s.createQuery("from adminVO");
			ls = q.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ls;

	}

	@Override
	public ResponseEntity delete(adminVO v) {
		// TODO Auto-generated method stub
		try {
			Session s = sf.getCurrentSession();
			s.delete(v);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(new adminResponse("user deleted....!!!!"));
		
		
	}

	@Override
	public List viewByID(adminVO v) {
		// TODO Auto-generated method stub
		List<adminVO> ls = new ArrayList<adminVO>();
		try {
			Session s = sf.getCurrentSession();
			Query q = s.createQuery("from adminVO where id="+v.getId());
			ls = q.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ls;

		
	}

	@Override
	public List edit(adminVO v) {
		// TODO Auto-generated method stub
		List<adminVO> ls = new ArrayList<adminVO>();
		try {
			Session s = sf.getCurrentSession();
			Query q = s.createQuery("from adminVO");
			ls = q.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ls;

}
}
