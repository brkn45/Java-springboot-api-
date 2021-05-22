package com.mtm.api;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    /*@GetMapping("/berkan")
    public String getvalue() throws FileNotFoundException, IOException, ParseException {
        Data data = new Data();
        data.readJsonFile("berkan");

        return data.getAllCountry().get(500).getCountry();
    }*/

    @RequestMapping(value = "/{word}", method = RequestMethod.GET, produces = {"application/json"})
    public ResponseEntity<ArrayList<Country>> requestWord(@PathVariable("word") String word) {
        int flag = 0;
        int i = 0, countrySize = data.getAllCountry().size();
        int count=0;
        data.getResponseCountry().clear();
        for (i = 0; i < countrySize && count < 5; i++) {
            if (findWord(word,data.getAllCountry().get(i).getName()) ) {
                data.getResponseCountry().add(data.getAllCountry().get(i));
                flag = 1;
                count++;
            }
            

        }
        if (flag == 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(data.getResponseCountry(), HttpStatus.OK);
        }
    }
    private boolean findWord(String word,String city) {
    	for(int i=0;i<word.length() && i< city.length();) {
    		if(Character.toLowerCase(word.charAt(i))==Character.toLowerCase(city.charAt(i))) {
    			i++;
    		}
    		else {
    			return false;
    		}
    	}
    	return true;
    }

}
