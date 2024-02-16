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
            IsMdiContainer = true;

            timer1.Enabled = true;
            KeyPreview = true;

            Animal animal = new Animal();
            animal.MakeSound(); // "������ �Ҹ��� ���� �ֽ��ϴ�." ���

            Dog dog = new Dog();
            dog.MakeSound(); // "�۸�" ���

            Cat cat = new Cat();
            cat.MakeSound(); // "�߿�" ���

            // �θ� Ŭ������ ������ �ڽ� Ŭ������ �ν��Ͻ��� ����Ű��
            Animal dogAsAnimal = new Dog();
            dogAsAnimal.MakeSound(); // "�۸�" ���

            Dog newDog = new Dog();
            Console.WriteLine( "newDog.MakeSound()");
            newDog.MakeSound();
            Console.WriteLine(" (Animal)newDog.MakeSound()");
            ((Animal)newDog).MakeSound(); // "�۸�" ���

            Animal catAsAnimal = new Cat();
            catAsAnimal.MakeSound(); // "�߿�" ���
            Console.WriteLine(" (Animal)catAsAnimal.MakeSound()");
            ((Animal)catAsAnimal).MakeSound(); // "�۸�" ���
        }

        private void Form1_KeyDown(object sender, KeyEventArgs e)
        {
            Console.WriteLine("����" + e.KeyCode);
            if (e.KeyCode == Keys.Q)
            {
                panel1.Visible = false;
                string currentDirectory = Application.StartupPath;

                Console.WriteLine(currentDirectory);
                currentDirectory =  Application.ExecutablePath;
                Console.WriteLine(currentDirectory);
                WaveOutEvent woe = new WaveOutEvent();
                woe.Init(new AudioFileReader(@"D:\Students\cs_work\WinFormsApp7\WinFormsApp7\do\������.mp3"));
                woe.Play();

                Form2 form2 = new Form2();
                form2.MdiParent = this;
                form2.Show();
            }
        }

        private void Form1_KeyUp(object sender, KeyEventArgs e)
        {
            Console.WriteLine("����" + e.KeyCode);
            panel1.Visible = true;
        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            label1.Text = DateTime.Now.ToString();
        }
    }
}
