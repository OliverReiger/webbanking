// Listener auf die Buttons
document.getElementById("btn").addEventListener("click", auslesen);


function auslesen() {
	
	var eingabeIDuser = document.getElementById("input").value;
	var jsonURL = "einzelzahlung/" + eingabeIDuser;
	// Verarbeitung
        fetch(jsonURL)
    // fetch("zahlung.json")       		   // URL: was wird geholt
        .then(empfaenger1)                 // Aufruf der Methode empfaenger1
        .then(empfaenger2);                // Aufruf der Methode empfaenger2
}


function empfaenger1(antwort) {
    var json = antwort.json();  			// Datenpaket auspacken
    

    
    return json;                			// Datenpaket zurückgeben an Aufrufer der Funktion
}

function empfaenger2(json) {

    var empfaenger 			= json.empfaenger; 
    var iban 				= json.empfaengerIBAN; 
    var bic 				= json.empfaengerBIC;
    var betrag 				= json.betrag;
    var waehrung 			= json.waehrung;
    var verwendungszweck 	= json.verwendungszweck;

    document.getElementById("empfaenger").innerHTML			= empfaenger;
    document.getElementById("iban").innerHTML				= iban;
    document.getElementById("bic").innerHTML				= bic;
    document.getElementById("betrag").innerHTML				= betrag;
    document.getElementById("waehrung").innerHTML 			= waehrung;
    document.getElementById("verwendungszweck").innerHTML   = verwendungszweck;

}

