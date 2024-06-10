using c_project.database;
using c_project.movie;
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

namespace c_project
{
    public partial class Ticketing1_1 : Form
    {
        Movie movie1 = new Movie();
        TestDB testDB = new TestDB();
        public Ticketing1_1()
        {
            InitializeComponent();
            timer1.Tick += timer1_Tick;
            timer1.Start();
            moviePoster();
            mvname();
        }

        public void moviePoster()
        {
            List<int> ints = new List<int>();

            ints = testDB.movieNumSelect(1);

            for (int i = 0; i < ints.Count; i++)
            {
                switch (ints[i])
                {
                    case 5:
                        pictureBox4.Image = Resources.윙카;
                        pictureBox4.Tag = ints[i];
                        break;
                    case 6:
                        pictureBox3.Image = Resources.남산의_부장들;
                        pictureBox3.Tag = ints[i];
                        break;
                    case 7:
                        pictureBox6.Image = Resources.오펜하이머;
                        pictureBox6.Tag = ints[i];
                        break;
                    case 8:
                        pictureBox5.Image = Resources.나랏말싸미;
                        pictureBox5.Tag = ints[i];
                        break;
                }
            }
        }
        public void mvname()
        {
            List<String> list1 = testDB.movieInfo(5);
            mvname1.Text = list1[0];
            List<String> list2 = testDB.movieInfo(6);
            mvname2.Text = list2[0];
            List<String> list3 = testDB.movieInfo(7);
            mvname3.Text = list3[0];
            List<String> list4 = testDB.movieInfo(8);
            mvname4.Text = list4[0];
        }
        private void pictureBox4_Click(object sender, EventArgs e)
        {
            PictureBox pictureBox = sender as PictureBox;
            movie1.moiveInfo(int.Parse(pictureBox.Tag.ToString()));
            movie1.Show();
            Close();
        }
        private void timer1_Tick(object sender, EventArgs e)
        {
        TimeLabel.Text = DateTime.Now.ToString("HH:mm");
        }

        private void pictureBox1_Click(object sender, EventArgs e)
        {
            Ticketing1 ticketing1 = new Ticketing1();
            ticketing1.Show();
            Hide();
        }

        private void pictureBox2_Click(object sender, EventArgs e)
        {
            Ticketing ticketing = new Ticketing();
            ticketing.Show();
            this.Close();
        }
    }
}
