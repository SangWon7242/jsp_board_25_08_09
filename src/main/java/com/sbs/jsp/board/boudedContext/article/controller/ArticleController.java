package com.sbs.jsp.board.boudedContext.article.controller;

import com.sbs.jsp.board.boudedContext.article.dto.Article;
import com.sbs.jsp.board.global.base.rq.Rq;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class ArticleController {
  public List<Article> articles;

  public ArticleController() {
    articles = new ArrayList<>();

    makeTestData();
  }

  private void makeTestData() {
    IntStream.rangeClosed(1, 5).forEach(i -> {
      articles.add(new Article("제목 " + i, "내용 " + i));
    });
  }


  public void showList(Rq rq) {
    // 원본을 기반으로 한 복사본 생성
    List<Article> articles = new ArrayList<>(this.articles);
    Collections.reverse(articles);

    rq.setAttr("articles", articles);
    rq.setAttr("articleCount", articles.size());

    rq.view("usr/article/list");
  }

  public void showWrite(Rq rq) {
    rq.view("usr/article/write");
  }
}
