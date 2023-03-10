let target = document.querySelector("#dynamic");

//랜덤으로 계속 리셋 + 텍스트 띄우기
function randomString() {
  let stringArr = ["저녁 뭐 먹지?", "점심 뭐 먹지?", "아침 뭐 먹지?"];
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
function dynamic(randomArr) {
  if (randomArr.length > 0) {
    target.textContent += randomArr.shift();
    setTimeout(function () {
      dynamic(randomArr);
      // 타이핑 속도 설정
    }, 80);
  } else {
    // 문장 반복 시간 설정
    setTimeout(resetTyping, 500);
  }
}
dynamic(randomString());

//커서 깜빡임효과
function blink() {
  // 액티브 추가 제거 반복
  target.classList.toggle("active");
}
//커서 깜빡임 속도 설정
setInterval(blink, 200);
