import React, { PropTypes } from 'react'
import { bindActionCreators } from 'redux'
import { connect } from 'react-redux'
import Login from './Login'
import Logged from './Logged'
import loginAction from '../reduxFiles/actions'

class App extends React.Component {
    render() {
        return  <div className="container">
                    {React.cloneElement(this.props.children, this.props)}
                </div>
    }
}

App.propTypes = {
    loginAction: PropTypes.func.isRequired,
    isLogged: PropTypes.bool.isRequired,
    isWaiting: PropTypes.bool // actually not needed since `redux-form` provides the 'submitting' flag
}

const mapStateToProps = state => ({
    isLogged: state.loginReducer.isLogged,
    isWaiting: state.loginReducer.isWaiting
})

const mapDispatchToProps = dispatch => bindActionCreators({ 
    loginAction
}, dispatch)

export default connect(mapStateToProps, mapDispatchToProps)(App)