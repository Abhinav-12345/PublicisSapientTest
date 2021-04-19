package com.publicis.sapient.project.publicissapient.exception;

public final class ErrorConstants {



    public static final String INVALID_COUNTRY_NAME = "1: Invalid Country NAME";
    public static final String INVALID_LEAUGUE_NAME = "2: Invalid LEAUGUE NAME";
    public static final String INVALID_TEAM_NAME = "3: Invalid TEAM NAME";

    public static String getCode(String error) {
        return error.split(":")[0];
    }

}
