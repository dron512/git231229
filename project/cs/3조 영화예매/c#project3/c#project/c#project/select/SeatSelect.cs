using c_project.database;
using c_project.final;
using c_project.Properties;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace c_project.seatselect
{
    public partial class SeatSelect : Form
    {
        TestDB testDB = new TestDB();

        #region 버튼클릭 bool 변수
        bool btnClick1 = false;
        bool btnClick2 = false;
        bool btnClick3 = false;
        bool btnClick4 = false;
        bool btnClick5 = false;
        bool btnClick6 = false;
        bool btnClick7 = false;
        bool btnClick8 = false;
        bool btnClick9 = false;
        bool btnClick10 = false;
        bool btnClick11 = false;
        bool btnClick12 = false;
        bool btnClick13 = false;
        bool btnClick14 = false;
        bool btnClick15 = false;
        #endregion
        #region 변수
        int adult {  get; set; }
        int teen {  get; set; }
        int old {  get; set; }
        int disabled {  get; set; }
        int sum = 0;
        int ttindex {  get; set; }
        int movieNum { get; set; }
        int peopleSum {  get; set; }
        #endregion
        List<int> seatNumInfo = new List<int>();

        String sttm = "";
        int checkpage = 0;
        int timeindex = 0;
        public SeatSelect()
        {
            InitializeComponent();
            timer1.Tick += timer1_Tick;
            timer1.Start();
        }

        public void movieDetailInfo(int ttindex,int movieNum,string peopleSum)
        {
            this.ttindex = ttindex;
            this.movieNum = movieNum;
            switch (movieNum)
            {
                case 1:
                    pictureBox1.Image = Resources.새벽의_저주;
                    break;
                case 2:
                    pictureBox1.Image = Resources.너의_이름은;
                    break;
                case 3:
                    pictureBox1.Image = Resources.살인의_추억;
                    break;
                case 4:
                    pictureBox1.Image = Resources.파묘;
                    break;
                case 5:
                    pictureBox1.Image = Resources.윙카;
                    break;
                case 6:
                    pictureBox1.Image = Resources.남산의_부장들;
                    break;
                case 7:
                    pictureBox1.Image = Resources.오펜하이머;
                    break;
                case 8:
                    pictureBox1.Image = Resources.나랏말싸미;
                    break;
            }

            List<string> mInfo = testDB.movieDetale(ttindex);

            moviename.Text = mInfo[0];
            movieage.Text = mInfo[1];
            movietime.Text = mInfo[2];
            starttime.Text = mInfo[3];
            movietheater.Text = mInfo[4];
            total.Text = peopleSum;

            seatInfo(ttindex);
        }

        public void seatInfo(int ttindex)
        {
            List<Button> buttons = new List<Button>{ button1, button2, button3, button4, button5, button6, button7, button8, button9, button10, button11, button12, button13, button14, button15 };
            List<string> seatInfo = new List<string>();
            seatInfo = testDB.seatInfo(ttindex);

            for (int i = 0; i < seatInfo.Count;i++)
            {
                for (int j = 0; j < buttons.Count;j++)
                {
                    if (buttons[j].Text.Equals(seatInfo[i]))
                    {
                        buttons[j].Enabled = false;
                        buttons[j].BackColor = Color.Gray;
                    }
                }

            }
        }

        public void peopleCount(int adult, int teen, int old, int disabled)
        {
            this.adult = adult;
            this.teen = teen;
            this.old = old;
            this.disabled = disabled;
            peopleSum = adult + teen + old + disabled;
            sum = adult+teen+old+disabled;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            Button button = sender as Button;
            int tag = int.Parse(button.Tag.ToString());
            Console.WriteLine(tag);
            switch (tag)
            {
                case 1:
                    btnClick1 = seatBtnInfo(button, btnClick1);
                    break;
                case 2:
                    btnClick2 = seatBtnInfo(button, btnClick2);
                    break;
                case 3:
                    btnClick3 = seatBtnInfo(button, btnClick3);
                    break;
                case 4:
                    btnClick4 = seatBtnInfo(button, btnClick4);
                    break;
                case 5:
                    btnClick5 = seatBtnInfo(button, btnClick5);
                    break;
                case 6:
                    btnClick6 = seatBtnInfo(button, btnClick6);
                    break;
                case 7:
                    btnClick7 = seatBtnInfo(button, btnClick7);
                    break;
                case 8:
                    btnClick8 = seatBtnInfo(button, btnClick8);
                    break;
                case 9:
                    btnClick9 = seatBtnInfo(button, btnClick9);
                    break;
                case 10:
                    btnClick10 = seatBtnInfo(button, btnClick10);
                    break;
                case 11:
                    btnClick11 = seatBtnInfo(button, btnClick11);
                    break;
                case 12:
                    btnClick12 = seatBtnInfo(button, btnClick12);
                    break;
                case 13:
                    btnClick13 = seatBtnInfo(button, btnClick13);
                    break;
                case 14:
                    btnClick14 = seatBtnInfo(button, btnClick14);
                    break;
                case 15:
                    btnClick15 = seatBtnInfo(button, btnClick15);
                    break;

            }
        }

        public bool seatBtnInfo(Button button,bool btnClick)
        {
            if (btnClick == false && sum != 0)
            {
                button.BackColor = Color.Gray;
                seatNumInfo.Add(int.Parse(button.Tag.ToString()));
                sum--;
                total.Text = sum.ToString();
                return btnClick = true;
            }
            else if (btnClick == true)
            {
                button.BackColor = Color.White;
                seatNumInfo.Remove(int.Parse(button.Tag.ToString()));
                sum++;
                total.Text = sum.ToString();
                return btnClick = false;
            }
            return false;
        }

        public void pagenumber(int page, int index)
        {
            checkpage = page;
            timeindex = index;
        }
        public void setstarttime(String sttima)
        {
            sttm = sttima;
            starttime.Text = sttima;
        }
        private void back_Click(object sender, EventArgs e)
        {
            Close();
        }
        private void home_Click(object sender, EventArgs e)
        {
            Ticketing ticketing = new Ticketing();
            ticketing.Show();
            this.Close();
        }

        private void next_Click(object sender, EventArgs e)
        {
            Final final = new Final();
            if (sum == 0)
            {
                final.movieDetailInfo(ttindex, movieNum, peopleSum, adult, teen, old, disabled);
                seatNumInfo.Sort();
                final.checkSeat(seatNumInfo);
                Hide();
                final.ShowDialog();
            }
            else
            {
                MessageBox.Show("좌석을 선택해주세요.");
            }
            
        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            time.Text = DateTime.Now.ToString("HH:mm");
        }
    }
}
