package com.publicis.sapient.project.publicissapient.exception;

public class StandingsException extends RuntimeException{

    private String errorCode;


    public StandingsException(String errorCode, String errorMessage){
        super(errorMessage);
        this.errorCode = errorCode;
    }

}
