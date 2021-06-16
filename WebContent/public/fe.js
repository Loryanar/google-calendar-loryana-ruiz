function savet(){
var json ={
	    		nombre: document.getElementById("eventTitleInput").value,
	    		desc: document.getElementById("eventTitleInputD").value,
	           hour: document.getElementById("eventTitleInputH").value,
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
document.location.replace(`http://localhost:9092/Google_Calendar/public/perfil.html`)
	            }
	            	else{
	            		console.log("jaja kloko no");
	            	}
	            	
	    });
		}
