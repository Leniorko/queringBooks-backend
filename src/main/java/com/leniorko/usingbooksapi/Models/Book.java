package com.leniorko.usingbooksapi.Models;

import lombok.Data;

@Data
public class Book {
  String id;
  BookInfo volumeInfo;
}

@Data
class BookInfo {
  String title;
  String[] authors;
  String description;
  Integer pageCount;
  String[] categories;
  BookImgs imageLinks;
  String previewLink;
}

@Data
class BookImgs {
  String smallThumbnail;
  String thumbnail;
  String small;
  String medium;
  String large;
  String extraLarge;
}
