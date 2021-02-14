package com.anjo.conversions;



import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConversionController {

	@RequestMapping("/Status")
	public String sayHi() {
		

		
		return "Up and fakkin runnin!";
	}
	
	@RequestMapping("/retur/{c}")
	public String retur(@PathVariable("c") String c) {
		

		
		return c;
	}
	@RequestMapping("/ctof/{k}")
	public String ctof(@PathVariable("k") Double k) {
		Double fahrenheit;
		Double celsius = k;
		fahrenheit = ((celsius * 9) / 5) + 32;
		
		return "Temperature in Farenheit: "+fahrenheit;
	}
	@RequestMapping("/ftoc/{k}")
	public String ftoc(@PathVariable("k") Double k) {
		Double celsius;
		celsius =  (k - 32)*5/9; 
		
		return "Temperature in Celsius: "+celsius;
	}
	
	
}
