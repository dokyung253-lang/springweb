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

// 2] 등록, 실행조건 : 등록버튼을 클릭했을 때
const onWrite = ( ) => {
    // 1. DOM객체 가져온다.
    const bcontentInput = document.querySelector('#bcontent');
    const bwriterInput = document.querySelector('#bwriter');
    // 2. 가져온 DOM객체 내 입력받은 값 꺼내기
    const bcontent = bcontentInput.value;
    const bwirter = bwriterInput.value;
    // 3. 입력받은 값으로 객체 구성
    const obj = { "bcontent" : bcontent , "bwriter" : bwriter }
    // 4. (1개월차) 배열에 저장한다 --> (3개월차) AXIOS 이용하여 서버에게 저장 요청한다.
    // 동기화 AXIOS, 1] 현재 함수 앞에 async키워드 붙인다. 2] axios 앞에 await키워드 붙인다.
    const response = await axios.post("/board", obj ) ; //axios.HTTP메소드명("통신할주소", body 본문)
    const data = response.data; // 응답값
    if(data == true){
        alert("등록성공"); 
        bcontentInput.value = ",bwriterInput.value ="; //입력상자에 입력한 값들 초기화
        onFindAll(); //** 화면 새로고침 **
        }
    else{ alert("등록실패 :관리자에게 문의");}
    }// func end

// 3] 개별 수정
const onUpdate = async(bno) => { // 1] 수정할 번호를 매개변수로 받는다.
    
    // 1) 새로운 수정할 내용 입력받ㄷ기
    const bcontent = prompt("수정할 내용");
    // 2) 객체(Body) 구성 , 속성명 대입할 변수명이 같다면 속성명 생략
    const obj = { bno, bcontent} // vs { "bno" : bno, "bcontent" : bcontent }
    // 3) axios 활용하여 서버에게 수정할 내용 요청 후 응답 받기
    const response = await axios.put("/board", obj);
    const data = response.data;
    // 4) 결과 제어
    if(data == true){
        alert("수정성공");
        onFindAll(); // **화면 새로고침**
    }else{ alert("수정실패");}
} // func end

// 4] 개별 삭제
const onDelete = async(bno) => { // 1] 삭제할 번호를 매개변수로 받는다.

    // 2] axios 활용하여 삭제할 번호를 서버에게 쿼리스트링으로 요청하고 결과를 응답받는다.
    const response = await axios.delete(`/board?bon=${bno}`);
    const data = response.data; 
    // 3] 결과에 따른 코드 제어
    if(data == true){
        alert("삭제성공");
        onFindAll(); //** 화면 새로고침 **
    }else{alert("삭제실패 : 관리자에게 문의 ");        
    }
}// f end