import axios from 'axios';


function getPeople(){
  return axios.get('http://swapi.co/api/people/');
}
export {getPeople}
