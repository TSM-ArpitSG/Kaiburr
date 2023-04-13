import React, { useState } from "react";  // import necessary modules
import axios from "axios";
import "./SearchByName.css"  // import CSS file

function SearchByName() {
  const [name, setName] = useState("");  // state to keep track of input field value
  const [servers, setServers] = useState([]);  // state to keep track of filtered servers

  const handleSubmit = (e) => {  // function to handle form submission
    e.preventDefault();
    axios.get(`http://localhost:8080/servers?name=${name}`)  // send GET request to server
      .then((res) => {
        const filteredServers = res.data.filter(server => server.name.toLowerCase().includes(name.toLowerCase()));  // filter servers based on input field value
        setServers(filteredServers);  // set state with filtered servers
      })
      .catch((err) => {
        console.log(err);
      });
  };

  const handleChange = (e) => {  // function to handle input field change
    setName(e.target.value);  // update state with new input value
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

/* Code Written by @Arpit Singh 19BCG10069 */