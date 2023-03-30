import React, { useState } from "react";
import axios from "axios";
import './ServerTable.css';

function ServerTable({ servers, onDelete }) {
  const handleDelete = (id) => {
    axios.delete(`http://localhost:8080/servers/${id}`)
      .then((res) => {
        onDelete(id);
      })
      .catch((err) => {
        console.log(err);
      });
  };

  return (
    <div className="server-table-container">
      <table className="server-table">
        <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Language</th>
            <th>Framework</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {servers.map((server) => (
            <tr key={server.id}>
              <td>{server.id}</td>
              <td>{server.name}</td>
              <td>{server.language}</td>
              <td>{server.framework}</td>
              <td>
                <button className="delete-btn" onClick={() => handleDelete(server.id)}>Delete</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default ServerTable;
