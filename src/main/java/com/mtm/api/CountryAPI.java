package com.mtm.api;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import org.json.simple.parser.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class CountryAPI {
	Data data;
	
	public CountryAPI() throws FileNotFoundException, IOException, ParseException {
		this.data = new Data();
		data.readJsonFile("berkan");
	}
	
	@GetMapping("/berkan")
	public String  getvalue() throws FileNotFoundException, IOException, ParseException{
		Data data = new Data();
		data.readJsonFile("berkan");
		
		
		return data.getAllCountry().get(500).getCountry();
	}
	@RequestMapping(value = "/{word}",method = RequestMethod.GET, produces = { "application/json" })
	public ResponseEntity<ArrayList<Country>> requestWord(@PathVariable("word") String word) {
		int flag=0;
		int i=0,countrySize=data.getAllCountry().size();
		for(i=0;i<countrySize;i++) {
			if(Pattern.compile(Pattern.quote(word), Pattern.CASE_INSENSITIVE).matcher(data.getAllCountry().get(i).getName()).find()) {
				data.getResponseCountry().add(data.getAllCountry().get(i));
				flag=1;
			}
			
			
		}
		if(flag==0) {
			return new ResponseEntity<ArrayList<Country>>(HttpStatus.BAD_REQUEST);
		}
		else {
			return new ResponseEntity<ArrayList<Country>>(data.getResponseCountry(), HttpStatus.OK);
		}
	}
	
	
	


}