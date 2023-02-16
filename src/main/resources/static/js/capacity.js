window.onload = function(){
    const btn = document.getElementById('bdBtn');
    btn.addEventListener('click',sendit);
}

function sendit(){
    const totcapacity = document.getElementById("totcapacity");
    const tottable = document.getElementById("tottable");

    if (totcapacity.value == "") {
        alert('몇인석인지 입력해주세요.');
        totcapacity.focus()
        return false;
    }

    if (tottable.value == "") {
        alert('총 테이블수를 입력해주세요.');
        tottable.focus()
        return false;
    }

    let data1 = {
        totCapacity : totcapacity.value,
        totTable : tottable.value}
    $.ajax({
        url: "/api/capacity/update",
        type: "GET",
        async:false,
        dataType: "json",
        processData: true,
        contentType: "application/json; charset=UTF-8",
        data: data1,
        success: function(result) {
            if (result) {
                alert('등록성공')
                location.href='/capacity';
                return;
            } else {
                alert("전송된 값 없음");
            }
        },
        error: function() {
            alert("에러 발생");
        }
    });

    return true;
}

function sendTime(){
    let month = document.getElementById("month");
    let day = document.getElementById("day");
    let data = {
        shopResMonth : month.value,
        shopResDay : day.value}
    $.ajax({
        url: "/api/status/createResTable",
        type: "GET",
        async:false,
        dataType: "json",
        processData: true,
        contentType: "application/json; charset=UTF-8",
        data: data,
        success: function(result) {
            if (result) {
                alert('등록성공')
                location.href='/capacity';
                return;
            } else {
                alert("전송된 값 없음");
            }
        },
        error: function() {
            alert("에러 발생");
        }
    });

    return true;
}