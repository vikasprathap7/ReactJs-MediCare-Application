import React from 'react';
import { Link } from 'react-router';

function User(props)
{
  return(
    <div className="user">
    <div>
    <Link to={'/profile/' + props.id}> <ul><li>{props.name}</li> </ul></Link>
    </div>
    </div>
  )
}
export default User;
