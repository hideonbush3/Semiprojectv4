// header 로고 클릭 이벤트
let logo = document.querySelector('#logo');
logo.addEventListener('click', function (){
    location.href = '/';
})

// 이용약관 체크박스
let agree1 = document.querySelector('#agree1');

// 개인정보 이용 체크박스
let agree2 = document.querySelector('#agree2');

// 동의 버튼
let agreeok = document.querySelector('#agreeok');
agreeok?.addEventListener('click', () => {
    if (!agree1.checked) alert("이용약관 동의에 체크하세요");
    else if(!agree2.checked) alert("개인정보 이용 동의에 체크하세요");
    else location.href = '/join/checkme';
})

// 비동의 버튼
let noagreeok = document.querySelector('#noagreeok');
noagreeok?.addEventListener('click', () =>{
    location.href = '/';
})



check2btn?.addEventListener('click', () => {
    location.href = '/join/joinme';
})

joinbtn?.addEventListener('click', () => {
    location.href = '/join/checkok'
})