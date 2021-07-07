function invokeCalculation(operationType){
	var number1 = document.getElementById("number1").value;
	var number2 = document.getElementById("number2").value;
	
	console.log(operationType.value);

	
	if(number1!="" && number2!="")
	{
	var requestData ={"number1" :  number1,
					  "number2" : number2};		  
	var requestJson = JSON.stringify(requestData);
	
	console.log("req:: "+requestData);
	fetch("http://localhost:8080/"+operationType.value,
		{
			headers : {"content-type" : "application/json"},
			body : requestJson,
			method : "POST"
		}).then(res => res.json())
  		 // .then(res => console.log(res.result))
  		  .then(res => document.getElementById("result").innerHTML = "The result is : "+res.result);
}
return false;
}