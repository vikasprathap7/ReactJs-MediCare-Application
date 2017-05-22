
/* Dependecies declaration */
var axios = require('axios');
var express = require('express');
var logger = require('morgan');
var bodyParser = require('body-parser');
var errorHandler = require('errorhandler');
var path = require('path');
var webpack = require('webpack');
var config = require('./webpack.config');

var http = require('http');

var compiler = webpack(config);
var app = express();
app.set('port', 3500);

/* Middleware stack */
// app.use(logger('dev'));
app.use(logger(':method :url :status :response-time ms - :date[web]'));
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({
  extended: true
}));
app.use(express.static(__dirname));
app.use(require('webpack-dev-middleware')(compiler, {
  publicPath: config.output.publicPath
}));

app.use(require('webpack-hot-middleware')(compiler));

app.get('*', function(req, res) {
  res.sendFile(path.join(__dirname, 'index.html'));
  res.sendFile(path.join(__dirname, '/node_modules/bootstrap/dist/css/bootstrap.min.css'));
  res.sendFile(path.join(__dirname, '/static/style.css'));
});
app.use(errorHandler());

/* POST handler */
app.post('/login', function(req, res, next) {
    var name = req.body.Username;
    var pass = req.body.Password;
    console.log('User: ' + name + '\n' + 'Pass: ' + pass);
    axios.get('http://localhost:8080/Doctors/rest/doctorsinfoService/doctorsinfo/name/' +name)
      .then(function (response) {
        console.log(response.data[0].username);
        console.log(name);
         console.log(pass);
        console.log(response.data[0]);
        let dname=response.data[0].doctor_name;
        let dId=response.data[0].doctor_id;
        console.log(dname);
        console.log(dId);
        /* Checking the credentials */
        if (name == response.data[0].username && pass == response.data[0].password) {
            replyWith(res, {
                "Auth": "Logged",
                "username": name,
                "dname":dname,
                "dId":dId,
                "Language": "EN"
            });
        } else {
            replyWith(res, { Auth: "Denied" });
        }
      })

      .catch(function (error) {
        console.log(error);
      });

    // console.log(Object.keys(req));
});

/* The server starts on */
/*http.createServer(app).listen(app.get('port'), function() {
    console.log('Express server listening on port ' + app.get('port'));
});*/

app.listen(3500, function(err) {
  if (err) {
    return console.error(err);
  }

  console.log('Listening at http://localhost:3500/');
})

/* Sends the delayed response */
function replyWith(res, obj) {
    setTimeout(function() {
        res
            .set({
                'Content-Type': 'application/json; charset=utf-8',
                'Cache-Control': 'public, max-age=86400'
            })
            .status(200)
            .json(obj)
            .end();

        console.log(obj);
    }, 1500);
}

/****** EOF *******/