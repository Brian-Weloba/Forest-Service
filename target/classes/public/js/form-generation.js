function endangeredForm() {
    //generate endangered From
    var eForm = document.getElementById("form-div");

    //add div for eName input
    var eNameDiv = document.createElement("div");
    eNameDiv.setAttribute("class", "txt_field col-12");

    //add eName label to form
    var eNameLabel = document.createElement("label");
    eNameLabel.setAttribute("class", "form-label")
    eNameLabel.innerHTML = "Animal Name : ";
    eNameLabel.htmlFor = "eName";

    //add eName input to form
    var eName = document.createElement("input");
    eName.setAttribute("id", "eName");
    eName.setAttribute("name", "eName");
    eName.setAttribute("type", "text");
    eName.setAttribute("placeholder", "Enter animal name");

    //create eName input
    eNameDiv.appendChild(eNameLabel);
    eNameDiv.appendChild(eName);

    //add div for eAge input
    var eAgeDiv = document.createElement("div");
    eAgeDiv.setAttribute("class", "form-group col-md-6");
    eAgeDiv.setAttribute("style", "width:200px;")

    //add eAge select to form
    var eAge = document.createElement("select");
    eAge.setAttribute("id", "eAge");
    eAge.setAttribute("name", "eAge");
    eAge.setAttribute("class", "form-select");
    eAge.setAttribute("type", "text");

    //add eAge label to form
    var eAgeLabel = document.createElement("label");
    eAgeLabel.setAttribute("for", "eAge");
    eAgeLabel.innerHTML = "Animal Age : ";
    eAgeLabel.htmlFor = "eAge";

    //add eAge value options to select
    var ageValues = ["Newborn", "Young", "Old"];
    for (const j of ageValues) {
        var eAgeOptions = document.createElement("option");
        eAgeOptions.setAttribute("value", j);
        eAgeOptions.text = j;
        eAge.appendChild(eAgeOptions);
    }

    //create eAge input
    eAgeDiv.appendChild(eAgeLabel);
    eAgeDiv.appendChild(eAge);

    //add div for eHealth input
    var eHealthDiv = document.createElement("div");
    eHealthDiv.setAttribute("class", "form-group col-md-6");
    eHealthDiv.setAttribute("style", "width:200px;")

    //add eHealth select to form
    var eHealth = document.createElement("select");
    eHealth.setAttribute("id", "eHealth");
    eHealth.setAttribute("name", "eHealth");
    eHealth.setAttribute("class", "form-select");
    eHealth.setAttribute("type", "text");

    //add eHealth label to form
    var eHealthLabel = document.createElement("label");
    eHealthLabel.setAttribute("for", "eHealth");
    eHealthLabel.setAttribute("class", "form-label");
    eHealthLabel.innerHTML = "Animal Health : ";
    eHealthLabel.htmlFor = "eHealth";

    //add eHealth value options to select
    var healthValues = ["Healthy", "Okay", "Ill"];
    for (const i of healthValues) {
        var eHealthOptions = document.createElement("option");
        eHealthOptions.setAttribute("value", i);
        eHealthOptions.text = i;
        eHealth.appendChild(eHealthOptions);
    }

    //create eHealth input
    eHealthDiv.appendChild(eHealthLabel);
    eHealthDiv.appendChild(eHealth);

    //add div for location input
    var lNameDiv = document.createElement("div");
    lNameDiv.setAttribute("class", "form-group col-12");
    lNameDiv.setAttribute("style", "width:200px;")

    //add location select to form
    var lName = document.createElement("select");
    lName.setAttribute("id", "lName");
    lName.setAttribute("name", "lName");
    lName.setAttribute("class", "form-select");
    lName.setAttribute("type", "text");

    //add lName label to form
    var lNameLabel = document.createElement("label");
    lNameLabel.setAttribute("for", "lName");
    lNameLabel.setAttribute("class", "form-label");
    lNameLabel.innerHTML = "Location : ";
    lNameLabel.htmlFor = "lName";

    //add lName value options to select
    var locationValues = ["Aberdare National Park", "Amboseli National Park", "Arabuko Sokoke National Park", "Hell's Gate National Park", "Kora National Park", "Lake Nakuru National Park", "Masai Mara National Park", "Meru National Park", "Mount Elgon National Park", "Nairobi National Park", "Ol Donyo Sabuk National Park", "Tsavo East National Park", "Tsavo West National Park"];
    for (const l of locationValues) {
        var lNameOptions = document.createElement("option");
        lNameOptions.setAttribute("value", l);
        lNameOptions.text = l;
        lName.appendChild(lNameOptions);
    }

    //create lName input
    lNameDiv.appendChild(lNameLabel);
    lNameDiv.appendChild(lName);

    //add submit input to form
    var eSubmit = document.createElement("input");
    eSubmit.setAttribute("type", "submit");
    eSubmit.setAttribute("value", "Add Animal");
    eSubmit.setAttribute("style", "margin-left:15px;")
    eSubmit.setAttribute("class", "btn btn-outline-secondary mbr-text mbr-fonts-style display-5");
    eSubmit.setAttribute("onclick", "return validateE()");

    //add all inputs to form
    eForm.appendChild(eNameDiv);
    eForm.appendChild(eAgeDiv);
    eForm.appendChild(eHealthDiv);
    eForm.appendChild(lNameDiv);
    eForm.appendChild(eSubmit);

    //hide button after click
    document.getElementById("endg-btn").style.display = "none";
    document.getElementById("thrv-btn").style.display = "none";
    document.getElementById("anml-h4").style.display = "none";

    document.getElementById("rngr-id").style.display = "block";
    document.getElementById("dtl-h5").style.display = "block";
}

