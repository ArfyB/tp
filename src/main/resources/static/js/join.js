$(function()
{
	$('#joinbtn').on('click', function(event)  // upbtn 클릭시 해당 이벤트 발생
	{
		event.preventDefault();
		
		$('#joinbtn').prop('disabled', true);	// upbtn버튼 비활성화     연속적인 버튼클릭시 서버에 대한 공격이 될 가능성
		
		var form = document.getElementById('User_info');
		var formData = new FormData(form);
		
		$.ajax						// ajax코드
		({
			type : 'post',
			url : '/user/join',	
			data : formData,
			processData : false,
			contentType : false,
			cache : false,
			timeout : 600000,
			success : function(res)
			{
				alert(res.added?'회원가입 성공':'실패')
				$('#upbtn').prop('disabled', false);
			},
			error : function(e)
			{
				$('#upbtn').prop('disabled', false);
            	alert('fail');
			}
		})

	})
}) 