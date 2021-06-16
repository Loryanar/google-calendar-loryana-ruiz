var form = document.getElementById("form");
var del = document.getElementById("delete");

del.addEventListener('click', function(e){
    e.preventDefault();
    var fd = new FormData(form);

    var datos = {
        method: "DELETE",
        body: fd 
    };

    fetch('http://google-calendar-loryana-ruiz.herokuapp.com/Usuario', datos)
    .then( res => res.json())
    .then( data => {
        if(data.status == 200){
            window.open('http://localhost:3040/Google_Calendar/', "_self");
            alert(data.message);
        }else{
            window.open('http://google-calendar-loryana-ruiz.herokuapp.com/public/perfil.html', "_self");
            alert(data.message);
        }
    })
    .catch(error => console.error());
    });