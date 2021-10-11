package com.solr.sinhalasearchengine;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.solr.sinhalasearchengine.config.Configuration;
import com.solr.sinhalasearchengine.controller.SearchController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;
import org.apache.log4j.Logger;

@SpringBootApplication
public class SolrSinhalaSearchEngineApplication {

	private static ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
	private static Logger logger = Logger.getLogger( SearchController.class);
	public static Configuration configuration = null;

	static {
		try {
			configuration = mapper.readValue(new File("config.yaml"), Configuration.class);
		} catch ( IOException e) {
			logger.error(e.getMessage());
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(SolrSinhalaSearchEngineApplication.class, args);
	}

}
