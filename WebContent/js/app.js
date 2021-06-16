var a = 0;
var b = 0;

function login(){
    var json ={
            correo: document.getElementById("correo").value,
            pass: document.getElementById("pass").value
    }
    
    
    let configs = {
            method: 'post',
            body: JSON.stringify(json),
            withCredentials: true,
            credentials: 'include',
            headers: {
                'Content-type': 'application/json'
            }
    }
    fetch('./Log', configs)
        .then(res => res.json())
        .then(data => {console.log(data)
        	let userData = data.userData;
            if(data.status == 200){
            	alert("todo bien login con exito");
            	document.location.replace(`http://localhost:9092/Google_Calendar/public/perfil.html`)
                //localStorage.setItem('sesion', JSON.stringify(userData));
                localStorage.setItem('id', userData.id_usurio)
            }
     });
}

function registrar(){

	if(a == 1 && b == 1){
	    var json ={
	    		nombre: document.getElementById("reg-name").value,
	    		apellido: document.getElementById("reg-ln").value,
	            email: document.getElementById("reg-correo").value,
	            pass: document.getElementById("reg-pass").value,
	            id: document.getElementById("reg-id").value
	    }
	    
	    
	    
	    let configs = {
	            method: 'post',
	            body: JSON.stringify(json),
	            withCredentials: true,
	            credentials: 'include',
	            headers: {
	                'Content-type': 'text'
	            }
	    }
	    
	    console.log(configs.body);
	    fetch('./Regist', configs)
	        .then(res => res.json())
	        .then(data => {console.log(data)
	        	let userData = data.userData;
	            if(data.status == 200){
	            	alert("todo bien registro con exito");
document.location.replace(`http://localhost:9093/Google_Calendar/public/perfil.html`)
	            }
	            	else{
	            		console.log("jaja kloko no");
	            	}
	            	
	    });
	}
}

function checkEmail() {
    var email = document.getElementById('reg-correo');
    var mailFormat = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;

    if (!mailFormat.test(email.value)) {
        alert('Direccion de correo invalida');
        email.focus;
        return false;
    }else{
    	a = 1;
    }
}


const check = () => {
	checkEmail();
	checkPassword();
	registrar();
	
}
function checkPassword(){
    var password = document.getElementById('reg-pass');
    var passwordFormat= /(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}/;

    if (!passwordFormat.test(password.value)) {
        alert('La contrasena debe tener al menos un numero, una letra mayuscula y una letra minuscula con minimo 6');
        password.focus;
        return false;
        console.log(aa);
    }else{
    	b = 1;
    }
}
