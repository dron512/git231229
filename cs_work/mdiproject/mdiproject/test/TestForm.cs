using mdiproject.todo;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace mdiproject.test
{
    public partial class TestForm : Form
    {
        private static TestForm instance = null;

        public static TestForm getInstance()
        {
            if (instance == null || instance.IsDisposed)
            {
                instance = new TestForm();
                return instance;
            }
            else
            {
                return instance;
            }
        }
        public TestForm()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            //DataGridViewColumn column =  new DataGridViewColumn();
            //column.HeaderText = "text";

            dataGridView1.Columns.Clear();
            dataGridView1.Rows.Clear();


            dataGridView1.Columns.Add("column1","column1");
            dataGridView1.Columns.Add("column2", "column2");
            dataGridView1.Columns.Add("column3", "column3");


            dataGridView1.Rows.Add("value1", "value2","value3");
            dataGridView1.Rows.Add("value1", "value2", "value3");
            dataGridView1.Rows.Add("value1", "value2", "value3");

        }
    }
}
