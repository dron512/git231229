using System.Drawing.Text;

namespace WinFormsApp8
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();

            // ÆùÆ®
            //this.Font = new Font(FontLibrary.Families[0], 12);

            foreach (Control control in this.Controls)
            {
                Console.WriteLine(control);
            }
        }
    }
}
