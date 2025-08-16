<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<%@ include file="../../common/head.jspf" %>

<section class="container mx-auto max-w-4xl px-4 mt-12">
  <div class="flex items-center justify-between mb-6">
    <h1 class="text-2xl md:text-3xl font-bold text-base-content">게시물 리스트</h1>
    <span class="badge badge-neutral">총 <span class="mx-1 font-semibold">${articleCount}</span>개</span>
  </div>

  <div class="card bg-base-100 shadow-xl">
    <div class="card-body p-0">
      <div class="overflow-x-auto">
        <table class="table table-zebra">
          <colgroup>
            <col class="w-20" />
            <col />
          </colgroup>
          <thead>
            <tr>
              <th>번호</th>
              <th>제목</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach var="article" items="${articles}">
              <tr class="hover">
                <td class="whitespace-nowrap">${article.id}</td>
                <td>
                  <a href="detail/free/${article.id}">${article.title}</a>
                </td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</section>

<%@ include file="../../common/foot.jspf" %>