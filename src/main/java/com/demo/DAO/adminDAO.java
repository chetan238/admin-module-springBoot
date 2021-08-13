package com.demo.DAO;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.demo.VO.adminVO;

public interface adminDAO {

	void insert(adminVO av);

	List search();

	ResponseEntity delete(adminVO v);

	List viewByID(adminVO v);

	List edit(adminVO v);

}
