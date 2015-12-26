/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready( function() {
    
	 var ws = new WebSocket("ws://localhost:8080/backend/service/messages");
     ws.onopen = function()
     {
        // Web Socket is connected, send data using send()
        ws.send("Message to send");
        console.log("Message is sent...");
     };
		
     ws.onmessage = function (evt) 
     { 
        var received_msg = evt.data;
        console.log("Message is received...");
     };
		
     ws.onclose = function()
     { 
    	 console.log("Connection is closed..."); 
     };
});

function openFile(file) {
    // do something with file
}
 

function init(){

}

window.onload = init;