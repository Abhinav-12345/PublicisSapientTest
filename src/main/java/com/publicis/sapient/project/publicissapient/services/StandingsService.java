package com.publicis.sapient.project.publicissapient.services;


import com.publicis.sapient.project.publicissapient.model.Leaugues;
import com.publicis.sapient.project.publicissapient.model.Standing;
import com.publicis.sapient.project.publicissapient.model.StandingsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class StandingsService {


    @Value("${standings.host}")
    private String standingHost;

    @Autowired
    private RestTemplate restTemplate;


    public StandingsResponse getstandingsIdFromName(int leaugeId, String apiKey,
                                                    String teamName, StandingsResponse standingsResponse){

        String hostName = standingHost+leaugeId+"&APIkey="+apiKey;

        Standing[] standings = restTemplate.getForObject(
                hostName ,Standing[].class);

        for(Standing standing:standings){
            if(standing.getTeam_name().equalsIgnoreCase(teamName)){
                standingsResponse.setLeaguePosition(standing.getOverall_league_position());
                standingsResponse.setTeamId(standing.getTeam_id());
                break;
            }
        }

        return standingsResponse;
    }




}
