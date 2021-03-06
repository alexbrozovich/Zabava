package com.gc.controller.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.gc.model.QuestDTO;
import com.gc.utils.HibernateUtil;
import com.gc.utils.QuestDao;
import com.gc.utils.RandCharMaker;

public class HibernateQuestDao implements QuestDao {

	private static SessionFactory factory;
	
	/**
	 * 
	 */
	public HibernateQuestDao() {
		factory = HibernateUtil.getSessionFactory();
	}

	@Override
	public List<QuestDTO> getAllQuests() {
		return null;
	}

	@Override
	public QuestDTO getQuest(int questId) {
		return null;
	}

	@Override
	public void updateQuest(QuestDTO quest) {

	}

	@Override
	public void deleteQuest(QuestDTO quest) {

	}

	@Override
	public void saveQuest(QuestDTO quest) {

	}

	public int addQuest(QuestDTO quest) {
		
		Session session = factory.openSession();
		Transaction tx = null;
		int questID = 0;

		try {
			tx = session.beginTransaction();
			questID = (Integer) session.save(quest); // Captures the AutoIncremented QuestID
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return questID;

	}

	public static String getQuestCode() {
		boolean isEqual = true;
		String questCode = null;

		while (isEqual == true) {
			questCode = "";

			for (int i = 0; i < 4; i++) {
				questCode += RandCharMaker.getRandChar();
			}

			if (RandCharMaker.checkForUse(questCode) == true) {
				isEqual = false;
			}
			
		}
		return questCode;

	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<QuestDTO> getQuestsByCreator(int creatorID){
		
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		
	      Session session = factory.openSession();
	      Transaction tx = null;
	      ArrayList<QuestDTO> quests = null;
	      try {
	         tx = session.beginTransaction();
	         Criteria crit = session.createCriteria(QuestDTO.class);
				crit.add(Restrictions.eq("creatorId", creatorID));
				// restrict to tasks associated with the creatorID
				
				quests = (ArrayList<QuestDTO>) crit.list();
	         
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
		return quests;
	   }

}
