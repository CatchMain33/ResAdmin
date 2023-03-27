window.onload = function(){
    const btn = document.getElementById('changestatus');
    btn.addEventListener('click',sendit);
}

function sendit(){
    const status1 = document.querySelector('#status10 option:checked').value;
    const status2 = document.querySelector('#status12 option:checked').value;
    const status3 = document.querySelector('#status14 option:checked').value;
    const status4 = document.querySelector('#status17 option:checked').value;
    const status5 = document.querySelector('#status19 option:checked').value;
    const status6 = document.querySelector('#status21 option:checked').value;
    // const statusmonth = document.querySelector("#status_month").innerText;
    // const statusday = document.querySelector("#status_day").innerText;
    const statustime1 = document.querySelector("span.status_time1").innerText;
    const statustime2 = document.querySelector("span.status_time2").innerText;
    const statustime3 = document.querySelector("span.status_time3").innerText;
    const statustime4 = document.querySelector("span.status_time4").innerText;
    const statustime5 = document.querySelector("span.status_time5").innerText;
    const statustime6 = document.querySelector("span.status_time6").innerText;
    console.log(statustime1)
    // console.log(statusmonth)
    // console.log(statusday)
    console.log(statustime1)

    let data1 = {
        shopResMonth : month1.innerText,
        shopResDay : day1.innerText,
        shopResTime : statustime1,
        shopResStatus : status1}
    let data2 = {
        shopResMonth : month1.innerText,
        shopResDay : day1.innerText,
        shopResTime : statustime2,
        shopResStatus : status2}
    let data3 = {
        shopResMonth : month1.innerText,
        shopResDay : day1.innerText,
        shopResTime : statustime3,
        shopResStatus : status3}
    let data4 = {
        shopResMonth : month1.innerText,
        shopResDay : day1.innerText,
        shopResTime : statustime4,
        shopResStatus : status4}
    let data5 = {
        shopResMonth : month1.innerText,
        shopResDay : day1.innerText,
        shopResTime : statustime5,
        shopResStatus : status5}
    let data6 = {
        shopResMonth : month1.innerText,
        shopResDay : day1.innerText,
        shopResTime : statustime6,
        shopResStatus : status6}
    let data7 = {
        shopResMonth : month1.innerText,
        shopResDay : day1.innerText}
    $.ajax({
        url: "/api/status/updatestatus",
        type: "GET",
        async:false,
        dataType: "json",
        processData: true,
        contentType: "application/json; charset=UTF-8",
        data: data1,
        success: function(result) {
            if (result) {
                // alert('등록성공')
                // location.href='/reservation';
                return;
            } else {
                alert("전송된 값 없음");
            }
        },
        error: function() {
            alert("에러 발생");
        }
    });
    $.ajax({
        url: "/api/status/updatestatus",
        type: "GET",
        async:false,
        dataType: "json",
        processData: true,
        contentType: "application/json; charset=UTF-8",
        data: data2,
        success: function(result) {
            if (result) {
                // alert('등록성공')
                // location.href='/reservation';
                return;
            } else {
                alert("전송된 값 없음");
            }
        },
        error: function() {
            alert("에러 발생");
        }
    });
    $.ajax({
        url: "/api/status/updatestatus",
        type: "GET",
        async:false,
        dataType: "json",
        processData: true,
        contentType: "application/json; charset=UTF-8",
        data: data3,
        success: function(result) {
            if (result) {
                // alert('등록성공')
                // location.href='/reservation';
                return;
            } else {
                alert("전송된 값 없음");
            }
        },
        error: function() {
            alert("에러 발생");
        }
    });
    $.ajax({
        url: "/api/status/updatestatus",
        type: "GET",
        async:false,
        dataType: "json",
        processData: true,
        contentType: "application/json; charset=UTF-8",
        data: data4,
        success: function(result) {
            if (result) {
                // alert('등록성공')
                // location.href='/reservation';
                return;
            } else {
                alert("전송된 값 없음");
            }
        },
        error: function() {
            alert("에러 발생");
        }
    });
    $.ajax({
        url: "/api/status/updatestatus",
        type: "GET",
        async:false,
        dataType: "json",
        processData: true,
        contentType: "application/json; charset=UTF-8",
        data: data5,
        success: function(result) {
            if (result) {
                // alert('등록성공')
                // location.href='/reservation';
                return;
            } else {
                alert("전송된 값 없음");
            }
        },
        error: function() {
            alert("에러 발생");
        }
    });
    $.ajax({
        url: "/api/status/updatestatus",
        type: "GET",
        async:false,
        dataType: "json",
        processData: true,
        contentType: "application/json; charset=UTF-8",
        data: data6,
        success: function(result) {
            if (result) {
                // alert('등록성공')
                // location.href='/reservation';
                return;
            } else {
                alert("전송된 값 없음");
            }
        },
        error: function() {
            alert("에러 발생");
        }
    });
    $.ajax({
        url: "/api/status/findstatus",
        type: "GET",
        dataType: "json",
        processData: true,
        contentType: "application/json; charset=UTF-8",
        data: data7,
        success: function(result) {
            if (result) {
                console.log(result.data[0]);
                itemList7.itemList7 = result.data;
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
