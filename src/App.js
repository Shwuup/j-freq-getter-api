import React, { Component } from 'react';
import './App.css';
import axios from 'axios';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      api: "",
      selectedFile: "",
    }
  }

  fileChangedHandler = (event) => {
    this.setState({selectedFile: event.target.files[0]})
  }

  uploadHandler = () => {
    axios.post("http://0.0.0.0:8001/upload", this.state.selectedFile)
      .then(function (response) {
        this.setState({api: response})
      })
  }

  render() {
    const apiCall = 
    axios.get("http://0.0.0.0:8001/")
      .then(function (response) {
        console.log(response)
      }
    )

    return (
      <React.Fragment>
        <input type="file" onChange={this.fileChangedHandler}/>
        <button onClick={this.uploadHandler}>Upload</button>
      </React.Fragment>
    );
  }
}

export default App;
