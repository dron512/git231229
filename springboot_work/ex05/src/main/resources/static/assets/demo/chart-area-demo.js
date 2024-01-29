// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#292b2c';

// Area Chart Example
var ctx = document.getElementById("myAreaChart");
var myAreaChart = new Chart(ctx, {
  type: 'line',
  data: {
    labels: ["Mar 1", "Mar 2", "Mar 3", "Mar 4", "Mar 5"],
    datasets: [{
      label: "Sessions",
      lineTension: 0.7,
      backgroundColor: "rgba(2,117,216,0.2)",
      borderColor: "rgba(2,255,216,1)",
      pointRadius: 5,
      pointBackgroundColor: "rgba(2,117,216,1)",
      pointBorderColor: "rgba(255,255,255,0.8)",
      pointHoverRadius: 5,
      pointHoverBackgroundColor: "rgba(2,117,216,1)",
      pointHitRadius: 50,
      pointBorderWidth: 2,
      data: [20,30,50,100,20],
    }],
  },
  options: {
    scales: {
      xAxes: [{
        time: {
          unit: 'date'
        },
        gridLines: {
          display: true
        },
        ticks: {
          maxTicksLimit: 7
        }
      }],
      yAxes: [{
        ticks: {
          min: 0,
          max: 150,
          maxTicksLimit: 5
        },
        gridLines: {
          color: "rgba(0, 0, 0, .125)",
        }
      }],
    },
    legend: {
      display: false
    }
  }
});

setInterval( ()=>{
    const randomArray = Array.from({ length: 5 }, () => Math.floor(Math.random() * 151));
    myAreaChart.data.datasets[0].data = randomArray;
    myAreaChart.update();
    /*
    $.ajax({
           url:'http://127.0.0.1:5000/chartData',
           type:'get',
           success:function(res){
               myAreaChart.data.datasets[0].data = res.slice(1, -1).split(',').map((num)=> num );
               myAreaChart.update();
           },
           error:function(e){
           }
    })
    */
}, 3000);
