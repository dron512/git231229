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


        private System.Windows.Forms.Label content_lb;
        private System.Windows.Forms.Label title_lb;
        private System.Windows.Forms.Label finishDate_lb;
        private System.Windows.Forms.CheckBox compete_checkbox;
        private System.Windows.Forms.Label finishDate_lb_value;
        private System.Windows.Forms.Label content_lb_value;
        private System.Windows.Forms.Label title_lb_value;

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

            Label title_lb = new Label();
            title_lb.Text = "title";
            title_lb.AutoSize = true;
            title_lb.Font = new Font("한컴 고딕", 21.75F, FontStyle.Bold, GraphicsUnit.Point, ((byte)(129)));

            Panel resevPanel = new Panel();
            resevPanel.BackColor = Color.White;
            resevPanel.Size = new Size(230, 200);
            resevPanel.Location = new Point(20, 70);

            resevPanel.Controls.Add(title_lb);
            panel1.Controls.Add(resevPanel);

            #region Panel 화면 구현

            // 
            // panel4
            // 
           

            this.compete_checkbox = new System.Windows.Forms.CheckBox();
            this.finishDate_lb_value = new System.Windows.Forms.Label();
            this.content_lb_value = new System.Windows.Forms.Label();
            this.title_lb_value = new System.Windows.Forms.Label();
            this.finishDate_lb = new System.Windows.Forms.Label();
            this.content_lb = new System.Windows.Forms.Label();
            this.title_lb = new System.Windows.Forms.Label();
            // 
            // compete_checkbox
            // 
            this.compete_checkbox.AutoSize = true;
            this.compete_checkbox.Font = new System.Drawing.Font("한컴 고딕", 15F, System.Drawing.FontStyle.Bold);
            this.compete_checkbox.Location = new System.Drawing.Point(198, 176);
            this.compete_checkbox.Name = "compete_checkbox";
            this.compete_checkbox.Size = new System.Drawing.Size(69, 30);
            this.compete_checkbox.TabIndex = 9;
            this.compete_checkbox.Text = "완료";
            this.compete_checkbox.UseVisualStyleBackColor = true;
            // 
            // finishDate_lb_value
            // 
            this.finishDate_lb_value.AutoSize = true;
            this.finishDate_lb_value.Font = new System.Drawing.Font("한컴 고딕", 15F, System.Drawing.FontStyle.Bold);
            this.finishDate_lb_value.Location = new System.Drawing.Point(4, 160);
            this.finishDate_lb_value.Name = "finishDate_lb_value";
            this.finishDate_lb_value.Size = new System.Drawing.Size(110, 26);
            this.finishDate_lb_value.TabIndex = 8;
            this.finishDate_lb_value.Text = "FinishDate";
            // 
            // content_lb_value
            // 
            this.content_lb_value.AutoSize = true;
            this.content_lb_value.Font = new System.Drawing.Font("한컴 고딕", 15F, System.Drawing.FontStyle.Bold);
            this.content_lb_value.Location = new System.Drawing.Point(4, 70);
            this.content_lb_value.Name = "content_lb_value";
            this.content_lb_value.Size = new System.Drawing.Size(86, 26);
            this.content_lb_value.TabIndex = 7;
            this.content_lb_value.Text = "Content";
            // 
            // title_lb_value
            // 
            this.title_lb_value.AutoSize = true;
            this.title_lb_value.Font = new System.Drawing.Font("한컴 고딕", 15F, System.Drawing.FontStyle.Bold);
            this.title_lb_value.Location = new System.Drawing.Point(95, 6);
            this.title_lb_value.Name = "title_lb_value";
            this.title_lb_value.Size = new System.Drawing.Size(47, 26);
            this.title_lb_value.TabIndex = 6;
            this.title_lb_value.Text = "title";
            // 
            // finishDate_lb
            // 
            this.finishDate_lb.AutoSize = true;
            this.finishDate_lb.Font = new System.Drawing.Font("한컴 고딕", 15F, System.Drawing.FontStyle.Bold);
            this.finishDate_lb.Location = new System.Drawing.Point(4, 134);
            this.finishDate_lb.Name = "finishDate_lb";
            this.finishDate_lb.Size = new System.Drawing.Size(110, 26);
            this.finishDate_lb.TabIndex = 5;
            this.finishDate_lb.Text = "FinishDate";
            // 
            // content_lb
            // 
            this.content_lb.AutoSize = true;
            this.content_lb.Font = new System.Drawing.Font("한컴 고딕", 15F, System.Drawing.FontStyle.Bold);
            this.content_lb.Location = new System.Drawing.Point(4, 44);
            this.content_lb.Name = "content_lb";
            this.content_lb.Size = new System.Drawing.Size(86, 26);
            this.content_lb.TabIndex = 4;
            this.content_lb.Text = "Content";
            // 
            // title_lb
            // 
            this.title_lb.AutoSize = true;
            this.title_lb.Font = new System.Drawing.Font("한컴 고딕", 15F, System.Drawing.FontStyle.Bold);
            this.title_lb.Location = new System.Drawing.Point(3, 6);
            this.title_lb.Name = "title_lb";
            this.title_lb.Size = new System.Drawing.Size(47, 26);
            this.title_lb.TabIndex = 3;
            this.title_lb.Text = "title";

            this.panel4.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(255)))), ((int)(((byte)(255)))), ((int)(((byte)(192)))));
            this.panel4.Controls.Add(this.compete_checkbox);
            this.panel4.Controls.Add(this.finishDate_lb_value);
            this.panel4.Controls.Add(this.content_lb_value);
            this.panel4.Controls.Add(this.title_lb_value);
            this.panel4.Controls.Add(this.finishDate_lb);
            this.panel4.Controls.Add(this.content_lb);
            this.panel4.Controls.Add(this.title_lb);
            this.panel4.Location = new System.Drawing.Point(12, 83);
            this.panel4.Name = "panel4";
            this.panel4.Size = new System.Drawing.Size(270, 220);
            this.panel4.TabIndex = 1;
            this.panel4.ResumeLayout(false);
            this.panel4.PerformLayout();

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
