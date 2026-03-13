// 삭제 기능
const deleteButton = document.getElementById('delete-btn');
if(deleteButton){
    deleteButton.addEventListener('click', event =>{
    let id = document.getElementById('article-id').value;
    fetch(`/api/articles/${id}`,{
        method: 'DELETE'
    })
    .then(() => {
        alert('삭제가 완료되었습니다.');
        location.replace('/articles');
    });
});
}

// 수정기능
// 1. id가 modify-btn인 엘리먼트 조회
const modifyButton= document.getElementById('modify-btn');
if(modifyButton){
    // 2. 클릭이벤트가 감지되면 수정 api 요청
    modifyButton.addEventListener('click', event =>{
        let params = new URLSearchParams(location.search);
        let id 
    })
}