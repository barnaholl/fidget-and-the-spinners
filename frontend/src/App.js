import React from "react";
import { BrowserRouter as Router, Route } from "react-router-dom";
import SignIn from "./pages/SignIn";
import Register from "./pages/Register";
import Main from "./pages/Main";

function App() {
  return (
    <Router>
      <div className="App">
        <Route exact path="/" component={Main} />
        <Route path="/register" component={Register} />
        <Route path="/login" component={SignIn} />
      </div>
    </Router>
  );
}

export default App;
