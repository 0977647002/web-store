package com.nguyentanhuy.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.nguyentanhuy.dao.IGennericDAO;
import com.nguyentanhuy.entity.ReceiptItem;
import com.nguyentanhuy.util.HibernateUtil;

@Repository
public class ReceiptItemDAO implements IGennericDAO<ReceiptItem> {
	
	public boolean create(ReceiptItem object) {
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

	public boolean update(ReceiptItem object) {
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

	public boolean delete(ReceiptItem object) {
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

	public ReceiptItem findById(Long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("FROM ReceiptItem WHERE id = :id");
			query.setLong("id", id);
			ReceiptItem opj = (ReceiptItem) query.uniqueResult();
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

	public List<ReceiptItem> getAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("FROM ReceiptItem");
			List<ReceiptItem> list = query.list();
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
