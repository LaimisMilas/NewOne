// Diagramos scriptas
// Paima url adresa ir pavercia objektu: Object { tenant: "LT/KL/KLAIPEDA/O91241B/BLD01/iot124" }
// Tada urlParams verte idedama i ajax uzklausa. O ChartRestControlleri gaudomas tenant kintamasis, atliekama uzklausa 
// ir atsiunciamas objektu listas: List<EnergyConsumed>
var urlParams;
(window.onpopstate = function () {
    var match,
        pl     = /\+/g,  // Regex for replacing addition symbol with a space
        search = /([^&=]+)=?([^&]*)/g,
        decode = function (s) { return decodeURIComponent(s.replace(pl, " ")); },
        query  = window.location.search.substring(1);
    urlParams = {};
    while (match = search.exec(query))
       urlParams[decode(match[1])] = decode(match[2]);
})();

function chart() {
	var pathNameArray = window.location.pathname.split("/"); // Gaunama dalis url: ["", "task", "showChart"]
var myChart = document.getElementById('myChart').getContext('2d');
var chartData;
$.ajax({
	url: "/"+pathNameArray[1]+"/getChartData",
	type: "POST",
	data: urlParams,
	dataType: "JSON",
	success : function (data) {
		chartData = data;
		console.log(chartData);
		showChart(data)
	},
	error : function () {
		console.log("nuluzo");
	}
});
}
setTimeout(chart, 100);

function showChart(data) {
console.log(new Date (data[0].date).toDateString());
var massPopChart = new Chart(myChart, {
    type: 'bar',
    data: {
        labels:[new Date (data[0].date).toDateString()],
        datasets:[{
            label: 'Used Energy',
            backgroundColor: 'rgba(255, 99, 132, 0.5)',
            borderColor: 'rgba(255,99,132,1)',
            borderWidth: 1,
            data: [data[0].usedEnergy]
        }]
    },
    options:{}
});
for(var a=1; a<data.length; a++){
	massPopChart.data.labels[a] = new Date (data[a].date).toDateString();
	massPopChart.data.datasets[0].data[a] = data[a].usedEnergy;
	massPopChart.update();
	}
var newDataset = {
        label: 'Estimated Energy',
        backgroundColor: 'rgba(99, 255, 132, 0.5)',
        borderColor: 'rgba(99, 255, 132, 1)',
        borderWidth: 1,
        data: [data[0].energyKwh]
    }
	massPopChart.data.datasets.push(newDataset);
	massPopChart.update();
	for(var n=1; n<data.length; n++){
		console.log(n);
		newDataset.data[n] = [data[n].energyKwh];
		massPopChart.update()
		    }
	}


