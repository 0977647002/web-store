package com.nguyentanhuy.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.nguyentanhuy.dao.IGennericDAO;
import com.nguyentanhuy.entity.Category;
import com.nguyentanhuy.util.HibernateUtil;

@Repository
public class CategoryDAO implements IGennericDAO<Category> {

	public boolean create(Category object) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(object);
			transaction.commit();
			return true;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return false;
	}

	public boolean update(Category object) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.update(object);
			transaction.commit();
			return true;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return false;
	}

	public boolean delete(Category object) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.delete(object);
			transaction.commit();
			return true;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return false;
	}

	public Category findById(Long categoryId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("FROM Category WHERE id = :id");
			query.setLong("id", categoryId);
			Category opj = (Category) query.uniqueResult();
			opj.getListProduct();
			transaction.commit();
			return opj;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Category> getAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("FROM Category");
			List<Category> list = query.list();
			transaction.commit();
			return list;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
				e.printStackTrace();
			}
		} finally {
			session.flush();
			session.close();
		}
		return null;
	}
}
