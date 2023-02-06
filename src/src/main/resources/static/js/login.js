window.onload = function (){
    const btn = document.getElementById('loginBtn');
    btn.addEventListener('click',sendit);
}
function sendit(){

    const resaUserid = document.getElementById('resaUserid');
    const resaUserpw = document.getElementById('resaUserpw');

    if(resaUserid.value==''){
        alert('아이디를 입력하세요');
        resaUserid.focus()
        return false;
    }

    if(resaUserpw.value==''){
        alert('비밀번호를 입력하세요');
        resaUserpw.focus()
        return false;
    }
    document.getElementById('frm').submit(

    );
}