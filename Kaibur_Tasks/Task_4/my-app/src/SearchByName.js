import React, { useState } from "react";
import axios from "axios";
import "./SearchByName.css"
function SearchByName() {
  const [name, setName] = useState("");
  const [servers, setServers] = useState([]);

  const handleSubmit = (e) => {
    e.preventDefault();
    axios.get(`http://localhost:8080/servers?name=${name}`)
      .then((res) => {
        const filteredServers = res.data.filter(server => server.name.toLowerCase().includes(name.toLowerCase()));
        setServers(filteredServers);
      })
      .catch((err) => {
        console.log(err);
      });
  };

  const handleChange = (e) => {
    setName(e.target.value);
  };

  return (
    <div className="search-by-name-container">
      <h2>Search by Name</h2>
      <form onSubmit={handleSubmit}>
        <label>
          Server Name:
          <input type="text" value={name} onChange={handleChange} className="search-input" />
        </label>
        <button type="submit" className="search-button">Search</button>
      </form>
      {servers.length > 0 ? (
        <table className="server-table">
          <thead>
            <tr>
              <th>ID</th>
              <th>Name</th>
              <th>Language</th>
              <th>Framework</th>
            </tr>
          </thead>
          <tbody>
            {servers.map((server) => (
              <tr key={server.id}>
                <td>{server.id}</td>
                <td>{server.name}</td>
                <td>{server.language}</td>
                <td>{server.framework}</td>
              </tr>
            ))}
          </tbody>
        </table>
      ) : (
        <p className="no-server">No servers found.</p>
      )}
    </div>
  );
}

export default SearchByName;

