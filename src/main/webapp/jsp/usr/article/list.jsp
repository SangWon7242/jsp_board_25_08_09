<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.sbs.jsp.board.boudedContext.article.dto.Article" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>

<%
  List<Article> articles = (List<Article>) request.getAttribute("articles");
%>

<h1>게시물 리스트</h1>

<div>
  <ul>
    <% for (Article article : articles) { %>
      <li>
        <span>id: <%= article.getId() %></span>
        <span>title: <%= article.getTitle() %></span>
      </li>
    <% } %>
  </ul>
</div>