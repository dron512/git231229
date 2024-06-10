using c_project.database;
using c_project.Properties;
using c_project.select_delete;
using Oracle.ManagedDataAccess.Client;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace c_project
{
    public partial class Ticketing : Form
    {
        Random random = new Random();
        public Ticketing()
        {
            InitializeComponent();
            player();
            timer1.Tick += timer1_Tick;
            timer1.Start();
        }
        private void player()
        {
            axWindowsMediaPlayer1.settings.autoStart = true;
            axWindowsMediaPlayer1.settings.setMode("loop", true); // 반복 재생 설정
            string videoFilePath;
            int randomNumber = random.Next(1, 9);
            switch (randomNumber)
            {
                case 1:
                    videoFilePath = "\\\\192.168.0.49\\공유\\미니프로젝트\\C#\\3조\\c#project 3조 최종\\c#project3\\movie\\새벽의 저주.mp4";
                    pictureBox1.Image = Resources.새벽의_저주1;
                    break;
                case 2:
                    videoFilePath = "\\\\192.168.0.49\\공유\\미니프로젝트\\C#\\3조\\c#project 3조 최종\\c#project3\\movie\\살인의 추억.mp4";
                    pictureBox1.Image = Resources.살인의_추억1;
                    break;
                case 3:
                    videoFilePath = "\\\\192.168.0.49\\공유\\미니프로젝트\\C#\\3조\\c#project 3조 최종\\c#project3\\movie\\너의 이름은.mp4";
                    pictureBox1.Image = Resources.너의_이름은1;
                    break;
                case 4:
                    videoFilePath = "\\\\192.168.0.49\\공유\\미니프로젝트\\C#\\3조\\c#project 3조 최종\\c#project3\\movie\\웡카.mp4";
                    pictureBox1.Image = Resources.웡카1;
                    break;
                case 5:
                    videoFilePath = "\\\\192.168.0.49\\공유\\미니프로젝트\\C#\\3조\\c#project 3조 최종\\c#project3\\movie\\파묘.mp4";
                    pictureBox1.Image = Resources.파묘1;
                    break;
                case 6:
                    videoFilePath = "\\\\192.168.0.49\\공유\\미니프로젝트\\C#\\3조\\c#project 3조 최종\\c#project3\\movie\\남산의 부장들.mp4";
                    pictureBox1.Image = Resources.남산의_부장들1;
                    break;
                case 7:
                    videoFilePath = "\\\\192.168.0.49\\공유\\미니프로젝트\\C#\\3조\\c#project 3조 최종\\c#project3\\movie\\오펜하이머.mp4";
                    pictureBox1.Image = Resources.오펜하이머1;
                    break;
                case 8:
                    videoFilePath = "\\\\192.168.0.49\\공유\\미니프로젝트\\C#\\3조\\c#project 3조 최종\\c#project3\\movie\\나랏말싸미.mp4";
                    pictureBox1.Image = Resources.나랏말싸미1;
                    break;
                default:
                    videoFilePath = ""; // 예외 처리를 위해 기본값을 설정합니다.
                    break;
            }
            axWindowsMediaPlayer1.URL = videoFilePath; // 재생할 동영상 파일 경로 설정
            axWindowsMediaPlayer1.uiMode = "none";
            axWindowsMediaPlayer1.stretchToFit = true;
        }
        private void timer1_Tick(object sender, EventArgs e)
        {
            DayLabel.Text = DateTime.Now.ToString("yyyy년MM월dd일");
            TimeLabel.Text = DateTime.Now.ToString("HH:mm:ss");
        }

        private void Search_Click(object sender, EventArgs e)
        {
            Select select = new Select();
            select.Show();
            Close();
        }

        private void Buy_Click(object sender, EventArgs e)
        {
            Ticketing1 ticketing1 = new Ticketing1();
            ticketing1.Show();
            Close();
        }

        private void Cancle_Click(object sender, EventArgs e)
        {
            Delete delete = new Delete();
            delete.Show();
            Close();
        }
    }
}
