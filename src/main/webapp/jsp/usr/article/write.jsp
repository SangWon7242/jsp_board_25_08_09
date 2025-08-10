<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<script>
  function submitWriteForm(form) {
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

<h1>게시물 작성</h1>

<div>
  <form onsubmit="submitWriteForm(this); event.preventDefault();" method="POST">
    <div>
      <div>
        <label for="title">제목</label>
      </div>
      <input type="text" name="title" id="title" placeholder="제목을 입력해주세요.">
    </div>
    <div>
      <div>
        <label for="content">내용</label>
      </div>
      <textarea name="content" id="content" placeholder="내용을 입력해주세요."></textarea>
    </div>
    <button type="submit">작성</button>
  </form>
</div>