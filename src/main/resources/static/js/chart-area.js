// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = 'Nunito', '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#858796';
let month111;
let month112;
let month113;
let month114;
let month115;
let month116;
let month117;
let month118;
let month119;
let month1110;
let month1111;
let month1112;
let mmonth111;
let mmonth112;
let mmonth113;
let mmonth114;
let mmonth115;
let mmonth116;
let mmonth117;
let mmonth118;
let mmonth119;
let mmonth1110;
let mmonth1111;
let mmonth1112;
let totcost1;
let totcost2;
let totcost3;
let totcost4;
let totcost5;
let totcost6;
let totcost7;
let totcost8;
let totcost9;
let totcost10;
let totcost11;
let totcost12;
function number_format(number, decimals, dec_point, thousands_sep) {
    // *     example: number_format(1234.56, 2, ',', ' ');
    // *     return: '1 234,56'
    number = (number + '').replace(',', '').replace(' ', '');
    var n = !isFinite(+number) ? 0 : +number,
        prec = !isFinite(+decimals) ? 0 : Math.abs(decimals),
        sep = (typeof thousands_sep === 'undefined') ? ',' : thousands_sep,
        dec = (typeof dec_point === 'undefined') ? '.' : dec_point,
        s = '',
        toFixedFix = function(n, prec) {
            var k = Math.pow(10, prec);
            return '' + Math.round(n * k) / k;
        };
    // Fix for IE parseFloat(0.55).toFixed(0) = 0;
    s = (prec ? toFixedFix(n, prec) : '' + Math.round(n)).split('.');
    if (s[0].length > 3) {
        s[0] = s[0].replace(/\B(?=(?:\d{3})+(?!\d))/g, sep);
    }
    if ((s[1] || '').length < prec) {
        s[1] = s[1] || '';
        s[1] += new Array(prec - s[1].length + 1).join('0');
    }
    return s.join(dec);
}

