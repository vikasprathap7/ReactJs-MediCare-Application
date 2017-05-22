import React from 'react';
  import { Link } from 'react-router';
  import Login from 'C:/Users/vikasprathap/Desktop/login-react-master/login-react-master/src/components/Login.js'
import Logged from 'C:/Users/vikasprathap/Desktop/login-react-master/login-react-master/src/components/Logged.js'
import User from 'C:/Users/vikasprathap/Desktop/login-react-master/login-react-master/src/components/User.js'

  export default class Nav extends React.Component {
    render() {    
      return (
        <nav className="login_wrapper">
          <div className="login_wrapper">
            <Link to="/" className="login_wrapper">
              <img src="1.jpg" className="login_wrapper" />
            </Link>

            <div className="login_wrapper">
              <ul className="login_wrapperr">
                <li className="login_wrapper">
                  <Link className="login_wrapper" to="/Login">Link 1</Link>
                </li>
                <li className="login_wrapper">
                  <Link className="login_wrapper" to="/Logged">Link 2</Link>
                </li>
                <li className="login_wrapper">
                  <Link className="login_wrapper" to="/User">Link 3</Link>
                </li>
              </ul>
            </div>
          </div>
        </nav>
      );
    }
  }