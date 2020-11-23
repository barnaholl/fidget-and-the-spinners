import React from "react";
import { BrowserRouter as Router, Route } from "react-router-dom";
import Login from "./pages/Login";
import Register from "./pages/Register";
import Main from "./pages/Main";
import CharacterCreation from "./pages/CharacterCreation";

function App() {
  return (
    <Router>
      <div className="App">
        <Route exact path="/" component={Main} />
        <Route exact path="/register" component={Register} />
        <Route path="/login" component={Login} />
        <Route
          path="/register/character-creation"
          component={CharacterCreation}
        />
      </div>
    </Router>
  );
}

export default App;
