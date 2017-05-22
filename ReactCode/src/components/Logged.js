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
import Patient from './patient';
import ProgressiveImage from 'react-progressive-bg-image';
//import action from './reduxFiles/actions'


class Logged extends Component{
    constructor(props){
        super(props);

        this.state = {

          // patient_id:'',
           //id:'',
          // noofappoiontment:'',
           treatments:[],
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

        axios.get('http://localhost:8080/Doctors/rest/doctorsinfoService/treatment/'+dId).then((results) => {
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
                            treatments:results.data

                           })

           
        }).catch(e =>{
         console.log(e);

         })
    }

    render(){
         
let treatments=this.state.treatments;
let dname= store.getState().loginReducer.dname;
console.log(dname);
        return(
             <div className="logged_Background">
          <div >
            <div>  <h2 style={{fontFamily:'Times New Roman',color:'grey'}}>Hi Dr.{dname}</h2></div>
         <div> <h3> Treatment Information: </h3></div>        
          <div>  
       </div>
       <div>
             <BootstrapTable data={ treatments} pagination  search={ true } scrollTop={ 'Bottom' }
              tableStyle={ { border: 'black 2.5px solid' } }> 
        <TableHeaderColumn dataField='id' width='150' isKey>Treatment ID</TableHeaderColumn>
       <TableHeaderColumn dataField='patient_id' width='150' ><Link to='/Patient'> Patient ID</Link> </TableHeaderColumn>
        <TableHeaderColumn dataField='diaginfo' width='150'>Treatment For</TableHeaderColumn>
        <TableHeaderColumn dataField='noofappoiontment' width='150'>Number Of Appointments</TableHeaderColumn>
      </BootstrapTable>
             </div>
             
    <Link to='/Login'><button className="login_button">Logout</button></Link>          
</div>
</div>


        );
    }
}

export default Logged; 