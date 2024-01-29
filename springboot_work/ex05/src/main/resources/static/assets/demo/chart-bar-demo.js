// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#292b2c';

// Bar Chart Example
var ctx = document.getElementById("myBarChart");
var myBarChart = new Chart(ctx, {
  type: 'bar',
  data: {
    labels: ["January", "February", "March", "April", "May"],
    datasets: [{
      label: "Revenue",
      backgroundColor: "rgba(2,117,216,1)",
      borderColor: "rgba(2,117,216,1)",
      data: [4215, 5312, 14984, 7841, 9821],
    }],
  },
  options: {
    scales: {
      xAxes: [{
        time: {
          unit: 'month'
        },
        gridLines: {
          display: false
        },
        ticks: {
          maxTicksLimit: 5
        }
      }],
      yAxes: [{
        ticks: {
          min: 0,
          max: 15000,
          maxTicksLimit: 5
        },
        gridLines: {
          display: true
        }
      }],
    },
    legend: {
      display: false
    }
  }
});

setInterval( ()=>{
   const randomArray = Array.from({ length: 5 }, () => Math.floor(Math.random() * 15001));
   myBarChart.data.datasets[0].data = randomArray;
   myBarChart.update();
   /*
    $.ajax({
           url:'http://127.0.0.1:5000/barData',
           type:'get',
           success:function(res){
               myBarChart.data.datasets[0].data = res.slice(1, -1).split(',').map((num)=> num );
               myBarChart.update();
           },
           error:function(e){
           }
    })
    */
}, 3000);
