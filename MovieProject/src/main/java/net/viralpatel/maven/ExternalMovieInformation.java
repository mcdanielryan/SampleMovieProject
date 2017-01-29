package net.viralpatel.maven;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.net.URL;
import java.net.URLConnection;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


/*
 * Return Movie class will all the external information about the movie.
 * */
public class ExternalMovieInformation{
	
  public static Movie testGet(){
	  
	  Movie movie = new Movie();
	  
	  return movie;
  }
	
  public static Movie getMovieInformation(String movieName){
	
	Movie newMovie = new Movie(); 
    
	String output  = getUrlContents(movieName);
	
	newMovie.setTitle(getStringElement(output,"Title"));
	newMovie.setYear(getStringElement(output,"Year"));
	newMovie.setRated(getStringElement(output,"Rated")); 
	newMovie.setRelease(getStringElement(output,"Released"));
	newMovie.setRuntime(getStringElement(output,"Runtime"));
	newMovie.setGenre(getStringElement(output,"Genre"));
	newMovie.setDirector(getStringElement(output,"Director"));
	newMovie.setWriter(getStringElement(output,"Writer"));
	newMovie.setActor(getStringElement(output,"Actors"));
	newMovie.setPlot(getStringElement(output,"Plot"));
	newMovie.setLanguage(getStringElement(output,"Language"));
	newMovie.setCountry(getStringElement(output,"Country"));
	newMovie.setAwards(getStringElement(output,"Awards"));
	newMovie.setPoster(getStringElement(output,"Poster"));
	newMovie.setMetascore(getStringElement(output,"Title"));
	newMovie.setImdbRating(getStringElement(output,"imdbRating"));
	
	return newMovie;
  }
 
  /*
   * Opens external connection and get json back
   * */
  private static String getUrlContents(String movieName){
	  
    StringBuilder content = new StringBuilder();
    String localString = movieName;
    String urlString = "http://www.omdbapi.com/?t=" + localString.replaceAll(" ", "+") + "&y=&plot=short&r=json";
    
    try {
    	
      URL url = new URL(urlString);
      URLConnection urlConnection = url.openConnection();
 
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
 
      String line;
 
      while ((line = bufferedReader.readLine()) != null){
    	  
    	  content.append(line + "\n");
      }
      bufferedReader.close();
    }catch(Exception e){
    	
    	e.printStackTrace();
    }
    
    return content.toString();
  }
  
  /*
   * Convert json to strings
   * */
  private static String getStringElement(String output, String label){
	
	  try{
		  if(!output.isEmpty()){
			  
			  JSONObject json = (JSONObject)new JSONParser().parse(output);
			  String text = (String) json.get(label);
			  
			  return text;
		  }
		  
	  }catch(ParseException e){
		  
		  System.out.println("ExternalMovieInformation::getStringElement:: ParseException " + e);
	  }
	  
	  return null;
  }
}