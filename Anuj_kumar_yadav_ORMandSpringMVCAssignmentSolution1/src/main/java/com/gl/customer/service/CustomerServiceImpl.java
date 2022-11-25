package com.gl.customer.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gl.customer.model.Customer;

@Repository
public class CustomerServiceImpl implements CustomerService {
	
	private SessionFactory sessionFactory;
	
	private Session session;
	
	public CustomerServiceImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		try {
			this.session = this.sessionFactory.getCurrentSession();
			}
		catch(HibernateException hiberException){
			this.session = this.sessionFactory.openSession();
		}
		
	}

	@Override
	@Transactional
	public List<Customer> getAll() {
		// TODO Auto-generated method stub
		Transaction tx = session.beginTransaction();
		
		List<Customer> stds = session.createQuery("from Customer").list();
		
		tx.commit();
				
		return stds;
	}

	@Override
	@Transactional
	public Customer getById(int id) {
		// TODO Auto-generated method stub
		Transaction tx = session.beginTransaction();
		Customer std = session.get(Customer.class, id);
		tx.commit();
		return std;
	}

	@Override
	@Transactional
	public List<Customer> getByName(String fName, String lName, String email) {
		// TODO Auto-generated method stub
		Transaction tx = session.beginTransaction();
		String qry;
		if(!fName.isEmpty() && !lName.isEmpty() && !email.isEmpty()) { 
			//all ok
			qry = "from Customer where firstName like '%"+fName 
					+ "%' or lastName like '%" + lName 
					+ "%' or email like '%" + email + "%'";
		}
		else if(!fName.isEmpty() && !lName.isEmpty() && email.isEmpty()) { 
			//email is empty
			qry = "from Customer where firstName like '%"+fName 
					+ "%' or lastName like '%" + lName 
					//+ "%' or email like '%" + email + 
					+ "%'";
		}
		else if(!fName.isEmpty() && lName.isEmpty() && !email.isEmpty()) { 
			// lName is empty
			qry = "from Customer where firstName like '%"+fName 
					//+ "%' or lastName like '%" + lName 
					+ "%' or email like '%" + email 
					+ "%'";
		}
		else if(fName.isEmpty() && !lName.isEmpty() && !email.isEmpty()) { 
			//firstName is empty
			qry = "from Customer where lastName like '%" + lName 
					+ "%' or email like '%" + email 
					+ "%'";
		}
		
		else if(!fName.isEmpty() && lName.isEmpty() && email.isEmpty()) { 
			// lName and email is empty
			qry = "from Customer where firstName like '%"+fName 
					// + "%' or lastName like '%" + lName 
					//+ "%' or email like '%" + email + 
					+ "%'";
		}
		else if(fName.isEmpty() && lName.isEmpty() && !email.isEmpty()) {
			// lName and firstName is empty
			qry = "from Customer where email like '%" + email 
					+ "%'";
		}
		else if(fName.isEmpty() && !lName.isEmpty() && email.isEmpty()) { 
			// firstName and email is empty
			qry = "from Customer where lastName like '%" + lName 
					//+ "%' or email like '%" + email + 
					+ "%'";
		}
		else {
			qry = "from Customer where firstName like '%"+fName 
					+ "%' or lastName like '%" + lName 
					+ "%' or email like '%" + email 
					+ "%'";
		}
		
		
		List<Customer> Customers = session.createQuery(qry).list();
		System.out.println("Search results--");
		for(Customer Customer:Customers) {
			System.out.println(Customer.toString());
		}
		
		tx.commit();
		return Customers;
	}

	@Override
	@Transactional
	public void saveOrUpdateCustomer(Customer cust) {
		// TODO Auto-generated method stub
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(cust);
		tx.commit();
	}

	@Override
	@Transactional
	public void removeCustomer(Customer cust) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public void removeCustomer(int id) {
		// TODO Auto-generated method stub
		Transaction tx = session.getTransaction();
		Customer delStd =session.get(Customer.class,id);
		session.delete(delStd);
		if(tx.isActive()) {
			tx.commit();
		}
		
	}

	
}
