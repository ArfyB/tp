let join = document.querySelector("#jbtn");
let find = document.querySelector("#fbtn");



find.addEventListener("click", findbtn, false);
function findbtn(event) 
{
	location.href='find'
}

join.addEventListener("click", joinbtn, false);
function joinbtn(event) 
{
	location.href='join'
}