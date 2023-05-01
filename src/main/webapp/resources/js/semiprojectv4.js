let logo = document.querySelector('#logo');
let agreeok = document.querySelector('#agreeok');
let check2btn = document.querySelector('#check2btn');
let joinbtn = document.querySelector('#joinbtn');

logo.addEventListener('click', function (){
    location.href = '/';
})

agreeok.addEventListener('click', function (){
    location.href = '/join/checkme';
})

check2btn.addEventListener('click', function (){
    location.href = '/join/joinme';
})

joinbtn.addEventListener('click', function (){
    location.href = '/join/checkok'
})