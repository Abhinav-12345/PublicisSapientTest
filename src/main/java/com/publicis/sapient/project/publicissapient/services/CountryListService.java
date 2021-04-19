package com.publicis.sapient.project.publicissapient.services;


import com.publicis.sapient.project.publicissapient.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CountryListService {

    @Value("${countries.host}")
    private String countriesHost;

    @Autowired
    private RestTemplate restTemplate;


    public int getCountryIdFromName(String countryName, String apiKey){

        String countriesHostName = countriesHost+"APIkey="+apiKey;

        int countryId = -1;

        Country[] countries = restTemplate.getForObject(
                countriesHostName ,Country[].class);

        for(Country country:countries){
            if(country.getCountry_name().equalsIgnoreCase(countryName)){
                countryId = Integer.parseInt(country.getCountry_id());
                break;
            }
        }
        return countryId;
    }


}
