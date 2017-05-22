# Login App with React / Redux
##### An authorization application written with React.js / Redux / ES6.
My second take on React.js. The app is a sequel for [Login App](https://github.com/kostyanet/login) written with AngularJS.

### Description
* The app is written with ES6 syntax. It includes 3 components and preserves its state in Redux store. The previous version of the app was written with a service way, thus resembles AngularJS approach. It still can be found in the `service-arch` branch of this repository.
* Entering the root URL `'/'` entails a redirection to the `'/login'` url, where you meet the login form of the __Login__ and __Password__ fields as well as the __Login__ button. 
* Submission of the form causes a POST request to the *Node.js* server. While waiting for the response the __Login__ button changes its appearance. 
* The expected credentials are: __Login: *Username*__ and __Password: *Password*__. In case of wrong credentials submission causes no view change, the fields are purged and marked. Passing the correct credentials causes redirection to the protected address `'/logged'`, which can be achieved only by the correct authentification. Non-authorized attempts to `'/logged'` cause redirection to `'/login'`.
* The app interacts with the *Node.js* server. In case of a wrong set of credentials the server responses with JSON of `{"Auth":"Denied"}`. The correct credentials are answered with `{Auth":"Logged", "Language":"EN"}` JSON response.

### Tech stack:
JavaScript, HTML 5, CSS 3, Webpack

### Frameworks | modules used:
`React.js`, `Redux`, `Node.js`, `React Router`, `Redux Form`, `Redux Thunk`, `Bootstrap`

### Installation
```
$ git clone https://github.com/kostyanet/login-react.git
$ cd login-react
$ npm install
```

### Run the server
```
$ npm start
```
The app will be available on [http://localhost:3000](http://localhost:3000).

###### See other projects on [my page](https://kostyanet.github.io/start/)