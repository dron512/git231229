using System.Windows.Forms;

namespace WinFormsApp2_class5
{
    class Car
    {
        public string Name { get; set; }
        //public Car(string name)
        //{
        //    this.Name = name;
        //}
    }

    public partial class Form1 : Form
    {
        int y = 10;

        List<Car> list = new List<Car>();
        public Form1()
        {
            InitializeComponent();

            Car car1 = new Car() { Name = "�ȳ��ϼ��� �ڵ��� 1�Դϴ�." };
            Car car2 = new Car() { Name = "�ڵ��� 2 �Դϴ�." };

            list.Add(car1);
            list.Add(car2);

            foreach (var car in list)
            {
                Console.WriteLine(car);
                MakeLabel(10, y, car.Name);
                y += 40;
            }

            //MakeLabel(10, 90, "�߰���");
        }

        // �ּ� ���� ctrl + k + c
        // �ּ� ���� ���� ctrl + k + u
        public void MakeLabel(int x, int y, string text)
        {
            Label label1 = new Label();
            label1.AutoSize = true;
            label1.Location = new Point(x, y);
            label1.TabIndex = 0;
            label1.Text = text;
            label1.Font = new Font("����ǹ��� ����", 14.2499981F, FontStyle.Bold, GraphicsUnit.Point, 129);
            this.Controls.Add(label1);
        }

        private void button1_Click(object sender, EventArgs e)
        {
            MakeLabel(10, y = y + 40, textBox1.Text);
            Console.WriteLine(textBox1.Text);
            textBox1.Text = "";
        }

        private void textBox1_KeyUp(object sender, KeyEventArgs e)
        {
            if (e.KeyCode == Keys.Enter)
            {
                button1_Click(null, null);
            }
        }
    }
}
