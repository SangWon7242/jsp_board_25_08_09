package com.sbs.jsp.board.boudedContext.article.controller;

import com.sbs.jsp.board.boudedContext.article.dto.Article;
import com.sbs.jsp.board.boudedContext.article.service.ArticleService;
import com.sbs.jsp.board.global.base.rq.Rq;
import com.sbs.jsp.board.global.container.Container;

import java.util.List;

public class ArticleController {
  private final ArticleService articleService;

  public ArticleController() {
    articleService = Container.articleService;
  }

  public void showList(Rq rq) {
    // 원본을 기반으로 한 복사본 생성
    List<Article> articles = articleService.findByOrderByIdDesc();

    rq.setAttr("articles", articles);
    rq.setAttr("articleCount", articles.size());

    rq.view("usr/article/list");
  }

  public void showWrite(Rq rq) {
    rq.view("usr/article/write");
  }

  public void doWrite(Rq rq) {
    String title = rq.getParam("title", "");
    String content = rq.getParam("content", "");

    long id = articleService.write(title, content);

    rq.print("%d번 게시물 작성 성공".formatted(id));
  }

  public void showDetail(Rq rq) {
    long id = rq.getLongPathValueByIndex(1, 0);
    // usr/article/detail?id=1 -> id=1

    if(id == 0) {
      rq.print("""
              <script>
                alert("게시물을 찾을 수 없습니다.");
              </script>
              """);

      return;
    }

    Article article = articleService.findById(id);

    if(article == null) {
      rq.print("""
              <script>
                alert("%d번 게시물은 존재하지 않습니다.");
              </script>
              """.formatted(id));

      return;
    }

    rq.setAttr("article", article);
    rq.view("usr/article/detail");
  }
}
