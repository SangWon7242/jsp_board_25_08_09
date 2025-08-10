<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.sbs.jsp.board.boudedContext.article.dto.Article" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>

<%
  List<Article> articles = (List<Article>) request.getAttribute("articles");
%>

<h1>게시물 리스트</h1>

<div>게시물 개수 : ${articleCount}</div>

<div>
  <table border="1" style="border-collapse: collapse">
    <colgroup>
      <col width="50px">
      <col width="200px">
    </colgroup>
    <thead>
      <tr>
        <th>번호</th>
        <th>제목</th>
      </tr>
    </thead>
    <tbody>
      <% for (Article article : articles) { %>
      <tr>
        <td><%= article.getId() %></td>
        <td><%= article.getTitle() %></td>
      </tr>
      <% } %>
    </tbody>
  </table>
</div>