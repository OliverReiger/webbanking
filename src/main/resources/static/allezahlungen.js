// Sammlung von Listener
document.getElementById("table").addEventListener("click", tabelleAusJson);
document.getElementById("btnK").addEventListener("click", kontostand);

// VARIABLE MIT DYNAMISCHE TABELLE ERZEUGEN
var table = document.createElement("table");

// FUNKTIONSAUFRUF zum senden eines DELETE an WEBSERVER und RELOAD TABELLE
function loescheZelle(i) {
	fetch("/zahlung/" + i,
			{
				headers: {"Content-Type":"application/json"},
				method: "DELETE",
				body: ""
			}
			).then(alert("Danke für die Nutzung unseres Webservices! Es wurden Ihnen Gebühren in Höhe von 0,05 Euro in Rechnung gestellt!"))
	
	zeile = table.deleteRow(i+1);
	
}

// FUNKTIONSAUFRUF zum abholen der json Daten über REST API und Erzeugung einer Tabelle
// Schritt 1: Vorbereitung des Abrufs und abholen der json
function tabelleAusJson() {
        var jsonURL = "/zahlungen/"			// URL zum Abfragen - REST API Get aus Java
        fetch(jsonURL)						// JSON abrufen
        .then(empfaenger1)
        .then(empfaenger2)
    }

// FUNKTIONSAUFRUF zum abholen der json Daten über REST API und Erzeugung einer Tabelle
// Schritt 2: Auspacken der json und als Array weiterreichen   
function empfaenger1(antwort) {
    var json = antwort.json();  			// Datenpaket auspacken
    return json;                			// Datenpaket zurückgeben an Aufrufer der Funktion
}

// FUNKTIONSAUFRUF zum abholen der json Daten über REST API und Erzeugung einer Tabelle
// Schritt 3: ex-json als Array verwenden um dynamisch eine Tabelle zu erzeugen  
function empfaenger2(json) {
	
        var spalte = [];
        for (var i = 0; i < json.zahlungen.length; i++) {
            for (var key in json.zahlungen[i]) {
                if (spalte.indexOf(key) === -1) {
                    spalte.push(key);
                }
            }
        }

         // TABELLEN Überschriften erstellen aus den Variablennamen der Json
        var zeile = table.insertRow(-1);                   			// TABELLEN ZEILE.

        for (var i = 0; i < spalte.length; i++) {
            var ueberschrift = document.createElement("th");        // TABELLEN ÜBERSCHRIFT.
            ueberschrift.innerHTML = spalte[i];
            zeile.appendChild(ueberschrift);
        }
        
        // Hinzufügen der Daten aus Json als Zeilen
        for (var i = 0; i < json.zahlungen.length; i++) {
            zeile = table.insertRow(-1);

            for (var j = 0; j < spalte.length; j++) {
                var tabellenZellen = zeile.insertCell(-1);
                tabellenZellen.innerHTML = json.zahlungen[i][spalte[j]];
                 }
                 // Erzeugen eines Links zum Aufruf der REST DELETE Methode über Link
                 var tabellenZellen = zeile.insertCell(-1);
                 tabellenZellen.innerHTML = '<a href = "#" onclick="loescheZelle('+i+');" title="delete">delete</a>';
          }

        // Erzeugte Tabelle mit den Daten aus Json Abruf in Div-Block ausgeben.
        var divContainer = document.getElementById("output");
        divContainer.innerHTML = "";
        divContainer.appendChild(table);
        }
        
        
        function kontostand() {
	    var jsonURL = "infoUmsatz/";
    	// Verarbeitung
            fetch(jsonURL)
            .then(empfaenger1)                 	// Aufruf der Methode empfaenger1
            .then(empfaengerKonto2);                // Aufruf der Methode empfaenger2
	}
	
	function empfaengerKonto2(json) {
		document.getElementById("info").innerHTML = json
	};
        