package com.TicketService.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.TicketService.model.Staff;

@Transactional
@Repository

public class StaffDAO extends BaseDAO<Staff> implements IStaffDAO {
	@Autowired
	SessionFactory sf;

	@Override
	public void addStaff(Staff staff) {
		// TODO Auto-generated method stub

		sf.getCurrentSession().persist(staff);

	}

	@Override
	public boolean removeStaff(int id) {
		// TODO Auto-generated method stub
		Staff c = (Staff) sf.getCurrentSession().get(Staff.class, id);
		sf.getCurrentSession().delete(c);
		return false;
	}

	@Override
	public void updateStaff(Staff Staff) {
		// TODO Auto-generated method stub
		Staff c = (Staff) sf.getCurrentSession().get(Staff.class, Staff.getId());
		sf.getCurrentSession().update(c);

	}

	@Override
	public List<Staff> findStaffByName(String key) {
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("from Staff c where c.name like :name ");
		query.setString("name", "%" + key + "%");
		List<Staff> listStaff = query.list();
		return listStaff;
	}

	@Override
	public List<Staff> findStaffByEmail(String key) {
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("from Staff c where c.email like :email ");
		query.setString("email", "%" + key + "%");
		List<Staff> listStaff = query.list();
		return listStaff;
	}
}
