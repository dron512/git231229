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
using static c_project.movie.Movie;

namespace c_project
{
    public partial class Ticketing1 : Form
    {
        TestDB testDB = new TestDB();
        Movie movie1 = new Movie();
        public Ticketing1()
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

            ints = testDB.movieNumSelect();

            for (int i = 0; i < ints.Count;i++)
            {
                switch (ints[i])
                {
                    case 1:
                        pictureBox1.Image = Resources.새벽의_저주;
                        pictureBox1.Tag = ints[i];


                        break;
                    case 2:
                        pictureBox2.Image = Resources.너의_이름은;
                        pictureBox2.Tag = ints[i];

                        break;
                    case 3:
                        pictureBox3.Image = Resources.살인의_추억;
                        pictureBox3.Tag = ints[i];

                        break;
                    case 4:
                        pictureBox5.Image = Resources.파묘;
                        pictureBox5.Tag = ints[i];

                        break;
                }    
            }
        }
        public void mvname()
        {
            List<String> list1 = testDB.movieInfo(1);
            mvname1.Text = list1[0];
            List<String> list2 = testDB.movieInfo(2);
            mvname2.Text = list2[0];
            List<String> list3 = testDB.movieInfo(3);
            mvname3.Text = list3[0];
            List<String> list4 = testDB.movieInfo(4);
            mvname4.Text = list4[0];
        }
        public void pictureBox1_Click(object sender, EventArgs e)
        {
            PictureBox pictureBox = sender as PictureBox;
            movie1.moiveInfo(int.Parse(pictureBox.Tag.ToString()));
            movie1.Show();
        }
        private void timer1_Tick(object sender, EventArgs e)
        {
            TimeLabel.Text = DateTime.Now.ToString("HH:mm");
        }

        private void pictureBox4_Click(object sender, EventArgs e)
        {
            Ticketing1_1 ticketing1_1 = new Ticketing1_1();
            ticketing1_1.Show();
        }

        private void pictureBox6_Click(object sender, EventArgs e)
        {
            Ticketing ticketing = new Ticketing();
            ticketing.Show();
            this.Close();
        }
    }
}
