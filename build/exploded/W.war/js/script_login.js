/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

let signup = document.querySelector('#signup');
let signin = document.querySelector('#signin');
let body = document.querySelector('body');
signup.onclick = function(){
    body.classList.add('signup');
};
signin.onclick = function(){
    body.classList.remove('signup');
};

