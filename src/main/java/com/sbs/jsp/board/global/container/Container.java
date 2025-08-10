package com.sbs.jsp.board.global.container;

import com.sbs.jsp.board.boudedContext.article.controller.ArticleController;
import com.sbs.jsp.board.boudedContext.member.controller.MemberController;

public class Container {
  public static ArticleController articleController;
  public static MemberController memberController;

  static {
    articleController = new ArticleController();
    memberController = new MemberController();
  }
}
