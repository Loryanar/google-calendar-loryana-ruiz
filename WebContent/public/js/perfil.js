
var form = document.getElementById("form");
var fd = new FormData(form);
var help = 0;

var data = {
        method: "POST",
        body: fd 
    };

    fetch('http://localhost:3040/Google_Calendar/Usuario', data)
    .then( res => res.json())
    .then( data => {
        if(help == 0){
            console.log(data);
            document.getElementById("nameus").innerHTML = ` ${data.name} ${data.lastname} `;
            document.getElementById("cedula").value = data.id;
            document.getElementById("nombre").value = data.name;
            document.getElementById("apellido").value = data.lastname;
            document.getElementById("email").value = data.correo;
            document.getElementById("idc").value = data.idc;
            help++;
            console.log(help)
            window.self();
        }
            
    })
    .catch(error => console.error());

