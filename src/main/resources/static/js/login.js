let join = document.querySelector("#jbtn");

//let find = document.querySelector("#fbtn");


/*
find.addEventListener("click", findbtn, false);
function findbtn(event) 
{
	location.href='find'
}
*/

join.addEventListener("click", joinbtn, false);
function joinbtn(event) 
{
	location.href='join'
}


$(function()
{
	$('#loginbtn').on('click', function(event)  // upbtn 클릭시 해당 이벤트 발생
	{
		event.preventDefault();
		
		var form = document.getElementById('logins');
		var formData = new FormData(form);
		
		$.ajax						// ajax코드
		({
			type : 'post',
			url : '/user/login',	
			data : formData,
			processData : false,
			contentType : false,
			cache : false,
			timeout : 600000,
			success : function(res)
			{
				alert(res.added?'성공':'실패');
			},
			error : function(e)
			{
            	alert('fail');
			}
		})

	})
}) 
