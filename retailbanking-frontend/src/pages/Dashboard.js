import { useState } from "react";
import axios from "axios";

function Dashboard() {
  const [balance, setBalance] = useState("");
  const [amount, setAmount] = useState("");
<<<<<<< HEAD
  const [toAccount, setToAccount] = useState("");
  const [transactions, setTransactions] = useState([]);
=======
>>>>>>> 2edd4d82b118aaa9095aa9ae65d5fe80666111b3

  const token = localStorage.getItem("token");

  const getBalance = async () => {
    try {
      const res = await axios.get(
        "http://localhost:8080/api/balance/123456789",
        {
          headers: {
            Authorization: `Bearer ${token}`
          }
        }
      );
<<<<<<< HEAD
      setBalance(res.data);
=======

      setBalance(res.data);

>>>>>>> 2edd4d82b118aaa9095aa9ae65d5fe80666111b3
    } catch (error) {
      console.log(error);
    }
  };

  const depositMoney = async () => {
    try {
      await axios.put(
        "http://localhost:8080/api/deposit/123456789/" + amount,
        {},
        {
          headers: {
            Authorization: `Bearer ${token}`
          }
        }
      );

      alert("Deposit Success");
<<<<<<< HEAD
      getBalance();

    } catch (error) {
      alert("Deposit Failed");
    }
  };

  const withdrawMoney = async () => {
    try {
      await axios.put(
        "http://localhost:8080/api/withdraw/123456789/" + amount,
        {},
        {
          headers: {
            Authorization: `Bearer ${token}`
          }
        }
      );

      alert("Withdraw Success");
      getBalance();

    } catch (error) {
      alert("Insufficient Balance");
    }
  };

  const transferMoney = async () => {
    try {
      const res = await axios.put(
        "http://localhost:8080/api/transfer/123456789/" + toAccount + "/" + amount,
        {},
        {
          headers: {
            Authorization: `Bearer ${token}`
          }
        }
      );

      alert(res.data);
      getBalance();

    } catch (error) {
      alert("Transfer Failed");
    }
  };

  const getTransactions = async () => {
    try {
      const res = await axios.get(
        "http://localhost:8080/api/transactions/123456789",
        {
          headers: {
            Authorization: `Bearer ${token}`
          }
        }
      );

      setTransactions(res.data);
=======
>>>>>>> 2edd4d82b118aaa9095aa9ae65d5fe80666111b3

    } catch (error) {
      console.log(error);
    }
  };

<<<<<<< HEAD
  const logoutUser = () => {
    localStorage.removeItem("token");
    window.location.href = "/";
  };

=======
>>>>>>> 2edd4d82b118aaa9095aa9ae65d5fe80666111b3
  return (
    <div>
      <h2>Dashboard</h2>

      <button onClick={getBalance}>Check Balance</button>
      <h3>{balance}</h3>

      <input
        type="text"
        placeholder="Enter amount"
        value={amount}
<<<<<<< HEAD
        onChange={(e) => setAmount(e.target.value.replace(/[^0-9]/g, ""))}
=======
        onChange={(e) => setAmount(e.target.value)}
>>>>>>> 2edd4d82b118aaa9095aa9ae65d5fe80666111b3
      />

      <br /><br />

      <button onClick={depositMoney}>Deposit</button>
<<<<<<< HEAD

      <br /><br />

      <button onClick={withdrawMoney}>Withdraw</button>

      <br /><br />

      <input
        type="text"
        placeholder="Enter account number"
        value={toAccount}
        onChange={(e) => setToAccount(e.target.value)}
      />

      <br /><br />

      <button onClick={transferMoney}>Transfer</button>

      <br /><br />

      <button onClick={getTransactions}>Transaction History</button>

      <br /><br />

      {transactions.map((t, index) => (
        <div key={index}>
          Account: {t.accountNumber} | Type: {t.type} | Amount: {t.amount} | Time: {t.time}
        </div>
      ))}

      <br /><br />

      <button onClick={logoutUser}>Logout</button>
=======
>>>>>>> 2edd4d82b118aaa9095aa9ae65d5fe80666111b3
    </div>
  );
}

export default Dashboard;