<%@ page pageEncoding="UTF-8" %>

<div id="main">
    <div class="mt-5">
        <i class="fa-solid fa-pen-to-square fa-2xl"> 게시판 </i>
        <hr>
    </div>

    <div class="row mt-5">
        <div class="offset-2 row col-4">
            <h4><i class="fa fa-plus-circle"> </i> 새글쓰기</h4>
        </div>
        <div class="text-end col-4">
            <button type="button" class="btn btn-light">
                <i class="fa fa-list"> </i> 목록으로
            </button>
        </div>

    </div>

    <div class="row offset-2 col-8 mt-2">
        <form class="card card-body bg-light"
            name="bdfrm" id="bdfrm">
            <div class="row">
                <label for="title" class="col-form-label text-danger text-end col-3">제목</label>
                <div class="col-6">
                    <input type="text" id="title" name="title"
                    class="form-control border-danger">
                </div>
            </div>

            <div class="row mt-2">
                <label for="userid" class="col-form-label text-danger text-end col-3">작성자</label>
                <div class="col-6">
                    <input type="text" id="userid" name="userid"
                           class="form-control border-danger bg-light" readonly value="hideonbush3">
                </div>
            </div>

            <div class="row mt-2">
                <label for="content" class="col-form-label text-danger text-end col-3">본문</label>
                <div class="col-6">
                    <textarea type="text" id="content" name="content"
                           class="form-control border-danger" rows="15"></textarea>
                </div>
            </div>

            <div class="row mt-2">
                <label for="g-recaptcha" class="col-form-label text-danger text-end col-3">자동가입방지</label>
                <div class="col-6">
                    <div class="g-recaptcha"
                        data-sitekey="6LdL4OskAAAAAK7rwtgYuLMdFMXONFJgc5hhBcaX"></div>
                    <input type="hidden" name="grecaptcha" id="g-recaptcha">
                </div>
            </div>

            <div class="row mt-2 justify-content-center">
                <hr class="w-75">
                <div class="text-center">

                    <button type="button" class="btn btn-primary" id="writebtn" name="writebtn">
                        <i class="fa fa-check"> </i> 입력완료</button>


                    <button type="button" class="btn btn-danger" id="cancelbtn" name="cancelbtn">
                        <i class="fa fa-remove"> </i> 입력취소</button>
                </div>
            </div>
        </form>
    </div>
    <script src="https://www.google.com/recaptcha/api.js"></script>
</div>

<script src="/assets/js/board.js"></script>