
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

var mnum = 1;
var gnum = 1;

$(function()
{
	$('#addmat').on('click', function(event)
	{
		event.preventDefault();
		
		const list = document.getElementById('MaterialGroup_' + gnum);  // MaterialGroup_1 호출
		
		const li = document.createElement('li');
		li.id = 'liMaterial_'+gnum+"_"+mnum;
		
		const input1 = document.createElement('input');
		input1.type = 'text';
		input1.id = 'mname_'+gnum;
		input1.name='mname_'+gnum+'_'+mnum;
		
		
		const input2 = document.createElement('input');
		input2.type = 'text';
		input2.id = 'weigh_'+gnum;
		input2.name='weigh_'+gnum+'_'+mnum;
		
		li.append('mname'+mnum);
		li.append(input1);
		
		li.append('weigh'+mnum);
		li.append(input2);
		
		list.append(li);
		mnum++;
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