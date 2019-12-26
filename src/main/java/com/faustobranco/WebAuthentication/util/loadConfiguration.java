package com.faustobranco.WebAuthentication.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.faustobranco.WebAuthentication.model.appConfiguration;

import java.io.File;
import java.io.IOException;

public class loadConfiguration {

    public static appConfiguration LoadConfiguration () throws IOException {
        ObjectMapper mapper2 = new ObjectMapper (new YAMLFactory ());
        appConfiguration cls_appConfiguration = mapper2.readValue(new File ("src/main/resources/config.yaml"), appConfiguration.class);
        return cls_appConfiguration;
    }

}
