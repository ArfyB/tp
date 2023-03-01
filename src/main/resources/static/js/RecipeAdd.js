
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
		
		// Material 클래스 정의
		class Material {
  		constructor(whatm, mname, weigh) {
    	this.whatm = whatm;
    	this.mname = mname;
    	this.weigh = weigh;
  		}
	}

		
		// HTML의 textarea에서 값을 가져온다
		var textareaValue = document.getElementById("RecipeMaterials").value;
		
		const lines = textareaValue.split("\n");

		// Material 객체들을 저장할 배열
		const materials = [];
	
		// 라인별로 반복하여 Material 객체 생성 후 배열에 추가
		for (const line of lines) {
  		const whatm = line.substring(1, line.indexOf("]"));
  		const elements = line.substring(line.indexOf("]")+2).split(", ");
		  
  		for (const element of elements) {
    	const mname = element.substring(0, element.lastIndexOf(" "));
    	const weigh = element.substring(element.lastIndexOf(" ")+1);
    	const material = new Material(whatm, mname, weigh);
    	materials.push(material);
  		}
		}


		console.log(materials);
		
		/*
		// HTML의 textarea에서 값을 가져온다
		var textareaValue = document.getElementById("RecipeMaterials").value;

		// 줄바꿈 문자(\n) 기준으로 문자열을 나눈다
		var materials = textareaValue.split("\n");

		// 결과를 저장할 배열을 생성한다
		var M = [];

		// 각 줄을 반복해서 처리한다
		for (var i = 0; i < materials.length; i++) 
		{
			
  		// 줄에서 대괄호([]) 안의 문자열을 whatm 변수에 저장한다
  		var whatm = materials[i].match(/\[(.*?)\]/)[1];
		
  		// 줄에서 대괄호([]) 밖의 문자열을 mnames 변수에 저장하고, 쉼표(,)를 기준으로 나눈다
  		var mnames = materials[i].match(/\](.*?)$/)[1].split(",");
		
  		// 객체를 생성해서 결과 배열에 추가한다
  		var obj = 
  		{
    		'whatm': whatm.trim(),
  		};

  		// 재료 이름과 양을 객체에 추가한다
  		for (var j = 0; j < mnames.length; j++) 
  		{
    		var mnw = mnames[j].trim().split(" ");
    		obj["mname" + (j+1)] = mnw[0];
    		obj["weigh" + (j+1)] = mnw[1];
  		}

  		// 결과 배열에 객체를 추가한다
  		M.push(obj);
  		
		}

		// 결과를 확인한다
		console.log(M);
*/



/*
		var checking = document.getElementById('RecipeMaterials').value;
		console.log('textarea : ' + checking);
		//[스테이크] 고기 10g, 후추 1/2
		//[닭갈비] 닭 100g, 고추장 500g, 우유 10L
		
		var lines = checking.split('\n');
		console.log('lines0 : ' + lines[0]); // [스테이크] 고기 10g, 후추 1/2
		console.log('lines1 : ' + lines[1]); // [닭갈비] 닭 100g, 고추장 500g, 우유 10L

		var names = [];
		var materials = [];

		for (var i = 0; i < lines.length; i++) 
		{
  			var parts = lines[i].split('['); 
  			//parts[0] = [를 기준 슬래시해서 앞부분 == ''
  			//parts[1] = 스테이크] 고기 10g, 후추 1/2
			  			
	  		var splits = parts[1].split(' ');
  			//console.log('s0 : '+splits[0]); // 스테이크] / 닭갈비]
  			//console.log('s1 : '+splits[1]); // 고기 / 닭
  			//console.log('s2 : '+splits[2]); // 10g, / 100g,
  			//console.log('s3 : '+splits[3]); // 후추 / 고추장
  			//console.log('s4 : '+splits[4]); // 1/2 / 500g,
  			//console.log('s5 : '+splits[5]); // undefined / 우유
  			//console.log('s6 : '+splits[6]); // undefined / 10L
  			
  			names.push(splits[0].slice(0, -1)); // 스테이크] => 스테이크 names배열에 저장
  			
  			
  			console.log(i);
	  		for (var j = 1; j<splits.length; j++)
			{
				if(j%2==0 & j!=splits.length-1) // 계량값들을 구하되 split을 하기위해 각 재료의 마지막계량은 제외
				{
					console.log(splits[j].slice(0, -1));
				}
			}
  		}
  		
  		console.log(names);
*/
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
		var data = { "a" : 1 };
		for (var key in data) {
        formData.append(key, data[key]);
    }
		
		console.log(formData);
		
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