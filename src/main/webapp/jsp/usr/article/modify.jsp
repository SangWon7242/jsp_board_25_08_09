<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<c:set var="pageTitle" value="게시물 수정" />

<%@ include file="../../common/head.jspf" %>

<script>
  function submitModifyForm(form) {
    form.title.value = form.title.value.trim();

    if (form.title.value.length == 0) {
      alert("제목을 입력해주세요.");
      return;
    }

    form.content.value = form.content.value.trim();

    if (form.content.value.length == 0) {
      alert("내용을 입력해주세요.");
      return;
    }

    form.submit();
  }
</script>

<section class="container mx-auto max-w-2xl px-4 mt-12">
  <h1 class="text-2xl md:text-3xl font-bold mb-6 text-base-content text-center">게시물 수정</h1>
  <form onsubmit="submitModifyForm(this); event.preventDefault();" method="POST" class="card bg-base-100 shadow-xl">
    <div class="card-body space-y-4">
      <div class="form-control">
        <label for="title" class="label">
          <span class="label-text">제목</span>
        </label>
        <input type="text" name="title" id="title" placeholder="제목을 입력해주세요." class="input input-bordered w-full" value="${article.title}" />
      </div>
      <div class="form-control">
        <label for="content" class="label">
          <span class="label-text">내용</span>
        </label>
        <textarea name="content" id="content" placeholder="내용을 입력해주세요." class="textarea textarea-bordered w-full min-h-40">${article.content}</textarea>
      </div>
      <div class="form-control mt-2">
        <button type="submit" class="btn btn-primary">수정</button>
        <a href="/usr/article/list" class="btn btn-secondary">취소</a>
      </div>
    </div>
  </form>
</section>

<%@ include file="../../common/foot.jspf" %>