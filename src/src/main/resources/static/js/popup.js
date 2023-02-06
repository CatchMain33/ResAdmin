const wrap = document.querySelector(".popup");
const header = document.querySelector(".header");
// const button = document.getElementById("open");
let button11 = document.querySelectorAll(".open11");
const close = document.querySelector('.close-icon');

console.log(button11)

// button.addEventListener('click', function(e) {
//     wrap.style.display = 'block';
// });

const openModal = () => {
  // modal의 hidden클래스를 지워줌으로서 display:none효과가 없어지면서 모달이 나타남
  wrap.classList.remove("hidden1")
  console.log('open modal')
};
// 모달을 꺼주는 함수
const closeModal = () =>{
  // modal에 hidden클래스를 추가해줌으로서 display:none효과가 적용되어 모달이 사라짐
  wrap.classList.add("hidden1")
  // 드래그로 옮겨진 모달을 원래 위치로 복귀시킴
  // (만약 modal__contents의 top left값이 바뀐다면 밑에 wrap.style.top의 값과 wrap.style.left를 바꿔줘야한다)
  // wrap.style.top = `100px`;
  // wrap.style.left = `700px`;

}
// foreach문으로 openButton배열에 담긴 모든 버튼을 모두 선택 할 수있게 해줌
// [].forEach.call(openBtns, function(col) {
//     col.addEventListener("click", openModal);
// });
[].forEach.call(button11, function(col) {
  col.addEventListener("click", openModal);
});
// closeBtn을 누르면 모달을 닫아줌
close.addEventListener("click", closeModal);


let lastX = 0;
let lastY = 0; 
let startX = 0; 
let startY = 0; 

// 1.
header.addEventListener('mousedown', function(e){
  e.preventDefault(); 
  startX = e.clientX; 
  startY = e.clientY; 
	
  // 2.  
  header.classList.add('active');
  
  // 3.
  document.addEventListener('mouseup', onRemoveEvent); 
  
  // 4.
  document.addEventListener('mousemove', onMove); 
});

function onRemoveEvent() { 
  header.classList.remove('active');
  document.removeEventListener('mouseup', onRemoveEvent); 
  document.removeEventListener('mousemove', onMove); 
} 

function onMove(e) { 
  e.preventDefault(); 
  lastX = startX - e.clientX; 
  lastY = startY - e.clientY; 

  startX = e.clientX; 
  startY = e.clientY; 

  wrap.style.top = `${wrap.offsetTop - lastY}px`;
  wrap.style.left = `${wrap.offsetLeft - lastX}px`;
}