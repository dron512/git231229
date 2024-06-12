using System.Drawing;
using System.Windows.Forms;

namespace studentApp
{
    public partial class Form1 : Form
    {
        private Button button3;
        private Button panelA_button;
        private Button stylishButton;
        private DataGridView stylishDataGridView;

        private Panel panelA;
        private Panel panelB;

        public Form1()
        {
            InitializeComponent();

            panelA = new Panel() { 
                BackColor = System.Drawing.Color.Red,
                Location = new System.Drawing.Point(0,200),
                Size = new System.Drawing.Size(200,200)
            };
            panelB = new Panel() {
                BackColor = System.Drawing.Color.Blue,
                Location = new System.Drawing.Point(100, 200),
                Size = new System.Drawing.Size(200, 200)
            };
            panelA_button = new Button() { 
                Text="panelAText",
                Location = new System.Drawing.Point(100, 200),
                Size = new System.Drawing.Size(200, 200)
            };

            stylishButton = new Button
            {
                Text = "Stylish Button",
                Size = new Size(150, 50),
                Location = new Point(100, 100),
                BackColor = Color.DodgerBlue,
                ForeColor = Color.White,
                FlatStyle = FlatStyle.Flat,
                Font = new Font("Arial", 12, FontStyle.Bold),
            };

            // Set flat style properties
            stylishButton.FlatAppearance.BorderSize = 0;
            stylishButton.FlatAppearance.MouseOverBackColor = Color.DeepSkyBlue;
            stylishButton.FlatAppearance.MouseDownBackColor = Color.SteelBlue;

            stylishDataGridView = new DataGridView
            {
                Size = new Size(600, 300),
                Location = new Point(50, 50),
                ColumnHeadersHeightSizeMode = DataGridViewColumnHeadersHeightSizeMode.EnableResizing,
                ColumnHeadersHeight = 40,
                EnableHeadersVisualStyles = false,
                ReadOnly = true,
                RowHeadersVisible = false,
                AlternatingRowsDefaultCellStyle = new DataGridViewCellStyle { BackColor = Color.LightGray },
                DefaultCellStyle = new DataGridViewCellStyle
                {
                    SelectionBackColor = Color.DodgerBlue,
                    SelectionForeColor = Color.White,
                    Font = new Font("Arial", 12, FontStyle.Regular),
                    BackColor = Color.White,
                    ForeColor = Color.Black,
                    Padding = new Padding(5)
                },
                ColumnHeadersDefaultCellStyle = new DataGridViewCellStyle
                {
                    BackColor = Color.DodgerBlue,
                    ForeColor = Color.White,
                    Font = new Font("Arial", 12, FontStyle.Bold),
                    Alignment = DataGridViewContentAlignment.MiddleCenter
                }
            };

            stylishDataGridView.Columns.Add("Column1", "Header 1");
            stylishDataGridView.Columns.Add("Column2", "Header 2");
            stylishDataGridView.Columns.Add("Column3", "Header 3");

            stylishDataGridView.Rows.Add("Row 1, Cell 1", "Row 1, Cell 2", "Row 1, Cell 3");
            stylishDataGridView.Rows.Add("Row 2, Cell 1", "Row 2, Cell 2", "Row 2, Cell 3");

            // Add DataGridView to form
            panelB.Controls.Add(stylishDataGridView);

            panelA.Controls.Add(stylishButton);
            panelA.Controls.Add(panelA_button);

            panelA.Dock = DockStyle.Fill;
            panelB.Dock = DockStyle.Fill;

            center_panel.Controls.Add(panelA);
            center_panel.Controls.Add(panelB);

            // 디자이너 cs 파일이 아니고 내가 직접 만들기
            Button customButton = new Button();
            customButton.Text= "OK";
            customButton.Location = new System.Drawing.Point(200, 10);

            panel1.Controls.Add(customButton);

            this.button3 = new Button();
            this.button3.Font = new System.Drawing.Font("휴먼둥근헤드라인", 15.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(129)));
            this.button3.Location = new System.Drawing.Point(200, 50);
            this.button3.Name = "button2";
            this.button3.Size = new System.Drawing.Size(160, 32);
            this.button3.TabIndex = 1;
            this.button3.Text = "복사한버튼";
            this.button3.UseVisualStyleBackColor = true;
            panel1.Controls.Add(button3);

            button2.Click += Button2_Click;
            button2.Click += (s, e) => {
                // ctrl + k + c 주석처리
                // ctrl + k + u 주석해제
                //MessageBox.Show("s = " + s);
                //MessageBox.Show("e = " + e);
                MessageBox.Show("람다 실행");
                panelA.BringToFront();
                //panel3.SendToBack();
            };
        }
        private void Button2_Click(object sender, System.EventArgs e)
        {
            //MessageBox.Show("button2 실행");
        }
        private void button1_Click(object sender, System.EventArgs e)
        {
            panelB.BringToFront();
            //panel3.BringToFront();
            //panel2.SendToBack();
            //MessageBox.Show("button1 실행");
        }
    }
}
