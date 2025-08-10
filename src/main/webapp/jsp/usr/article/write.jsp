<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<h1>게시물 작성</h1>

<div>
  <form action="https://www.naver.com" target="_blank">
    <div>
      <div>
        <label for="title">제목</label>
      </div>
      <input type="text" name="title" id="title" placeholder="제목을 입력해주세요." required>
    </div>
    <div>
      <div>
        <label for="content">내용</label>
      </div>
      <textarea name="content" id="content" placeholder="내용을 입력해주세요." required></textarea>
    </div>
    <button type="submit">작성</button>
  </form>
</div>