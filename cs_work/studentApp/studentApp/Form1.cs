using System.Windows.Forms;

namespace studentApp
{
    public partial class Form1 : Form
    {
        private Button button3;
        public Form1()
        {
            InitializeComponent();

            // 디자이너 cs 파일이 아니고 내가 직접 만들기
            Button customButton = new Button();
            customButton.Text= "OK";
            customButton.Location = new System.Drawing.Point(200, 10);

            panel1.Controls.Add(customButton);

            this.button3 = new Button();
            this.button3.Font = new System.Drawing.Font(
                "휴먼둥근헤드라인", 
                15.75F,
                System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(129)));
            this.button3.Location = new System.Drawing.Point(200, 50);
            this.button3.Name = "button2";
            this.button3.Size = new System.Drawing.Size(160, 32);
            this.button3.TabIndex = 1;
            this.button3.Text = "복사한버튼";
            this.button3.UseVisualStyleBackColor = true;
            panel1.Controls.Add(button3);

            button2.Click += Button2_Click;
            button2.Click += (s, e) => {
                MessageBox.Show("람다 실행");
            };
        }
        private void Button2_Click(object sender, System.EventArgs e)
        {
            MessageBox.Show("button2 실행");
        }
        private void button1_Click(object sender, System.EventArgs e)
        {
            MessageBox.Show("button1 실행");
        }
    }
}
