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
    public partial class Main : Form
    {
        Random random = new Random();
        private int Imageindex = 0;
        public Main()
        {
            InitializeComponent();
            LoadImages();
        }
        private void LoadImages()
        {
            int randomNumber = random.Next(1, 9);
            switch (randomNumber)
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
                default:
                    break;
            }
        }
        private void pictureBox5_Click(object sender, EventArgs e)
        {
            Ticketing ticketing = new Ticketing();
            ticketing.Show();
        }

    }
}
