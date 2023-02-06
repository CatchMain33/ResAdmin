$(function(){

    const { createApp } = Vue


    let itemList = createApp({
        data() {
            return {
                itemList: {}
            }
        }
    }).mount('#itemList');

    console.log("review_lookUp.js 실행!");
    searchStart(0);

    function searchStart(index){
        console.log("index : " + index);
        $.get("/api/reviewLookUp", function(response){

            console.log(response);

            itemList.itemList = response.data;

        });
    }
});