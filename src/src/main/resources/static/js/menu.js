window.onload = function(){
    const btn = document.getElementById('menuBtn');
    btn.addEventListener('click',sendit);
}

function sendit(){
    const resaBisName = document.getElementById("resaBisName").innerText;
    const meName = document.getElementById("meName");
    const mePrice = document.getElementById("mePrice");
    const meContent = document.getElementById("meContent");

    console.log(resaBisName);
    console.log(meName.value);
    console.log(mePrice.value);
    console.log(meContent.value);

    if (meName.value == "") {
        alert('메뉴 이름 입력하세요');
        meName.focus()
        return false;
    }

    if (mePrice.value == "") {
        alert('가격 입력하세요');
        mePrice.focus()
        return false;
    }

    fetch('http://localhost:9999/api/menu', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({
            "transaction_time":`${new Date()}`,
            "resultCode":"ok",
            "description":"정상",
            "data":{
                "resaBisName":`${resaBisName}`,
                "meName":`${meName.value}`,
                "meContent":`${meContent.value}`,
                "mePrice":`${mePrice.value}`
            }
        }),
    })
        .then((res) => {
            alert('등록성공')
            location.href='/menuLookUp';
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