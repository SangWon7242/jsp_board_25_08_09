package com.sbs.jsp.board.boudedContext.article.service;

import com.sbs.jsp.board.boudedContext.article.dto.Article;
import com.sbs.jsp.board.boudedContext.article.repository.ArticleRepository;
import com.sbs.jsp.board.global.container.Container;

import java.util.List;

public class ArticleService {
  private final ArticleRepository articleRepository;

  public ArticleService() {
    articleRepository = Container.articleRepository;
  }

  public List<Article> findByOrderByIdDesc() {
    // 게시물 리스트를 id를 기준으로 역순 정렬하여 반환
    return articleRepository.findByOrderByIdDesc();
  }

  public long write(String title, String content) {
    return articleRepository.save(title, content);
  }

  public Article findById(long id) {
    return articleRepository.findById(id);
  }

  public void modify(long id, String title, String content) {
    articleRepository.modify(id, title, content);
  }
}
