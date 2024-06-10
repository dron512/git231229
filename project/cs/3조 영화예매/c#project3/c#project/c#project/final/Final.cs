using c_project.database;
using c_project.Properties;
using Oracle.ManagedDataAccess.Client;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Diagnostics;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using static System.Net.Mime.MediaTypeNames;

namespace c_project.final
{

    public partial class Final : Form
    {
        TestDB testDB = new TestDB();
        String couponnumber = "";
        int checkpass = 0;
        int timeindex = 0;
        List<int> seatchecklist = new List<int>();
        Ticketing ticketing = new Ticketing();
        String checknumber = "";
        int checktotal = 0;
        int totalmoney = 0;

        string sixDigitRandomNumber = "";

        public Final()
        {
            InitializeComponent();
            timer1.Tick += timer1_Tick;
            timer1.Start();
            seatcheck.Text = "";
            phonenumbertextbox.Text = "010";
        }

        public void checkSeat(List<int> seatNumInfo)
        {
            for (int i = 0; i < seatNumInfo.Count; i++)
            {
                if (seatNumInfo.Count <= 1)
                {
                    seatcheck.Text += seatNumInfo[i] + "번";
                    seatchecklist.Add(seatNumInfo[i]);
                }
                else if (seatNumInfo.Count - 1 > i)
                {
                    seatcheck.Text += seatNumInfo[i] + "번, ";
                    seatchecklist.Add(seatNumInfo[i]);
                }
                else
                {
                    seatcheck.Text += seatNumInfo[i] + "번";
                    seatchecklist.Add(seatNumInfo[i]);
                }
            }

            for (int i = 0;i < seatchecklist.Count;i++)
            {
                Console.WriteLine(seatchecklist[i]);
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
        }

        public void movieDetailInfo(int ttindex, int movieNum, int peopleSum, int adult, int teen, int old, int disabled)
        {
            timeindex = ttindex;
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
            total.Text = peopleSum.ToString();
            this.adult.Text = adult.ToString();
            this.teen.Text = teen.ToString();
            this.old.Text = old.ToString();
            this.disabled.Text = disabled.ToString();

            List<int> price = testDB.ticketPrice();
            
            adultprice.Text = price[0].ToString();
            teenprice.Text = price[1].ToString();
            oldprice.Text = price[2].ToString();
            disabledprice.Text = price[3].ToString();

            adulttotalprice.Text = (int.Parse(adultprice.Text) * adult).ToString();
            teentotalprice.Text = (int.Parse(teenprice.Text) * teen).ToString();
            oldtotalprice.Text = (int.Parse(oldprice.Text) * old).ToString();
            disabledtotalprice.Text = (int.Parse(disabledprice.Text) * disabled).ToString();

            

            totalprice.Text = (int.Parse(adulttotalprice.Text)+ int.Parse(teentotalprice.Text)+
                int.Parse(oldtotalprice.Text)+ int.Parse(disabledtotalprice.Text)).ToString();
            totalmoney = (int.Parse(totalprice.Text));
            Label[] label = { this.adult, this.teen, this.old, this.disabled };
            Label[] label2 = { adultlabel, teenlabel, oldlabel, disabledlabel };
            Label[] label3 = { adultprice, teenprice, oldprice, disabledprice };
            Label[] label4 = { adulttotalprice, teentotalprice, oldtotalprice, disabledtotalprice };

            int x = 341; // label의 x
            int y = 269; // label의 y

            int z = 282; // label2의 x
            int w = 269; // label2의 y

            int a = 370; // label3 x
            int b = 269; // label3 y

            int c = 434; // label4 x
            int d = 269; // label4 y

            int up = 22; // Y 위치 증가량

            for (int i = 0; i < label.Length; i++)
            {
                if (int.Parse(label[i].Text) == 0)
                {
                    label[i].Visible = false;
                    label2[i].Visible = false;
                    label3[i].Visible = false;
                    label4[i].Visible = false;
                }
                else
                {
                    label[i].Location = new Point(x, y);
                    label2[i].Location = new Point(z, w);
                    label3[i].Location = new Point(a, b);
                    label4[i].Location = new Point(c, d);
                    y = y + up;
                    w = w + up;
                    b = b + up;
                    d = d + up;
                }
            }
        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            time.Text = DateTime.Now.ToString("HH:mm");
        }
        public String Randomnumber()
        {
            Random random = new Random();
            int randomNumber = random.Next(100000, 999999);
            return randomNumber.ToString("D6");
        }
        public string checkRandom()
        {
            string randomNumber = "";
            string connectionString = DB.dbstr;
            using (OracleConnection connection = DB.openConnect())
            {
                while (true)
                {
                    randomNumber = Randomnumber();
                    string query = "SELECT COUNT(*) FROM 예매 WHERE 예매번호 = :randomNumber";
                    using (OracleCommand command = new OracleCommand(query, connection))
                    {
                        command.Parameters.Add(":randomNumber", OracleDbType.Varchar2).Value = randomNumber;
                        int count = Convert.ToInt32(command.ExecuteScalar());
                        if (count == 0)
                        {
                            // 중복이 아닌 경우 루프 종료
                            break;
                        }
                    }
                }
            }
            DB.closeConnect();
            return randomNumber;
        }

        private void next_Click(object sender, EventArgs e)
        {

            sixDigitRandomNumber = checkRandom();
            if (checkpass == 1)
            {
                string connectionString = DB.dbstr;
                using (OracleConnection connection = DB.openConnect())
                {
                    try
                    {
                        string sql = @"INSERT INTO 예매 (예매번호, 성인, 청소년, 노인, 장애인, 전화번호, 상영관, 영화명, 시작시간, 좌석번호, 가격)
                       VALUES (:reservationNumber, :adult, :teenager, :senior, :disabled, :phoneNumber, :theater, :movieTitle, :startTime, :seatNumber, :price)";

                        using (OracleCommand command = new OracleCommand(sql, connection))
                        {
                            command.Parameters.Add(new OracleParameter(":reservationNumber", sixDigitRandomNumber));
                            command.Parameters.Add(new OracleParameter(":adult", adult.Text.ToString()));
                            command.Parameters.Add(new OracleParameter(":teenager", teen.Text.ToString()));
                            command.Parameters.Add(new OracleParameter(":senior", old.Text.ToString()));
                            command.Parameters.Add(new OracleParameter(":disabled", disabled.Text.ToString()));
                            command.Parameters.Add(new OracleParameter(":phoneNumber", phonenumbertextbox.Text.ToString()));
                            command.Parameters.Add(new OracleParameter(":theater", movietheater.Text.ToString()));
                            command.Parameters.Add(new OracleParameter(":movieTitle", moviename.Text.ToString()));
                            command.Parameters.Add(new OracleParameter(":startTime", starttime.Text.ToString()));
                            command.Parameters.Add(new OracleParameter(":seatNumber", seatcheck.Text.ToString()));
                            command.Parameters.Add(new OracleParameter(":price", totalprice.Text.ToString()));

                            int test = command.ExecuteNonQuery();

                            if (test > 0)
                            {
                                MessageBox.Show("예매가 성공 되었습니다");
                                MessageBox.Show("bye");
                                updateseat(connection);
                                ticketprint();
                                System.Windows.Forms.Application.Restart();
                            }
                            else
                            {
                                MessageBox.Show("예매 등록 실패");
                            }
                        }
                    }
                    catch (Exception ex)
                    {
                        MessageBox.Show("오류 발생: " + ex.Message);
                    }
                }
                DB.closeConnect();
            }
            else if (checkpass == 0)
            {
                MessageBox.Show("전화번호 입력하고 오세요");
            }
        }
        public void updateseat(OracleConnection connection)
        {
            string seatNum = "";
            for (int i = 0; i < seatchecklist.Count; i++)
            {
                seatNum = seatchecklist[i].ToString();

                String sql = "UPDATE 상영관 SET 확인 = 1 WHERE 시간표 = :timeIndex and 좌석 = :seat";

                OracleCommand updateCommand = new OracleCommand(sql, connection);

                updateCommand.Parameters.Add(":timeIndex", timeindex);
                updateCommand.Parameters.Add(":seat", seatNum);

                updateCommand.ExecuteNonQuery();



            }
        }
        #region 전화번호 넣자
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

        private void button0_Click(object sender, EventArgs e)
        {
            AppendDigit("0");
        }

        private void delete_Click(object sender, EventArgs e)
        {
            if (!string.IsNullOrEmpty(phonenumbertextbox.Text) && phonenumbertextbox.Text != "010")
            {
                phonenumbertextbox.Text = phonenumbertextbox.Text.Remove(phonenumbertextbox.Text.Length - 1);
            }
        }
        private void AppendDigit(string digit)
        {
            const int MaxPhoneNumberLength = 11;
            int currentLength = phonenumbertextbox.Text.Length;

            if (currentLength < MaxPhoneNumberLength)
            {
                phonenumbertextbox.Text += digit;
            }
        }
        #endregion
        private void doublecheck_Click(object sender, EventArgs e)
        {

            checknumber = phonenumbertextbox.Text.ToString();
            string connectionString = DB.dbstr;
            using (OracleConnection connection = DB.openConnect())
            {
                try
                {
                    string sql = "select 전화번호 from 예매 where 전화번호 = :phonenumber";
                    using (OracleCommand command = new OracleCommand(sql, connection))
                    {
                        command.Parameters.Add(new OracleParameter(":phonenumber", checknumber));
                        using (OracleDataReader reader = command.ExecuteReader())
                        {
                            if (reader.Read())
                            {
                                MessageBox.Show("중복된 전화번호가 있습니다");
                                MessageBox.Show("다시 입력해주세요");
                                checkpass = 0;
                                Console.WriteLine(checkpass);
                                phonenumbertextbox.Clear();
                                phonenumbertextbox.Text = "010";
                            }
                            else
                            {
                                if (checknumber.Length != 11)
                                {
                                    MessageBox.Show("전화번호 길이가 짧습니다");
                                    MessageBox.Show("다시 입력해주세요");
                                    checkpass = 0;
                                    Console.WriteLine(checkpass);
                                    phonenumbertextbox.Clear();
                                    phonenumbertextbox.Text = "010";
                                }
                                else
                                {
                                    MessageBox.Show("등록가능한 번호입니다");
                                    checkpass = 1;
                                    Console.WriteLine(checkpass);
                                }
                            }
                        }
                    }
                }
                catch (Exception ex)
                {
                    Console.WriteLine("Error: " + ex.Message);
                }
                finally
                {
                    DB.closeConnect();
                }
            }
        }
        public void ticketprint()
        {
            String text1 = sixDigitRandomNumber;
            String text2 = checknumber;

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
영화명 : {moviename.Text}
연령 : {movieage.Text}
상영시간 : {starttime.Text}
런타임 : {movietime.Text}
선택인원 : {total.Text}
상영관 : {movietheater.Text}
좌석 : {seatcheck.Text}
총 결제 금액 : {totalprice.Text}
====================

       즐거운 시간 보내세요             

{DateTime.Now.ToString("yyyy:MM:dd hh:mm:ss")}  POS:02 BILL:XXXX ";

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



        private void home_Click(object sender, EventArgs e)
        {
            ticketing.Show();
            this.Close();
        }

        private void back_Click(object sender, EventArgs e)
        {
            Close();
        }

        private void c1_Click(object sender, EventArgs e)
        {
            CoupondDigit("1");
        }

        private void c2_Click(object sender, EventArgs e)
        {
            CoupondDigit("2");
        }

        private void c3_Click(object sender, EventArgs e)
        {
            CoupondDigit("3");
        }

        private void c4_Click(object sender, EventArgs e)
        {
            CoupondDigit("4");
        }

        private void c5_Click(object sender, EventArgs e)
        {
            CoupondDigit("5");
        }

        private void c6_Click(object sender, EventArgs e)
        {
            CoupondDigit("6");
        }

        private void c7_Click(object sender, EventArgs e)
        {
            CoupondDigit("7");
        }

        private void c8_Click(object sender, EventArgs e)
        {
            CoupondDigit("8");
        }

        private void c9_Click(object sender, EventArgs e)
        {
            CoupondDigit("9");
        }

        private void c0_Click(object sender, EventArgs e)
        {
            CoupondDigit("0");
        }
        private void CoupondDigit(string digit)
        {
            const int MaxCouponumberLength = 11;
            int currentLength = couponnumbertextbox.Text.Length;

            if (currentLength < MaxCouponumberLength)
            {
                couponnumbertextbox.Text += digit;
            }
        }

        private void deletecoupon_Click(object sender, EventArgs e)
        {
            if (couponnumbertextbox.Text.Length != 0 )
            {
                couponnumbertextbox.Text = couponnumbertextbox.Text.Remove(couponnumbertextbox.Text.Length - 1);
            }
        }
        public void coupon()
        {
            couponnumber = couponnumbertextbox.Text.ToString();
            SelectTicket selectTicket = new SelectTicket();
            int discount = selectTicket.Coupon(couponnumber);
            discountmoney.Text = discount.ToString();
            totalprice.Text = (totalmoney - discount).ToString() + "원";


        }
        private void button10_Click(object sender, EventArgs e)
        {
            coupon();
        }
    }

}



