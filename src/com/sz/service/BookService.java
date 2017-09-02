package com.sz.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.hibernate.Session;

import com.sz.model.Book;
import com.sz.util.HibernateSessionFactory;

public class BookService {

	public ArrayList getAllBooks() {
		ArrayList<Book> books = new ArrayList();
		
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		
		books = (ArrayList<Book>) session.createQuery("from Book").list();
		
		session.getTransaction().commit();
		session.close();
		return books;
	}

	public boolean addBook(Book book) {
		boolean b =true;
		Session session = HibernateSessionFactory.getSession();
		
		try {
			
			session.beginTransaction();
			
			session.save(book);
			
			session.getTransaction().commit();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			b=false;
		}finally{
			session.close();
		}
		
		return b;
	}


	public boolean deleteBookById(String id) {
		boolean b=true;
		Session session = HibernateSessionFactory.getSession();
		
		try {
			session.beginTransaction();
			
			Book book = (Book)session.load(Book.class,Integer.parseInt(id));
			session.delete(book);
			
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			b=false;
		}finally{
			session.close();
		}
		
		
		return b;
	}

	public Book getBookById(String id) {
		Book book = new Book();
		Session session = HibernateSessionFactory.getSession();
		
		try {
			session.beginTransaction();
			book = (Book)session.get(Book.class,Integer.parseInt(id));
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally{
			session.close();
		}
		
		return book;
	}


	public boolean updateBook(Book book) {
		boolean b =true;
		Session session = HibernateSessionFactory.getSession();
		
		try {
			
			session.beginTransaction();
			
			session.update(book);
			
			session.getTransaction().commit();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			b=false;
		}finally{
			session.close();
		}
		
		return b;
	}

}
