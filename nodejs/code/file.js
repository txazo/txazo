var fs = require('fs');

var data = fs.readFileSync('server.js');
console.log(data);
console.log("readFileSync end");

data = fs.readFile('server.js', function (err, data) {
    if (err) {
        console.error(err);
    } else {
        console.log(data);
    }
});
console.log("readFile end");