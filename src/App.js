import React, { Component } from 'react';
import './App.css';
import axios from 'axios';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      api: {
        jlptTotal: []
      },
      test: "",
      selectedFile: "",
    }
  }

  fileChangedHandler = (event) => {
    this.setState({selectedFile: event.target.files[0]})
  }

  uploadHandler = () => {
    axios.post("http://0.0.0.0:8001/upload", this.state.selectedFile)
      .then(response => {
        this.setState({ api: response.data }, () => 
          console.log(
            this.state.api.jlptTotal
        ));
      });
  }

  render() {
    let jlpt = this.state.api.jlptTotal
    axios.get("http://0.0.0.0:8001/")
      .then(function (response) {
        console.log(response)
      }
    )
    return (
      <React.Fragment>
        <input type="file" onChange={this.fileChangedHandler}/>
        <button onClick={this.uploadHandler}>Upload</button>
        <WordLister freqList={this.state.api.jlptTotal}/>
      </React.Fragment>
    );
  }
}

export default App;

function WordLister(props) {
  return (
    <div>
      {props.freqList.map((w, index) => 
      <h1>
        {index + 1}. Word: {w.word} <br/> JLPT Level: {w.jlptLevel} <br/> Frequency: {w.freq}
      </h1>)}
    </div>
  );
}