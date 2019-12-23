import React, { Component } from "react";
import axios from "axios";
import {
  Container,
  Tab,
  Button,
  Header,
  Segment,
  Icon,
  Grid
} from "semantic-ui-react";
import "./App.css";
import {
  BarChart,
  Bar,
  XAxis,
  YAxis,
  Tooltip,
  ResponsiveContainer
} from "recharts";

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
      isSelected: false,
      fileName: "",
      isFetched: false
    };
  }
  fileInputRef = React.createRef();

  fileChangedHandler = event => {
    this.setState({
      selectedFile: event.target.files[0],
      fileName: event.target.files[0].name,
      isSelected: true
    });
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
          <ResponsiveContainer width={"99%"} height={300}>
            <BarChart
              data={this.state.api[name.toLowerCase()]}
              margin={{
                top: 5,
                right: 40,
                left: 10,
                bottom: 5
              }}
            >
              <XAxis dataKey="word" />
              <YAxis />
              <Tooltip />
              <Bar dataKey="freq" fill="#8884d8" />
            </BarChart>
          </ResponsiveContainer>
        </Tab.Pane>
      )
    }));

    return (
      <Grid>
        <Grid.Column>
          <Container>
            <h1 className="App-header">J-VOCAB-FREQ-GETTER</h1>
            {!this.state.isFetched && (
              <h3 style={{ textAlign: "center" }}>
                To get started, please enter a japanese text file to upload{" "}
              </h3>
            )}

            <FileUploader
              inputRef={this.fileInputRef}
              upload={this.uploadHandler}
              onClick={this.fileChangedHandler}
              isSelected={this.state.isSelected}
              name={this.state.fileName}
            ></FileUploader>

            {this.state.isFetched && (
              <Tab
                panes={transformed}
                menu={{ fluid: true, vertical: true }}
                className="tab"
              />
            )}
          </Container>
        </Grid.Column>
      </Grid>
    );
  }
}

export default App;

const WordLister = props => {
  const freqListElement = props.freqList.map(w => (
    <li key={w.word.toString()}>
      Word:{" "}
      <a
        href={"https://jisho.org/search/" + w.word}
        target="_blank"
        rel="noopener noreferrer"
      >
        {w.word}
      </a>
      <br />
      Frequency: {w.freq}
      <br />
    </li>
  ));
  return <ol>{freqListElement}</ol>;
};

const FileUploader = props => {
  let text;
  if (props.isSelected) {
    text = props.name;
  } else {
    text = "No file selected";
  }

  return (
    <Segment className="grouping" placeholder>
      <React.Fragment>
        <Header icon>
          <Icon name="file alternate outline" />
          {text}
        </Header>
        <Button
          className="add-button"
          onClick={() => props.inputRef.current.click()}
        >
          Add file
        </Button>

        {props.isSelected && (
          <Button primary onClick={props.upload}>
            Upload
          </Button>
        )}
      </React.Fragment>

      <input
        ref={props.inputRef}
        type="file"
        hidden
        accept=".txt"
        onChange={props.onClick}
      />
    </Segment>
  );
};
