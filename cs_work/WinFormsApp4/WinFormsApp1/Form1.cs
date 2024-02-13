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
            // 자동 정렬 ctrl + k -> f
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

            // 안전한 형변환...
            // (Button)sender; -> 예외....
            Button btn = sender as Button;  // 예외가 발생하지 않는 형변환

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
            

            Console.WriteLine( "OK 버튼 누름 ");
        }
    }
}
