namespace OrderForm.product_menu
{
    public partial class Burger : Form
    {
        private Main_form main_form;
        public Burger(Main_form main_form)
        {
            InitializeComponent();
            this.main_form = main_form;

        }
        private void button1_Click(object sender, EventArgs e)
        {
            main_form.Load_Products_calum(1);
        }

        private void button2_Click(object sender, EventArgs e)
        {
            main_form.Load_Products_calum(2);
        }

        private void button3_Click(object sender, EventArgs e)
        {
            main_form.Load_Products_calum(3);
        }

        private void button4_Click(object sender, EventArgs e)
        {
            main_form.Load_Products_calum(4);
        }

        private void button5_Click(object sender, EventArgs e)
        {
            main_form.Load_Products_calum(5);
        }

        private void button6_Click(object sender, EventArgs e)
        {
            main_form.Load_Products_calum(6);
        }

        private void button7_Click(object sender, EventArgs e)
        {
            main_form.Load_Products_calum(7);
        }

        private void button8_Click(object sender, EventArgs e)
        {
            main_form.Load_Products_calum(8);
        }

        private void button9_Click(object sender, EventArgs e)
        {
            main_form.Load_Products_calum(9);
        }

        private void Burger_Load(object sender, EventArgs e)
        {

        }
    }
}
