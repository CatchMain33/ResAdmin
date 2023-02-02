console.log("facility")
window.onload = function(){
    const btn = document.getElementById('bdBtn');
    btn.addEventListener('click',sendit);
}

function sendit(){
    const park = document.querySelector('#parking option:checked').value;
    const valet = document.querySelector('#valet option:checked').value;
    const corkage = document.querySelector('#corkage option:checked').value;
    const nokid = document.querySelector('#nokid option:checked').value;
    const animal = document.querySelector('#animal option:checked').value;
    const handi = document.querySelector('#handi option:checked').value;
    console.log(park)

    let data1 = {
        facParking : park,
        facValet : valet,
        facCorkage : corkage,
        facNokid : nokid,
        facAnimal : animal,
        facHandi : handi}
    $.ajax({
        url: "/api/facility/update",
        type: "GET",
        async:false,
        dataType: "json",
        processData: true,
        contentType: "application/json; charset=UTF-8",
        data: data1,
        success: function(result) {
            if (result) {
                alert('등록성공')
                location.href='/facility';
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