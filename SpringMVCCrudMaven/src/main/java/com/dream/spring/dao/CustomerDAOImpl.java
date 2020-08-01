package com.dream.spring.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dream.spring.entity.Customer;

@SuppressWarnings("deprecation")
@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// need to inject session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Customer> getCustomers() {
		// get the current hibernate session
		Session session=sessionFactory.getCurrentSession();
		
		// create the query
		Query<Customer> query=session.createQuery("from Customer",Customer.class);
		
		// execute query and get result list
		List<Customer> customer=query.getResultList();
		return customer;
	}

	@Override
	public void saveCustomer(Customer customer) {
		// get the current hibernate session
				Session session=sessionFactory.getCurrentSession();
				// for save/update cutomer
				session.saveOrUpdate(customer);
		
	}

	@Override
	public Customer getCustomer(int customeId) {
		// get the current hibernate session
		Session session=sessionFactory.getCurrentSession();
		Customer customer=session.get(Customer.class, customeId);
		return customer;
	}

	@Override
	public void deleteCustomer(int customeId) {
		// get the current hibernate session
		Session session=sessionFactory.getCurrentSession();
		//Customer customer=new Customer();
		//customer.setId(customeId);
		
		Query query=session.createQuery("delete from Customer where id=:customeId");
		query.setParameter("customeId", customeId);
		query.executeUpdate();
		//session.delete(new Integer(customeId));
	}

	
	@Override
    public List<Customer> searchCustomers(String email) {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();     
        Query theQuery = null;  
        if (email != null && email.trim().length() > 0) {
            // search for email case insensitive
        	theQuery =currentSession.createQuery("from Customer where email=:email");
            theQuery.setParameter("email", email);
        }
        else {
            // email is empty ... so just get all customers
            //theQuery =currentSession.createQuery("from Customer", Customer.class);   
            theQuery =currentSession.createQuery("from Customer");   
        }
        // execute query and get result list
        List<Customer> customers = theQuery.getResultList();        
        // return the results        
        return customers;
        
    }

	@Override
	public boolean checkLogin(String email, String password) {
		System.out.println(email+" "+password);
		Session session = sessionFactory.getCurrentSession();
        boolean customerFound = false;
        //Query using Hibernate Query Language
        String hql = "from Customer c where c.email='"+email+"' and c.password='"+password+"'";
        Query query = session.createQuery(hql);
        //query.setParameter(0, email);
        //query.setParameter(1, password);
        List list = query.list();
        if ((list != null) && (list.size() > 0)) {
        	customerFound = true;
        }
        return customerFound;
	}

}
