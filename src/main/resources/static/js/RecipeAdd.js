
function readURL(input) {
	if (input.files && input.files[0]) {
		var reader = new FileReader();
		reader.onload = function(e) {
			document.getElementById('mainpreview').src = e.target.result;
		};
		reader.readAsDataURL(input.files[0]);
	} else {
		document.getElementById('mainpreview').src = "";
	}
}




$(function()
{
	$('#upbtn').on('click', function(event)  // upbtn 클릭시 해당 이벤트 발생
	{
		event.preventDefault();
		
		var form = document.getElementById('recipe')			// 레시피 폼 데이터를 form이라고 명명
		var formData = new FormData(form);		// form을 FormData로 변환
		var materials = [];

  		for (var i = 1; i <= 2; i++) 
  		{
    		var mname = formData.get('mname_1_' + i);
    		var weigh = formData.get('weigh_1_' + i)
    		var material = { mname : mname, weigh : weigh };
    		materials.push(material);
  		}
		
		console.log(materials);
		
		$('#upbtn').prop('disabled', true);	// upbtn버튼 비활성화     연속적인 버튼클릭시 서버에 대한 공격이 될 가능성
		
		$.ajax						// ajax코드
		({
			type : 'post',
			enctype : 'multipart/form-data',// 파일 업로드를 위한 mutipart/form-data 
			url : '/recipe/upload',	
			data : formData,
			processData : false,
			contentType : false,
			cache : false,
			timeout : 600000,
			success : function(res)
			{
				alert(res.added?'성공':'실패')
				$('#upbtn').prop('disabled', false);
				if(res.added)
				{
					href='/recipe/main'
				}
			},
			error : function(e)
			{
				$('#upbtn').prop('disabled', false);
            	alert('fail');
			}
		})
	})
}) 