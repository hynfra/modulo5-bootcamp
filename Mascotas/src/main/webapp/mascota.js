// global valriables
let clientList = [];
let tempClient = "";
let myNumber = 1;
let contactNumberFormat = /[0]{1}[0-9]{10}/;
let emailFormat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
let letters = /^[A-Za-z ]+$/;

//Changing the Pages
function showClientInput() {
    document.getElementById("client-form").style.display = "inline-block";
    document.getElementById("pet-form").style.display = "none";
    document.getElementById("output").style.display = "none";
}

function showPetInput() {
    document.getElementById("client-form").style.display = "none";
    document.getElementById("pet-form").style.display = "inline-block";
    document.getElementById("output").style.display = "none";
}

function showRecords() {
    document.getElementById("client-form").style.display = "none";
    document.getElementById("pet-form").style.display = "none";
    document.getElementById("output").style.display = "inline-block";
  
    myNumber = 1;

    let recordsResult = "";

    for(let i = 0; i < clientList.length; i++){
        recordsResult += `${clientList[i].getFullDetails()}\n`;
        myNumber = myNumber + 1;
    }
    document.getElementById("pOutput").innerHTML = recordsResult;
}

//Classes
class Pet{
    _petType;
    _petNickname;
    constructor(type, nickname){
        this._petType = type;
        this._petNickname = nickname;
    }

    get getPetType(){
        return this._petType;
    }

    get getPetNickname(){
        return this._petNickname;
    }
}

class Client extends Pet{
    _clientName;
    _clientAddress;
    _clientEmail;
    _clientContactNumber;
    _petList = [];

    constructor(name, address, email, contactNumber){
        super();
        this._clientName = name;
        this._clientAddress = address;
        this._clientEmail = email;
        this._clientContactNumber = contactNumber;
    }

    get getClientName(){
        return this._clientName;
    }

    get getClientAddress(){
        return this._clientAddress;
    }

    get getClientEmail(){
        return this._clientEmail;
    }

    get getClientContactNumber(){
        return this._clientContactNumber;
    }

    get getPetList(){
        return this._petList;
    }

    getPetListDetails(){
        let petDetails = "";
        for(let i = 0; i < this._petList.length; i++){
            let currentPet = this._petList[i];

            petDetails += `
            <tr>
                <td>${currentPet._petType}</td>
                <td>${currentPet._petNickname}</td>
            </tr>`;
        }
        return `<table class="pet-table">
        <tr>
        <th>Pet Type</th>
        <th>Pet Nickname</th>
        </tr>
        ${petDetails}
        </table>`;
    }

    getFullDetails(){
        return `<table class="client-table">
        <h2>Client ${myNumber}</h2>
        <tr>
            <th>Name: </th>
            <th>Address: </th>
            <th>Email: </th>
            <th>Contact Number: </th>
        </tr>
        <tr>
            <td>${this._clientName}</td>
            <td>${this._clientAddress}</td>
            <td>${this._clientEmail}</td>
            <td>${this._clientContactNumber}</td>
        </tr>
        </table>
        <p>---Pets Registered---</p>
        ${this.getPetListDetails()}`;
    }
}

function submitClient(){
    let clientName = document.getElementById("Name").value;
    let clientAddress = document.getElementById("Address").value;
    let clientEmail = document.getElementById("Email").value;
    let clientContact = document.getElementById("Contact").value;

    //Input Validation
    if(!clientName || !clientAddress || !clientEmail || !clientContact) {
        alert("Please Fill all the Forms");
    }else if(!clientName.match(letters)) {
        alert("Incorrect Name Format");
    }else if(!clientEmail.match(emailFormat)) {
        alert("Incorrect email format.");
    }else if(!contactNumberFormat.test(clientContact)) {
        alert("Incorrect contact Number. (Must be 11 digits)");
    }else {
        //If the name exists
        for(i = 0; i < clientList.length; i++){
            if(clientName == clientList[i].getClientName){
                alert("The Client name already exist!!");

                return;
            }
        }
        tempClient = new Client(clientName, clientAddress, clientEmail, clientContact);
        clientList.push(tempClient);
        alert("Client Successfully added");
        //If successful the forms will reset
        reset();
    }
}

function submitPet(){
    let petOwner = document.getElementById("Owner").value;
    let petType = document.getElementById("Pet-Type").value;
    let petNickname = document.getElementById("Pet-Nickname").value;

    //Input Validation
    if(!petOwner || !petType || !petNickname) {
        alert("Please Fill all the Forms");
        return;
    }else {
        for(i = 0; i < clientList.length; i++){
            if(petOwner == clientList[i].getClientName){
                clientList[i]._petList.push(new Pet(petType, petNickname));
                alert("Pet Successfully added");
                //If successful the forms will reset
                reset();
                return;
            }
        }
        alert("The Client Doesn't Exist!!");
    }
}

function reset(){
    document.getElementById("Name").value = "";
    document.getElementById("Address").value = "";
    document.getElementById("Email").value = "";
    document.getElementById("Contact").value = "";

    document.getElementById("Owner").value = "";
    document.getElementById("Pet-Type").value = "";
    document.getElementById("Pet-Nickname").value = "";
}