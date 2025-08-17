package com.sbs.jsp.board.boudedContext.article.repository;

import com.sbs.jsp.board.boudedContext.article.dto.Article;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class ArticleRepository {
  private List<Article> articles;

  public ArticleRepository() {
    articles = new ArrayList<>();

    makeTestData();
  }

  private void makeTestData() {
    IntStream.rangeClosed(1, 5).forEach(i ->
        save("제목 " + i, "내용 " + i)
    );
  }

  public List<Article> findByOrderByIdDesc() {
    // 원본을 기반으로 한 복사본 생성
    List<Article> articleList = new ArrayList<>(articles);
    Collections.reverse(articleList); // 복사본 역순 정렬

    return articleList;
  }

  public long save(String title, String content) {
    Article article = new Article(title, content);
    articles.add(article);

    return article.getId();
  }

  public Article findById(long id) {
    return articles.stream()
        .filter(article -> article.getId() == id)
        .findFirst()
        .orElse(null);
  }

  public void modify(long id, String title, String content) {
    Article article = findById(id);

    article.setTitle(title);
    article.setContent(content);
  }
}
