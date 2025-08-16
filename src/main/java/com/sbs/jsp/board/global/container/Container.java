package com.sbs.jsp.board.global.container;

import com.sbs.jsp.board.boudedContext.article.controller.ArticleController;
import com.sbs.jsp.board.boudedContext.article.repository.ArticleRepository;
import com.sbs.jsp.board.boudedContext.article.service.ArticleService;
import com.sbs.jsp.board.boudedContext.member.controller.MemberController;

public class Container {
  public static ArticleRepository articleRepository;

  public static ArticleService articleService;

  public static ArticleController articleController;
  public static MemberController memberController;

  static {
    articleRepository = new ArticleRepository();

    articleService = new ArticleService();

    articleController = new ArticleController();
    memberController = new MemberController();
  }
}
