import React, { useState, useEffect } from "react";
import axios from "axios";
import ServerForm from "./ServerForm";
import ServerTable from "./ServerTable";
import SearchById from "./SearchById";
import SearchByName from "./SearchByName";
import "./App2.css"

function App() {
  const [servers, setServers] = useState([]); // Set state variable for servers
  const [message, setMessage] = useState(""); // Set state variable for message

  useEffect(() => {
    // GET request to retrieve all servers
    axios.get("http://localhost:8080/servers")
      .then((res) => {
        setServers(res.data); // Update state variable with server data
      })
      .catch((err) => {
        console.log(err); // Log any errors to the console
      });
  }, []);

  const handleSearchById = (id) => {
    // GET request to search for a server by ID
    axios.get(`http://localhost:8080/servers/${id}`)
      .then((res) => {
        setServers(res.data); // Update state variable with server data
      })
      .catch((err) => {
        console.log(err); // Log any errors to the console
      });
  };

  const handleSearchByName = (name) => {
    // GET request to search for a server by name
    axios.get(`http://localhost:8080/servers?name=${name}`)
      .then((res) => {
        setServers(res.data); // Update state variable with server data
      })
      .catch((err) => {
        console.log(err); // Log any errors to the console
      });
  };

  const handleCreateServer = (server) => {
    // POST request to create a new server
    axios.post("http://localhost:8080/servers", server)
      .then((res) => {
        setServers([...servers, res.data]); // Add new server to the state variable
        setMessage("Server created successfully!"); // Update message state variable
      })
      .catch((err) => {
        console.log(err); // Log any errors to the console
      });
  };

  const handleDelete = (id) => {
    setServers((prevServers) => prevServers.filter((server) => server.id !== id)); // Update state variable with new array of servers after deleting a server
  };

  return (
    <div>
      <h1>Kaiburr Task 4 - UI</h1>

      <ServerForm onServerCreated={handleCreateServer} />
      {message && <p>{message}</p>}
      <SearchById onSubmit={handleSearchById} />
      <SearchByName onSubmit={handleSearchByName} />
      <ServerTable servers={servers} onDelete={handleDelete} />
    </div>
  );
}

export default App;
/* Code Written by @Arpit Singh 19BCG10069 */


