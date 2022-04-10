package com.fwork.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fwork.services.WorkService;

@RestController
@RequestMapping("find-work/admin")
public class AdminController {
	@Autowired WorkService workService;
	@PatchMapping("/updatestatus")
	public ResponseEntity<String> workApproval(@RequestParam("workId") int workId,@RequestParam("status") String status){
		workService.updateworkApproval(workId,status);
		HttpHeaders header=new HttpHeaders();
		header.add("desc", "Successfully updated admin status");
		String msg="Successfully approved work";
		return ResponseEntity.status(HttpStatus.ACCEPTED).headers(header).body(msg);
	}
}
