
var weatherData;
var cityList = [ "Klaipeda", "Vilnius", "Kaunas", "Siauliai", "Panevezys" ];
var weatherByCity;

function getCity() {
	for (var i = 0; i < cityList.length; i++) {
		weatherByCity = cityList[i];
		getWeather();
	}
}
setTimeout(getCity, 15 * 60 * 1000);
setInterval(getCity, 60 * 60 * 1000);

function getWeather() {
	var temp, pressure, humidity, city;
	$.ajax({
		url : "http://api.openweathermap.org/data/2.5/weather?q="+ weatherByCity + "&APPID=497f27c30263fbc7989157a9cea7fd60",
		type : "POST",
		dataType : "JSON",
		success : function(data) {
			temp = data.main.temp;
			pressure = data.main.pressure;
			humidity = data.main.humidity;
			city = data.name;
			console.log("temp: " + temp + " pressure: " + pressure + " humidity: " + humidity, "City: " + city);
			weatherData = {
				"temp" : temp,
				"pressure" : pressure,
				"humidity" : humidity,
				"city" : city
			};
			sendWeatherData();
		},
		error : function(data) {
			console.log("Klaida");
		}
	});
}

function sendWeatherData() {
	var protocol = window.location.protocol; // Gaunama is url (http:)
	var host = window.location.host; // Gaunama is url (localhost:8080)
	var pathNameArray = window.location.pathname.split("/"); // Gaunama dalis url: ["", "task", "showChart"]
	var contextPath = protocol+"//"+host+"/"+pathNameArray[1];

	$.ajax({
		url : contextPath+"/api/getWeather",
		type : "GET",
		data : weatherData,
		dataType : "JSON",
		success : function() {
			console.log("suveike siuntimas");
			console.log(weatherData);
		},
		error : function() {
			console.log("klaida error metodas");
			console.log(weatherData);
		}
	});
}

//Istrinimo dialogas, jei paspaudziama cancel irasas neistrinamas
$('.dltBtn').click(function(e){
    var result = confirm("Are you sure you want to delete the entry?");
    if(!result) {
        e.preventDefault();
    }
});


