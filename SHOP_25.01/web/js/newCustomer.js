function validate(){
    let valid = true;
    let name = document.getElementById('name');
    let surname = document.getElementById('surname');
    let money = document.getElementById('money');
    
    if(name.value < 1){
        name.className = ' invalid';
        valid = false;
    }else{
        name.className = '';
        name = true;
    }
    
    if(surname.value < 1){
        surname.className = ' invalid';
        valid = false;
    }else{
        surname.className = '';
        valid = true;
    }
    
    if(money.value < 1){
        money.className = ' invalid';
        valid = false;
    }else{
        money.className = '';
        valid = true;
    }
    
    return valid;
}