/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready( function() {
    $('#filetree').fileTree({ root:'/', script:'FileSystemObject' }, function(file) {
        openFile(file);
    });
});

function openFile(file) {
    // do something with file
}
 

function init(){

}

window.onload = init;