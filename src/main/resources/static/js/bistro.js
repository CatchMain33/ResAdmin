window.onload = function(){
    console.log("로드완료")
    const btn = document.getElementById('bisBtn');
    btn.addEventListener('click',sendit);
}

function sendit(){
    const resaBisName = document.getElementById("resaBisName");
    console.log(resaBisName.value);
    const bisDesc = document.getElementById("bisDesc");
    console.log(bisDesc.value);
    const bisCategory = document.getElementById("bisCategory");
    const bisRegion = document.getElementById("bisRegion");
    const bisLunch = document.getElementById("bisLunch");
    const bisDinner = document.getElementById("bisDinner");

    if (bisDesc.value == "") {
        alert('한줄소개를 입력하세요');
        bisDesc.focus()
        return false;
    }

    if (bisCategory.value == "") {
        alert('카테고리 선택하세요');
        bisCategory.focus()
        return false;
    }

    if (bisRegion.value == "") {
        alert('지역 입력하세요');
        bisRegion.focus()
        return false;
    }

    if (bisLunch.value == "") {
        alert('점심운영시간 입력하세요');
        bisLunch.focus()
        return false;
    }

    if (bisDinner.value == "") {
        alert('저녁운영시간 입력하세요');
        bisDinner.focus()
        return false;
    }

    fetch('http://localhost:9999/api/admin', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({
            "transaction_time":`${new Date()}`,
            "resultCode":"ok",
            "description":"정상",
            "data":{
                "resaBisName":`${resaBisName.value}`,
                "bisDesc":`${bisDesc.value}`,
                "bisCategory":`${bisCategory.value}`,
                "bisRegion":`${bisRegion.value}`,
                "bisLunch":`${bisLunch.value}`,
                "bisDinner":`${bisDinner.value}`,
            }
        }),
    })
        .then((res) => {
            alert('등록성공')
            location.href='/mypage';
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