using System.Diagnostics;


namespace WinFormsApp1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private int y = 30;

        private void button1_Click(object sender, EventArgs e)
        {
            try
            {
                //Dispose();
                Hide();
                new Form2().ShowDialog();
                Show();

                System.Diagnostics.Process.Start("https://ko-kr.facebook.com/");
            }
            catch (Exception ae)
            {
                Console.WriteLine(  ae.ToString);
            }
            

            // �ڵ� ���� ctrl + k -> f
            for (int i =0; i<10; i++) {
                Button btn1 = new Button();
                btn1.Text = "OK";
                btn1.Location = new Point(300, 10+y*i);
                btn1.UseVisualStyleBackColor = false;
                btn1.Click += Btn1_Click;
                Controls.Add(btn1);
            }
        }

        private void Btn1_Click(object? sender, EventArgs e)
        {
            Random ran = new Random();
            int x = ran.Next(1, 300);
            int y = ran.Next(10, 200);
            Console.WriteLine( x );
            Console.WriteLine( y );

            // ������ ����ȯ...
            // (Button)sender; -> ����....
            Button btn = sender as Button;  // ���ܰ� �߻����� �ʴ� ����ȯ

            if (btn.BackColor == Color.Red)
            {
                btn.BackColor = Color.White;
                btn.Text = "OK";
                btn.Location = new Point(x,y);
            }
            else {
                btn.BackColor = Color.Red;
                btn.Text = "NOT OK";
            }
            

            Console.WriteLine( "OK ��ư ���� ");
        }
    }
}
