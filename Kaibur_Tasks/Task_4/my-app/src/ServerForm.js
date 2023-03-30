import React, { useState } from "react";
import axios from "axios";
import "./ServerForm.css";

function ServerForm({ onServerCreated }) {
  const [server, setServer] = useState({
    id: "",
    name: "",
    language: "",
    framework: "",
  });
  const [message, setMessage] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();
    axios
      .post("http://localhost:8080/servers", server)
      .then((res) => {
        onServerCreated(res.data);
        setMessage("Server created successfully!");
        setServer({
          id: "",
          name: "",
          language: "",
          framework: "",
        });
      })
      .catch((err) => {
        console.log(err);
      });
  };

  const handleChange = (e) => {
    const { name, value } = e.target;
    setServer((prevState) => ({
      ...prevState,
      [name]: value,
    }));
  };

  return (
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


