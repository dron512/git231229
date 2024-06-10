using c_project.database;
using c_project.movie;
using c_project.Properties;
using c_project.seatselect;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace c_project.seat
{
    public partial class MovieSeat1 : Form
    {
        int adult = 0;
        int teen = 0;
        int old = 0;
        int disabled = 0;
        int PosX = 0;
        int movieNum { get; set; }
        int ttindex { get; set; }

        TestDB testDB = new TestDB();

        List<int> list = new List<int>();
        int personcheck = 0;

        public MovieSeat1()
        {
            InitializeComponent();
            timer1.Tick += timer1_Tick;
            timer1.Start();
            btnEnabled();
        }

        public void movieTimeTable(int movieNum)
        {
            this.movieNum = movieNum;
            switch (movieNum)
            {
                case 1:
                    pictureBox5.Image = Resources.새벽의_저주;
                    break;
                case 2:
                    pictureBox5.Image = Resources.너의_이름은;
                    break;
                case 3:
                    pictureBox5.Image = Resources.살인의_추억;
                    break;
                case 4:
                    pictureBox5.Image = Resources.파묘;
                    break;
                case 5:
                    pictureBox5.Image = Resources.윙카;
                    break;
                case 6:
                    pictureBox5.Image = Resources.남산의_부장들;
                    break;
                case 7:
                    pictureBox5.Image = Resources.오펜하이머;
                    break;
                case 8:
                    pictureBox5.Image = Resources.나랏말싸미;
                    break;
            }

            list = testDB.timeTableIndex(movieNum);
            endMovie();

        }

        public void endMovie()
        {
            for (int i = 0; i < list.Count; i++)
            {
                DateTime startTime = testDB.movieStartTime(list[i]);
                string currentSeat = testDB.currentSeat(list[i]);

                if (startTime < DateTime.Now && list.Count - i < 5)
                {
                    makeEndPanel(PosX);
                }
                else if(startTime > DateTime.Now)
                {
                    string time = startTime.ToString("MM/dd HH:mm");
                    makePanel(PosX, time, currentSeat, list[i]);
                }
            } 
        }

        private void makeEndPanel(int PosX)
        {
            Panel panel1 = new Panel();
            Label label1 = new Label();

            panel1.BackColor = Color.FromArgb(((int)(((byte)(64)))), ((int)(((byte)(64)))), ((int)(((byte)(64)))));
            panel1.Font = new Font("KoPubWorld돋움체 Bold", 11.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte)(129)));
            panel1.ForeColor = Color.Transparent;
            panel1.Location = new Point(PosX, 95);
            panel1.Name = "panel1";
            panel1.Size = new Size(170, 130);
            panel1.TabIndex = 22;


            this.PosX += 174;

            label1.AutoSize = false;
            label1.Font = new Font("KoPubWorld돋움체 Bold", 20F, FontStyle.Bold, GraphicsUnit.Point, ((byte)(129)));
            label1.ForeColor = Color.Red;
            label1.Dock = DockStyle.Fill;
            label1.TextAlign = ContentAlignment.MiddleCenter;
            label1.Name = "label1";
            label1.Size = new Size(152, 83);
            label1.TabIndex = 0;
            label1.Text = "상영종료";

            panel1.Controls.Add(label1);
            Controls.Add(panel1);
        }

        public void makePanel(int PosX, string startTime, string currentSeat, int ttindex)
        {
            Panel panel1 = new Panel();
            Label time1 = new Label();
            Label seat1 = new Label();

            panel1.BackColor = Color.FromArgb(((int)(((byte)(64)))), ((int)(((byte)(64)))), ((int)(((byte)(64)))));
            panel1.Font = new Font("KoPubWorld돋움체 Bold", 15F, FontStyle.Bold, GraphicsUnit.Point, ((byte)(129)));
            panel1.ForeColor = Color.Transparent;
            panel1.Location = new Point(PosX, 95);
            panel1.Name = "panel1";
            panel1.Size = new Size(170, 130);
            panel1.TabIndex = 22;
            panel1.Tag = ttindex;
            panel1.Click += new EventHandler(timeTable_Click);


            this.PosX += 174;

            time1.AutoSize = true;
            time1.Font = new Font("KoPubWorld돋움체 Bold", 17F, FontStyle.Bold, GraphicsUnit.Point, ((byte)(129)));
            time1.ForeColor = Color.Transparent;
            time1.Location = new Point(15, 35);
            time1.Name = "time1";
            time1.Size = new Size(135, 83);
            time1.TabIndex = 0;
            time1.Text = startTime;
            time1.Tag = ttindex;
            time1.Click += new EventHandler(timeTable_Click);
            // 
            // seat1
            // 
            seat1.AutoSize = true;
            seat1.Font = new Font("KoPubWorld돋움체 Bold", 17F, FontStyle.Bold, GraphicsUnit.Point, ((byte)(129)));
            seat1.ForeColor = Color.Transparent;
            seat1.Location = new Point(45, 70);
            seat1.Name = "seat1";
            seat1.Size = new Size(109, 83);
            seat1.TabIndex = 1;
            seat1.Text = currentSeat + "/15";
            seat1.Tag = ttindex;
            seat1.Click += new EventHandler(timeTable_Click);

            panel1.Controls.Add(time1);
            panel1.Controls.Add(seat1);
            Controls.Add(panel1);
        }

        private void timeTable_Click(object sender, EventArgs e)
        {
            List<string> mInfo = new List<string>();
            Panel panel = sender as Panel;
            Label label1 = sender as Label;
            Label label2 = sender as Label;
            string currentNum = "";

            if (panel != null)
            {
                ttindex = (int)panel.Tag;
                mInfo = testDB.movieDetale(ttindex);
                currentNum = testDB.currentSeat(ttindex);
            }
            else if (label1 != null)
            {
                ttindex = (int)label1.Tag;
                mInfo = testDB.movieDetale(ttindex);
                currentNum = testDB.currentSeat(ttindex);
            }
            else if (label2 != null)
            {
                ttindex = (int)label2.Tag;
                mInfo = testDB.movieDetale(ttindex);
                currentNum = testDB.currentSeat(ttindex);
            }
            personcheck = int.Parse(currentNum);
            this.label1.Text = mInfo[0];
            moviename.Text = mInfo[0];
            movieage.Text = mInfo[1];
            mmovietime.Text = mInfo[2];
            starttime.Text = mInfo[3];
            movietheater.Text = mInfo[4];
            checklastseat.Text = currentNum;

            this.label1.Visible = true;
            moviename.Visible = true;
            movieage.Visible = true;
            mmovietime.Visible = true;
            starttime.Visible = true;
            movietheater.Visible = true;
            checklastseat.Visible = true;
            pictureBox5.Visible = true;
            label5.Visible = true;
            label8.Visible = true;
            choice.Visible = true;
        }
        private void pictureBox1_Click(object sender, EventArgs e)
        {
            Movie movie = new Movie();
            movie.moiveInfo(movieNum);
            Close();
            
        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            Time.Text = DateTime.Now.ToString("HH:mm");
        }

        private void button1_Click(object sender, EventArgs e)
        {
            Hide();
        }

        private void home_Click(object sender, EventArgs e)
        {
            Ticketing ticketing = new Ticketing();
            ticketing.Show();
            Close();
        }
        #region 인원선택
        private void btnEnabled()
        {
            choice.Text = (adult + teen + old + disabled).ToString();
            //성인
            if (adult == 0)
            {
                adultminus.Enabled = false;
                adultminus.BackColor = Color.Gray;
                adultminus.FlatAppearance.BorderColor = Color.Gray;
            }
            else if (adult > 0)
            {
                adultminus.Enabled = true;
                adultminus.BackColor = Color.White;
                adultminus.FlatAppearance.BorderColor = Color.White;
            }
            if (adult > 14)
            {
                adultplus.Enabled = false;
                adultplus.BackColor = Color.Gray;
                adultplus.FlatAppearance.BorderColor = Color.Gray;
            }
            else if (adult <= 15)
            {
                adultplus.Enabled = true;
                adultplus.BackColor = Color.White;
                adultplus.FlatAppearance.BorderColor = Color.Gray;
            }
            //청소년
            if (teen == 0)
            {
                teenminus.Enabled = false;
                teenminus.BackColor = Color.Gray;
                teenminus.FlatAppearance.BorderColor = Color.Gray;
            }
            else if (teen > 0)
            {
                teenminus.Enabled = true;
                teenminus.BackColor = Color.White;
                teenminus.FlatAppearance.BorderColor = Color.White;
            }
            if (teen > 14)
            {
                teenplus.Enabled = false;
                teenplus.BackColor = Color.Gray;
                teenplus.FlatAppearance.BorderColor = Color.Gray;
            }
            else if (teen <= 15)
            {
                teenplus.Enabled = true;
                teenplus.BackColor = Color.White;
                teenplus.FlatAppearance.BorderColor = Color.Gray;
            }
            //노약자
            if (old == 0)
            {
                oldminus.Enabled = false;
                oldminus.BackColor = Color.Gray;
                oldminus.FlatAppearance.BorderColor = Color.Gray;
            }
            else if (old > 0)
            {
                oldminus.Enabled = true;
                oldminus.BackColor = Color.White;
                oldminus.FlatAppearance.BorderColor = Color.White;
            }
            if (old > 14)
            {
                oldplus.Enabled = false;
                oldplus.BackColor = Color.Gray;
                oldplus.FlatAppearance.BorderColor = Color.Gray;
            }
            else if (old <= 15)
            {
                oldplus.Enabled = true;
                oldplus.BackColor = Color.White;
                oldplus.FlatAppearance.BorderColor = Color.Gray;
            }
            //장애인
            if (disabled == 0)
            {
                disabledminus.Enabled = false;
                disabledminus.BackColor = Color.Gray;
                disabledminus.FlatAppearance.BorderColor = Color.Gray;
            }
            else if (disabled > 0)
            {
                disabledminus.Enabled = true;
                disabledminus.BackColor = Color.White;
                disabledminus.FlatAppearance.BorderColor = Color.White;
            }
            if (disabled > 14)
            {
                disabledplus.Enabled = false;
                disabledplus.BackColor = Color.Gray;
                disabledplus.FlatAppearance.BorderColor = Color.Gray;
            }
            else if (disabled <= 15)
            {
                disabledplus.Enabled = true;
                disabledplus.BackColor = Color.White;
                disabledplus.FlatAppearance.BorderColor = Color.Gray;
            }
        }
        #endregion

        private void next_Click(object sender, EventArgs e)
        {
            if (choice.Text == "0")
            {
                MessageBox.Show("인원을 선택해주세요");
            }
            else
            {
                SeatSelect seatSelect = new SeatSelect();
                seatSelect.movieDetailInfo(ttindex,movieNum,choice.Text);
                seatSelect.peopleCount(adult,teen,old,disabled);
                Hide();
                seatSelect.ShowDialog();
            }
        }

        #region 꺼져
        private void adultplus_Click_1(object sender, EventArgs e)
        {
            if (adult + teen + old + disabled < personcheck)
            {
                adult++;
                adulttotal.Text = adult.ToString();
                btnEnabled();
            }
            else
            {
                MessageBox.Show("남은 좌석보다 선택된 인원이 많습니다");
            }
        }

        private void adultminus_Click_1(object sender, EventArgs e)
        {
            adult--;
            adulttotal.Text = adult.ToString();
            btnEnabled();
        }

        private void teenplus_Click_1(object sender, EventArgs e)
        {
            if (adult + teen + old + disabled < personcheck)
            {
                teen++;
                teentotal.Text = teen.ToString();
                btnEnabled();
            }
            else
            {
                MessageBox.Show("남은 좌석보다 선택된 인원이 많습니다");
            }
        }
        private void teenminus_Click_1(object sender, EventArgs e)
        {
            teen--;
            teentotal.Text = teen.ToString();
            btnEnabled();

        }

        private void oldplus_Click_1(object sender, EventArgs e)
        {
            if (adult + teen + old + disabled < personcheck)
            {
                old++;
                oldtotal.Text = old.ToString();
                btnEnabled();
            }
            else
            {
                MessageBox.Show("남은 좌석보다 선택된 인원이 많습니다");
            }
        }

        private void oldminus_Click_1(object sender, EventArgs e)
        {
            old--;
            oldtotal.Text = old.ToString();
            btnEnabled();
        }

        private void disabledplus_Click_1(object sender, EventArgs e)
        {
            if (adult + teen + old + disabled < personcheck)
            {
                disabled++;
                disabledtotal.Text = disabled.ToString();
                btnEnabled();
            }
            else
            {
                MessageBox.Show("남은 좌석보다 선택된 인원이 많습니다");
            }
        }

        private void disabledminus_Click_1(object sender, EventArgs e)
        {
            disabled--;
            disabledtotal.Text = disabled.ToString();
            btnEnabled();
        }
        #endregion
    }
}