function mmonth1(){
    let data1 = {}
    $.ajax({
        url: "/api/reservation/month1",
        type: "GET",
        async:false,
        dataType: "json",
        processData: true,
        contentType: "application/json; charset=UTF-8",
        data: data1,
        success: function(result) {
            if (result) {
                month111 = Object.keys(result.data).length;
                console.log("1월예약 건수 : "+month111);
                return month111;
            } else {
                alert("전송된 값 없음");
            }
        },
        error: function() {
            alert("에러 발생");
        }
    });
}
function mmmonth1(){
    let data1 = {}
    $.ajax({
        url: "/api/reservation/mmonth1",
        type: "GET",
        async:false,
        dataType: "json",
        processData: true,
        contentType: "application/json; charset=UTF-8",
        data: data1,
        success: function(result) {
            if (result) {
                mmonth111 = Object.keys(result.data).length;
                console.log("1월예약 건수 : "+mmonth111);
                return mmonth111;
            } else {
                alert("전송된 값 없음");
            }
        },
        error: function() {
            alert("에러 발생");
        }
    });
}
function mmonth2(){
    let data2 = {}
    $.ajax({
        url: "/api/reservation/month2",
        type: "GET",
        async:false,
        dataType: "json",
        processData: true,
        contentType: "application/json; charset=UTF-8",
        data: data2,
        success: function(result) {
            if (result) {
                month112 = Object.keys(result.data).length;
                console.log("2월예약 건수 : "+month112);
                return month112;
            } else {
                alert("전송된 값 없음");
            }
        },
        error: function() {
            alert("에러 발생");
        }
    });
}
function mmmonth2(){
    let data2 = {}
    $.ajax({
        url: "/api/reservation/mmonth2",
        type: "GET",
        async:false,
        dataType: "json",
        processData: true,
        contentType: "application/json; charset=UTF-8",
        data: data2,
        success: function(result) {
            if (result) {
                mmonth112 = Object.keys(result.data).length;
                console.log("2월예약 건수 : "+mmonth112);
                return mmonth112;
            } else {
                alert("전송된 값 없음");
            }
        },
        error: function() {
            alert("에러 발생");
        }
    });
}
function mmonth3(){
    let data3 = {}
    $.ajax({
        url: "/api/reservation/month3",
        type: "GET",
        async:false,
        dataType: "json",
        processData: true,
        contentType: "application/json; charset=UTF-8",
        data: data3,
        success: function(result) {
            if (result) {
                month113 = Object.keys(result.data).length;
                console.log("3월예약 건수 : "+month113);
                return month113;
            } else {
                alert("전송된 값 없음");
            }
        },
        error: function() {
            alert("에러 발생");
        }
    });
}
function mmmonth3(){
    let data3 = {}
    $.ajax({
        url: "/api/reservation/mmonth3",
        type: "GET",
        async:false,
        dataType: "json",
        processData: true,
        contentType: "application/json; charset=UTF-8",
        data: data3,
        success: function(result) {
            if (result) {
                mmonth113 = Object.keys(result.data).length;
                console.log("3월예약 건수 : "+mmonth113);
                return mmonth113;
            } else {
                alert("전송된 값 없음");
            }
        },
        error: function() {
            alert("에러 발생");
        }
    });
}
function mmonth4(){
    let data4 = {}
    $.ajax({
        url: "/api/reservation/month4",
        type: "GET",
        async:false,
        dataType: "json",
        processData: true,
        contentType: "application/json; charset=UTF-8",
        data: data4,
        success: function(result) {
            if (result) {
                month114 = Object.keys(result.data).length;
                console.log("4월예약 건수 : "+month114);
                return month114;
            } else {
                alert("전송된 값 없음");
            }
        },
        error: function() {
            alert("에러 발생");
        }
    });
}
function mmmonth4(){
    let data4 = {}
    $.ajax({
        url: "/api/reservation/mmonth4",
        type: "GET",
        async:false,
        dataType: "json",
        processData: true,
        contentType: "application/json; charset=UTF-8",
        data: data4,
        success: function(result) {
            if (result) {
                mmonth114 = Object.keys(result.data).length;
                console.log("4월예약 건수 : "+mmonth114);
                return mmonth114;
            } else {
                alert("전송된 값 없음");
            }
        },
        error: function() {
            alert("에러 발생");
        }
    });
}
function mmonth5(){
    let data5 = {}
    $.ajax({
        url: "/api/reservation/month5",
        type: "GET",
        async:false,
        dataType: "json",
        processData: true,
        contentType: "application/json; charset=UTF-8",
        data: data5,
        success: function(result) {
            if (result) {
                month115 = Object.keys(result.data).length;
                console.log("5월예약 건수 : "+month115);
                return month115;
            } else {
                alert("전송된 값 없음");
            }
        },
        error: function() {
            alert("에러 발생");
        }
    });
}
function mmmonth5(){
    let data5 = {}
    $.ajax({
        url: "/api/reservation/mmonth5",
        type: "GET",
        async:false,
        dataType: "json",
        processData: true,
        contentType: "application/json; charset=UTF-8",
        data: data5,
        success: function(result) {
            if (result) {
                mmonth115 = Object.keys(result.data).length;
                console.log("5월예약 건수 : "+mmonth115);
                return mmonth115;
            } else {
                alert("전송된 값 없음");
            }
        },
        error: function() {
            alert("에러 발생");
        }
    });
}
function mmonth6(){
    let data6 = {}
    $.ajax({
        url: "/api/reservation/month6",
        type: "GET",
        async:false,
        dataType: "json",
        processData: true,
        contentType: "application/json; charset=UTF-8",
        data: data6,
        success: function(result) {
            if (result) {
                month116 = Object.keys(result.data).length;
                console.log("6월예약 건수 : "+month116);
                return month116;
            } else {
                alert("전송된 값 없음");
            }
        },
        error: function() {
            alert("에러 발생");
        }
    });
}
function mmmonth6(){
    let data6 = {}
    $.ajax({
        url: "/api/reservation/mmonth6",
        type: "GET",
        async:false,
        dataType: "json",
        processData: true,
        contentType: "application/json; charset=UTF-8",
        data: data6,
        success: function(result) {
            if (result) {
                mmonth116 = Object.keys(result.data).length;
                console.log("6월예약 건수 : "+mmonth116);
                return mmonth116;
            } else {
                alert("전송된 값 없음");
            }
        },
        error: function() {
            alert("에러 발생");
        }
    });
}
function mmonth7(){
    let data1 = {}
    $.ajax({
        url: "/api/reservation/month7",
        type: "GET",
        async:false,
        dataType: "json",
        processData: true,
        contentType: "application/json; charset=UTF-8",
        data: data1,
        success: function(result) {
            if (result) {
                month117 = Object.keys(result.data).length;
                console.log("7월예약 건수 : "+month117);
                return month117;
            } else {
                alert("전송된 값 없음");
            }
        },
        error: function() {
            alert("에러 발생");
        }
    });
}
function mmmonth7(){
    let data1 = {}
    $.ajax({
        url: "/api/reservation/mmonth7",
        type: "GET",
        async:false,
        dataType: "json",
        processData: true,
        contentType: "application/json; charset=UTF-8",
        data: data1,
        success: function(result) {
            if (result) {
                mmonth117 = Object.keys(result.data).length;
                console.log("7월예약 건수 : "+mmonth117);
                return mmonth117;
            } else {
                alert("전송된 값 없음");
            }
        },
        error: function() {
            alert("에러 발생");
        }
    });
}

