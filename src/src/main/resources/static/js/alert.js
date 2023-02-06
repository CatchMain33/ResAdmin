$().ready(function () {
    $("#alertStart").click(function () {
        Swal.fire({
            icon: 'success',
            title: '확정 되었습니다',
            // text: '이곳은 내용이 나타나는 곳입니다.',
            url:'reservation.html'
        });
    });
});

$().ready(function () {
    $("#confirmStart").click(function () {
        Swal.fire({
            title: '확정하시겠습니까?',
            // text: "다시 되돌릴 수 없습니다. 신중하세요.",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: '확정',
            cancelButtonText: '취소'
        });
        // }).then((result) => {
        //     if (result.isConfirmed) {
        //         Swal.fire(
        //             '예약확정',
        //             '확정이 완료되었습니다'
        //         )
        //     }
        // })
    });
});

function deleteBoard(seq){
		Swal.fire({
		  title: '글을 삭제하시겠습니까???',
		  text: "삭제하시면 다시 복구시킬 수 없습니다.",
		  icon: 'warning',
		  showCancelButton: true,
		  confirmButtonColor: '#3085d6',
		  cancelButtonColor: '#d33',
		  confirmButtonText: '삭제',
		  cancelButtonText: '취소'
		}).then((result) => {
		  if (result.value) {
              //"삭제" 버튼을 눌렀을 때 작업할 내용을 이곳에 넣어주면 된다. 
		  }
		})
	}

// Alert Modal Type
$(document).on('click', '#success', function(e) {
    swal(
        'Success',
        'You clicked the <b style="color:green;">Success</b> button!',
        'success'
    )
});

$(document).on('click', '#error', function(e) {
    swal(
        'Error!',
        'You clicked the <b style="color:red;">error</b> button!',
        'error'
    )
});

$(document).on('click', '#warning', function(e) {
    swal(
        'Warning!',
        'You clicked the <b style="color:coral;">warning</b> button!',
        'warning'
    )
});

$(document).on('click', '#info', function(e) {
    swal(
        'Info!',
        'You clicked the <b style="color:cornflowerblue;">info</b> button!',
        'info'
    )
});

$(document).on('click', '#question', function(e) {
    swal(
        'Question!',
        'You clicked the <b style="color:grey;">question</b> button!',
        'question'
    )
});

// Alert With Custom Icon and Background Image
$(document).on('click', '#icon', function(event) {
    swal({
        title: 'Custom icon!',
        text: 'Alert with a custom image.',
        imageUrl: 'https://image.shutterstock.com/z/stock-vector--exclamation-mark-exclamation-mark-hazard-warning-symbol-flat-design-style-vector-eps-444778462.jpg',
        imageWidth: 200,
        imageHeight: 200,
        imageAlt: 'Custom image',
        animation: false
    })
});

$(document).on('click', '#image', function(event) {
    swal({
        title: 'Custom background image, width and padding.',
        width: 700,
        padding: 150,
        background: '#fff url(https://image.shutterstock.com/z/stock-vector--exclamation-mark-exclamation-mark-hazard-warning-symbol-flat-design-style-vector-eps-444778462.jpg)'
    })
});

// Alert With Input Type
$(document).on('click', '#subscribe', function(e) {
    swal({
        title: 'Submit email to subscribe',
        input: 'email',
        inputPlaceholder: 'Example@email.xxx',
        showCancelButton: true,
        confirmButtonText: 'Submit',
        showLoaderOnConfirm: true,
        preConfirm: (email) => {
            return new Promise((resolve) => {
                setTimeout(() => {
                    if (email === 'example@email.com') {
                        swal.showValidationError(
                            'This email is already taken.'
                        )
                    }
                    resolve()
                }, 2000)
            })
        },
        allowOutsideClick: false
    }).then((result) => {
        if (result.value) {
            swal({
                type: 'success',
                title: 'Thank you for subscribe!',
                html: 'Submitted email: ' + result.value
            })
        }
    })
});

// // Alert Redirect to Another Link
// $(document).on('click', '#link', function(e) {
//     swal({
//         title: "Are you sure?",
//         text: "You will be redirected to https://utopian.io",
//         type: "warning",
//         confirmButtonText: "Yes, visit link!",
//         showCancelButton: true
//     })
//         .then((result) => {
//             if (result.value) {
//                 window.location = 'https://utopian.io';
//             } else if (result.dismiss === 'cancel') {
//                 swal(
//                     'Cancelled',
//                     'Your stay here :)',
//                     'error'
//                 )
//             }
//         })
// });

// Alert Redirect to Another Link
$(document).on('click', '#link', function(e) {
    swal({
        title: "예약 확정하시겠습니까??",
        // text: "You will be redirected to https://utopian.io",
        type: "warning",
        confirmButtonText: "확정",
        showCancelButton: true
    })
        .then((result) => {
            if (result.value) {
                window.location = '/reservation';
            } else if (result.dismiss === 'cancel') {
                swal(
                    '취소되었습니다',
                    // 'Your stay here :)',
                    'error'
                )
            }
        })
});