package com.leniorko.usingbooksapi.Models;

import lombok.Data;

@Data
public class SearchResult {
  Integer totalItems;
  Integer nextIndex;
  SearchItem[] items;
}
