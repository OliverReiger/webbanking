// Listener
document.getElementById("button").addEventListener("click", post);
document.getElementById("zufall").addEventListener("click", zufall);

// Neuen Eintrag an REST API senden
function post() {
	// Eingaben prüfen
		if (document.getElementById("empf").value == "") {
			alert("Du musst auch einen Empfänger angeben!");
		} else if (document.getElementById("iban").value == "") {
			alert("Du musst auch eine IBAN angeben!");
		} else if (document.getElementById("bic").value == "") {
			alert("Du musst auch eine BIC angeben!");
		} else if (document.getElementById("betr").value == "") {
			alert("Du musst einen Betrag angeben!");
		} else if (document.getElementById("waeh").value == "") {
			alert("Du musst eine Währung angeben!");
		} else if (document.getElementById("verw").value == "") {
			alert("Du musst auch einen Verwendungszweck angeben!");
		} else {	
	
	// Eingaben auslesen
	var input = {
		empfaenger: 		document.getElementById("empf").value,
		empfaengerIBAN: 	document.getElementById("iban").value,
		empfaengerBIC: 		document.getElementById("bic").value,
		betrag: 	  		document.getElementById("betr").value,
		waehrung:   		document.getElementById("waeh").value,
		verwendungszweck: 	document.getElementById("verw").value,		
	}
	
	// String in json umwandeln
	var json = JSON.stringify(input)
	
	// Daten senden
	fetch("/zahlung/",
	{
		headers: {"Content-Type":"application/json"},
		method: "POST",
		body: json
	}
	
	// Bestätigung ausgeben
	).then(alert("Danke für die Nutzung unseres Webservices! Es wurden Ihnen Gebühren in Höhe von 0,05 Euro in Rechnung gestellt!"))
	}
}

function zufall() {
	
	// Deklaration Variable
	var empfaenger 			= zufallEmpfaenger();
	var empfaengerIBAN 		= zufallIBAN();
	var empfaengerBIC 		= zufallBIC();
	var betrag 				= zufallBetrag();
	var waehrung 			= "Euro";
	var verwendungszweck 	= zufallZweck();
	
	// Werte setzen
	document.getElementById("empf").value = empfaenger;
	document.getElementById("iban").value = empfaengerIBAN;
	document.getElementById("bic").value  = empfaengerBIC;
	document.getElementById("betr").value = betrag;
	document.getElementById("waeh").value = waehrung;
	document.getElementById("verw").value = verwendungszweck;
		
}

function zufallBetrag() {
	var min = 1;
	var max = 1000;
	var betrag = Math.floor(Math.random() * (max - min)) + min;
	return betrag
}

function zufallEmpfaenger() {
	var werte = ["Andre", "Eckard", "Elisabeth", "Holger", "Franzi", "Marco", "Peggy", "Oli", "Thorsten", "Christof", "Michael", "Joachim", "Robert", "Felix"];
	var zufall = Math.floor(Math.random()*werte.length);
	var empfaenger = werte[zufall];
	return empfaenger
}

function zufallIBAN() {
	var werte = ['DE89370400440532013000', 'DE44880401230511099041', 'DE45368500110544055011', 'DE333704011147532044009', 'DE11770407740992099044'];
	var zufall = Math.floor(Math.random()*werte.length);
	var iban = werte[zufall];
	return iban
}

function zufallBIC() {
	var werte = ['BYLADEM1SAD', 'BYABCDM1SAD', 'CALADEM1ODD', 'ZZLADCE3SAD', 'DAABDEM9MUC'];
	var zufall = Math.floor(Math.random()*werte.length);
	var bic = werte[zufall];
	return bic
}

function zufallZweck() {
	var werte = ['Schuhe', 'Handtasche', 'Tickets', 'Spende', 'Mitgliedsbeitrag', 'Auto', 'Computer', 'Zweifelhaftes Abo', 'Gebühren', 'Haus', 'Haushaltshilfe', 'Schulgeld'];
	var zufall = Math.floor(Math.random()*werte.length);
	var zweck = werte[zufall];
	return zweck
}

