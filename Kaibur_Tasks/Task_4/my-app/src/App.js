import React, { useState, useEffect } from "react";
import axios from "axios";
import ServerForm from "./ServerForm";
import ServerTable from "./ServerTable";
import SearchById from "./SearchById";
import SearchByName from "./SearchByName";
import "./App2.css"

function App() {
  const [servers, setServers] = useState([]);
  const [message, setMessage] = useState("");

  useEffect(() => {
    // GET request to retrieve all servers
    axios.get("http://localhost:8080/servers")
      .then((res) => {
        setServers(res.data);
      })
      .catch((err) => {
        console.log(err);
      });
  }, []);

  const handleSearchById = (id) => {
    // GET request to search for a server by ID
    axios.get(`http://localhost:8080/servers/${id}`)
      .then((res) => {
        setServers(res.data);
      })
      .catch((err) => {
        console.log(err);
      });
  };

  const handleSearchByName = (name) => {
    // GET request to search for a server by name
    axios.get(`http://localhost:8080/servers?name=${name}`)
      .then((res) => {
        setServers(res.data);
      })
      .catch((err) => {
        console.log(err);
      });
  };

  const handleCreateServer = (server) => {
    // POST request to create a new server
    axios.post("http://localhost:8080/servers", server)
      .then((res) => {
        setServers([...servers, res.data]);
        setMessage("Server created successfully!");
      })
      .catch((err) => {
        console.log(err);
      });
  };

  const handleDelete = (id) => {
    setServers((prevServers) => prevServers.filter((server) => server.id !== id));
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



