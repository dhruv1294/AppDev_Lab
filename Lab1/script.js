const form = document.getElementById('form');
const Name = document.getElementById('name');
const rollNo = document.getElementById('rollNo');
const email = document.getElementById('email');
const phone = document.getElementById('phone');
const pwd = document.getElementById('pwd');
const cpwd = document.getElementById('cpwd');

function checkInputs() {
    var returnVal =true;
    resetErrors();
    const nameValue = Name.value.trim();
    const rollValue = rollNo.value.trim();
    const phoneValue = phone.value.trim();
    const emailValue = email.value.trim();
    const pwdValue = pwd.value.trim();
    const cpwdValue = cpwd.value.trim();

    if(nameValue === ''){
        setErrorFor(Name,'Name cannot be blank');
        returnVal=false;
    }else if(!isAplhaNum(nameValue)){
        setErrorFor(Name,'Name should be alphaNumeric only');
        returnVal=false;
    }else{
        setSuccessFor(Name);
    }

    if(rollValue === ''){
        setErrorFor(rollNo,'Roll no cannot be blank');
        returnVal=false;
    }else if(isNaN(rollValue)){
        setErrorFor(rollNo,'Enter a numeric number');
        returnVal=false;
    }else{
        setSuccessFor(rollNo);
    }
    if(emailValue === ''){
        setErrorFor(email,'Email cannot be blank');
        returnVal=false;
    }else if(!isEmail(emailValue)){
        setErrorFor(email,'Not a valid email');
        returnVal=false;
    }else {
        setSuccessFor(email);
    }
    if(phoneValue === ''){
        setErrorFor(phone,'Phone number cannot be blank');
        returnVal=false;
    }else if(!isPhone(phoneValue)){
        setErrorFor(phone,'Phone number should be 10 digits')
        returnVal=false;
    }else{
        setSuccessFor(phone);
    }

    if(pwdValue === ''){
        setErrorFor(pwd,'Password cannot be blank');
        returnVal=false;
    }else{
        setSuccessFor(pwd);
    }

    if(cpwdValue === ''){
        setErrorFor(cpwd,'Confirm password cannot be blank');
        returnVal=false;
    }else if(pwdValue != cpwdValue){
        setErrorFor(cpwd,'Passwords do not match');
        returnVal=false;
    }else{
        setSuccessFor(cpwd);
    }

    if(!isRadioChecked()){
        returnVal=false;
    }
    return returnVal;
}

function setErrorFor(input, message){
    const formControl = input.parentElement;
    const small = formControl.querySelector('small');
    formControl.className = 'input-box error';
    small.innerText = message;
}

function setSuccessFor(input){
    const formControl = input.parentElement;
    formControl.className = 'input-box success';
}
function resetErrors(){
    errors = document.getElementsByClassName('input-box error');
    for(let item of errors){
        item.className = 'input-box';
    }
    errors = document.getElementsByClassName('gender-details error');
    for(let item of errors){
        item.className = 'gender-details';
    }
}

function isEmail(email){
    return /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/.test(email);
}

function isPhone(phone){
    return /^\d{10}$/.test(phone);
}

function isAplhaNum(name){
    return /^[A-Za-z\d\s]+$/.test(name);
}

function isRadioChecked(){
    var radios = document.getElementsByName("gender");
    var formValid = false;

    var i = 0;
    while (!formValid && i < radios.length) {
        if (radios[i].checked) formValid = true;
        i++;        
    }

    if (!formValid) {
        const radio = document.getElementById('dot-1');
        const formControl = radio.parentElement;
        const small = formControl.querySelector('small');
        formControl.className = 'gender-details error';
        small.innerText = 'Pls fill gender details';
    }
    return formValid;
}
