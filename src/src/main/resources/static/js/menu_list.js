$(function(){

    const { createApp } = Vue

    let itemList = createApp({
        data() {
            return {
                itemList: {}
            }
        }
    }).mount('#itemList');

    console.log("menu_list.js 실행!");
    searchStart(0);

    function searchStart(index){
        console.log("index : " + index);
        $.get("/api/menu", function(response){

            console.log(response);


            itemList.itemList = response.data;

        });
    }
});