// Gnerator für Testdaten - Array List
function testDataStart() {
   	var eingabeUser = document.getElementById("inputUserTestdata").value;
   	var url = "/createTestdata/" + eingabeUser;
   	window.location = url;
   }
    
document.getElementById("button").addEventListener("click", testDataStart);