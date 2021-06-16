var form = document.getElementById("form");
var cam = document.getElementById("cambiar");

function cambiar(){
  var json = {
	    		nombre: document.getElementById("nombre").value,
	    		apellido: document.getElementById("apellido").value,
	            email: document.getElementById("correo").value,
	            id: document.getElementById("id").value,
	           
	    }

    var datos = {
        method: "PUT",
        body: JSON.stringify(json),
        withCredentials: true,
	    credentials: 'include',
	    headers: {
	        'Content-type': 'text'
	    }
    }

    fetch('http://localhost:3040/Google_Calendar/Usuario', datos)
    .then( res => res.json())
    .then( data => {console.log(data)
    let userData = data.userData;
        if(data.status == 200){
            window.open('http://localhost:3040/Google_Calendar/public/perfil.html', "_self");
            alert(data.message);
        }else{
           
            alert(data.message);
        }
    })
    .catch(error => console.error());
}