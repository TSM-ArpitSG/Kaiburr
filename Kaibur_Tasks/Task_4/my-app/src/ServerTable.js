// Importing React, useState hook for managing state, and axios for making HTTP requests
import React, { useState } from "react";
import axios from "axios";
import './ServerTable.css'; // Importing CSS styles for the component

// ServerTable component takes 'servers' and 'onDelete' as props
function ServerTable({ servers, onDelete }) {

  // Function to handle delete button click event
  const handleDelete = (id) => {
    axios.delete(`http://localhost:8080/servers/${id}`) // Making a DELETE request to the server API
      .then((res) => {
        onDelete(id); // Call the 'onDelete' prop function with the deleted server's id
      })
      .catch((err) => {
        console.log(err); // Log any errors to the console
      });
  };

  // The component returns a table with server details and a delete button for each server
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
          {/* Map through each server object and render a table row */}
          {servers.map((server) => (
            <tr key={server.id}>
              <td>{server.id}</td>
              <td>{server.name}</td>
              <td>{server.language}</td>
              <td>{server.framework}</td>
              <td>
                {/* Render a delete button with the handleDelete function */}
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

// Code Written by @Arpit Singh - 19BCG10069