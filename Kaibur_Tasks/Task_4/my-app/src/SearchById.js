import React, { useState } from "react";
import axios from "axios";

import "./SearchById.css";

function SearchById() {
  const [id, setId] = useState("");
  const [server, setServer] = useState(null);

  const handleSubmit = (e) => {
    e.preventDefault();
    axios.get(`http://localhost:8080/servers/${id}`)
      .then((res) => {
        setServer(res.data);
      })
      .catch((err) => {
        console.log(err);
        setServer(null);
      });
  };

  const handleChange = (e) => {
    setId(e.target.value);
  };

  return (
    <div className="search-by-id-container">
      <h2>Search by ID</h2>
      <form className="search-by-id-form" onSubmit={handleSubmit}>
        <label className="search-by-id-label">
          Server ID:
          <input className="search-by-id-input" type="text" value={id} onChange={handleChange} />
        </label>
        <button className="search-by-id-btn" type="submit">Search</button>
      </form>
      {server ? (
        <table className="search-by-id-table">
          <thead>
            <tr>
              <th>ID</th>
              <th>Name</th>
              <th>Language</th>
              <th>Framework</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>{server.id}</td>
              <td>{server.name}</td>
              <td>{server.language}</td>
              <td>{server.framework}</td>
            </tr>
          </tbody>
        </table>
      ) : (
        <p className="search-by-id-no-results">No server found.</p>
      )}
    </div>
  );
}

export default SearchById;
