package com.solr.sinhalasearchengine.entity;

import org.apache.solr.client.solrj.beans.Field;

public class Actor
{
    @Field("name")
    private String name;
    @Field("date_of_birth")
    private String dateOfBirth;
    @Field("father")
    private String father;
    @Field("mother")
    private String mother;
    @Field("spouse")
    private String spouse;
    @Field("early_life")
    private String earlyLife;
    @Field("career")
    private String career;
    @Field("movies")
    private String movies;
    @Field("awards")
    private String awards;
    @Field("common")
    private Object common;
    @Field("score")
    private float score;

    public Actor() { }

    @Override
    public String toString()
    {
        return "Actor{" +
                       "name='" + name + '\'' +
                       ", date_of_birth='" + dateOfBirth + '\'' +
                       ", father='" + father + '\'' +
                       ", mother='" + mother + '\'' +
                       ", spouse='" + spouse + '\'' +
                       ", early_life='" + earlyLife + '\'' +
                       ", career='" + career + '\'' +
                       ", movies='" + movies + '\'' +
                       ", awards='" + awards + '\'' +
                       ", score=" + score +
                       '}';
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public String getFather()
    {
        return father;
    }

    public void setFather( String father )
    {
        this.father = father;
    }

    public String getMother()
    {
        return mother;
    }

    public void setMother( String mother )
    {
        this.mother = mother;
    }

    public String getSpouse()
    {
        return spouse;
    }

    public void setSpouse( String spouse )
    {
        this.spouse = spouse;
    }

    public String getDateOfBirth()
    {
        return dateOfBirth;
    }

    public void setDateOfBirth( String dateOfBirth )
    {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEarlyLife()
    {
        return earlyLife;
    }

    public void setEarlyLife( String earlyLife )
    {
        this.earlyLife = earlyLife;
    }

    public String getCareer()
    {
        return career;
    }

    public void setCareer( String career )
    {
        this.career = career;
    }

    public String getMovies()
    {
        return movies;
    }

    public void setMovies( String movies )
    {
        this.movies = movies;
    }

    public String getAwards()
    {
        return awards;
    }

    public void setAwards( String awards )
    {
        this.awards = awards;
    }

    public float getScore()
    {
        return score;
    }

    public void setScore( float score )
    {
        this.score = score;
    }

    public Object getCommon()
    {
        return common;
    }

    public void setCommon( Object common )
    {
        this.common = common;
    }
}
