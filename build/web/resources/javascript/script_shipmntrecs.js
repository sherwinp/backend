/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready( function() {
    $.get('contentservice', {}, 
    function(data){
        $('#shipmentrecs').find("tr:gt(0)").remove();
        $('#shipmentrecs > tbody:last').append(data);
    });
}); 
