import { Route, Routes } from "react-router-dom";
import TopNavi from "./components/TopNavi";
import LifeCycle from "./components/LifeCycle";
import LocalJsonFetcher from "./components/LocalJsonFetcher";
import ExternalApiFetcher from "./components/ExternalApiFetcher";


export default function App( props ){
    return(<>
        <TopNavi></TopNavi>
        <Routes>
            <Route path="/" element={ <LifeCycle/> }></Route>
            <Route path="/local" element={ <LocalJsonFetcher /> }></Route>
            <Route path="/external" element={ <ExternalApiFetcher />}></Route>
        </Routes>
    </>)
}