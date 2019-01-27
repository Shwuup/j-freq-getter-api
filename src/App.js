import React, { Component } from 'react';
import axios from 'axios';
import { Dropdown, DropdownItem } from 'semantic-ui-react'
import _ from 'lodash';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      api: {
        jlptTotal: []
      },
      selectedFile: "",
      isFetched: false,
      currentList: [],
      currentListName: "",
    }
  }

  fileChangedHandler = (event) => {
    this.setState({selectedFile: event.target.files[0]})
  }

  dropdownHandler = (event, data) => {
    const chosenVal = _.get(this.state.api, data.value)
    this.setState({ currentList: chosenVal, currentListName: data.text}, () => 
      console.log(
        event,data
      ))
  }

  uploadHandler = () => {
    axios.post("http://0.0.0.0:8001/upload", this.state.selectedFile)
      .then(response => {
        this.setState({ api: response.data, isFetched: true }, () => 
          console.log(
            this.state.api.jlptTotal
        ));
      });
  }

  render() {
    return (
      <React.Fragment>
        <h1>J-FREQ-LIST-GETTER</h1>
        <input type="file" onChange={this.fileChangedHandler}/>
        <button onClick={this.uploadHandler}>Upload</button>
        {this.state.isFetched &&
          <Dropdown 
          placeholder='select level' 
          fluid 
          selection 
          onChange={this.dropdownHandler}
          options={
            [
              {text: 'JLPT1', 
              value: 'jlpt1List'},
              {text: 'JLPT2', 
              value: 'jlpt2List'},
              {text: 'JLPT3', 
              value: 'jlpt3List'},
              {text: 'JLPT4', 
              value: 'jlpt4List'},
              {text: 'JLPT5', 
              value: 'jlpt5List'},
              {text: 'OVERALL', 
              value: 'jlptTotal'}
              ]}
              />}
        <WordLister freqList={this.state.currentList} name={this.state.currentListName}/>
      </React.Fragment>
    );
  }
}

export default App;

function WordLister(props) {
  const freqListElement = props.freqList.map(w => 
    <li>
      Word: {w.word}<br></br>
      Frequency: {w.freq}
    </li>
  )
  return (
    <ol>
      {freqListElement}
    </ol>
  );
}