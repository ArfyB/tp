function submitForm() {
  var form = document.getElementById('test');
  var formData = new FormData(form);
  var materials = [];

  for (var i = 1; i <= 2; i++) {
    var mname = formData.get('dat_' + i);
    var material = { mname: mname };
    materials.push(material);
  }

  var data = { materials: materials };

  $.ajax								// ajax코드
		({
			type : 'post',
			enctype : 'multipart/form-data',// 파일 업로드를 위한 mutipart/form-data 
			url : '/test/test',	
			data : data,
			processData : false,
			contentType : false,
			cache : false,
			timeout : 600000,
			success : function(res)
			{
				alert(res.added?'성공':'실패')
				$('#upbtn').prop('disabled', false);
			},
			error : function(e)
			{
				$('#upbtn').prop('disabled', false);
            	alert('fail');
			}
		})
}






$(function()
{
	$('#upbtn').on('click', function(event)  // upbtn 클릭시 해당 이벤트 발생
	{
		event.preventDefault();
		
		var form = $('#board')[0]			// 레시피 폼 데이터를 form이라고 명명
		var data = new FormData(form);		// form을 FormData로 변환
		
		$('#upbtn').prop('disabled', true);	// upbtn버튼 비활성화     연속적인 버튼클릭시 서버에 대한 공격이 될 가능성
		
		$.ajax								// ajax코드
		({
			type : 'post',
			enctype : 'multipart/form-data',// 파일 업로드를 위한 mutipart/form-data 
			url : '/board/add',	
			data : data,
			processData : false,
			contentType : false,
			cache : false,
			timeout : 600000,
			success : function(res)
			{
				alert(res.added?'성공':'실패')
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