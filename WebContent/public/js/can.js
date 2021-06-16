

function registrar(){

	
	    var json ={
	    		nombre: document.getElementById("nombrea").value,
	    		idc: document.getElementById("idcA").value,
	            id_us: document.getElementById("cedula").value
                 
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
	    fetch('http://google-calendar-loryana-ruiz.herokuapp.com/', configs)
	        .then(res => res.json())
	        .then(data => {console.log(data)
	        	let userData = data.userData;
	            if(data.status == 200){
	            	alert("todo bien registro con exito");
document.location.replace(`http://localhost:3040/Google_Calendar/public/calen.html`)
	            }
	            	else{
	            		console.log("jaja kloko no");
	            	}
	            	
	    });
	
}
