import logo from './logo.svg';
import './App.css';
import api from './api/axiosConfig';
import {useState, useEffect} from 'react';

function App() {
  const [reward, setReward] = useState();
 
  const getReward = async() =>{
    try {
      const response = await api.get("/reward/customer/1");
      setReward(response.data);
    }
    catch(err){
      console.log(err);
    }
  }

  useEffect(()=> {
    getReward();
  },[])

  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
    </div>
  );
}

export default App;
