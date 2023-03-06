// 댓글을 표시하는 함수
function showComments() {
    // localStorage에 저장된 댓글 배열을 가져옵니다.
    let comments = JSON.parse(localStorage.getItem('comments')) || [];

    // 댓글 영역의 내용을 초기화합니다.
    let commentsDiv = document.getElementById('comments');
    commentsDiv.innerHTML = '';

    // 각 댓글에 대해 HTML 요소를 생성하고, 댓글 영역에 추가합니다.
    comments.forEach(function(comment) {
        let commentDiv = document.createElement('div');
        commentDiv.classList.add('comment');

        let nameDiv = document.createElement('div');
        nameDiv.classList.add('name');
        nameDiv.innerText = comment.name;
        commentDiv.appendChild(nameDiv);

        let timestampDiv = document.createElement('div');
        timestampDiv.classList.add('timestamp');
        timestampDiv.innerText = comment.timestamp;
        commentDiv.appendChild(timestampDiv);

        let commentContentDiv = document.createElement('div');
        commentContentDiv.classList.add('comment-content');
        commentContentDiv.innerText = comment.comment;
        commentDiv.appendChild(commentContentDiv);

        commentsDiv.appendChild(commentDiv);
    });
}
