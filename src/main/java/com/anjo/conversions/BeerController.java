package com.anjo.conversions;

import java.util.Base64;
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
	@RequestMapping("/addBeerEnc/{s}")
	public String addBeerEnc(@PathVariable("s") String s) {
		
		
		byte[] decodedBytes = Base64.getUrlDecoder().decode(s);
		String decodedString = new String(decodedBytes);
		
		BeerDAO bdao=new BeerDAO();
		bdao.addBeer(decodedString);
		
		return decodedString+ " added.";
	}
	@RequestMapping("/deleteBeer/{s}")
	public String delBeer(@PathVariable("s") String s) {
		
		
		BeerDAO bdao=new BeerDAO();
		bdao.deleteBeer(s);
		
		return s+ " deleted.";
	}
	@RequestMapping("/deleteBeerEnc/{s}")
	public String delBeerEnc(@PathVariable("s") String s) {
		
		byte[] decodedBytes = Base64.getUrlDecoder().decode(s);
		String decodedString = new String(decodedBytes);
		
		BeerDAO bdao=new BeerDAO();
		bdao.deleteBeer(decodedString);
		
		return decodedString+ " deleted.";
	}
	
	@RequestMapping("/listBeers")
	public ResponseEntity<List<String>> listBeers() {
		
		BeerDAO bdao=new BeerDAO();
		return new ResponseEntity<List<String>>(bdao.getBeers(), HttpStatus.OK);
		
		//return "Beer?";
	}
	@RequestMapping("/searchBeers/{s}")
	public ResponseEntity<List<String>> searchBeers(@PathVariable("s") String s) {
		
		BeerDAO bdao=new BeerDAO();
		return new ResponseEntity<List<String>>(bdao.getBeers(s), HttpStatus.OK);
			
	}
	
}
