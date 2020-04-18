package com.nguyentanhuy.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.nguyentanhuy.dao.IGennericDAO;
import com.nguyentanhuy.entity.Receipt;
import com.nguyentanhuy.util.HibernateUtil;

@Repository
public class ReceiptDAO implements IGennericDAO<Receipt> {

	public boolean create(Receipt object) {
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

	public boolean update(Receipt object) {
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

	public boolean delete(Receipt object) {
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

	public Receipt findById(Long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("FROM Receipt WHERE id = :id");
			query.setLong("id", id);
			Receipt opj = (Receipt) query.uniqueResult();
			transaction.commit();
			return opj;
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

	public List<Receipt> getAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("FROM Receipt");
			List<Receipt> list = query.list();
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
