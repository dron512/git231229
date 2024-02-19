using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WindowsFormsApp2
{
    public partial class Form1 : Form
    {
        private List<string> dataList = new List<string> { "Item 1", "Item 2", "Item 3" };
        private List<Person> personList = new List<Person>();


        public Form1()
        {
            InitializeComponent();

            listBox1.DataSource = dataList;
            personList.Add(new Person() { Name = "홍길동", age = 10 });
            personList.Add(new Person() { Name = "홍길동", age = 10 });
            personList.Add(new Person() { Name = "홍길동", age = 10 });

            dataGridView1.DataSource = personList;

        }

        private void button1_Click(object sender, EventArgs e)
        {
            personList.Add(new Person() { Name = "홍길동", age = 10 });
            personList.Add(new Person() { Name = "홍길동", age = 10 });
            personList.Add(new Person() { Name = "홍길동", age = 10 });
            dataGridView1.DataSource = null;
            dataGridView1.DataSource = personList;
        }

        private void button2_Click(object sender, EventArgs e)
        {
            dataList.Add("test");
            dataList.Add("test");
            listBox1.DataSource = null;
            listBox1.DataSource = dataList;

        }
    }


}
