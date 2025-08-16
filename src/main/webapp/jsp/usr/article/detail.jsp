<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<%@ include file="../../common/head.jspf" %>

<h1>게시물 상세보기</h1>

<div>게시물 번호 : ${article.id}</div>
<div>게시물 제목 : ${article.title}</div>
<div>게시물 내용 : ${article.content}</div>

<div>
  <a href="/usr/article/list">게시물 리스트</a>
</div>

<%@ include file="../../common/foot.jspf" %>