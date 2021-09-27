import React from "react";
import ReactDOM from "react-dom";
import { Provider } from "react-redux";
import { BrowserRouter, Route, Switch, Redirect } from "react-router-dom";



import "bootstrap/dist/css/bootstrap.min.css";
import "./assets/css/animate.min.css";
import "./assets/scss/light-bootstrap-dashboard-react.scss?v=2.0.0";
import "./assets/css/demo.css";
import "@fortawesome/fontawesome-free/css/all.min.css";

import AdminLayout from "layouts/Admin.js";

import {ConnectedRouter} from 'connected-react-router';
import {routerMiddleware, connectRouter} from 'connected-react-router';
import { createLogger } from "redux-logger";
import thunk from "redux-thunk";
import promise from "redux-promise-middleware";
import rootReducer from 'RootReducer';
import { createBrowserHistory } from "history";
import {createStore, compose, applyMiddleware} from 'redux';

const history = createBrowserHistory();
const composeEnhancer = window.__REDUX_DEVTOOLS_COMPOSE__ || compose;
const middleWare = composeEnhancer(applyMiddleware(routerMiddleware(history), promise(), thunk, createLogger()))

const store = createStore(
  connectRouter(history)(rootReducer), middleWare
);

ReactDOM.render(
  <Provider store={store}>
    <ConnectedRouter history={history}>
      <Switch>
        <Route path="/admin" render={(props) => <AdminLayout {...props} />} />
        <Redirect from="/" to="/admin/dashboard" />
      </Switch>
    </ConnectedRouter>
  </Provider>,
  document.getElementById("root")
);

export { store }