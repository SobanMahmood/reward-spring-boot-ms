import './App.css';
import api from './api/axiosConfig';
import {useState, useEffect} from 'react';
import Layout from './components/Layout';
import {Routes, Route} from 'react-router-dom';
import Home from './components/home/Home';
import DataTable from 'react-data-table-component'
import "bootstrap/dist/css/bootstrap.css";

function App() {
  const [reward, setReward] = useState();
  const [customer, setCustomer] = useState();
  const [customers, setCustomers] = useState();

  const getRewardData = async (customer) => {
    try {
      const response = await api.get(`http://localhost:9001/api/v1/reward/customer/${customer.customerId}`);
      const singleReward = response.data;
      setReward(singleReward);
    }
    catch(err)
    {
      console.log(err);
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
    getRewardData(row).then((res)=>{
      setCustomer(row);
  });
}

function CustomerName(props) {
  if(props!=null && props.customer!=null){
    return <h1>#{props.customer.customerId}. {props.customer.firstName} {props.customer.lastName}</h1>;
  }
  else {
    return "";
  }
}

function TotalReward(props) {
  if(props!=null && props.reward!=null){
    return <h3>Total Reward Points: {props.reward.totalRewardPoints}</h3>;
  }
  else {
    return "";
  }
}

function MonthlyReward(props) {
  let monthlyRewardsStr = "";
  if(props!=null && props.reward!=null && props.reward.monthlyRewardPoints!=null){
    const monthlyRewardPoints = props.reward.monthlyRewardPoints;
    Object.keys(monthlyRewardPoints).forEach(function(key) {
      monthlyRewardsStr = `${monthlyRewardsStr} Rewards for ${key} = ${monthlyRewardPoints[key]}\n`
    })

    return monthlyRewardsStr.split('\n').map(str => <p>{str}</p>);
  } else {
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
      />

      <CustomerName customer={customer} />
      <TotalReward reward = {reward} />
      <MonthlyReward reward = {reward} />

      <Routes>
        <Route path="/" element={<Layout/>}>
          <Route path="/" element={<Home/>}></Route>
        </Route>
      </Routes>
    </div>
  );
}

export default App;
