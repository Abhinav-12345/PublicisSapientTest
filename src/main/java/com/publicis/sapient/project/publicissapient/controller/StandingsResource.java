package com.publicis.sapient.project.publicissapient.controller;


import com.publicis.sapient.project.publicissapient.exception.ErrorConstants;
import com.publicis.sapient.project.publicissapient.exception.StandingsException;
import com.publicis.sapient.project.publicissapient.model.*;
import com.publicis.sapient.project.publicissapient.services.CountryListService;
import com.publicis.sapient.project.publicissapient.services.LeaugesListService;
import com.publicis.sapient.project.publicissapient.services.StandingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RestController
@RequestMapping("/team")
public class StandingsResource extends Exception{

    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.key}")
    private String apiKey;

    @Autowired
    private CountryListService countryListService;

    @Autowired
    private LeaugesListService leaugesListService;

    @Autowired
    private StandingsService standingsService;

    @GetMapping("/ping")
    public String pong(){
        return  "pong";
    }


    @GET
    @GetMapping("/standing")
    @Produces(MediaType.APPLICATION_JSON)
    @ExceptionHandler(StandingsException.class)
    public Object getStandingInfo(@Valid @BeanParam StandingsQueryParams standingsQueryParams) throws StandingsException{

        String countryName = standingsQueryParams.getCountryName();
        String teamName = standingsQueryParams.getTeamName();
        String leaugueName = standingsQueryParams.getLeagueName();
        StandingsResponse standingsResponse = new StandingsResponse();

        int countryId = -1;
        int leagueId = -1;


        countryId = countryListService.getCountryIdFromName(countryName, apiKey);

        if(countryId==-1){
            return Response.status(1).entity("Invalid Country Name = "+countryName).build().getEntity();
        }

        leagueId = leaugesListService.getLeaugeIdFromName(leaugueName, apiKey, countryId);


        if(leagueId == -1){
            return Response.status(1).entity("Invalid League Name = "+leaugueName).build().getEntity();
        }

        standingsResponse.setCountryId(String.valueOf(countryId));
        standingsResponse.setCountryName(countryName);
        standingsResponse.setTeamName(teamName);
        standingsResponse.setLeagueId(String.valueOf(leagueId));
        standingsResponse.setLeagueName(leaugueName);


        standingsResponse = standingsService.getstandingsIdFromName(leagueId, apiKey, teamName, standingsResponse);

        if(standingsResponse.getLeaguePosition()==null || standingsResponse.getTeamId()==null) {
            return Response.status(1).entity("Invalid Team Name = "+teamName).build().getEntity();
        }

        return Response.status(Response.Status.ACCEPTED).entity(standingsResponse).build().getEntity();
    }


    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }






}
