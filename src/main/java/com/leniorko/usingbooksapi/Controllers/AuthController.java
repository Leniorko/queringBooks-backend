package com.leniorko.usingbooksapi.Controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * AuthController
 */
@RestController
public class AuthController {
  // Getting API key from application.properties
  @Value("${google.api.key}")
  private String apiKey;

  // TODO: Change mapping
  // TODO: Create path to request every single book
  // TODO: Think about load-on purpose. Like, request first 10 books and wait for
  // request for another.
  // TODO: Change Responce type
  // TODO: Create models for book and books list.
  // TODO: Add parametrs and pass them into query
  @GetMapping("/auth")
  StringBuffer authTest() {
    StringBuffer content = new StringBuffer();
    try {
      URL googleBookSearchUrl = new URL("https://www.googleapis.com/books/v1/volumes?q=Decameron");
      HttpURLConnection connection = (HttpURLConnection) googleBookSearchUrl.openConnection();
      connection.setRequestMethod("GET");
      int result = connection.getResponseCode();
      if (result == 200) {
        InputStream is = connection.getInputStream();
        BufferedReader rd = new BufferedReader(new InputStreamReader(is));
        String inputLine;
        while ((inputLine = rd.readLine()) != null) {
          content.append(inputLine);
        }
        is.close();
      }
      connection.disconnect();
    } catch (MalformedURLException e) {
      // TODO: Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO: Auto-generated catch block
      e.printStackTrace();
    }
    return content;
  }
}