import React, { useState } from "react";  // Importing React and useState hook from react library
import axios from "axios";  // Importing axios library for making HTTP requests

import "./SearchById.css";  // Importing SearchById.css stylesheet

function SearchById() {  // Defining a functional component called SearchById
  const [id, setId] = useState("");  // Initializing state variable id and function setId to manage its state
  const [server, setServer] = useState(null);  // Initializing state variable server and function setServer to manage its state

  const handleSubmit = (e) => {  // Defining handleSubmit function that will run when the form is submitted
    e.preventDefault();  // Preventing the default behavior of form submission
    axios.get(`http://localhost:8080/servers/${id}`)  // Sending GET request to the server with the specified ID
      .then((res) => {  // If the request is successful, execute the following code
        setServer(res.data);  // Updating the state of server variable with the response data
      })
      .catch((err) => {  // If the request fails, execute the following code
        console.log(err);  // Logging the error to the console
        setServer(null);  // Setting the server variable to null
      });
  };

  const handleChange = (e) => {  // Defining handleChange function that will run when the input field value changes
    setId(e.target.value);  // Updating the state of id variable with the new input field value
  };

  return (  // Returning the JSX code to be rendered in the DOM
    <div className="search-by-id-container">  {/* Search by ID container */}
      <h2>Search by ID</h2>  {/* Heading */}
      <form className="search-by-id-form" onSubmit={handleSubmit}>  {/* Form with onSubmit event listener */}
        <label className="search-by-id-label">  {/* Label for the input field */}
          Server ID:
          <input className="search-by-id-input" type="text" value={id} onChange={handleChange} />  {/* Input field for server ID */}
        </label>
        <button className="search-by-id-btn" type="submit">Search</button>  {/* Submit button */}
      </form>
      {server ? (  // Conditional rendering based on the state of server variable
        <table className="search-by-id-table">  {/* Table to display server details */}
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

export default SearchById;  // Exporting the SearchById component for use in other parts of the application

