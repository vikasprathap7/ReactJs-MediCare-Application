import React from 'react';

export default (props) =>
    props.waiting ? (
        <button type="submit" disabled
            className="btn btn-default login_button login_button_disabled" >
    
            <span className="glyphicon glyphicon-cog login_glyph"></span>
        </button>
    ) : (
        <button type="submit"
            className="btn btn-default login_button" >
    
            Submit &rarr;
        </button>
    )
