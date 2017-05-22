import React, { Component } from 'react';
import { connect } from 'react-redux';
import axios from 'axios';
import {Link} from 'react-router';
import User from './User';
import store from '../reduxFiles/store';
import {BootstrapTable, TableHeaderColumn} from 'react-bootstrap-table';
import { ReactDataGrid, ReactDataGridColumn } from 'flexicious-react-datagrid'
import { CssStyles, ApiStyles,BaseAdapter } from 'flexicious-react-datagrid-styles'
import ImageResponsive, {Source} from 'react-image-responsive';
import Login from './Login';

//import action from './reduxFiles/actions'


class Logged extends Component{
    constructor(props){
        super(props);

        this.state = {

          // patient_id:'',
           //id:'',
          // noofappoiontment:'',
           patients:[],
           //docs:[]
           
        };
    }

    componentDidMount(){
      let isLogged = store.getState().loginReducer.isLogged;
      console.log('isLogged '+ isLogged);
      let dId=0;
      let uname='';
      let dname= '';
      if (isLogged)  {
          uname= store.getState().loginReducer.username;
            dname= store.getState().loginReducer.dname;
        dId=store.getState().loginReducer.dId;}
     console.log('doctorname ' +dname);
      console.log('test' +dId);

        axios.get('http://localhost:8080/Doctors/rest/doctorsinfoService/patient').then((results) => {
            let all = results.data[0];
           // let all1 = results.data[1];
            console.log("1111111111"+all);
            let test = [];
            test.push(all);
            console.log('2222222'+test);
            console.log('doctorname ' +dname);
            this.setState({
                            //patient_id: all.patient_id,
                            //id:all.id,
                            //noofappoiontment:all.noofappoiontment
                            patients:results.data

                           })

           
        }).catch(e =>{
         console.log(e);

         })
    }

    render(){
         
let patients=this.state.patients;
let dname= store.getState().loginReducer.dname;
console.log(dname);
        return(
          <div className="logged_Background" >
         <div> <h3> Patients Information: </h3></div>        
          <div>  
       </div>
       <div>
             <BootstrapTable data={ patients} pagination  search={ true }> 
        <TableHeaderColumn dataField='patient_id' width='150' isKey>Patient ID</TableHeaderColumn>
       <TableHeaderColumn dataField='patient_name' width='150' > Patient Name </TableHeaderColumn>
        <TableHeaderColumn dataField='age' width='150'>Pateint Age</TableHeaderColumn>
        <TableHeaderColumn dataField='gender' width='150'>Gender</TableHeaderColumn>
        <TableHeaderColumn dataField='medication' width='150'>Mediction Given</TableHeaderColumn>
       
      </BootstrapTable>
             </div>
             
   <Link to='/Login'><button className="login_button">Logout</button></Link>          
</div>


        );
    }
}

export default Logged; 