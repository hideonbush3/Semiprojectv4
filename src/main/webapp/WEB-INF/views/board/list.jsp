<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%
  // 게시판 리스트 처리 - 페이징
  // 1. 전체 게시물 수 처리 (bdcnt : 526)
  // 2. 페이지당 보여줄 게시물 수 지정 (=perPage : 10)
  // 3. 총 페이지 수 계산 (=> 52 + 1)
  // 4. 현재 페이지 번호 (cp, )
  // ex) list.do?cp=1 : 526 ~ 517
  // ex) list.do?cp=2 : 516 ~ 507
  // ex) list.do?cp=3 : 506 ~ 497
  // ...
  // ex) list.do?cp=n : x ~ x - 9
  // x를 구하는 식 : (x - 1) * 10, (x - 1) * 10 - 10
%>

<div id="main">
  <div class="mt-5">
    <i class="fa-solid fa-pen-to-square fa-2xl"> 게시판 </i>
    <hr>
  </div>

  <div class="row mt-5">
    <div class="row offset-2 col-6">
      <div class="col-3">
        <select class="form-select" id="findtype">
          <option value="title">제목</option>
          <option value="titcont">제목+내용</option>
          <option value="content">내용</option>
          <option value="userid">작성자</option>
        </select></div>

      <div class="col-4">
        <input type="text" class="form-control col-2" id="findkey"></div>

      <div class="col-3">
        <button type="button" class="btn btn-light">
          <i class="fa-solid fa-magnifying-glass"> </i> 검색하기</button></div>
    </div>
    <div class="col-2 text-end">
      <button type="button" class="btn btn-light">
        <i class="fa fa-plus-circle"> </i> 새글쓰기</button>
    </div>
  </div>

  <div class="row mt-2">
    <div class="offset-2 col-8">
      <table class="table table-striped tbborder">
        <thead class="thbg">
        <tr><th style="width: 7%">번호</th>
          <th>제목</th>
          <th style="width: 13%">작성자</th>
          <th style="width: 13%">작성일</th>
          <th style="width: 7%">추천</th>
          <th style="width: 7%">조회</th></tr>
        </thead>
        <tbody>
        <tr><th>공지</th>
          <th><span class="badge text-bg-danger">hot!</span>
            석가탄신일·성탄절 대체공휴일 확정</th>
          <th>운영자</th>
          <th>2023-05-04</th>
          <th>567</th>
          <th>1345</th></tr>

        <c:forEach items="${bdlist}" var="bd">
          <tr><td>${bd.bno}</td>
            <td>${bd.title}</td>
            <td>${bd.userid}</td>
            <td>${fn:substring(bd.regdate, 0, 10)}</td>
            <td>${bd.thumbs}</td>
            <td>${bd.views}</td></tr>
        </c:forEach>

        </tbody>
      </table>
    </div>
  </div>

  <div class="row">
    <div class="offset-2 col-8">
      <nav>
        <ul class="pagination justify-content-center">
          <li class="page-item disabled"><a class="page-link" href="#">이전</a></li>
          <li class="page-item"><a class="page-link" href="#">1</a></li>
          <li class="page-item"><a class="page-link" href="#">2</a></li>
          <li class="page-item"><a class="page-link" href="#">3</a></li>
          <li class="page-item"><a class="page-link" href="#">4</a></li>
          <li class="page-item"><a class="page-link" href="#">5</a></li>
          <li class="page-item"><a class="page-link" href="#">6</a></li>
          <li class="page-item"><a class="page-link" href="#">7</a></li>
          <li class="page-item"><a class="page-link" href="#">8</a></li>
          <li class="page-item"><a class="page-link" href="#">9</a></li>
          <li class="page-item"><a class="page-link" href="#">10</a></li>
          <li class="page-item"><a class="page-link" href="#">다음</a></li>
        </ul>
      </nav>
    </div>
  </div>

</div>

<script src="/assets/js/board.js"></script>