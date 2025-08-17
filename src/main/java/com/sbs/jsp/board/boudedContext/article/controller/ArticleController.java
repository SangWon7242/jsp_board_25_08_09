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

    if (articles == null || articles.isEmpty()) {
      rq.historyBack("게시물이 없습니다.");
      return;
    }

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

    if (title.trim().isEmpty()) {
      rq.historyBack("제목을 입력해주세요.");
      return;
    }

    if (content.trim().isEmpty()) {
      rq.historyBack("내용을 입력해주세요.");
      return;
    }

    long id = articleService.write(title, content);

    rq.replace("%d번 게시물이 작성되었습니다.".formatted(id), "/usr/article/detail/free/%d".formatted(id));
  }

  public void showDetail(Rq rq) {
    long id = rq.getLongPathValueByIndex(1, 0);
    // usr/article/detail?id=1 -> id=1

    if (id == 0) {
      rq.historyBack("게시물 번호를 입력해주세요.");
      return;
    }

    Article article = articleService.findById(id);

    if (article == null) {
      rq.historyBack("%d번 게시물이 존재하지 않습니다.".formatted(id));
      return;
    }

    rq.setAttr("article", article);
    rq.view("usr/article/detail");
  }

  public void showModify(Rq rq) {
    long id = rq.getLongPathValueByIndex(1, 0);

    if (id == 0) {
      rq.historyBack("올바른 요청이 아닙니다.");
      return;
    }

    Article article = articleService.findById(id);

    if (article == null) {
      rq.historyBack("%d번 게시물이 존재하지 않습니다.".formatted(id));
      return;
    }

    rq.setAttr("article", article);

    rq.view("usr/article/modify");
  }

  public void doModify(Rq rq) {
    long id = rq.getLongPathValueByIndex(1, 0);

    if (id == 0) {
      rq.historyBack("올바른 요청이 아닙니다.");
      return;
    }

    String title = rq.getParam("title", "");
    String content = rq.getParam("content", "");

    if (title.trim().isEmpty()) {
      rq.historyBack("제목을 입력해주세요.");
      return;
    }

    if (content.trim().isEmpty()) {
      rq.historyBack("내용을 입력해주세요.");
      return;
    }

    articleService.modify(id, title, content);

    rq.replace("게시물이 수정되었습니다.", "/usr/article/detail/free/%d".formatted(id));
  }

  public void doDelete(Rq rq) {
    long id = rq.getLongPathValueByIndex(1, 0);

    if (id == 0) {
      rq.historyBack("올바른 요청이 아닙니다.");
      return;
    }

    Article article = articleService.findById(id);

    if (article == null) {
      rq.historyBack("%d번 게시물이 존재하지 않습니다.".formatted(id));
      return;
    }

    articleService.delete(id);

    rq.replace("%d번 게시물이 삭제되었습니다.".formatted(id), "/usr/article/list");
  }
}
