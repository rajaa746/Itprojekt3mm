async function opretAftale(){
    let Aftaleform= document.getElementById("aftaleform");// man får fat i formen så man kan gøre brug af den
    console.log(Aftaleform)
    let formData = new FormData(Aftaleform)// formen bliver herefter konveteret til fromData
    let AftaleJson = Object.fromEntries(formData); //fromdata bliver konveteres til json så den kan fetchees
    let res = await fetch("rest/aftale", { //
        method:"POST",
        body: JSON.stringify(AftaleJson), //det man fetchere serialiseres til en string så det sendes over nettet
        headers:{
            'content-type':"application/json"
        }

    })
    alert(res);
    await hentAftale();


}
async function hentAftale(){
    let result = await fetch("rest/aftale",{
        headers:{
            "authorization":"Bearer "+localStorage.getItem("token")
        }
    }); //ved at bruge resultat await får den sin egen tråd altså kan programmet køre uden den nødvendigvis køre
    console.log(result.status)
    if (result.status!=200){
        alert("noget gik galt!");
    }
    let json = await result.json();
    console.log(json)
    updateAftale(json)

}

function updateAftale(json) {
    let listelements =""
    json.forEach(function(element){
        listelements += ("<tr><td>"+element.name+"</td><td>"+element.cpr+"</td><td> "+element.tidspunkt+"</td><td> "+element.dato+"</td><td> "+element.notat+"</td></tr>")


    })



    let aftalelist= document.getElementById("minktabel");

        aftalelist.innerHTML+=listelements

}

async function login() {
    // Serialiser formen til js-objekt
    let loginform = document.getElementById("loginform");
    const formData = new FormData(loginform);
    const object = Object.fromEntries(formData);
    console.log(object)
    //Bruger fetch-API til at sende data - POST. JSON.stringify for at serialisere objekt til string.
    const res = await fetch("api/login", {
        method: "POST",
        body: JSON.stringify(object),
        headers: {
            "content-type": "application/json"
        }
    })

    // hvis vi får en token, gemmer vi den i browserens localstorage
    const token = await res.text();
    localStorage.setItem("token",token);
    //For ekstra krymmel fisker vi en bruger ud af tokenen
    const payload = window.atob(token.split(".")[1]);
    const payloadJson = JSON.parse(payload);
    localStorage.setItem("user",payloadJson.username);
    //Viderestil til den rigtige side!
    window.location.href="Welcome.html"


/*
    function doLogin() {
    this.state=Loginstates.LOGGING_IN;
    fetch(baseUrl + "rest/login",{
        method:"POST",
        body:JSON.stringify(this.logindata),
        headers: {
            'Content-Type': 'application/json'
        }
    }).then(
        (response)=> {
            response.text().then(
                (token)=> {
                    console.log("Got Token: " + token)
                    localStorage.setItem("token",token);
                }

            )}
    ).catch(()=>alert("fejl")) }

    function fetchaftaler(){
        const token = tokenStore.token;
        this.loading = states.LOADING;
        fetch(baseUrl + "rest/aftaler", {
            headers: {
                Authorization: localStorage.getItem("token")
            }
        }).then(/*....* */
    }
