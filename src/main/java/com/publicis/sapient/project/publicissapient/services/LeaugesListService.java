package com.publicis.sapient.project.publicissapient.services;


import com.publicis.sapient.project.publicissapient.model.Country;
import com.publicis.sapient.project.publicissapient.model.Leaugues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class LeaugesListService {

    @Value("${leauge.host}")
    private String leaugeHost;

    @Autowired
    private RestTemplate restTemplate;


    public int getLeaugeIdFromName(String leaugeName, String apiKey, int countryId){

        String leaugeHostName = leaugeHost+countryId+"&APIkey="+apiKey;
        int leagueId = -1;

        Leaugues[] leaugues = restTemplate.getForObject(leaugeHostName, Leaugues[].class);

        for(Leaugues leaugue:leaugues){
            if(leaugue.getLeague_name().equalsIgnoreCase(leaugeName)){
                leagueId = Integer.parseInt(leaugue.getLeague_id());
                break;
            }
        }
        return leagueId;
    }

}