function mmonth8(){
    let data1 = {}
    $.ajax({
        url: "/api/reservation/month8",
        type: "GET",
        async:false,
        dataType: "json",
        processData: true,
        contentType: "application/json; charset=UTF-8",
        data: data1,
        success: function(result) {
            if (result) {
                month118 = Object.keys(result.data).length;
                console.log("1월예약 건수 : "+month118);
                return month118;
            } else {
                alert("전송된 값 없음");
            }
        },
        error: function() {
            alert("에러 발생");
        }
    });
}
function mmmonth8(){
    let data1 = {}
    $.ajax({
        url: "/api/reservation/mmonth8",
        type: "GET",
        async:false,
        dataType: "json",
        processData: true,
        contentType: "application/json; charset=UTF-8",
        data: data1,
        success: function(result) {
            if (result) {
                mmonth118 = Object.keys(result.data).length;
                console.log("1월예약 건수 : "+mmonth118);
                return mmonth118;
            } else {
                alert("전송된 값 없음");
            }
        },
        error: function() {
            alert("에러 발생");
        }
    });
}
function mmonth9(){
    let data1 = {}
    $.ajax({
        url: "/api/reservation/month9",
        type: "GET",
        async:false,
        dataType: "json",
        processData: true,
        contentType: "application/json; charset=UTF-8",
        data: data1,
        success: function(result) {
            if (result) {
                month119 = Object.keys(result.data).length;
                console.log("9월예약 건수 : "+month119);
                return month119;
            } else {
                alert("전송된 값 없음");
            }
        },
        error: function() {
            alert("에러 발생");
        }
    });
}
function mmmonth9(){
    let data1 = {}
    $.ajax({
        url: "/api/reservation/mmonth9",
        type: "GET",
        async:false,
        dataType: "json",
        processData: true,
        contentType: "application/json; charset=UTF-8",
        data: data1,
        success: function(result) {
            if (result) {
                mmonth119 = Object.keys(result.data).length;
                console.log("9월예약 건수 : "+mmonth119);
                return mmonth119;
            } else {
                alert("전송된 값 없음");
            }
        },
        error: function() {
            alert("에러 발생");
        }
    });
}
function mmonth10(){
    let data1 = {}
    $.ajax({
        url: "/api/reservation/month10",
        type: "GET",
        async:false,
        dataType: "json",
        processData: true,
        contentType: "application/json; charset=UTF-8",
        data: data1,
        success: function(result) {
            if (result) {
                month1110 = Object.keys(result.data).length;
                console.log("10월예약 건수 : "+month1110);
                return month1110;
            } else {
                alert("전송된 값 없음");
            }
        },
        error: function() {
            alert("에러 발생");
        }
    });
}
function mmmonth10(){
    let data1 = {}
    $.ajax({
        url: "/api/reservation/mmonth10",
        type: "GET",
        async:false,
        dataType: "json",
        processData: true,
        contentType: "application/json; charset=UTF-8",
        data: data1,
        success: function(result) {
            if (result) {
                mmonth1110 = Object.keys(result.data).length;
                console.log("10월예약 건수 : "+mmonth1110);
                return mmonth1110;
            } else {
                alert("전송된 값 없음");
            }
        },
        error: function() {
            alert("에러 발생");
        }
    });
}
function mmonth11(){
    let data1 = {}
    $.ajax({
        url: "/api/reservation/month11",
        type: "GET",
        async:false,
        dataType: "json",
        processData: true,
        contentType: "application/json; charset=UTF-8",
        data: data1,
        success: function(result) {
            if (result) {
                month1111 = Object.keys(result.data).length;
                console.log("11월예약 건수 : "+month1111);
                return month1111;
            } else {
                alert("전송된 값 없음");
            }
        },
        error: function() {
            alert("에러 발생");
        }
    });
}
function mmmonth11(){
    let data1 = {}
    $.ajax({
        url: "/api/reservation/mmonth11",
        type: "GET",
        async:false,
        dataType: "json",
        processData: true,
        contentType: "application/json; charset=UTF-8",
        data: data1,
        success: function(result) {
            if (result) {
                mmonth1111 = Object.keys(result.data).length;
                console.log("11월예약 건수 : "+mmonth1111);
                return mmonth1111;
            } else {
                alert("전송된 값 없음");
            }
        },
        error: function() {
            alert("에러 발생");
        }
    });
}
function mmonth12(){
    let data1 = {}
    $.ajax({
        url: "/api/reservation/month12",
        type: "GET",
        async:false,
        dataType: "json",
        processData: true,
        contentType: "application/json; charset=UTF-8",
        data: data1,
        success: function(result) {
            if (result) {
                console.log(result.data)
                month1112 = Object.keys(result.data).length;
                console.log("12월예약 건수 : "+month1112);
                return month1112;
            } else {
                alert("전송된 값 없음");
            }
        },
        error: function() {
            alert("에러 발생");
        }
    });
}
function mmmonth12(){
    let data1 = {}
    $.ajax({
        url: "/api/reservation/mmonth12",
        type: "GET",
        async:false,
        dataType: "json",
        processData: true,
        contentType: "application/json; charset=UTF-8",
        data: data1,
        success: function(result) {
            if (result) {
                console.log(result.data)
                mmonth1112 = Object.keys(result.data).length;
                console.log("12월예약 건수 : "+mmonth1112);
                return mmonth1112;
            } else {
                alert("전송된 값 없음");
            }
        },
        error: function() {
            alert("에러 발생");
        }
    });
}
function allreserve(){
    mmonth1()
    mmonth2()
    mmonth3()
    mmonth4()
    mmonth5()
    mmonth6()
    mmonth7()
    mmonth8()
    mmonth9()
    mmonth10()
    mmonth11()
    mmonth12()
    mmmonth1()
    mmmonth2()
    mmmonth3()
    mmmonth4()
    mmmonth5()
    mmmonth6()
    mmmonth7()
    mmmonth8()
    mmmonth9()
    mmmonth10()
    mmmonth11()
    mmmonth12()
}
allreserve();
month111 *= 50000;
month112 *= 50000;
month113 *= 50000;
month114 *= 50000;
month115 *= 50000;
month116 *= 50000;
month117 *= 50000;
month118 *= 50000;
month119 *= 50000;
month1110 *= 50000;
month1111 *= 50000;
month1112 *= 50000;
mmonth111 *= 50000;
mmonth112 *= 50000;
mmonth113 *= 50000;
mmonth114 *= 50000;
mmonth115 *= 50000;
mmonth116 *= 50000;
mmonth117 *= 50000;
mmonth118 *= 50000;
mmonth119 *= 50000;
mmonth1110 *= 50000;
mmonth1111 *= 50000;
mmonth1112 *= 50000;