function validateE() {
    var y = document.getElementById("eName").value;
    if (y == "") {
        alert("Enter a Valid name")
        return false;
    }
    ;
}

function thrivingForm() {
    //generate animal From
    var form = document.getElementById("form-div");

    //add div for name input
    var nameDiv = document.createElement("div");
    nameDiv.setAttribute("class", "txt_field col-12");

    //add name label to form
    var nameLabel = document.createElement("label");
    nameLabel.innerHTML = "Animal Name : ";
    nameLabel.htmlFor = "name";
    nameLabel.setAttribute("class", "form-label")

    //add name input to form
    var name = document.createElement("input");
    name.setAttribute("id", "name");
    name.setAttribute("name", "name");
    name.setAttribute("type", "text");
    name.setAttribute("placeholder", "Enter animal name");
    name.setAttribute("class", "form-control");

    //create name input
    nameDiv.appendChild(nameLabel);
    nameDiv.appendChild(name);

    //add div for age input
    var ageDiv = document.createElement("div");
    ageDiv.setAttribute("class", "form-group col-md-6");
    ageDiv.setAttribute("style", "width:200px;")

    //add age select to form
    var age = document.createElement("select");
    age.setAttribute("id", "age");
    age.setAttribute("name", "age");
    age.setAttribute("class", "form-control");
    age.setAttribute("type", "text");

    //add age label to form
    var ageLabel = document.createElement("label");
    ageLabel.setAttribute("for", "age");
    ageLabel.setAttribute("class", "form-label");
    ageLabel.innerHTML = "Animal Age : ";
    ageLabel.htmlFor = "age";

    //add age value options to select
    var ageValues = ["Newborn", "Young", "Old"];
    for (const j of ageValues) {
        var ageOptions = document.createElement("option");
        ageOptions.setAttribute("value", j);
        ageOptions.text = j;
        age.appendChild(ageOptions);
    }

    //create age input
    ageDiv.appendChild(ageLabel);
    ageDiv.appendChild(age);

    //add div for health input
    var healthDiv = document.createElement("div");
    healthDiv.setAttribute("class", "form-group col-md-6");
    healthDiv.setAttribute("style", "width:200px;")

    //add health select to form
    var health = document.createElement("select");
    health.setAttribute("id", "health");
    health.setAttribute("name", "health");
    health.setAttribute("class", "form-control");
    health.setAttribute("type", "text");

    //add health label to form
    var healthLabel = document.createElement("label");
    healthLabel.setAttribute("for", "health");
    healthLabel.setAttribute("class", "form-label")
    healthLabel.innerHTML = "Animal Health : ";
    healthLabel.htmlFor = "health";

    //add health value options to select
    var healthValues = ["Healthy", "Okay", "Ill"];
    for (const i of healthValues) {
        var healthOptions = document.createElement("option");
        healthOptions.setAttribute("value", i);
        healthOptions.text = i;
        health.appendChild(healthOptions);
    }

    //create health input
    healthDiv.appendChild(healthLabel);
    healthDiv.appendChild(health);

    //add div for location input
    var lNameDiv = document.createElement("div");
    lNameDiv.setAttribute("class", "form-group col-12");
    lNameDiv.setAttribute("style", "width:200px;")

    //add location select to form
    var lName = document.createElement("select");
    lName.setAttribute("id", "lName");
    lName.setAttribute("name", "lName");
    lName.setAttribute("class", "form-select");
    lName.setAttribute("type", "text");

    //add lName label to form
    var lNameLabel = document.createElement("label");
    lNameLabel.setAttribute("for", "lName");
    lNameLabel.setAttribute("class", "form-label");
    lNameLabel.innerHTML = "Location : ";
    lNameLabel.htmlFor = "lName";

    //add lName value options to select
    var locationValues = ["Aberdare National Park", "Amboseli National Park", "Arabuko Sokoke National Park", "Hell's Gate National Park", "Kora National Park", "Lake Nakuru National Park", "Masai Mara National Park", "Meru National Park", "Mount Elgon National Park", "Nairobi National Park", "Ol Donyo Sabuk National Park", "Tsavo East National Park", "Tsavo West National Park"];
    for (const l of locationValues) {
        var lNameOptions = document.createElement("option");
        lNameOptions.setAttribute("value", l);
        lNameOptions.text = l;
        lName.appendChild(lNameOptions);
    }

    //create lName input
    lNameDiv.appendChild(lNameLabel);
    lNameDiv.appendChild(lName);

    //add submit input to form
    var submit = document.createElement("input");
    submit.setAttribute("type", "submit");
    submit.setAttribute("value", "Add Animal");
    submit.setAttribute("style", "margin-left:15px;")
    submit.setAttribute("class", "btn btn-outline-secondary mbr-text mbr-fonts-style display-5");
    submit.setAttribute("onclick", "return validate()");

    //add all inputs to form
    form.appendChild(nameDiv);
    form.appendChild(ageDiv);
    form.appendChild(healthDiv);
    form.appendChild(lNameDiv);
    form.appendChild(submit);

    //hide button after click
    document.getElementById("thrv-btn").style.display = "none";
    document.getElementById("endg-btn").style.display = "none";
    document.getElementById("anml-h4").style.display = "none";

    document.getElementById("rngr-id").style.display = "block";
    document.getElementById("dtl-h5").style.display = "block";
}

function validate() {
    var x = document.getElementById("name").value;
    if (x == "") {
        alert("Enter a Valid name")
        return false;
    }
    ;
}
