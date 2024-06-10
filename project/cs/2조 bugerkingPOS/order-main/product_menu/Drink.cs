namespace OrderForm.product_menu
{
    public partial class Drink : Form
    {
        private Main_form main_form;
        public Drink(Main_form main_form)
        {
            InitializeComponent();
            this.main_form = main_form;

        }
        private void button19_Click(object sender, EventArgs e)
        {
            main_form.Load_Products_calum(19);
        }
        private void button20_Click(object sender, EventArgs e)
        {
            main_form.Load_Products_calum(20);
        }
        private void button21_Click(object sender, EventArgs e)
        {
            main_form.Load_Products_calum(21);
        }
        private void button22_Click(object sender, EventArgs e)
        {
            main_form.Load_Products_calum(22);
        }
        private void button23_Click(object sender, EventArgs e)
        {
            main_form.Load_Products_calum(23);
        }
        private void Drink_Load(object sender, EventArgs e)
        {
            
        }
    }
}
