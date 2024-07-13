package com.atdev.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atdev.task.entity.Students;
import com.atdev.task.services.MainServices;

@RestController
@RequestMapping("/api")
public class MainController {
	
	@Autowired
	MainServices service;
	
	@PostMapping("/addData")
	public String addData(@RequestBody Students s) {
		String msg = service.addData(s);
		return msg;
	}
	
	@PutMapping("/update")
	public String updateData(@RequestBody Students s) {
		String msg = service.updateData(s);
		return msg;
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteData(@PathVariable int id) {
		String msg = service.deleteData(id);
		return msg;
	}
	
	@GetMapping("getData")
	public List<Students> getAllData(){
		List<Students> list = service.getAllData();
		return list;
	}
}
