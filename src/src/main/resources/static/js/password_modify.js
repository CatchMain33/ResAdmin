window.onload = function(){
    const btn = document.getElementById('passwordBtn');
    btn.addEventListener('click',sendit);
}

function sendit(){
    const resaUserid = document.getElementById("resaUserid").innerText;
    const resaUserpw = document.getElementById("resaUserpw");
    const resaUserpw2 = document.getElementById("resaUserpw2");


    console.log(resaUserpw.value);
    console.log(resaUserpw2.value);

    if (resaUserpw.value != resaUserpw2.value){
        alert('비밀번호 확인값이 다릅니다');
        resaUserpw2.focus()
        return false;
    }
    if (resaUserpw.value == "") {
        alert('새 비밀번호 입력하세요');
        resaUserpw.focus()
        return false;
    }

    if (resaUserpw2.value == "") {
        alert('새 비밀번호 확인');
        resaUserpw2.focus()
        return false;
    }

    fetch('http://localhost:9999/api/re_password', {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({
            "transaction_time":`${new Date()}`,
            "resultCode":"ok",
            "description":"정상",
            "data":{
                "resaUserid" : `${resaUserid}`,
                "resaUserpw":`${resaUserpw.value}`
            }
        }),
    })
        .then((res) => {
            alert('비밀번호 변경 성공')
            location.href='/';
            return;
        })
        .then((data) => {
            console.log(data);
            return;
        })
        .catch((err) => {
            alert('에러!');
            location.reload();
            return;
        });

    // fetch
    return true;
}