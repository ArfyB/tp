
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
	$('#checkbtn').on('click', function(event)
	{
		var checking = document.getElementById('RecipeMaterials').value;
		console.log(checking);
		
		var lines = checking.split('\n');
		console.log(lines);
		
		var materials = [];
		
		for (var i = 0; i < lines.length; i++) {
  		var parts = lines[i].split('[');
  		var name = parts[1].slice(0, -1); // 마지막 문자(]) 제거
  		var data = parts[2];
		}
		
		console.log("1"+parts);
		console.log("2"+name);
		console.log("3"+data);		
	})
})

$(function()
{
	$('#upbtn').on('click', function(event)  // upbtn 클릭시 해당 이벤트 발생
	{
		event.preventDefault();
		
		$('#upbtn').prop('disabled', true);	// upbtn버튼 비활성화     연속적인 버튼클릭시 서버에 대한 공격이 될 가능성
		
		var form = document.getElementById('recipe');
		var formData = new FormData(form);
		
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