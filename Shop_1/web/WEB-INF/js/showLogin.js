function validate(){
    let valid = true;
    let login = document.getElementById('login');
    let password = document.getElementById('password');
    let button = document.getElementById('button');
    if(login.value < 1){
        login.className = 'invalid';
        valid = false;
    }else{
        login.className = '';
        valid = true;
    }
    if(password.value < 1){
        password.className = 'invalid';
        valid = false;
    }else{
        password.className = '';
        valid = true;
    }
    return valid;
}


