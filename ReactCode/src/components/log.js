'use strict';

var React    = require('react')
var DataGrid = require('react-datagrid')

var columns = [
	{ name: 'id', title: '#', width: 150 },
	{ name: 'patient_Id' },
	{ name: 'diaginfo', width: 200 },
	{ name: 'noofappoiontment'}
]

function ds(){
    let isLogged = store.getState().loginReducer.isLogged;
      console.log('isLogged '+ isLogged);
      let docId = 0;
      let dname= '';
      if (isLogged)  docId= store.getState().loginReducer.doctor_id;
      dname= store.getState().loginReducer.dname;
	//all we need is a Promise - so you can make any request (either GET or POST)
	return fetch('http://localhost:8080/Doctors/rest/doctorsinfoService/treatment/'+docId).then(function(response){
		return response.json().then(function(json){
			return {
				array: json.data,
				total: json.count
			}
		})
	}).then(function(json){
		//if you return your data array and the remote data count
		//under different keys, make sure you map them to {data,count}
		return {
			data : json.array,
			count: json.total
		}
	})
}

module.exports = React.createClass({

	render: function(){
		return <DataGrid
			dataSource={ds}
			idProperty='id'
			columns={columns}
			style={{height: 500}}
			paginationToolbarProps={{
				showRefreshIcon: false,
				iconSize: 30,
				iconProps: {
					style: {fill: '#FF8484'},
					overStyle: {fill: 'red'},
					disabledStyle: { fill: '#808080'}
				}
			}}
		/>
	}
})
export default Log;