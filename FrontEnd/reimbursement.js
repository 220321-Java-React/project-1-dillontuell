const url = "http://localhost:3000"; 
document.getElementById("getUserButton").addEventListener("click", getUsers);

document.getElementById("loginButton").addEventListener("click", loginFunction);

async function getUsers() {

    let response = await fetch(url + "/users", {credentials: "include"});

    console.log(response);

    if(response.status === 200) { 
        let data = await response.json();

        console.log(data);

        for(let user of data){

            let row = document.createElement("tr");

            let cell = document.createElement("td")
            cell.innerHTML = user.user_id;
            row.appendChild(cell);

            let cell2 = document.createElement("td");
            cell2.innerHTML = user.first_name;
            row.appendChild(cell2);

            let cell3 = document.createElement("td");
            cell3.innerHTML = user.last_name;
            row.appendChild(cell3);

            let cell4 = document.createElement("td");
            cell4.innerHTML = user.user_role;
            row.appendChild(cell4);

            document.getElementById("userBody").appendChild(row);

        }
    

    } else {
    
        alert("uh oh your session is inactive. Maybe not logged in? :/");
    }


}



async function loginFunction(){

let usern = document.getElementById("username").value;
let userp = document.getElementById("password").value;

let user = {
    username:usern,
    password:userp
}

console.log(user);

let response = await fetch(url+"/login", {

    method: "POST", 
    body: JSON.stringify(user), 
    credentials: "include"
    
})

console.log(response.status);


if(response.status === 202){


    let data = await response.json();

    document.getElementById("loginRow").innerText="Welcome " + data.first_name + "!!";

} else {
    document.getElementById("welcomeHead").innerText="Login failed! Try Again";
    document.getElementById("welcomeHead").style.color = "red";
}

}