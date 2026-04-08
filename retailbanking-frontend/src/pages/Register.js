import { useState } from "react";
import axios from "axios";

function Register() {

  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const registerUser = async () => {

    if (!firstName || !lastName || !email || !password) {
      alert("Fill all fields");
      return;
    }

    const name = firstName + " " + lastName;

    try {

      await axios.post("http://localhost:8080/api/register", {
        name: name,
        email: email,
        password: password
      });

      alert("Registration Success");
      window.location.href = "/";

    } catch (error) {
      alert("Registration Failed");
    }
  };

  return (
    <div>

      <h2>Register</h2>

      <input
        placeholder="First Name"
        value={firstName}
        onChange={(e) => setFirstName(e.target.value)}
      />

      <br /><br />

      <input
        placeholder="Last Name"
        value={lastName}
        onChange={(e) => setLastName(e.target.value)}
      />

      <br /><br />

      <input
        placeholder="Email"
        value={email}
        onChange={(e) => setEmail(e.target.value)}
      />

      <br /><br />

      <input
        placeholder="Password"
        type="password"
        value={password}
        onChange={(e) => setPassword(e.target.value)}
      />

      <br /><br />

      <button onClick={registerUser}>Register</button>

    </div>
  );
}

export default Register;