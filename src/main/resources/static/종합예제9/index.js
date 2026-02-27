// 1] 전체조회, 실행조건 : js가 열렸을 때, 수정/등록/삭제 성공했을 때
const onFindAll = async ( )=> {
    // 1. 어디에 , document.querySelector( 출력할 위치 );
    const tbody = document.querySelector("#boardTable tbody");

    // 2. 무엇을 , 출력할 내용물 정의 ******** AXIOS 사용 **********
    let html = ""; // 동기화 axios : 1. 현재 함수명 앞에 async 키워드 붙인다. 2. axois 앞에 await 키워드 붙인다.
        const response = await axios.get("/board"); // js에서 스프링Controller 와 통신기술
        console.data = response.data; // response : HTTP응답정보객체, response.data : 응답값
        for( let index = 0 ; index <= data.length-1; index ++ ){
        const board = data[index];
        html += `<tr>
                    <td>${board.bno}</td>
                    <td>${board.bcontent}</td>
                    <td>${board.bwriter}</td>
                    <td>${board.bdate}</td>
                    <td>
                        <button onclick="onUpdate(${board.bno})>수정</button>
                        <button onclick="onDelete(${board.bno})>삭제</button>
                    </td>
                 </tr>`
        }
        // 3. 출력, innerHTML , 출력할 위치에 내용 대입한다.
        tbody.innerHTML = html;
}// func end
onFindAll(); // js가 열렸을 때, 전체조회 함수 호출