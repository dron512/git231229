using ex0220_File_입출력.file;
using System;
using System.Collections.Generic;
using System.Windows.Forms;

namespace ex0220_File_입출력
{
    public partial class Form1 : Form
    {
        FileControl fc = new FileControl();

        List<string> list = new List<string>();

        public Form1()
        {
            InitializeComponent();
        }

        private void 불러오기(object sender, EventArgs e)
        {
            fc.read();
        }

        private void 파일쓰기(object sender, EventArgs e)
        {
            if(textBox1.Text=="")
            {
                MessageBox.Show("글자를 입력하세요");
                return;
            }

            fc.write(textBox1.Text);
            list.Add(textBox1.Text);

            listBox1.DataSource = null;
            listBox1.DataSource = list;
            textBox1.Text = "";

            //listBox1.Items.Add("추가");
        }
    }
}
