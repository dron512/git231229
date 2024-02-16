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
            animal.MakeSound(); // "동물이 소리를 내고 있습니다." 출력

            Dog dog = new Dog();
            dog.MakeSound(); // "멍멍" 출력

            Cat cat = new Cat();
            cat.MakeSound(); // "야옹" 출력

            // 부모 클래스의 참조로 자식 클래스의 인스턴스를 가리키기
            Animal dogAsAnimal = new Dog();
            dogAsAnimal.MakeSound(); // "멍멍" 출력

            Dog newDog = new Dog();
            Console.WriteLine( "newDog.MakeSound()");
            newDog.MakeSound();
            Console.WriteLine(" (Animal)newDog.MakeSound()");
            ((Animal)newDog).MakeSound(); // "멍멍" 출력

            Animal catAsAnimal = new Cat();
            catAsAnimal.MakeSound(); // "야옹" 출력
            Console.WriteLine(" (Animal)catAsAnimal.MakeSound()");
            ((Animal)catAsAnimal).MakeSound(); // "멍멍" 출력
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

                Form2 form2 = new Form2();
                form2.MdiParent = this;
                form2.Show();
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
