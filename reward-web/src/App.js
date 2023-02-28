import logo from './logo.svg';
import './App.css';
import api from './api/axiosConfig';
import {useState, useEffect} from 'react';
import Layout from './component/Layout';
import {Routes, Route} from 'react-router-dom';
import Home from './component/home/Home';

function App() {
  const [rewards, setRewards] = useState();
  const [reward, setReward] = useState();
 
  const getRewards = async() =>{
    try {
      const response = await api.get("/reward/customer/1");
      setRewards(response.data);
    }
    catch(err){
      console.log(err);
    }
  }

  const getRewardData = async (cutomerId) => {
    try {
      const response = await api.get('reward/customer/${customerId}');
      const singleReward = response.data;
      setReward(singleReward);
    }
    catch(err)
    {

    }
  }

  useEffect(()=> {
    getRewards();
  },[])

  return (
    <div className="App">
      
      <Routes>
        <Route path="/" element={<Layout/>}>
          <Route path="/" element={<Home/>}></Route>
        </Route>
      </Routes>

    </div>
  );
}

export default App;
