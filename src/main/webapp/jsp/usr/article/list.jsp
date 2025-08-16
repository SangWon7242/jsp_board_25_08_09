<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<%@ include file="../../common/head.jspf" %>

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
      <c:forEach var="article" items="${articles}">
        <tr>
          <td>${article.id}</td>
          <td>
            <a href="detail/free/${article.id}">${article.title}</a>
          </td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</div>

<%@ include file="../../common/foot.jspf" %>