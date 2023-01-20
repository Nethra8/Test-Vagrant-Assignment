package com.testvagrant.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.util.List;

import org.json.JSONException;

import io.restassured.path.json.JsonPath;

public class TestVagrant {
	
	String jsonDataString = "{\"name\":\"RoyalChallengersBangalore\","
			+ "\"location\":\"Bangalore\","
			+ "\"player\":[{\"name\":\"FafDuPlessis\","
			+ "\"country\":\"SouthAfrica\","
			+ "\"role\":\"Batsman\","
			+ "\"price-in-crores\":\"7\"},"
			+ "{\"name\":\"ViratKohli\",\"country\":\"India\",\"role\":\"Batsman\",\"price-in-crores\":\"15\"},"
			+ "{\"name\":\"GlennMaxwell\",\"country\":\"Australia\",\"role\":\"Batsman\",\"price-in-crores\":\"11\"},"
			+ "{\"name\":\"MohammadSiraj\",\"country\":\"India\",\"role\":\"Bowler\",\"price-in-crores\":\"7\"},"
			+ "{\"name\":\"HarshalPatel\",\"country\":\"India\",\"role\":\"Bowler\",\"price-in-crores\":\"10.75\"},"
			+ "{\"name\":\"WaninduHasaranga\",\"country\":\"Srilanka\",\"role\":\"Bowler\",\"price-in-crores\":\"10.75\"},"
			+ "{\"name\":\"DineshKarthik\",\"country\":\"India\",\"role\":\"Wicket-keeper\",\"price-in-crores\":\"5.5\"},"
			+ "{\"name\":\"ShahbazAhmed\",\"country\":\"India\",\"role\":\"All-Rounder\",\"price-in-crores\":\"2.4\"},"
			+ "{\"name\":\"RajatPatidar\",\"country\":\"India\",\"role\":\"Batsman\",\"price-in-crores\":\"0.20\"},"
			+ "{\"name\":\"JoshHazlewood\",\"country\":\"Australia\",\"role\":\"Bowler\",\"price-in-crores\":\"7.75\"},"
			+ "{\"name\":\"MahipalLomror\",\"country\":\"India\",\"role\":\"Bowler\",\"price-in-crores\":\"7.75\"}]}";

	@Test
	public void validateFourForeignPlayers() throws JSONException {
	        JsonPath pathResponse = new JsonPath(jsonDataString);
	        List<String> countriesList = pathResponse.getList("player.country");
	        int foreignPlayerCount =0;
	        for(String playerCountry : countriesList)
	        {
	        	if(!(playerCountry.equals("India")))
	        		{
	        			foreignPlayerCount++;
	        		}
	        }

	        AssertJUnit.assertEquals(foreignPlayerCount,4);
	    }

}
