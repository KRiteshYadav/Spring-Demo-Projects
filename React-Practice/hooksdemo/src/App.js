import React,{useState,useEffect} from 'react';
import './App.css';

function App() {
  let [stock,setStock] = useState({});

  useEffect(()=>
  {
    async function fetchData()
    {
      const response = await fetch('https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=MSFT&interval=5min&apikey=S9C3XDXUHXF2Q4BB');
      const data = await response.json();
      setStock(data);
    }
    fetchData();
  },[stock['Time Series (5min)']])
  return (
    <div className="App">
      {
        console.log(stock?stock:"Not Yet")
      }
    </div>
  );
}

export default App;
