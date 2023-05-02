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
const chkfrm2 = document.forms.checkfrm2;
const chk2btn = document.querySelector('#check2btn');
const cancel2btn = document.querySelector('#cancel2btn');

chk2btn?.addEventListener('click', () => {
    if (chkfrm2.name2.value === '') alert("이름을 기입하세요");
    else if(chkfrm2.jumin1.value === '') alert("주민번호 앞자리를 입력하세요");
    else if(chkfrm2.jumin2.value === '') alert("주민번호 뒷자리를 입력하세요");
    else if(!chkfrm2.chkjumin.checked) alert("주민번호 처리에 동의하세요");
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
const joinfrm = document.forms.joinfrm;
const joinbtn = document.querySelector('#joinbtn');
const cancelbtn = document.querySelector('#cancelbtn');
const email3 = document.querySelector('#email3');

// 우편번호 검색 모달
const dong = document.querySelector('#dong');           // 동 입력칸
const zipbtn = document.querySelector('#findzipbtn');   // 우편번호 검색 버튼
const addrlist = document.querySelector('#addrlist');   // 검색결과 표시하는 option 태그
const sendzip = document.querySelector('#sendzip');     // 우편번호 선택하고 닫는 버튼
const zipmodal = document.querySelector('#zipmodal');

joinbtn?.addEventListener('click', () => {
    if (joinfrm.userid.value === '') alert("아이디를 입력하세요")
    else if(joinfrm.passwd.value === '') alert("비밀번호를 입력하세요");
    else if(joinfrm.repasswd.value === '') alert("비밀번호를 한번 더 입력하세요");
    else if(joinfrm.passwd.value !== joinfrm.repasswd.value) alert("비밀번호가 일치하지 않습니다");
    // else if(joinfrm.zip1.value === '' || joinfrm.zip2.value === '') alert("우편번호를 확인하세요");
    else if(joinfrm.addr1.value === '' || joinfrm.addr2.value === '') alert("주소를 입력하세요");
    // else if(joinfrm.email1.value === '' || joinfrm.email2.value === '') alert("이메일을 입력하세요");
    else if(joinfrm.tel2.value === '' || joinfrm.tel3.value === '') alert("전화번호를 입력하세요");
    // else if(joinfrm.grecaptcha.value === '') alert("자동가입방지를 확인하세요");
    else {
        location.href = "/join/joinok";
    }
})

cancelbtn?.addEventListener('click', () => {
    location.href = "/join/checkme";
})

const showzipaddr = (jsons) => {
    // for(idx in jsons){
    //     console.log(jsons[idx]);
    // }

    // 4. json 문자열을 객체로 변환
    jsons = JSON.parse(jsons);
    let addrs = '';
    // console.log("제이슨 문자열을 객체로 바꿈!!!!!    " + jsons + "     제이슨 문자열을 객체로 바꿈!!!!!    ")
    // jsons.forEach(function (data, idx) {
    //     console.log(data);
    // });
    jsons.forEach(function (data, idx) {
        // console.log(`${data['zipcode']} ${data['sido']} ${data['gugun']} ${data['dong']}`);
        addrs += `<option>${data['zipcode']} ${data['sido']} ${data['gugun']} ${data['dong']}</option>`;
    });
    while(addrlist.lastChild){
        addrlist.removeChild(addrlist.lastChild);
    }
    addrlist.innerHTML = addrs;
};

// 1. fetch() 함수로 url 요청
// 2. joinController 에서 json 문자열 형식으로 결과를 보내줌
// 3. 그것을 인자로 showzipaddr() 호출. showzipaddr()은 우편번호 검색 결과를 보여주는 함수
zipbtn?.addEventListener('click', () => {
    const url = '/join/zipcode?dong=' + dong.value;
    fetch(url).then(response => response.text())
        .then(text => showzipaddr(text));
});

sendzip?.addEventListener('click', () => {
    let addr = addrlist.value;
    if(addr !== '') {
        // 123-456 서울 ....
        let zip = addr.split(' ')[0];   // 글자 시작부터 공백이 처음 나올때까지
        let sido = addr.split(' ')[1];
        let gugun = addr.split(' ')[2];
        let dong = addr.split(' ')[3];
        joinfrm.zip1.value = zip.split('-')[0];
        joinfrm.zip2.value = zip.split('-')[1];
        let addrs =
            `${addr.split(' ')[1]} ${addr.split(' ')[2]} ${addr.split(' ')[3]}`;
        joinfrm.addr1.value = addrs;

        bootstrap.Modal.getInstance(zipmodal).hide();
    }
    else alert("주소를 선택하세요")
})

email3.addEventListener('onchange', () => {

})

// ------------------------------------------ joinok