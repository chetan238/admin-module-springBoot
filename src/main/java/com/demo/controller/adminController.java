package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import com.demo.Service.adminService;
import com.demo.VO.adminResponse;
import com.demo.VO.adminVO;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class adminController {

	@Autowired
	private adminService as;

	@GetMapping("hello")
	public String load() {

		return "i am called";
	}

	@PostMapping("users")

	public ResponseEntity<adminResponse> insert(@RequestBody adminVO av) {

		as.insert(av);
		boolean b = as.sendemail(av);
		if (b) {
			return ResponseEntity.ok(new adminResponse("user created succesfully and email send success....!!!!"));

		}
		else
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body((new adminResponse("email not send ....!!!!")));
		}
	}

	@SuppressWarnings("unchecked")
	@GetMapping("view")

	public ResponseEntity<List<adminVO>> view() {

		List<adminVO> ls = as.search();
		return new ResponseEntity<List<adminVO>>(ls, HttpStatus.OK);

	}

	@GetMapping("viewByID/{id}")

	public List viewByID(@ModelAttribute adminVO v, @PathVariable int id) {

		v.setId(id);
		List ljs = as.viewByID(v);
		return ljs;

	}

	@GetMapping("viewById/{id}")

	public ResponseEntity<List<adminVO>> viewById(@ModelAttribute adminVO v, @PathVariable int id) {

		v.setId(id);
		List ljs = as.viewByID(v);
		return new ResponseEntity<List<adminVO>>(ljs, HttpStatus.OK);

	}

	@SuppressWarnings("unchecked")

	@DeleteMapping("delete/{id}")

	public ResponseEntity delete(adminVO v, @PathVariable("id") int id) {

		System.out.println(id);
		v.setId(id);
		return as.delete(v);

	}

	@PutMapping("Update/{id}")

	public ResponseEntity<adminResponse> update(@RequestBody adminVO av, @PathVariable("id") int id) {

		av.setId(id);
		as.insert(av);
		as.sendemail(av);
		return ResponseEntity.ok(new adminResponse("user created success....!!!!"));

	}

	/*
	 * @GetMapping("update/{id}")
	 * 
	 * public ResponseEntity update(adminVO v, @PathVariable("id") int id) {
	 * 
	 * System.out.println(id); v.setId(id); List ls=as.edit(v); return new
	 * ResponseEntity<List<adminVO>>(ls, HttpStatus.OK);
	 * 
	 * }
	 */
}
