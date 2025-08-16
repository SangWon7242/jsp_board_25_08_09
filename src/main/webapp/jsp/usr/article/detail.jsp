<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<%@ include file="../../common/head.jspf" %>

<section class="container mx-auto max-w-3xl px-4 mt-12">
  <div class="flex items-center justify-between mb-6">
    <h1 class="text-2xl md:text-3xl font-bold text-base-content">게시물 상세보기</h1>
    <span class="badge badge-neutral">No. ${article.id}</span>
  </div>

  <div class="card bg-base-100 shadow-xl">
    <div class="card-body space-y-4">
      <div class="form-control">
        <label class="label">
          <span class="label-text">제목</span>
        </label>
        <p class="text-lg font-semibold">${article.title}</p>
      </div>
      <div class="form-control">
        <label class="label">
          <span class="label-text">내용</span>
        </label>
        <div class="prose max-w-none whitespace-pre-line">${article.content}</div>
      </div>
      <div class="card-actions justify-end mt-2">
        <a href="/usr/article/list" class="btn btn-outline">목록</a>
      </div>
    </div>
  </div>
</section>

<%@ include file="../../common/foot.jspf" %>