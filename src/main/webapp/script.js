async function opretPatient(){
    let patientform= document.getElementById("patientform");
    let formData = new FormData(patientform)
    let patientJson = Object.fromEntries(formData);
    let res = await fetch("rest/patients", {
        method:"POST",
        body: JSON.stringify(patientJson),
        headers:{
            'content-type':"application/json"
        }

    })
    alert(res);
    await hentPatienter();


}
async function hentPatienter(){
    let result = await fetch("rest/patients");
    console.log(result.status)
    if (result.status!=200){
        alert("noget gik galt!");
    }
    let json = await result.json();
    console.log(json)
    updatePatienter(json)

}

function updatePatienter(json) {
    let listelements =""
    json.forEach(function(element){
        listelements += ("<li>"+element.name+"</li>")
    })

    let Patientlist= document.getElementById("patienter");
    Patientlist.innerHTML=listelements


}



