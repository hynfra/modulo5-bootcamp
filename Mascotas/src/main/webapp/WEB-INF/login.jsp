<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
  <html>
<head>
    <title>Midterm Lab Exercise 3</title>
    <link rel="stylesheet" type="text/css" href="mascota.css"">
</head>

<body>
    <div class="form-inputs">
        <div class="header">
            <h1>Welcome to formulario</h1>
        </div>
        <div class="buttons">
            <button id="btnClient" onclick="showClientInput()">boton 1</button>
            <button id="btnPet" onclick="showPetInput()">boton 2</button>
            <button id="btnRecords" onclick="showRecords()">boton 3</button>
        </div>
        
        <!--The Second Form-->
        <div id="client-form">
        <div class="alert alert-primary" role="alert">
		 		 This is a primary alert—check it out!
		</div>	
            <h2>Formulario</h2>
            <!-- En el action se pone el nombre del proyecto seguido de la ruta donde esta ubicado el servlet (omitiendo el .java) -->
            <form action="/Mascotas/login" method="post">
            <div class="module">
                <label for="name">nombre de usuario: </label>
                <input type="text" name ="username" class="name" id="Name" placeholder="Ingresa tu usuario" required/>
            </div>
            <div class="module">
                <label for="address">clave: </label>
                <input type="password" name ="password" class="address" id="Address" placeholder="Ingresa tu clave" required/>
            </div>
            <div class="module">
                <button type="submit">Iniciar sesion</button>
            </div>
            </form>
        </div>

        <!--The Second Form-->
        <div id="pet-form" style="display: none;">
            <h2>Pet Application Form</h2>
            <div class="module">
                <label for="owner">Owner Name: </label>
                <input type="text" name="owner" class="owner" id="Owner" placeholder="Enter your name"/>
            </div>
            <div class="module">
                <label for="pet-type">Type of Pet: </label>
                <select name="pet-type" id="Pet-Type">
                  <option value="Dog">Dog</option>
                  <option value="Cat">Cat</option>
                  <option value="Bird">Bird</option>
                </select>
            </div>
            <div class="module">
                <label for="pet-nickname">Pet Nickname: </label>
                <input type="text" name="pet-nickname" class="pet-nickname" id="Pet-Nickname" placeholder="e.g pogi, buto and blackie" />
            </div>
            
            <div class="module">
                <button id="btnsubmitPet" onclick="submitPet()">Submit</button>
            </div>
        </div>
        
        <!--The Third Form-->
        <div id="output" style="display: none;">
            <p style="text-align: center;">[LIST OF RECORD]</p>
            <p id="pOutput">[THERE ARE NO EXISTING CLIENTS]</p>
        </div>
    </div>

    <script type="text/javascript" src="Client.js"></script>
    <script type="text/javascript" src="Pet.js"></script>
    <script type="text/javascript" src="script.js"></script>
</body>

</html>