$(function()
{
	$('#upbtn').on('click', function(event)  // upbtn 클릭시 해당 이벤트 발생
	{
		event.preventDefault();
		
		$('#upbtn').prop('disabled', true);	// upbtn버튼 비활성화     연속적인 버튼클릭시 서버에 대한 공격이 될 가능성
		
		var form = document.getElementById('abc');
		var formData = new FormData(form);
		
		var rdmenu = document.getElementById('rdmenu');
		
		$.ajax						// ajax코드
		({
			type : 'post',
			url : '/msel/getrdwithmg',
			data : formData,
			processData : false,
			contentType : false,
			cache : false,
			timeout : 600000,
			success : function(res)
			{
				$('#upbtn').prop('disabled', false);
				rdmenu.innerHTML=res.rd;
				//사진
			},
			error : function(e)
			{
				$('#upbtn').prop('disabled', false);
            	alert('fail');
			}
		})

	})
}) 