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

// ------------------------------ checkme
const name2 = document.querySelector('#name2');
const jumin1 = document.querySelector('#jumin1')
const jumin2 = document.querySelector('#jumin2')
const chkjumin = document.querySelector('#chkjumin');
const chk2btn = document.querySelector('#check2btn');
const cancel2btn = document.querySelector('#cancel2btn');
const chkfrm2 = document.querySelector('#checkfrm2');

chk2btn?.addEventListener('click', () => {
    if (name2.value === '') alert("이름을 기입하세요");
    else if(jumin1.value === '') alert("주민번호 앞자리를 입력하세요");
    else if(jumin2.value === '') alert("주민번호 뒷자리를 입력하세요");
    else if(!chkjumin.checked) alert("주민번호 처리에 동의하세요");
    else {
        chkfrm2.method = "post";
        chkfrm2.action = '/join/joinme';
        chkfrm2.submit();
    }
})

cancel2btn?.addEventListener('click', () => {
    location.href = '/join/agree';
})

// ------------------------------------------ joinme

// ------------------------------------------ joinok