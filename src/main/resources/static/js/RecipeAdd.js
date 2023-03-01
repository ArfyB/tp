
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

		var names = [];
		var materials = [];

		for (var i = 0; i < lines.length; i++) {
  		var parts = lines[i].split('['); // 스테이크] 고기10g, 후추1/2 형식으로 나옴
  		
  		var splits = parts[1].split(' '); // 스테이크], 고기10g, 후추1/2 로 나눔
  		
  		console.log('parts ' + parts[1]);
  		
  		names.push(splits[0].slice(0, -1)); // 스테이크] => 스테이크 names배열에 저장
  		
  		
  		for (var j = 1; j<splits.length; j++)
  		{
			console.log('splits'+j+' '+splits[j]);
			
			if(j%2==0 & j!=splits.length-1) // 계량값들을 구하되 split을 하기위해 각 재료의 마지막계량은 제외
			{
				console.log('계량 ' + splits[j]);
			}
		}
  		
  		}
  		console.log(names);
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