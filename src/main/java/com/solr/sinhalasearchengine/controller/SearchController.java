package com.solr.sinhalasearchengine.controller;

import com.solr.sinhalasearchengine.SolrSinhalaSearchEngineApplication;
import com.solr.sinhalasearchengine.entity.Actor;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.apache.log4j.Logger;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class SearchController
{
    private Logger logger = Logger.getLogger(SearchController.class);
    private HttpSolrClient solrClient;

    @PostConstruct
    public void initialize() {
        String baseUrl = "http://" + SolrSinhalaSearchEngineApplication.configuration.getIp()
                                 + ":" + SolrSinhalaSearchEngineApplication.configuration.getPort()
                                 + "/solr/" + SolrSinhalaSearchEngineApplication.configuration.getCore();
        solrClient = new HttpSolrClient.Builder(baseUrl).build();
        System.out.println(baseUrl);
        solrClient.setParser(new XMLResponseParser());
    }

    @GetMapping("/query")
    public ArrayList query( @RequestParam(name = "term") String term)
    {
        QueryResponse response = null;
        SolrQuery query = new SolrQuery();
        ArrayList<Actor> list = new ArrayList<Actor>();
        query.set( "q", term );
        query.set( "fl", "name,date_of_birth,father,mother,spouse,early_life,career,movies,awards,score" );
        try
        {
            response = solrClient.query( query );
            SolrDocumentList documentList = response.getResults();
            for( SolrDocument document : documentList )
            {
                Actor actor = new Actor();
                actor.setName( ( String ) document.getFieldValue( "name" ) );
                actor.setDateOfBirth( ( String ) document.getFieldValue( "date_of_birth" ) );
                actor.setFather( ( String ) document.getFieldValue( "father" ) );
                actor.setMother( ( String ) document.getFieldValue( "mother" ) );
                actor.setSpouse( ( String ) document.getFieldValue( "spouse" ) );
                actor.setEarlyLife( ( String ) document.getFieldValue( "early_life" ) );
                actor.setCareer( ( String ) document.getFieldValue( "career" ) );
                actor.setMovies( ( String ) document.getFieldValue( "movies" ) );
                actor.setAwards( ( String ) document.getFieldValue( "awards" ) );
                actor.setScore( ( float ) document.getFieldValue( "score" ) );
                Object[] common = { document.getFieldValue( "common" ) };
                actor.setCommon( common );
                list.add( actor );
            }
        }
        catch( SolrServerException | IOException e )
        {
            logger.error( e.getMessage() );
        }

        return list;
    }

}
