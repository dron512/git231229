using c_project.database;
using c_project.seat;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Diagnostics;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace c_project.movie
{
    public partial class Movie : Form
    {
        TestDB testDB = new TestDB();

        int movieNum { get; set; }

        public Movie()
        {
            InitializeComponent();
            timer1.Tick += timer1_Tick;
            timer1.Start();
        }

        public void moiveInfo(int movieNum)
        {
            List<string> list = new List<string>();
            list = testDB.movieInfo(movieNum);
            moviename.Text = list[0];
            movieage.Text = list[1];
            movietime.Text = list[2];
            moviestory.Text = list[3];
            this.movieNum = movieNum;
            moviecheck();
        }
        public void moviecheck()
        {
            Console.WriteLine(movieNum);
            string videoFilePath = "";
            switch (movieNum)
            {
                case 1:
                    videoFilePath = "\\\\192.168.0.49\\공유\\미니프로젝트\\C#\\3조\\c#project 3조 최종\\c#project3\\movie\\새벽의 저주.mp4";
                    break;
                case 2:
                    videoFilePath = "\\\\192.168.0.49\\공유\\미니프로젝트\\C#\\3조\\c#project 3조 최종\\c#project3\\movie\\너의 이름은.mp4";
                    break;
                case 3:
                    videoFilePath = "\\\\192.168.0.49\\공유\\미니프로젝트\\C#\\3조\\c#project 3조 최종\\c#project3\\movie\\살인의 추억.mp4";
                    break;
                case 4:
                    videoFilePath = "\\\\192.168.0.49\\공유\\미니프로젝트\\C#\\3조\\c#project 3조 최종\\c#project3\\movie\\파묘.mp4";
                    break;
                case 5:
                    videoFilePath = "\\\\192.168.0.49\\공유\\미니프로젝트\\C#\\3조\\c#project 3조 최종\\c#project3\\movie\\웡카.mp4";
                    break;
                    case 6:
                    videoFilePath = "\\\\192.168.0.49\\공유\\미니프로젝트\\C#\\3조\\c#project 3조 최종\\c#project3\\movie\\남산의 부장들.mp4";
                    break;
                    case 7:
                    videoFilePath = "\\\\192.168.0.49\\공유\\미니프로젝트\\C#\\3조\\c#project 3조 최종\\c#project3\\movie\\오펜하이머.mp4";
                    break;
                case 8:
                    videoFilePath = "\\\\192.168.0.49\\공유\\미니프로젝트\\C#\\3조\\c#project 3조 최종\\c#project3\\movie\\나랏말싸미.mp4";
                    break;
                default:
                    break;
            }
            axWindowsMediaPlayer1.settings.autoStart = true;
            axWindowsMediaPlayer1.settings.setMode("loop", true);
            axWindowsMediaPlayer1.URL = videoFilePath;
            axWindowsMediaPlayer1.uiMode = "none";
            axWindowsMediaPlayer1.stretchToFit = true;
        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            Time.Text = DateTime.Now.ToString("HH:mm");
        }

        private void pictureBox1_Click(object sender, EventArgs e)
        {
            Ticketing1 ticketing1 = new Ticketing1();
            ticketing1.Show();

        }

        private void button2_Click(object sender, EventArgs e)
        {
            MovieSeat1 movieSeat1 = new MovieSeat1();
            movieSeat1.movieTimeTable(movieNum);
            movieSeat1.Show();
        }
    }
}
