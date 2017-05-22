import { reducer as formReducer } from 'redux-form'
import { createStore, applyMiddleware, combineReducers } from 'redux'
import thunk from 'redux-thunk'
import loginReducer from './reducers'

const reducer = combineReducers({
    loginReducer,
    form: formReducer,
})

const store = createStore(reducer, applyMiddleware(thunk))
export default store