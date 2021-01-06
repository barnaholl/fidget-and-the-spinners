import React from "react";
import ReactDOM from "react-dom";
import App from "./App";
// import Copyright from "./components/Copyright";
import reportWebVitals from "./reportWebVitals";

ReactDOM.render(
  <React.StrictMode>
    <App />
    {/* <Copyright /> */}
  </React.StrictMode>,
  document.getElementById("root")
);
reportWebVitals();
