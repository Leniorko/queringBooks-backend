package com.leniorko.usingbooksapi.Controllers;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import com.leniorko.usingbooksapi.Models.Book;
import com.leniorko.usingbooksapi.Models.SearchResult;
import com.leniorko.usingbooksapi.Services.SearchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * SearchController
 */
// TODO: Maybe delete
@CrossOrigin(origins = "www.example.com")
@RestController
public class SearchController {

  @Autowired
  SearchService searchService;

  // TODO: Cleanup. Remove this variable and make it work.
  ResponseEntity<SearchResult> result;

  @GetMapping("/search")
  ResponseEntity<SearchResult> searchPath(@RequestParam(name = "q") String query,
      @RequestParam(name = "startIndex") Integer startIndex,
      @RequestParam(name = "itemsLimit", defaultValue = "10", required = false) Integer itemsLimit) {
    try {
      URL googleBookSearchUrl = UriComponentsBuilder.fromUriString("https://www.googleapis.com/books/v1/volumes")
          .queryParam("q", query).queryParam("startIndex", startIndex).queryParam("maxResults", itemsLimit).build()
          .toUri().toURL();
      SearchResult result = searchService.getSearchResult(googleBookSearchUrl);
      result.setNextIndex(startIndex + itemsLimit);

      URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();

      return ResponseEntity.created(uri).body(result);
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
    return result;
  }

  // TODO: Cleanup. Remove this variable and make it work.
  ResponseEntity<Book> bookResult;

  @GetMapping("/book")
  ResponseEntity<Book> bookPath(@RequestParam(name = "bookID") String bookID) {
    try {
      URL googleBookSearchUrl = UriComponentsBuilder.fromUriString("https://www.googleapis.com/books/v1/volumes")
          .pathSegment(bookID).build().toUri().toURL();

      Book result = searchService.getBook(googleBookSearchUrl);
      URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();

      return ResponseEntity.created(uri).body(result);
    } catch (MalformedURLException | IllegalArgumentException e) {
      e.printStackTrace();
    }

    return bookResult;
  }
}