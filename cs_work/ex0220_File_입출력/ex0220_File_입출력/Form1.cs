using ex0220_File_입출력.database;
using ex0220_File_입출력.file;
using System;
using System.Collections.Generic;
using System.Windows.Forms;

namespace ex0220_File_입출력
{
    public partial class Form1 : Form
    {


        FileControl fc = new FileControl();
        FileTBDataBase ftdb = new FileTBDataBase();

        //List<string> list = new List<string>();

        public Form1()
        {
            InitializeComponent();

            //List<string> list = fc.read();

            List<string> list = ftdb.read();
            listBox1.DataSource = null;
            listBox1.DataSource = list;
        }

        private void 불러오기(object sender, EventArgs e)
        {
            //List<string> list = fc.read();
            List<string> list = ftdb.read();
            listBox1.DataSource = null;
            listBox1.DataSource = list;
        }

        private void 파일쓰기(object sender, EventArgs e)
        {
            // 혹시나 아무글자 않넣으면 그다음꺼 진행 하지 않고 종료
            if(textBox1.Text=="")
            {
                MessageBox.Show("글자를 입력하세요");
                return;
            }

            // 파일에 list 저장
            //fc.write(textBox1.Text, list);

            // list 객체안에 글자 담기
            //list.Add(textBox1.Text);

            // DB 에 저장하기
            ftdb.insert(textBox1.Text);
            List<string> list = ftdb.read();

            // 화면에 추가된 내용 보여주기
            listBox1.DataSource = null;
            listBox1.DataSource = list;
            // 글자 적은거 깨끗하게
            textBox1.Text = "";

            //listBox1.Items.Add("추가");
        }
    }
}
