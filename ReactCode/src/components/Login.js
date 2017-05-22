import React from 'react'
import { Field, reduxForm } from 'redux-form';
import Button from './Button';


const validate = values => {
  const errors = {};
  if (!values.username) errors.username = 'Required';
  if (!values.password) errors.password = 'Required';
  return errors;
}

const Login = (props) => {
    const { loginAction, handleSubmit, submitting, error } = props;
    const defaultClass = 'form-control login_control';
    const errorClass = `${defaultClass} has_error`;
    // !!! autoComplete={false} doesn't work for me, neither <form> nor <Field> (v6.4.3)
    
	return (
         <div className="login_Background">
       <div >
           <h1><center>Welcome to Medicare</center></h1>
        <div className="login_wrapper">
           <h3>Login</h3>
                <form onSubmit={handleSubmit(loginAction)} id="loginForm">
                <Field component={"input"} type="text" required
                    className={error ? errorClass : defaultClass} 
                    placeholder="Username" name="Username" autoFocus
                    disabled={submitting} autoComplete={false} />

                <Field component={"input"} type="password" required
                    className={error ? errorClass : defaultClass}
                    placeholder="Password" name="Password"
                    disabled={submitting} />
        
                <Button waiting={submitting} />
            </form>
        </div>
        </div>
        </div>
	)    
}
export default reduxForm({
    form: 'loginForm',
    validate
})(Login)