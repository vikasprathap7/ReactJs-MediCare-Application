import { reset, focus, SubmissionError } from 'redux-form';
import { hashHistory } from 'react-router';
import _fetch from '../misc/fetch';


// class Doctor extends Component{
//   constructor(props){
//       super(props);
//       this.state = {
//           doctorId : 1
//       };
//   }
// }
function submitCycleAction(status,username,dname,dId) {
    console.info('status ' +status);
   // console.info('doctor_id ' +doctor_id );
    return {
        type: 'SUBMIT_USER',
        status,
        username,
        dname,
        dId
    }
}

function _err(err) {
    throw new Error(err.status + ': ' + err.message)
}

export default function loginAction(credentials) {
    const url = 'http://localhost:3500/login';
    const query = [JSON.stringify(credentials), url];

    return dispatch => {
        dispatch(submitCycleAction('waiting',0));   // actually not needed since `redux-form` provides the 'submitting' flag

        return _fetch(...query)
			.then(response => JSON.parse(response), _err) // parsing & analyzing the server's response
            .then(data => {
                console.log(data);
                console.log(data.Auth);

                dispatch(reset('loginForm')); // clear the form
                dispatch(focus('loginForm', 'Username')); // !!! `focus` action doesn't work (v6.4.3)
                document.getElementById('loginForm').elements[0].focus(); // so this ugly hack performed

                if (data['Auth'] == 'Logged') {
					dispatch(submitCycleAction('success',data['username'],data['dname'],data['dId']));
                    hashHistory.push('/logged');
				} else {
                    throw new SubmissionError({ _error: 'Login failed!' });
					dispatch(submitCycleAction('error',0));
				}
            }, _err);
    }
}
//export default Doctor;