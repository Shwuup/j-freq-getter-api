import React, { Component } from "react";
import axios from "axios";
import { Dropdown, Tab } from "semantic-ui-react";
import get from "lodash/get";
import "./App.css";

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      api: {
        jlptTotal: []
      },
      selectedFile: "",
      isFetched: false,
      currentList: []
    };
  }

  fileChangedHandler = event => {
    this.setState({ selectedFile: event.target.files[0] });
  };

  dropdownHandler = (event, data) => {
    const chosenVal = get(this.state.api, data.value);
    this.setState({ currentList: chosenVal }, () => console.log(event, data));
  };

  uploadHandler = () => {
    axios
      .post("http://0.0.0.0:8001/upload", this.state.selectedFile)
      .then(response => {
        this.setState({ api: response.data, isFetched: true }, () =>
          console.log(this.state.api.jlptTotal)
        );
      });
  };

  render() {
    return (
      <React.Fragment>
        <h1 class="App-header">J-FREQ-LIST-GETTER</h1>
        <div class="File-upload">
          <input type="file" onChange={this.fileChangedHandler} />
          <button onClick={this.uploadHandler}>Upload</button>
        </div>

        <Tab
          panes={[
            {
              menuItem: "OVERALL",
              render: () => (
                <Tab.Pane>
                  <WordLister freqList={this.state.api.jlptTotal} />
                </Tab.Pane>
              )
            },
            {
              menuItem: "JLPT1",
              render: () => (
                <Tab.Pane>
                  <WordLister freqList={this.state.api.jlpt1List} />
                </Tab.Pane>
              )
            },
            {
              menuItem: "JLPT2",
              render: () => (
                <Tab.Pane>
                  <WordLister freqList={this.state.api.jlpt2List} />
                </Tab.Pane>
              )
            },
            {
              menuItem: "JLPT3",
              render: () => (
                <Tab.Pane>
                  <WordLister freqList={this.state.api.jlpt3List} />
                </Tab.Pane>
              )
            },
            {
              menuItem: "JLPT4",
              render: () => (
                <Tab.Pane>
                  <WordLister freqList={this.state.api.jlpt4List} />
                </Tab.Pane>
              )
            },
            {
              menuItem: "JLPT5",
              render: () => (
                <Tab.Pane>
                  <WordLister freqList={this.state.api.jlpt5List} />
                </Tab.Pane>
              )
            }
          ]}
          menu={{ fluid: true, vertical: true }}
          className="tab"
        />
      </React.Fragment>
    );
  }
}

export default App;

function WordLister(props) {
  const freqListElement = props.freqList.map(w => (
    <li>
      Word:{" "}
      <a href={"https://jisho.org/search/" + w.word} target="_blank">
        {w.word}
      </a>
      <br />
      Frequency: {w.freq}
      <br />
    </li>
  ));
  return <ol>{freqListElement}</ol>;
}
