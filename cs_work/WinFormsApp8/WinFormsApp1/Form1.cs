namespace WinFormsApp1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();

            //label3.Font = new Font("배달의민족 도현", 14.2499981F, FontStyle.Bold, GraphicsUnit.Point, 129);

            foreach (Control control in this.Controls)
            {
                Console.WriteLine( control );

                if( control is Panel)
                {
                    // 예외 상황이 발생하더라도 종료 안됨....
                    Panel panel = control as Panel;
                    foreach (Control subcontrol in panel.Controls)
                    {
                        subcontrol.Text = "글자바꾸기";
                    }
                }
                control.Text = "글자바꾸기";
                control.Font = new Font("배달의민족 도현", 14.2499981F, FontStyle.Bold, GraphicsUnit.Point, 129);
                if( control is Button ) {
                    Button button = control as Button;
                    button.AutoSize = true;
                }
            }

        }
    }
}
