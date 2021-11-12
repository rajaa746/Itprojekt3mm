async function opretAftale(){
    let Aftaleform= document.getElementById("aftaleform");
    console.log(Aftaleform)
    let formData = new FormData(Aftaleform)
    let AftaleJson = Object.fromEntries(formData);
    let res = await fetch("rest/aftale", {
        method:"POST",
        body: JSON.stringify(AftaleJson),
        headers:{
            'content-type':"application/json"
        }

    })
    alert(res);
    await hentAftale();


}
async function hentAftale(){
    let result = await fetch("rest/aftale");
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
        listelements += ("<tr><td>"+element.name+"</td></tr>")


    })
    let aftalelist= document.getElementById("minktabel");

        aftalelist.innerHTML+=listelements







}


