using mdiproject.user;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace mdiproject.todo
{
    public partial class TodoForm : Form
    {
        private static TodoForm instance = null;

        private TodoDBManager dbManager = new TodoDBManager();

        public static TodoForm getInstance()
        {
            if (instance == null || instance.IsDisposed)
            {
                instance = new TodoForm();
                return instance;
            }
            else
            {
                return instance;
            }
        }

        public TodoForm()
        {
            InitializeComponent();

            userIdx_combobox.DataSource = new List<string>()
            {
                "1","2","3","4","5"
            };

            userIdx_combobox.SelectedText= "1";

            //Label title_lb = new Label();
            //title_lb.Text = "title";
            //title_lb.AutoSize = true;
            //title_lb.Font = new Font("한컴 고딕", 21.75F, FontStyle.Bold, GraphicsUnit.Point, ((byte)(129)));

            //Panel resevPanel = new Panel();
            //resevPanel.BackColor = Color.White;
            //resevPanel.Size = new Size(230, 200);
            //resevPanel.Location = new Point(20, 70);

            //resevPanel.Controls.Add(title_lb);
            //panel1.Controls.Add(resevPanel);

            #region Panel 화면 구현

            // 
            // panel4
            // 
            Label content_lb = new Label(); 
            Label title_lb = new Label();
            Label finishDate_lb = new Label();
            CheckBox compete_checkbox = new CheckBox();
            Label finishDate_lb_value = new Label();
            Label content_lb_value = new Label();
            Label title_lb_value = new Label();

            // 
            // compete_checkbox
            // 
            compete_checkbox.AutoSize = true;
            compete_checkbox.Font = new Font("한컴 고딕", 15F, FontStyle.Bold);
            compete_checkbox.Location = new Point(198, 176);
            compete_checkbox.Name = "compete_checkbox";
            compete_checkbox.Size = new Size(69, 30);
            compete_checkbox.TabIndex = 9;
            compete_checkbox.Text = "완료";
            compete_checkbox.UseVisualStyleBackColor = true;
            // 
            // finishDate_lb_value
            // 
            finishDate_lb_value.AutoSize = true;
            finishDate_lb_value.Font = new Font("한컴 고딕", 15F, FontStyle.Bold);
            finishDate_lb_value.Location = new Point(4, 160);
            finishDate_lb_value.Name = "finishDate_lb_value";
            finishDate_lb_value.Size = new Size(110, 26);
            finishDate_lb_value.TabIndex = 8;
            finishDate_lb_value.Text = "FinishDate";
            // 
            // content_lb_value
            // 
            content_lb_value.AutoSize = true;
            content_lb_value.Font = new Font("한컴 고딕", 15F, FontStyle.Bold);
            content_lb_value.Location = new Point(4, 70);
            content_lb_value.Name = "content_lb_value";
            content_lb_value.Size = new Size(86, 26);
            content_lb_value.TabIndex = 7;
            content_lb_value.Text = "Content";
            // 
            // title_lb_value
            // 
            title_lb_value.AutoSize = true;
            title_lb_value.Font = new Font("한컴 고딕", 15F, FontStyle.Bold);
            title_lb_value.Location = new Point(95, 6);
            title_lb_value.Name = "title_lb_value";
            title_lb_value.Size = new Size(47, 26);
            title_lb_value.TabIndex = 6;
            title_lb_value.Text = "title";
            // 
            // finishDate_lb
            // 
            finishDate_lb.AutoSize = true;
            finishDate_lb.Font = new Font("한컴 고딕", 15F, FontStyle.Bold);
            finishDate_lb.Location = new Point(4, 134);
            finishDate_lb.Name = "finishDate_lb";
            finishDate_lb.Size = new Size(110, 26);
            finishDate_lb.TabIndex = 5;
            finishDate_lb.Text = "FinishDate";
            // 
            // content_lb
            // 
            content_lb.AutoSize = true;
            content_lb.Font = new Font("한컴 고딕", 15F, FontStyle.Bold);
            content_lb.Location = new Point(4, 44);
            content_lb.Name = "content_lb";
            content_lb.Size = new Size(86, 26);
            content_lb.TabIndex = 4;
            content_lb.Text = "Content";
            // 
            // title_lb
            // 
            title_lb.AutoSize = true;
            title_lb.Font = new Font("한컴 고딕", 15F, FontStyle.Bold);
            title_lb.Location = new Point(3, 6);
            title_lb.Name = "title_lb";
            title_lb.Size = new Size(47, 26);
            title_lb.TabIndex = 3;
            title_lb.Text = "title";

            panel4.BackColor = Color.FromArgb(((int)(((byte)(255)))), ((int)(((byte)(255)))), ((int)(((byte)(192)))));
            panel4.Controls.Add(compete_checkbox);
            panel4.Controls.Add(finishDate_lb_value);
            panel4.Controls.Add(content_lb_value);
            panel4.Controls.Add(title_lb_value);
            panel4.Controls.Add(finishDate_lb);
            panel4.Controls.Add(content_lb);
            panel4.Controls.Add(title_lb);
            panel4.Location = new Point(12, 83);
            panel4.Name = "panel4";
            panel4.Size = new Size(270, 220);
            panel4.TabIndex = 1;
            panel4.ResumeLayout(false);
            panel4.PerformLayout();

            #endregion
        }

        private void button1_Click(object sender, EventArgs e)
        {
            bool result =  dbManager.insert(new Todo()
            {
                user_idx = int.Parse(userIdx_combobox.Text),
                title = title_tb.Text,
                content = content_tb.Text,
                finishdate = finish_datepicker.Value,
            });


            if (result) { 
                MessageBox.Show("입력하였습니다.");
                title_tb.Text = "";
                content_tb.Text = "";
            }
        }
    }
}
