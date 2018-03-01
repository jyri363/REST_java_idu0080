package ttu.idu0080.rest.service;

import ttu.idu0080.rest.data.*;

import java.util.*;
import java.text.*;
import java.util.List;

import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Service;;
@Service
public class RESTDataService  {



	
	
	public List<Painting> getAllPaintings()  {
		
		Painting[] painting_array = null;
		try
		{
			RestTemplate restTemplate = new RestTemplate();
		painting_array = restTemplate.getForObject("http://localhost:8080/REST_service/service/paintings", Painting[].class) ;
		System.out.println("Autosid REST-teenusest:" + painting_array.length);
		}
		catch(Exception ex)
		{
			System.out.println("RESTDataService.getAllPaintings():"+ ex.getMessage());
		}

		List<Painting> painting_list= Arrays.asList(painting_array);
		return painting_list;
	}

	
	
	
}
