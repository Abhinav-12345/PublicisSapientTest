package com.publicis.sapient.project.publicissapient.model;

import javax.ws.rs.QueryParam;

import com.publicis.sapient.project.publicissapient.constants.ServiceConstants;
import io.swagger.annotations.ApiParam;


public class StandingsQueryParams {

    @QueryParam(ServiceConstants.COUNTRY_NAME)
    @ApiParam(required = true)
    private String countryName;

    @QueryParam(ServiceConstants.LEAUGUE_NAME)
    @ApiParam(required = true)
    private String leagueName;

    @QueryParam(ServiceConstants.TEAM_NAME)
    @ApiParam(required = true)
    private String teamName;


    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }


    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }


    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}