totcost1 = month111+mmonth111;
totcost2 = month112+mmonth112;
totcost3 = month113+mmonth113;
totcost4 = month114+mmonth114;
totcost5 = month115+mmonth115;
totcost6 = month116+mmonth116;
totcost7 = month117+mmonth117;
totcost8 = month118+mmonth118;
totcost9 = month119+mmonth119;
totcost10 = month1110+mmonth1110;
totcost11 = month1111+mmonth1111;
totcost12 = month1112+mmonth1112;
// Area Chart Example
var ctx = document.getElementById("myAreaChart");
var myLineChart = new Chart(ctx, {
    type: 'line',
    data: {
        labels: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],
        datasets: [{
            label: "Earnings",
            lineTension: 0.3,
            backgroundColor: "rgba(78, 115, 223, 0.05)",
            borderColor: "rgba(78, 115, 223, 1)",
            pointRadius: 3,
            pointBackgroundColor: "rgba(78, 115, 223, 1)",
            pointBorderColor: "rgba(78, 115, 223, 1)",
            pointHoverRadius: 3,
            pointHoverBackgroundColor: "rgba(78, 115, 223, 1)",
            pointHoverBorderColor: "rgba(78, 115, 223, 1)",
            pointHitRadius: 10,
            pointBorderWidth: 2,
            data: [totcost1, totcost2, totcost3, totcost4, totcost5, totcost6, totcost7, totcost8, totcost9, totcost10, totcost11, totcost12],
        }],
    },
    options: {
        maintainAspectRatio: false,
        layout: {
            padding: {
                left: 10,
                right: 25,
                top: 25,
                bottom: 0
            }
        },
        scales: {
            xAxes: [{
                time: {
                    unit: 'date'
                },
                gridLines: {
                    display: false,
                    drawBorder: false
                },
                ticks: {
                    maxTicksLimit: 7
                }
            }],
            yAxes: [{
                ticks: {
                    maxTicksLimit: 5,
                    padding: 10,
                    // Include a dollar sign in the ticks
                    callback: function(value, index, values) {
                        return '$' + number_format(value);
                    }
                },
                gridLines: {
                    color: "rgb(234, 236, 244)",
                    zeroLineColor: "rgb(234, 236, 244)",
                    drawBorder: false,
                    borderDash: [2],
                    zeroLineBorderDash: [2]
                }
            }],
        },
        legend: {
            display: false
        },
        tooltips: {
            backgroundColor: "rgb(255,255,255)",
            bodyFontColor: "#858796",
            titleMarginBottom: 10,
            titleFontColor: '#6e707e',
            titleFontSize: 14,
            borderColor: '#dddfeb',
            borderWidth: 1,
            xPadding: 15,
            yPadding: 15,
            displayColors: false,
            intersect: false,
            mode: 'index',
            caretPadding: 10,
            callbacks: {
                label: function(tooltipItem, chart) {
                    var datasetLabel = chart.datasets[tooltipItem.datasetIndex].label || '';
                    return datasetLabel + ': $' + number_format(tooltipItem.yLabel);
                }
            }
        }
    }
});