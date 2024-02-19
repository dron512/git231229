using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WindowsFormsApp1
{
    public partial class Form1 : Form
    {
        int gak = 10;


        public Form1()
        {
            InitializeComponent();

            timer1.Interval = 100;
            timer1.Start();
        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            Console.WriteLine(Math.PI);   // 원주율 3.141592653589793

            Console.WriteLine(Math.Cos((gak * Math.PI) / 180) * 100);
            Console.WriteLine(Math.Sin((gak * Math.PI) / 180) * 100);

            int x = 200 + (int)(Math.Cos((gak * Math.PI) / 180) * 150);
            int y = 200 + (int)(Math.Sin((gak * Math.PI) / 180) * 150);

            Console.WriteLine("출력");
            button1.Location = new Point(x, y);
            gak += 10;
        }
    }
}
