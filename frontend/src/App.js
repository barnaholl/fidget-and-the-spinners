import React from "react";
import { BrowserRouter as Router, Route } from "react-router-dom";
import Login from "./pages/Login";
import Register from "./pages/Register";
import CharacterCreation from "./pages/CharacterCreation";
import "./App.css";
import Landing from "./pages/Landing";
import Grid from "@material-ui/core/Grid";
import Character from "./pages/Character";
import Kitchen from "./pages/Kitchen";

function App() {
  return (
    <Router>
      <div className="background-image"></div>
      <div className="App">
        <Route exact path="/" component={Landing} />
        <Route exact path="/register" component={Register} />
        <Route path="/login" component={Login} />
        <Route
          exact
          path="/username/character-creation"
          component={CharacterCreation}
        />
        <Route path="/character" component={Character}/>
        <Route path="/kitchen" component={Kitchen}/>
      </div>
    </Router>
  );
}

export default App;
