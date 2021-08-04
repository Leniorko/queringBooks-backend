package com.leniorko.usingbooksapi.Models;

import lombok.Data;

@Data
public class SearchResult {
  Integer totalItems;
  Integer nextIndex;
  SearchItem[] items;
}

// There is much more data per item but i need only an id
@Data
class SearchItem {
  String id;
}
