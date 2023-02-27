function submitForm() {
  var form = document.getElementById('test');
  var formData = new FormData(form);
  var materials = [];

  for (var i = 1; i <= 2; i++) {
    var mname = formData.get('mname' + i);
    var material = { mname : mname };
    materials.push(material);
    
  }

  var data = { materials : materials };

  $.ajax({
      type : 'post',
      url : '/test/test',  
      data : JSON.stringify(data),
      contentType: 'application/json',
      cache : false,
      timeout : 600000,
      success : function(res)
      {
        alert(res)
        alert(res.added?'성공':'실패')
      },
      error : function(e)
      {
              alert('fail');
      }
    })
}
