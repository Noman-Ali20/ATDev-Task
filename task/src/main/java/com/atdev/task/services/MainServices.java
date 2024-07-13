package com.atdev.task.services;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atdev.task.dao.MainDao;
import com.atdev.task.entity.Students;

@Service
public class MainServices {
	
	@Autowired
	MainDao dao;
	
	public String addData(Students s) {
		String msg =dao.addData(s);
		
		if(Objects.isNull(msg)) {
			msg="Data is not Added";
		}
		return msg;
	}
	
	public String updateData(Students s) {
		String msg = dao.updateData(s);
		if(Objects.isNull(msg)) {
			msg="Data is not updated";
		}
		return msg;
	}

	public String deleteData(int id) {
		String msg = dao.deleteData(id);
		if(Objects.isNull(msg)) {
			msg="Data is not deleted";
		}
		return msg;
	}
	
	public List<Students> getAllData(){
		List<Students> list =dao.getAllData();
		if (Objects.isNull(list)) {
			list = null;
		}
		return list;
	}
}
