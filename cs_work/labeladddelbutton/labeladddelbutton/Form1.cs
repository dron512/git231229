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
    public partial class Form1 : Form
    {
        List<int> ints = new List<int>();

        int size = 3;

        public Form1()
        {
            InitializeComponent();

            //this.label2.Font = new System.Drawing.Font("배달의민족 도현", 26.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(129)));

            Console.WriteLine();

            //ints.Add(11);
            //ints.Add(22);


            addButtons();
            setLabelList();

            //this.panel1.IsMdiContainer = true;
        }

        private void Button_Click1(object aa, EventArgs bb)
        {
            MessageBox.Show("함수 연결 또 되니?");
        }

        private void Button_Click(object sender, EventArgs e)
        {
            Button btn = (Button) sender;
            //MessageBox.Show("Test"+btn.Text);
            int temp = int.Parse(btn.Text);
            ints.Add(temp);

            setLabelList();
        }

        #region 버튼 추가 하는 함수
        private void addButtons()
        {
            Random ran = new Random();
            for (int i = 0; i < 5; i++)
            {
                string randomstr = ran.Next(100).ToString();
                // 추가 하는 버튼...
                Button button = new Button();
                button.Text = randomstr;
                button.Font = new System.Drawing.Font("배달의민족 도현", 26.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(129)));
                button.Location = new Point(80 + (i * 100), 210);
                button.AutoSize = true;
                button.Click += Button_Click;

                //button.Click += new System.EventHandler(Button_Click1);
                //button.Click += (sender, e) =>
                //{
                //    MessageBox.Show("람다도 연결 되네..."+sender+""+e);
                //};
                Controls.Add(button);
                // 삭제 하는 버튼
                Button button1 = new Button();
                button1.Text = randomstr;
                button1.Font = new System.Drawing.Font("배달의민족 도현", 26.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(129)));
                button1.Location = new Point(80 + (i * 100), 330);
                button1.AutoSize = true;
                button1.Click += Button1_Click;
                //button1.Click += (sender,e) =>
                //{
                //    Button temp = sender as Button;
                //    int itemp = int.Parse(temp.Text);
                //    ints.Remove(itemp);
                //    //ints.RemoveAt(0);
                //    setLabelList();
                //};

                Controls.Add(button1);
            }
        }

        private void Button1_Click(object sender, EventArgs e)
        {
            Button temp = sender as Button;
            int itemp = int.Parse(temp.Text);
            ints.Remove(itemp);
            //ints.RemoveAt(0);
            setLabelList();
        }



        #endregion

        #region list 설정하는 함수

        private void setLabelList()
        {
            string result = "";
            for (int i = 0; i < ints.Count; i++)
            {
                if (ints.Count != (i + 1))
                    result = result + (ints[i] + ", ");
                else
                    result = result + (ints[i]);
            }
            label2.Text = result;
        }

        #endregion


        // 폼이 나오는 순간 실행되는 함수
        private void Form1_Load(object sender, EventArgs e)
        {
            //MessageBox.Show("Test");
        }

        private void button1_Click(object sender, EventArgs e)
        {
            this.WindowState = FormWindowState.Maximized;

            MessageBox.Show(this.MaximumSize.ToString());
            MemberForm memfrm = new MemberForm();
            memfrm.TopLevel = false;

            this.panel1.Controls.Add(memfrm);
            //memfrm.MdiParent = this;
            memfrm.Show();
        }
    }
}
