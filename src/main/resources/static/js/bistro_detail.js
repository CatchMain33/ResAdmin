window.onload = function(){
    const btn = document.getElementById('bdBtn');
    btn.addEventListener('click',sendit);
}

function sendit(){
    const resaBisName = document.getElementById("resaBisName");
    const bdPark = document.getElementById("bdPark");
    const bdAddr = document.getElementById("bdAddr");
    const bdHp = document.getElementById("bdHp");
    const bdIntro = document.getElementById("bdIntro");
    const bdCaution = document.getElementById("bdCaution");
    const bdHour = document.getElementById("bdHour");
    const bdHoliday = document.getElementById("bdHoliday");
    const bdHomepage = document.getElementById("bdHomepage");

    console.log(bdCaution);
    if (bdAddr.value == "") {
        alert('식당 상세주소 입력하세요');
        bdAddr.focus()
        return false;
    }


    fetch('http://localhost:9999/api/admin2', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({
            "transaction_time":`${new Date()}`,
            "resultCode":"ok",
            "description":"정상",
            "data":{
                "resaBisName":`${resaBisName.value}`,
                "bdPark":`${bdPark.value}`,
                "bdAddr":`${bdAddr.value}`,
                "bdHp":`${bdHp.value}`,
                "bdIntro":`${bdIntro.value}`,
                "bdCaution":`${bdCaution.value}`,
                "bdHour":`${bdHour.value}`,
                "bdHoliday":`${bdHoliday.value}`,
                "bdHomepage":`${bdHomepage.value}`
            }
        }),
    })
        .then((res) => {
            alert('등록성공')
            location.href='/bisDetail';
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