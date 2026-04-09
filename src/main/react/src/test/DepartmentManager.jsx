import axios from "axios";
import React, { useEffect, useState } from "react";

export default function DepartmentManager() {
  
  // [1] 부서 등록
  const departmentPost = async (e) => {
    e.preventDefault();
    let dname = e.target.dname.value;
    let obj = { dname }//vs let obj = { dname }  // 객체의 속성명과 변수명이 같으면 하나로 줄일 수 있다.
    const response = await axios.post("http://localhost:8080/api/department/create", obj);
    const data = response.data;
    if(data == true){
      alert("부서 등록 성공")
    }
    else{
      alert("부서 등록 실패")
    }
  };

  // [2] 부서 전체 조회
  const[ departmentlist, Setdepartmentlist ] = useState([]);

  const findAll = async() =>{
    try{
      const response = await axios.get("http://localhost:8080/api/department/read");
      const data = response.data;
      Setdepartmentlist(data);
    }catch(e){console.log(e)}
  }
  useEffect( () => {findAll();}, [])


  return (
    <div className="sidebar">
      <h3>부서 관리</h3>

      <form onSubmit={departmentPost} className="dept-input">
        <input name="dname" type="text" placeholder="신규 부서명 입력" />
        <button type="submit">추가</button>
      </form>

      <table className="dept-table">
        <thead>
          <tr>
            <th>부서명</th>
            <th>관리</th>
          </tr>
        </thead>
        <tbody>
          {departmentlist.map( department => {
          return (
          <tr key={department.dno}>
            <td>{department.dname}</td>
            <td>
              <span className="edit">수정</span>
              <span className="delete">삭제</span>
            </td>
          </tr>
          )
        })}
        </tbody>
      </table>
    </div>
  );
}