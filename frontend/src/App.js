import React from "react";
import { BrowserRouter as Router, Route } from "react-router-dom";
import SignIn from "./pages/SignIn";
import Register from "./pages/Register";

function App() {
  return (
    <Router>
      <div className="App">
        <Route path="/register" component={Register} />
        <Route path="/login" component={SignIn} />
      </div>
    </Router>
  );
}

export default App;
