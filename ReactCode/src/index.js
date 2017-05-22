import React from 'react'
import { render } from 'react-dom'
import { Router, Route, IndexRedirect, hashHistory } from 'react-router'
import { Provider } from 'react-redux'

import store from './reduxFiles/store'
import App from './components/App'
import Login from './components/Login'
import Logged from './components/Logged'
import User from './components/User'
import Nav from './components/Nav'
import Patient from 'C:/Users/vikasprathap/Desktop/login-react-master/login-react-master/src/components/patient.js'

// checks if the user is logged to allow them protected url '/logged'
const authCheck = () => {
    let isLogged = store.getState().loginReducer.isLogged;
    if (!isLogged) hashHistory.push('/login');
}

render((
    <Provider store={store}>
        <Router history={hashHistory}>
            <Route path='/' component={App}>
                <IndexRedirect to='login' />
                <Route path="/login" component={Login} />
                <Route path="/logged" component={Logged} onEnter={authCheck}/>
                <Route path="/Patient" component={Patient} onEnter={authCheck}/>
                
            </Route>
        </Router>
    </Provider>
    ), document.getElementById('root'));
