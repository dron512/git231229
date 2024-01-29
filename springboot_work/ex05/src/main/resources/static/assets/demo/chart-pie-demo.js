// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#292b2c';

// Pie Chart Example
var ctx = document.getElementById("myPieChart");
var myPieChart = new Chart(ctx, {
  type: 'pie',
  data: {
    labels: ["Blue", "Red", "Yellow", "Green","Black"],
    datasets: [{
      data: [12.21, 15.58, 11.25, 8.32,20],
      backgroundColor: ['#007bff', '#dc3545', '#ffc107', '#28a745'],
    }],
  },
});

setInterval( ()=>{
    const randomArray = Array.from({ length: 5 }, () => Math.floor(Math.random() * 101));
    myPieChart.data.datasets[0].data = randomArray;
    myPieChart.update();
    /*
    $.ajax({
           url:'http://127.0.0.1:5000/pieData',
           type:'get',
           success:function(res){
               myPieChart.data.datasets[0].data = res.slice(1, -1).split(',').map((num)=> num );
               myPieChart.update();
           },
           error:function(e){
           }
    })
    */
}, 3000);

