// custome code   

import React, { useState } from "react";
import axios from "axios";
import {
  Typography,
  TextField,
  Button,
  Paper,
  Box,
} from "@mui/material";
import { useNavigate } from "react-router-dom";

const initial = { postId: "", postProfile: "", reqExperience: 0, postTechStack: [], postDesc: "" };

const Create = () => {
  const skillSet = [
    { name: "Javascript" },
    { name: "Java" },
    { name: "Python" },
    { name: "Django" },
    { name: "Rust" }
  ];

  const navigate = useNavigate();
  const [form, setForm] = useState(initial);

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await axios.post("http://localhost:8082/jobPost", form);
      navigate("/");
    } catch (error) {
      console.error('Error submitting form:', error);
    }
  };

  const { postId, postProfile, reqExperience, postDesc } = form;

  const handleChange = (e) => {
    const { value, checked } = e.target;
    setForm((prevForm) => ({
      ...prevForm,
      postTechStack: checked
        ? [...prevForm.postTechStack, value]
        : prevForm.postTechStack.filter((tech) => tech !== value),
    }));
  };

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setForm({ ...form, [name]: value });
  };

  return (
    <Paper sx={{ padding: "1%" }} elevation={0}>
      <Typography sx={{ margin: "3% auto" }} align="center" variant="h5">
        Create New Post
      </Typography>
      <form autoComplete="off" noValidate onSubmit={handleSubmit}>
        <Box
          sx={{
            display: "flex",
            justifyContent: "center",
            flexDirection: "column",
          }}
        >
          <TextField
            min="0"
            type="number"
            sx={{ width: "50%", margin: "2% auto" }}
            onChange={handleInputChange}
            name="postId"
            label="Enter your Post ID"
            variant="outlined"
            value={postId}
          />
          <TextField
            type="string"
            sx={{ width: "50%", margin: "2% auto" }}
            required
            onChange={handleInputChange}
            name="postProfile"
            label="Job-Profile"
            variant="outlined"
            value={postProfile}
          />
          <TextField
            min="0"
            type="number"
            sx={{ width: "50%", margin: "2% auto" }}
            required
            onChange={handleInputChange}
            name="reqExperience"
            label="Years of Experience"
            variant="outlined"
            value={reqExperience}
          />
          <TextField
            type="string"
            sx={{ width: "50%", margin: "2% auto" }}
            required
            multiline
            rows={4}
            onChange={handleInputChange}
            name="postDesc"
            label="Job-desc"
            variant="outlined"
            value={postDesc}
          />
          <Box sx={{ margin: "1% auto" }}>
            <h3>Please mention required skills</h3>
            <ul>
              {skillSet.map(({ name }, index) => (
                <li key={index}>
                  <div>
                    <div>
                      <input
                        type="checkbox"
                        id={`custom-checkbox-${index}`}
                        name={name}
                        value={name}
                        onChange={handleChange}
                        checked={form.postTechStack.includes(name)}
                      />
                      <label htmlFor={`custom-checkbox-${index}`}>{name}</label>
                    </div>
                  </div>
                </li>
              ))}
            </ul>
          </Box>
          <Button
            sx={{ width: "50%", margin: "2% auto" }}
            variant="contained"
            type="submit"
          >
            Submit
          </Button>
        </Box>
      </form>
    </Paper>
  );
};

export default Create;
