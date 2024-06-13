using studentApplication.model;
using studentApplication.repo;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace studentApplication
{
    public partial class Form2 : Form
    {
        private StudentRepo repo = new StudentRepo();

        public Form2()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            dataGridView1.DataSource = repo.FindAll();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            try
            {
                StudentModel model = new StudentModel()
                {
                    Name = tb_name.Text,
                    Math = int.Parse(tb_math.Text),
                    Eng = int.Parse(tb_eng.Text),
                    Kor = int.Parse(tb_kor.Text)
                };

                repo.save();
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.StackTrace);
            }
        }
    }
}
