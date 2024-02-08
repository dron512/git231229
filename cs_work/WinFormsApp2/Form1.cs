using static System.Runtime.InteropServices.JavaScript.JSType;

namespace WinFormsApp2
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            MessageBox.Show(((Button)sender).ToString());
            MessageBox.Show(tb.Text);
        }

        private void button5_Click(object sender, EventArgs e)
        {

        }

        private void button2_Click_1(object sender, EventArgs e)
        {
            int num1;
            int num2;

            int.TryParse(tb_num1.Text.ToString(), out num1);
            int.TryParse(tb_num2.Text.ToString(), out num2);

            MessageBox.Show("더하기"+(num1+num2));
            lb_result.Text = (num1 + num2)+"";
        }

        private void button3_Click_1(object sender, EventArgs e)
        {
            int num1;
            int num2;

            int.TryParse(tb_num1.Text.ToString(), out num1);
            int.TryParse(tb_num2.Text.ToString(), out num2);

            MessageBox.Show("빼기"+(num1-num2));
            lb_result.Text = (num1 - num2) + "";
        }

        private void button4_Click_1(object sender, EventArgs e)
        {
            try
            {
                int num1;
                int num2;

                int.TryParse(tb_num1.Text.ToString(), out num1);
                int.TryParse(tb_num2.Text.ToString(), out num2);

                MessageBox.Show("나누기" + (num1 / num2));
                lb_result.Text = (num1 / num2) + "";
            }
            catch (Exception)
            {
                MessageBox.Show("0으로 나눌수 없습니다.");
            }
        }

        private void button5_Click_1(object sender, EventArgs e)
        {
            int.TryParse(tb_num1.Text.ToString(), out int num1);
            int.TryParse(tb_num2.Text.ToString(), out int num2);

            MessageBox.Show("곱하기" + (num1 * num2));
            lb_result.Text = (num1 * num2) + "";
        }
    }
}
