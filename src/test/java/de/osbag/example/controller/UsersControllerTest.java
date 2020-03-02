/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.osbag.example.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import de.osbag.example.entity.User;
import de.osbag.example.util.Util;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static junit.framework.Assert.assertEquals;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;
import org.springframework.http.HttpStatus;

/**
 *
 * @author Eldin - system test. Run this test after application deployment
 */

public class UsersControllerTest {

    private static final String ENDPOINT = "/api/v1/users";
    public static final String URL = "http://localhost:8080";
   
    @Test
    public void testPostRequest() throws Exception {
        StringEntity postPayloadEntity = new StringEntity(Util.json(Util.createValidUser()),ContentType.APPLICATION_JSON);        
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost request = new HttpPost(URL + ENDPOINT);        
        request.setEntity(postPayloadEntity);
        HttpResponse response = httpClient.execute(request); 
        int responseCode = response.getStatusLine().getStatusCode();
        assertEquals("Response code must be equal to :", HttpStatus.CREATED.value(), responseCode);
    }
    @Test
    public void testGetRequest() throws Exception {
        URL obj = new URL(URL + ENDPOINT);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();        
        int responseCode = con.getResponseCode();                                        
        assertEquals("Response code must be equal to :", responseCode, HttpStatus.OK.value());
    }
    
    
       
    

}
