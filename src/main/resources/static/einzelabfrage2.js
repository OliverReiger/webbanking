    function arraySize() {
	    var jsonURL = "info/";
    	// Verarbeitung
            fetch(jsonURL)
            .then(empfaenger1)                 // Aufruf der Methode empfaenger1
            .then(empfaengerInfo2);                // Aufruf der Methode empfaenger2
	}
    
    
    function empfaenger1(antwort) {
        var json = antwort.json();  			// Datenpaket auspacken
        return json;                			// Datenpaket zurückgeben an Aufrufer der Funktion
    }


	
	function empfaengerInfo2(json) {
		document.getElementById("info").innerHTML = json
	};