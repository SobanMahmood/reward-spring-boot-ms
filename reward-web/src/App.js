import logo from './logo.svg';
import './App.css';
import api from './api/axiosConfig';
import {useState, useEffect} from 'react';
import Layout from './components/Layout';
import {Routes, Route} from 'react-router-dom';
import Home from './components/home/Home';
//import Customer from './components/customer/Customer';
import DataTable from 'react-data-table-component'
import { Modal, Button } from "react-bootstrap";
import "bootstrap/dist/css/bootstrap.css";

function App() {
  const [reward, setReward] = useState();
  const [customers, setCustomers] = useState();

  const getRewardData = async (customer) => {
    try {
      const response = await api.get(`http://localhost:9001/api/v1/reward/customer/${customer.customerId}`);
      const singleReward = response.data;
      setReward(singleReward);
    }
    catch(err)
    {

    }
  }

  const getCustomers = async() =>{
    try {
      const response = await api.get("http://localhost:9003/api/v1/customers");
      setCustomers(response.data);
      console.log(response.data);
    }
    catch(err){
      console.log(err);
    }
  }

const columns = [
  {
    name: "Customer ID",
    selector: (row) => row.customerId,
  },
  {
    name: "First Name",
    selector: (row) => row.firstName,
  },
  {
    name: "Last Name",
    selector: (row) => row.lastName,
  },
]

const modalClickHandler  = row => {
 // this.setState({notebookDisplayOpen: true});
  console.log("HEYYYYYYYYYYYYYYYYYYY");
  console.log(row.customerId);
  getRewardData(row).then((res)=>{

    console.log(reward);
  });
}

function TotalReward(props) {
  if(props!=null && props.reward!=null){
  return <h1>#{props.reward.customerId} Total Reward Points: {props.reward.totalRewardPoints}</h1>;
  }
  else {
    return "";
  }
}

  useEffect(()=> {
    getCustomers();
  },[])

  return (
    <div className="App">
  
  

      <DataTable
        title="Customers"
        columns={columns}
        data={customers}
        pagination
        onRowClicked={modalClickHandler}
        Clicked
        //Selected={handleChange}
      />

      <TotalReward reward = {reward} />
<Routes>
        <Route path="/" element={<Layout/>}>
          <Route path="/" element={<Home/>}></Route>
        </Route>
      </Routes>
     

    </div>
  );
}

export default App;
