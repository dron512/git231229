namespace WinFormsApp1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();

            //label3.Font = new Font("����ǹ��� ����", 14.2499981F, FontStyle.Bold, GraphicsUnit.Point, 129);

            foreach (Control control in this.Controls)
            {
                Console.WriteLine( control );

                if( control is Panel)
                {
                    // ���� ��Ȳ�� �߻��ϴ��� ���� �ȵ�....
                    Panel panel = control as Panel;
                    foreach (Control subcontrol in panel.Controls)
                    {
                        subcontrol.Text = "���ڹٲٱ�";
                    }
                }
                control.Text = "���ڹٲٱ�";
                control.Font = new Font("����ǹ��� ����", 14.2499981F, FontStyle.Bold, GraphicsUnit.Point, 129);
                if( control is Button ) {
                    Button button = control as Button;
                    button.AutoSize = true;
                }
            }

        }
    }
}
