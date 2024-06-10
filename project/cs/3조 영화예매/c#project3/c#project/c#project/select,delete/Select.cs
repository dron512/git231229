using c_project.database;
using c_project.Properties;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace c_project
{
    public partial class Select : Form
    {
        SelectTicket selectTicket = new SelectTicket();
        List<string> checklist = new List<string>();
        String text1 = "";
        String text2 = "";
        String text3 = "";
        String text4 = "";
        String text5 = "";
        String text6 = "";
        String text7 = "";
        String text8 = "";
        String text9 = "";
        String checknumber = "";
        int totalcheck = 0;

        public Select()
        {
            InitializeComponent();
            timer1.Tick += timer1_Tick;
            timer1.Start();
        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            time.Text = DateTime.Now.ToString("HH:mm");
        }

        private void back_Click(object sender, EventArgs e)
        {
            System.Windows.Forms.Application.Restart();
        }
        #region 버튼클릭
        private void button1_Click(object sender, EventArgs e)
        {
            AppendDigit("1");
        }

        private void button2_Click(object sender, EventArgs e)
        {
            AppendDigit("2");
        }

        private void button3_Click(object sender, EventArgs e)
        {
            AppendDigit("3");
        }

        private void button4_Click(object sender, EventArgs e)
        {
            AppendDigit("4");
        }

        private void button5_Click(object sender, EventArgs e)
        {
            AppendDigit("5");
        }

        private void button6_Click(object sender, EventArgs e)
        {
            AppendDigit("6");
        }

        private void button7_Click(object sender, EventArgs e)
        {
            AppendDigit("7");
        }

        private void button8_Click(object sender, EventArgs e)
        {
            AppendDigit("8");
        }

        private void button9_Click(object sender, EventArgs e)
        {
            AppendDigit("9");
        }

        private void button10_Click(object sender, EventArgs e)
        {
            AppendDigit("0");
        }
        private void button11_Click(object sender, EventArgs e)
        {
            if (!string.IsNullOrEmpty(numbercheck.Text))
            {
                numbercheck.Text = numbercheck.Text.Remove(numbercheck.Text.Length - 1);
            }
        }
        private void AppendDigit(string digit)
        {
            const int MaxPhoneNumberLength = 11;
            int currentLength = numbercheck.Text.Length;

            if (currentLength < MaxPhoneNumberLength)
            {
                numbercheck.Text += digit;
            }

        }
        #endregion

        private void next_Click(object sender, EventArgs e)
        {
            MessageBox.Show("티켓이 출력중입니다");
            ticketprint();
            System.Windows.Forms.Application.Restart();
        }

        private void checkbutton_Click(object sender, EventArgs e)
        {


            Label[] label = { ticketnumber ,adult, teen, old, disabled, phonenumber, movietheater, moviename,
           starttime, seatcheck, price };
            checknumber = numbercheck.Text.ToString();
            checklist = selectTicket.CheckMovieData(checknumber);

            if (checklist == null)
            {
                checknumber = numbercheck.Text.ToString();
                moviename.Visible = false;
                movieage.Visible = false;
                label2.Visible = false;
                movietheater.Visible = false;
                starttime.Visible = false;
                label4.Visible = false;
                total.Visible = false;
                seatcheck.Visible = false;
                adultlabel.Visible = false;
                teenlabel.Visible = false;
                oldlabel.Visible = false;
                disabledlabel.Visible = false;
                adult.Visible = false;
                teen.Visible = false;
                old.Visible = false;
                disabled.Visible = false;
                label5.Visible = false;
                price.Visible = false;
                ticketPanel.Visible = false;
                label3.Visible = false;
                label6.Visible = false;
                ticketnumber.Visible = false;
                phonenumber.Visible = false;
                pictureBox1.Visible = false;
            }
            else
            {
            for (int i = 0; i < checklist.Count; i++)
            {
                label[i].Text = checklist[i].ToString();
            }

            string check = seatcheck.ToString();
            string plus = "";
            int commaCount = 0;

            for (int i = 0; i < check.Length; i++)
            {
                if (check[i] == ',')
                {
                    commaCount++;
                    if (commaCount % 4 == 0) // ','가 4번 나올 때마다
                    {
                        plus += "\n"; // 줄 바꿈 추가
                    }
                }
                else
                {
                    plus += check[i]; // 다른 문자는 그대로 추가
                }
            }
            plus = plus.Substring(32);
            seatcheck.Text = plus.ToString();


            String adultnum = adult.Text.ToString();
            String teennum = teen.Text.ToString();
            String oldnum = old.Text.ToString();
            String disablednum = disabled.Text.ToString();

            int a = int.Parse(new string(adultnum.Where(char.IsDigit).ToArray()));
            int b = int.Parse(new string(teennum.Where(char.IsDigit).ToArray()));
            int c = int.Parse(new string(teennum.Where(char.IsDigit).ToArray()));
            int d = int.Parse(new string(disablednum.Where(char.IsDigit).ToArray()));

            addCountPanel(a, b, c, d);

            totalcheck = a + b + c + d;

            total.Text = totalcheck.ToString();
            text2 = phonenumber.Text.ToString();
            text3 = moviename.Text.ToString();
            text4 = movieage.Text.ToString();
            text5 = starttime.Text.ToString();
            text7 = movietheater.Text.ToString();
            text8 = seatcheck.Text.ToString();
            text9 = price.Text.ToString();
            switch (text3)
            {
                case "새벽의 저주":
                    pictureBox1.Image = Resources.새벽의_저주;
                    break;
                case "너의 이름은":
                    pictureBox1.Image = Resources.너의_이름은;
                    break;
                case "살인의 추억":
                    pictureBox1.Image = Resources.살인의_추억;
                    break;
                case "파묘":
                    pictureBox1.Image = Resources.파묘;
                    break;
                case "윙카":
                    pictureBox1.Image = Resources.윙카;
                    break;
                case "남산의 부장들":
                    pictureBox1.Image = Resources.남산의_부장들;
                    break;
                case "오펜하이머":
                    pictureBox1.Image = Resources.오펜하이머;
                    break;
                case "나랏말싸미":
                    pictureBox1.Image = Resources.나랏말싸미;
                    break;
                default:
                    break;
            }
                checknumber = numbercheck.Text.ToString();
                moviename.Visible = true;
            movieage.Visible = true;
            label2.Visible = true;
            movietheater.Visible = true;
            starttime.Visible = true;
            label4.Visible = true;
            total.Visible = true;
            seatcheck.Visible = true;
            adultlabel.Visible = true;
            teenlabel.Visible = true;
            oldlabel.Visible = true;
            disabledlabel.Visible = true;
            adult.Visible = true;
            teen.Visible = true;
            old.Visible = true;
            disabled.Visible = true;
            label5.Visible = true;
            price.Visible = true;
            ticketPanel.Visible = true;
            label3.Visible = true;
            label6.Visible = true;
            ticketnumber.Visible = true;
            phonenumber.Visible = true;
            pictureBox1.Visible = true;
        }
    }
        private void addCountPanel(int adultCnt, int teenCnt, int oldCnt, int disabledCnt)
        {
            Console.WriteLine(adultCnt);
            Console.WriteLine(teenCnt);
            Console.WriteLine(oldCnt);
            Console.WriteLine(disabledCnt);

            int x = 10;
            int y = 10;

            adult.Text = adultCnt.ToString();
            teen.Text = teenCnt.ToString();
            old.Text = oldCnt.ToString();
            disabled.Text = disabledCnt.ToString();


            ticketPanel.Controls.Clear();

            if (adultCnt != 0)
            {
                // 23, 28
                Console.WriteLine("어른");
                Console.WriteLine($"x = {x}");
                Console.WriteLine($"y = {y}");
                adultlabel.Location = new Point(x, y);
                adult.Location = new Point(x + 100, y);

                ticketPanel.Controls.Add(adult);
                ticketPanel.Controls.Add(adultlabel);
                y += 30;
            }
            if (teenCnt != 0)
            {
                Console.WriteLine("10대");
                Console.WriteLine($"x = {x}");
                Console.WriteLine($"y = {y}");
                teenlabel.Location = new Point(x, y);
                teen.Location = new Point(x + 100, y);
                ticketPanel.Controls.Add(teen);
                ticketPanel.Controls.Add(teenlabel);
                y += 30;
            }
            if (oldCnt != 0)
            {
                Console.WriteLine("노인");
                Console.WriteLine($"x = {x}");
                Console.WriteLine($"y = {y}");
                oldlabel.Location = new Point(x, y);
                old.Location = new Point(x + 100, y);
                ticketPanel.Controls.Add(old);
                ticketPanel.Controls.Add(oldlabel);
                y += 30;
            }
            if (disabledCnt != 0)
            {
                Console.WriteLine("장애인");
                Console.WriteLine($"x = {x}");
                Console.WriteLine($"y = {y}");
                disabledlabel.Location = new Point(x, y);
                disabled.Location = new Point(x + 100, y);
                ticketPanel.Controls.Add(disabled);
                ticketPanel.Controls.Add(disabledlabel);
                y += 30;
            }

        }
        public void ticketprint()
        {
            text1 = ticketnumber.Text.ToString();
            text6 = totalcheck.ToString();

            string content = $@"
               [영화입장권]
                 [고객용]

                {text1}

[SOOP] 대구 동성로 지점

대구광역시 중구 중앙대로 395
-------------------------------------
예매번호 : {text1}
전화번호 : {text2}
====================
영화명 : {text3}
연령 : {text4}
상영시간 : {text5}
선택인원 : {text6}
상영관 : {text7}
좌석 : {text8}
총 결제 금액 : {text9}
====================

       즐거운 시간 보내세요             

{DateTime.Now.ToString("yyyy:MM:dd hh:mm:ss")}  POS:02 BILL:XXXX             
";

            string desktopPath = Environment.GetFolderPath(Environment.SpecialFolder.Desktop);
            string filePath = Path.Combine(desktopPath, "ticket.txt"); // 바탕화면에 파일 경로 및 이름

            File.WriteAllText(filePath, content);

            try
            {
                System.Diagnostics.Process.Start("notepad.exe", filePath);
            }
            catch (Exception ex)
            {
                MessageBox.Show("메모장을 열 수 없습니다: " + ex.Message);
            }
        }
    }
}
