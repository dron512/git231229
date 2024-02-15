//using System.Windows.Forms;

using NAudio.Wave;

namespace WinFormsApp7
{
    public partial class Form1 : Form
    {
        // enum...
        public Form1()
        {
            InitializeComponent();

            timer1.Enabled = true;
            KeyPreview = true;
        }

        private void Form1_KeyDown(object sender, KeyEventArgs e)
        {
            Console.WriteLine("누름" + e.KeyCode);
            if (e.KeyCode == Keys.Q)
            {
                panel1.Visible = false;
                string currentDirectory = Application.StartupPath;

                Console.WriteLine(currentDirectory);
                currentDirectory =  Application.ExecutablePath;
                Console.WriteLine(currentDirectory);
                WaveOutEvent woe = new WaveOutEvent();
                woe.Init(new AudioFileReader(@"D:\Students\cs_work\WinFormsApp7\WinFormsApp7\do\도도도.mp3"));
                woe.Play();
            }
        }

        private void Form1_KeyUp(object sender, KeyEventArgs e)
        {
            Console.WriteLine("뗏음" + e.KeyCode);
            panel1.Visible = true;
        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            label1.Text = DateTime.Now.ToString();
        }
    }
}
