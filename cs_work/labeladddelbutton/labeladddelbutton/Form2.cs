using labeladddelbutton.member;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace labeladddelbutton
{
    public partial class Form2 : Form
    {
        public Form2()
        {
            InitializeComponent();
            
            //this.WindowState = FormWindowState.Maximized;
            //this.IsMdiContainer = true;

            //MemberForm memberForm = new MemberForm();
            //memberForm.MdiParent = this;
            //memberForm.Show();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            this.WindowState = FormWindowState.Maximized;
            this.IsMdiContainer = true;
            
            MemberForm memberForm = new MemberForm();
            memberForm.MdiParent = this;
            //memberForm.Location = new Point(20, 100);

            //memberForm.FormBorderStyle = FormBorderStyle.None;
            //memberForm.Dock = DockStyle.Fill;

            //memberForm.TopLevel = false;
            //this.panel1.Controls.Add(memberForm);
            memberForm.Show();
        }

        private void button1_Click_1(object sender, EventArgs e)
        {
            this.WindowState = FormWindowState.Maximized;
            this.IsMdiContainer = true;

            MemberForm memberForm = new MemberForm();
            memberForm.MdiParent = this;
            //memberForm.Location = new Point(20, 100);

            //memberForm.FormBorderStyle = FormBorderStyle.None;
            //memberForm.Dock = DockStyle.Fill;

            //memberForm.TopLevel = false;
            //this.panel1.Controls.Add(memberForm);
            memberForm.Show();
        }
    }
}
