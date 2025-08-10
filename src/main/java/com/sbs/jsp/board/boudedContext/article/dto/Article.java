package com.sbs.jsp.board.boudedContext.article.dto;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Article {
  private static long lastId = 0;
  private final long id;
  private String title;
  private String content;

  public Article(String title, String content) {
    this(++lastId, title, content);
  }
}
