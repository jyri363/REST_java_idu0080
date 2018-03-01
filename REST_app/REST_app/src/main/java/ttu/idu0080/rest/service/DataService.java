package ttu.idu0080.rest.service;

import ttu.idu0080.rest.data.*;

import java.util.*;
import java.text.*;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.transaction.annotation.Propagation;

import javax.persistence.EntityTransaction;
@Repository
public class DataService  {




	@PersistenceContext
	private EntityManager em;

	public void setEntityManager(EntityManager em) {
		this.em = em;
	}


	public Painting getPaintingById(long id)  {


		Painting node = null;
		try {


			Query q =  em
					.createQuery(
							"select c from Painting c where c.id = :id")
							.setParameter("id", id);
			node = (Painting) q.getSingleResult();


		}

		catch(Exception ex)
		{
			System.out.println("DataService.getPaintingById():"+ ex.getMessage());
		
		}

		return node;
	}


	
	
	
	public List<Painting> getAllPaintings()  {


		List<Painting> painting_list = null;
		try {


			Query q =  em
					.createQuery(
							"select c from Painting c ");
			painting_list = (List<Painting>)  q.getResultList();


		}

		catch(Exception ex)
		{
			System.out.println("DataService.getAllPaintings():"+ ex.getMessage());
		}

		return painting_list;
	}

	
	
	public Painting update(Painting painting)  {


		System.out.println("painting update , painting author: " + painting.getAuthor());
		try {

			em.merge(painting);
			em.flush();

		}

		catch(Exception ex)
		{
			System.out.println("DataService.update():"+ ex.getMessage());
		}

		return painting;
	}

	
	public Painting save(Painting painting) {

		System.out.println("new painting insert , painting author: " + painting.getAuthor());

		try {
			
			em.persist(painting);


		}

		catch(Exception ex)
		{
			System.out.println("DataService.save():"+ ex.getMessage());
		}

		return painting;
	}
	
	public void delete(long id) {

		System.out.println("DELETE ");

		try {
			
	          Painting painting =  em.find(Painting.class,id);
	          em.remove(painting);


		}

		catch(Exception ex)
		{
			System.out.println("DataService.delete():"+ ex.getMessage());
		}


	}
	
	public  List<Painting> searchByAuthor(String s_author)  {

		List<Painting> paintings = null;

		try {

			String sql = "from Painting c where upper(c.author) like upper(:author) order by c.artname";
            
			Query q = em.createQuery(sql);	
			q.setParameter("author", s_author+"%") ;                  
			paintings =  (List<Painting>) q.getResultList();	 				
                        System.out.println("Otsingu tulemusi:" + paintings.size());

		}

		catch(Exception ex)
		{
			System.out.println("DataService.searchByAuthor():" + ex.getMessage());

		}

		return paintings;
	}
	
	
}
