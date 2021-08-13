package com.demo.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.demo.VO.adminVO;


public interface adminService {

	boolean insert(adminVO av);

	List search();

	ResponseEntity delete(adminVO v);

	List viewByID(adminVO v);

	List edit(adminVO v);

	boolean sendemail(adminVO av);

	

}
