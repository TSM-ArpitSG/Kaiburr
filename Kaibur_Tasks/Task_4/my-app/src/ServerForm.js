import React, { useState } from "react"; // import React and useState hook from react library
import axios from "axios"; // import axios for making API requests
import "./ServerForm.css"; // import CSS styles for this component

function ServerForm({ onServerCreated }) { // define ServerForm component that takes onServerCreated prop
  const [server, setServer] = useState({ // set up state using the useState hook
    id: "",
    name: "",
    language: "",
    framework: "",
  });
  const [message, setMessage] = useState(""); // set up another piece of state for displaying messages

  const handleSubmit = (e) => { // define a function to handle form submissions
    e.preventDefault(); // prevent the default form submission behavior
    axios // use axios to make a POST request to the server API
      .post("http://localhost:8080/servers", server) // specify the URL and data to send
      .then((res) => { // if the request is successful
        onServerCreated(res.data); // call the onServerCreated callback with the data returned by the server
        setMessage("Server created successfully!"); // set a success message to display to the user
        setServer({ // reset the form inputs
          id: "",
          name: "",
          language: "",
          framework: "",
        });
      })
      .catch((err) => { // if there's an error
        console.log(err); // log the error to the console
      });
  };

  const handleChange = (e) => { // define a function to handle changes to form inputs
    const { name, value } = e.target; // get the name and value of the input that triggered the event
    setServer((prevState) => ({ // update the server state with the new value for the input that changed
      ...prevState,
      [name]: value,
    }));
  };

  return ( // return a form with input fields and a submit button
    <form className="server-form">
      <h2 className="server-form__title">Create a Server Object</h2>
      <div className="server-form__group">
        <label className="server-form__label" htmlFor="id-input">
          Server ID:
        </label>
        <input
          className="server-form__input"
          type="text"
          id="id-input"
          name="id"
          value={server.id}
          onChange={handleChange}
        />
      </div>
      <div className="server-form__group">
        <label className="server-form__label" htmlFor="name-input">
          Server Name:
        </label>
        <input
          className="server-form__input"
          type="text"
          id="name-input"
          name="name"
          value={server.name}
          onChange={handleChange}
        />
      </div>
      <div className="server-form__group">
        <label className="server-form__label" htmlFor="language-input">
          Language:
        </label>
        <input
          className="server-form__input"
          type="text"
          id="language-input"
          name="language"
          value={server.language}
          onChange={handleChange}
        />
      </div>
      <div className="server-form__group">
        <label className="server-form__label" htmlFor="framework-input">
          Framework:
        </label>
        <input
          className="server-form__input"
          type="text"
          id="framework-input"
          name="framework"
          value={server.framework}
          onChange={handleChange}
        />
      </div>
      <button className="server-form__submit" type="submit" onClick={handleSubmit}>
        Create
      </button>
      {message && <p className="server-form__message">{message}</p>}
    </form>
  );
}

export default ServerForm;

// Code Written by @Arpit Singh 19BCG10069
