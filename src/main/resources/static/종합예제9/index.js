// 1] 전체조회, 실행조건 : js가 열렸을 때, 수정/등록/삭제 성공했을 때
const onFindAll = async ( )=> {
    // 1. 어디에 , document.querySelector( 출력할 위치 )
    const tbody = document.querySelector("#boardTable tbody");

    // 2. 무엇을 , 출력할 내용물 정의 ******** AXIOS 사용 **********
    let html = "";
        // 동기화 axios : 1. 현재 함수명 앞에 async 키워드 붙인다. 2. axois 앞에 await 키워드 붙인다.
        const response = await axios.get("/board"); // js에서 스프링Controller 와 통신기술
        console.data = response.data; // response : HTTP응답정보객체, response.data : 응답값
        for( int index = 0 ; index <= data.length-1 ; index ++ ){
        const board = data[index];
        html += `<tr>
                 </tr>`
        }
}
