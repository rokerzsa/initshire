package com.redyhire.application.model.appconfig;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApplicationConfiguration {
    private String name;
    private String description = "";
    private String version = "0";
}

