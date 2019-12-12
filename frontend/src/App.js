import React, { Component } from "react";
import axios from "axios";
import { Container, Tab } from "semantic-ui-react";
import "./App.css";
import {
  BarChart, Bar, Cell, XAxis, YAxis, CartesianGrid, Tooltip, Legend,
} from 'recharts';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      api: {
        jlptTotal: [],
        jlpt1: [],
        jlpt2: [],
        jlpt3: [],
        jlpt4: [],
        jlpt5: []
      },
      selectedFile: "",
      isFetched: false,
    };
  }



  fileChangedHandler = event => {
    this.setState({ selectedFile: event.target.files[0] });
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
    const names = ["JLPT1", "JLPT2", "JLPT3", "JLPT4", "JLPT5"];
    const transformed = names.map(name => ({
      menuItem: name,
      render: () => (
        <Tab.Pane>
          <WordLister freqList={this.state.api[name.toLowerCase()]} />
          <BarChart
            width={700}
            height={400}
            data={this.state.api[name.toLowerCase()]}
            margin={{
              top: 5, right: 40, left: 10, bottom: 5,
            }}
          >

            <XAxis dataKey="word" />
            <YAxis />
            <Tooltip />
            <Bar dataKey="freq" fill="#8884d8" />
          </BarChart>
        </Tab.Pane>
      )
    }))

    return (
      <React.Fragment>
        <h1 class="App-header">J-FREQ-LIST-GETTER</h1>
        <Container>
          {!this.state.isFetched &&
            <h3 style={{ textAlign: "center" }}>Please enter a japanese text file to upload: </h3>

          }

          <div class="File-upload">
            <input type="file" onChange={this.fileChangedHandler} />
            <button onClick={this.uploadHandler}>Upload</button>
          </div>

          {this.state.isFetched &&
            <Tab
              panes={transformed}
              menu={{ fluid: true, vertical: true }}
              className="tab"
            />
          }



        </Container>

      </React.Fragment>

    );
  }
}

export default App;

function WordLister(props) {
  const freqListElement = props.freqList.map(w => (
    <li>
      Word:{" "}
      <a href={"https://jisho.org/search/" + w.word} target="_blank" rel="noopener noreferrer">
        {w.word}
      </a>
      <br />
      Frequency: {w.freq}
      <br />
    </li>
  ));
  return <ol>{freqListElement}</ol>;
}


