package com.atdev.task.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.atdev.task.entity.Students;


@Repository
public class MainDao {

	@Autowired
	SessionFactory factory;

	// ADD DATA
	public String addData(Students s) {
		Session session = null;
		Transaction tx = null;
		String msg = null;

		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			session.persist(s);
			tx.commit();
			msg = "Data Added Succesfully";
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}

			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return msg;
	}

	// UPDATE DATA
	public String updateData(Students s) {
		Session session = null;
		Transaction tx = null;
		String msg = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();

			Students std = session.get(Students.class, s.getId());

			std.setName(s.getName());
			std.setAddress(s.getAddress());
			std.setMobileNo(s.getMobileNo());
			std.setAddress(s.getAddress());

			session.merge(std);
			tx.commit();
			msg = "Data Updated Succesfully";
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}

			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return msg;
	}

	//DELETE DATA
	public String deleteData(int id) {
		Session session = null;
		Transaction tx = null;
		String msg = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();

			Students s = session.get(Students.class, id); 
			session.remove(s);

			tx.commit();
			msg = "Data Deleted Succefully..";

		} catch (Exception e) {

			if (tx != null) {
				tx.rollback();
			}

			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return msg;
	}
	
	//GET ALL RECORDS
	public List<Students> getAllData() {
		Session session = null;
		Transaction tx = null;
		List<Students> list=null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			
			String hqlQry = "from Students";
			Query<Students> qry = session.createQuery(hqlQry,Students.class);
			list = qry.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}

			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

}
