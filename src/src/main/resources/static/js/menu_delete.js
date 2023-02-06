function deleteIt(){

    const meIdx = document.getElementById("meIdx").innerText;
    console.log(meIdx)

    fetch('http://localhost:9999/api/menu/'+ meIdx, {
        method: 'DELETE',
    })
        .then((res) => {
            alert('삭제성공')
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