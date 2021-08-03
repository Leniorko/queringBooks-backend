package com.leniorko.usingbooksapi.Services;

import java.net.URL;

import com.leniorko.usingbooksapi.Models.SearchResult;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SearchService {
  private final RestTemplate restTemplate;

  public SearchService(RestTemplateBuilder restTemplateBuilder) {
    this.restTemplate = restTemplateBuilder.build();
  }

  public SearchResult getPostPlainJSON(URL url) {
    return this.restTemplate.getForObject(url.toString(), SearchResult.class);
  }
}
