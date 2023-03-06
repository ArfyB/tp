let lbtn = document.querySelector('#lbtn');

lbtn.addEventListener("click", login, false);
function login(event)
{
	location.href='../user/login'
}





let target = document.querySelector("#dynamic");

//랜덤으로 계속 리셋하면서 텍스트 띄우기
function randomString() {
  let stringArr = [
    "오늘 뭐 먹지?",
    "저녁 뭐 먹지?",
    "점심 뭐 먹지?",
    "아침 뭐 먹지?",
  ];
  let selectString = stringArr[Math.floor(Math.random() * stringArr.length)];
  let selectStringArr = selectString.split("");

  return selectStringArr;
}

//타이핑 리셋하기
function resetTyping() {
  target.textContent = "";
  dynamic(randomString());
}

//한글자씩 텍스트 출력 함수
function dynamic(randemArr) {
  if (randemArr.length > 0) {
    target.textContent += randemArr.shift();
    setTimeout(function () {
      dynamic(randemArr);
    }, 80);
  } else {
    setTimeout(resetTyping, 400);
  }
}
dynamic(randomString());

//커서 깜빡임효과
function blink() {
  // 액티브 추가 제거 반복
  target.classList.toggle("active");
}
//초당 반복할 함수
setInterval(blink, 500);

