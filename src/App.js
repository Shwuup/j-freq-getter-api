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
    axios.get("http://0.0.0.0:8001/")
      .then(function (response) {
        console.log(response)
      }
    )
    return (
      <React.Fragment>
        <h1>J-FREQ-LIST-GETTER</h1>
        <input type="file" onChange={this.fileChangedHandler}/>
        <button onClick={this.uploadHandler}>Upload</button>
        <WordLister freqList={this.state.api.jlptTotal}/>
      </React.Fragment>
    );
  }
}

export default App;

function WordLister(props) {
  const freqListElement = props.freqList.map(w => 
    <li>
      Word: {w.word}<br></br>
      JLPT: {w.jlptLevel}<br></br>
      Frequency: {w.freq}
    </li>
  )
  return (
    <ol>
      {freqListElement}
    </ol>
  );
}