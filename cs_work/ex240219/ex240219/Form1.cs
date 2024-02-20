using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ex240219
{
    public partial class Form1 : Form
    {
        List<string> listboxdata = new List<string>() { "홍길동","이길동","박길동"};
        List<Person> personlist = new List<Person>() {
            new Person(){name = "김길동", age= 20},
            new Person(){name = "이길동", age= 30}
        };
        public Form1()
        {
            InitializeComponent();

            dataGridView1.DataSource = null;
            dataGridView1.DataSource = personlist;

            List<int> ints = new List<int>() { 11,22,33,44,55 };
            string result = "";
            foreach (int i in ints)
            {
                result += i;
            }
            label1.Text = result;
        }

        public void myThread()
        {
            Random random = new Random();
            double ran = random.NextDouble();
            //button1.Text = ran.ToString();
            while (true)
            {
                Thread.Sleep(1000);
                Invoke(new Action( ()=>{
                    button1.Location = new Point(random.Next(700), random.Next(500));
                }));
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            Thread th1 = new Thread(myThread);
            th1.Start();

            button1.Text = "동적으로 버튼생성";
            button1.Width = 400;

            for(int i = 0;i < 5; i++)
            {
                Button button = new Button();
                button.Text = i.ToString();
                this.Controls.Add(button);

                Point point = new Point();
                point.X = 10;
                point.Y = 100 + 40 * i;
                button.Location = point;

                bool visible = new Random().Next(2)==0? true : false;

                Thread.Sleep(10);
                button.Visible = visible;
            }

        }

        private void button2_Click(object sender, EventArgs e)
        {
            A a = new A() { x=10, y=20 };
            A b = a;

            AA aa = new AA() { x=10, y=20 };
            AA bb = aa;

            a.x = 100;
            Console.WriteLine( $"a.x = "+a.x );
            Console.WriteLine( $"b.x = {b.x}" );

            aa.x = 100;
            Console.WriteLine($"aa.x = {aa.x}");
            Console.WriteLine($"bb.x = {bb.x}");
        }

        private void button3_Click(object sender, EventArgs e)
        {
            List<int> list = new List<int>() { 10,20,30,40,50 };
            foreach( var i in list)
            {
                Console.WriteLine( i );
            }
        }

        private void button4_Click(object sender, EventArgs e)
        {
            listBox1.DataSource = null;
            listboxdata.Add("김길동");
            listBox1.DataSource = listboxdata;
        }

        private void button5_Click(object sender, EventArgs e)
        {
            Console.WriteLine( "일로오나");
            personlist.Add(new Person() { name = "이길동", age = 30 });
            dataGridView1.DataSource = null;
            dataGridView1.DataSource = personlist;
        }

        List<int> ints = new List<int>() { 11, 22, };
        private void button6_Click(object sender, EventArgs e)
        {
            int temp = new Random().Next(100);
            
            Button btn = new Button();
            btn.Text = temp.ToString();
            btn.Click += Btn_Click;
            btn.Location = new Point(0, 0);
            Controls.Add(btn);

            ints.Add(temp);

            string result = "";
            foreach (int i in ints)
            {
                result += i+" ";
            }
            label1.Text = result;
        }

        private void Btn_Click(object sender, EventArgs e)
        {
            Button btn = sender as Button;
            ints.Remove(int.Parse(btn.Text));
            string result = "";
            foreach (int i in ints)
            {
                result += i + " ";
            }
            label1.Text = result;
        }
    }
}

