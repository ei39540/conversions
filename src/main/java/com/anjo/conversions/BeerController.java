package com.anjo.conversions;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anjo.conversions.persisntance.BeerDAO;


@RestController
public class BeerController {
	
	@RequestMapping("/Beer")
	public String Beer() {
		

		
		return "Beer?";
	}
	@RequestMapping("/addBeer/{s}")
	public String addBeer(@PathVariable("s") String s) {
		
		BeerDAO bdao=new BeerDAO();
		
		bdao.addBeer(s);
		
		return s+ " added.";
	}
	@RequestMapping("/deleteBeer/{s}")
	public String delBeer(@PathVariable("s") String s) {
		
		BeerDAO bdao=new BeerDAO();
		
		bdao.deleteBeer(s);
		
		return s+ " deleted.";
	}
	@RequestMapping("/listBeers")
	public ResponseEntity<List<String>> listBeers() {
		
		BeerDAO bdao=new BeerDAO();
		
		
		
		return new ResponseEntity<List<String>>(bdao.getBeers(), HttpStatus.OK);
		
		//return "Beer?";
	}
	
}
