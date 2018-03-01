package ttu.idu0080.rest.controller;

import java.io.IOException;

import java.util.*;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.ui.Model;

import ttu.idu0080.rest.service.*;
import ttu.idu0080.rest.data.*;


@Controller
public class RESTController {
	
	@Autowired
	private DataService dataService;
	@Autowired
	private RESTDataService restDataService;

	@RequestMapping(value="/service/paintings",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Painting> getPaintings(HttpServletResponse response) throws IOException{
		
		List<Painting> paintings = dataService.getAllPaintings();
		return paintings;
	}
	
	@RequestMapping(value="/service/painting/{id}",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Painting getPainting(@PathVariable int id) throws IOException{
		
		Painting painting = dataService.getPaintingById(id);
		return painting;
	}
	
	@Transactional
	@RequestMapping(value = "/service/painting/{id}", method=RequestMethod.POST)
	public @ResponseBody void updatePainting(@RequestBody Painting painting)
	{
		dataService.update(painting);
		
	}
	
	@Transactional
	@RequestMapping(value = "/service/painting/{id}", method=RequestMethod.DELETE)
	public @ResponseBody void deletePainting(@PathVariable int id)
	{
		dataService.delete(id);
	}
	
	@Transactional
	@RequestMapping(value = "/service/painting/", method=RequestMethod.PUT)
	public @ResponseBody void insertPainting(@RequestBody Painting painting)
	{
		dataService.save(painting);
	}
	
	
	@RequestMapping(value="/service/search",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Painting> searchPaintings(@RequestParam(value = "author") String author) throws IOException
	{
		List<Painting> paintings= dataService.searchByAuthor(author);
		return paintings;
	}
	
	@RequestMapping(value="/service/external/paintings",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Painting> getExternalPaintings(HttpServletResponse response) throws IOException{
		List<Painting> paintings = restDataService.getAllPaintings();
		return paintings;
	}
	

	
}
