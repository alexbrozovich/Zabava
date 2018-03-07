package com.gc.controller;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.gc.model.Task;
import com.gc.utils.HibernateUtil;

public class QuestController {
	
	public ArrayList<Task> generateQuestList() {
		SessionFactory sessFact = HibernateUtil.getSessionFactory();
		Session sess = sessFact.openSession();
		Transaction tx = sess.beginTransaction();
		Criteria crit = sess.createCriteria(Task.class);
		ArrayList<Task> taskList = (ArrayList<Task>) crit.list();
		tx.commit();
		sess.close();
		return taskList;
	}
	
//	@RequestMapping 
//	public ModelAndView saveQuest(QuestDTO questDto) {
//		QuestDao questDao = new HibernateQuestDao(); 
//		questDao.updateQuest(questDto);
//	
//		return ModelAndView("", "", "");
//	}

}
