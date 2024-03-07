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

        private TodoDBManager todoDBManager = new TodoDBManager();
        private UserDBManager userDBManager = new UserDBManager();

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

            List<String> list = userDBManager.selectUserId();

            // 사용자 데이터 불러와야...
            userIdx_combobox.DataSource = list;

            userIdx_combobox.SelectedText= "1";

            
            todoSelect();
        }

        public void todoSelect()
        {
            DataTable dataTable = todoDBManager.select();

            int y = 90;
            int evenOdd = 1;
            foreach (DataRow row in dataTable.Rows)
            {
                int idx = int.Parse(row["idx"].ToString());
                string title = row["title"].ToString();
                string content = row["content"].ToString();
                DateTime finishdate = new DateTime(
                                    int.Parse(row["finishdate"].ToString().Split('-', ' ')[0]),
                                    int.Parse(row["finishdate"].ToString().Split('-', ' ')[1]),
                                    int.Parse(row["finishdate"].ToString().Split('-', ' ')[2]));
                Todo todo = new Todo();
                todo.idx = idx;
                todo.title = title;
                todo.content = content;
                todo.finishdate = finishdate;
                todo.name = row["name"].ToString();

                // y 값은 230씩 증가되야함
                makeTodoPanel(10, y, todo, evenOdd % 2);
                evenOdd += 1;
                y += 230;
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            bool result =  todoDBManager.insert(new Todo()
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

                panel1.Controls.Clear();
                todoSelect();
            }
        }

        private void makeTodoPanel(int panelx, int panely,Todo todo, int evenOdd)
        {
            #region Panel 화면 구현

            Label content_lb = new Label();
            Label title_lb = new Label();
            Label finishDate_lb = new Label();
            CheckBox compete_checkbox = new CheckBox();
            Label finishDate_lb_value = new Label();
            Label content_lb_value = new Label();
            Label title_lb_value = new Label();

            // compete_checkbox
            compete_checkbox.AutoSize = true;
            compete_checkbox.Font = new Font("한컴 고딕", 15F, FontStyle.Bold);
            compete_checkbox.Location = new Point(198, 176);
            compete_checkbox.Name = "compete_checkbox";
            compete_checkbox.Size = new Size(69, 30);
            compete_checkbox.TabIndex = 9;
            compete_checkbox.Text = "완료";
            // 변수 숨기기
            compete_checkbox.Tag = todo.idx;
            compete_checkbox.UseVisualStyleBackColor = true;
            compete_checkbox.Click += Compete_checkbox_Click;

            // finishDate_lb_value
            finishDate_lb_value.AutoSize = true;
            finishDate_lb_value.Font = new Font("한컴 고딕", 15F, FontStyle.Bold);
            finishDate_lb_value.Location = new Point(4, 160);
            finishDate_lb_value.Name = "finishDate_lb_value";
            finishDate_lb_value.Size = new Size(110, 26);
            finishDate_lb_value.TabIndex = 8;
            finishDate_lb_value.Text = todo.finishdate.ToString("yyyy/MM/dd");
            
            // content_lb_value
            content_lb_value.AutoSize = true;
            content_lb_value.Font = new Font("한컴 고딕", 15F, FontStyle.Bold);
            content_lb_value.Location = new Point(4, 70);
            content_lb_value.Name = "content_lb_value";
            content_lb_value.Size = new Size(86, 26);
            content_lb_value.TabIndex = 7;
            content_lb_value.Text = todo.content;
            
            // title_lb_value
            title_lb_value.AutoSize = true;
            title_lb_value.Font = new Font("한컴 고딕", 15F, FontStyle.Bold);
            title_lb_value.Location = new Point(95, 6);
            title_lb_value.Name = "title_lb_value";
            title_lb_value.Size = new Size(47, 26);
            title_lb_value.TabIndex = 6;
            title_lb_value.Text = todo.title;
            
            // finishDate_lb
            finishDate_lb.AutoSize = true;
            finishDate_lb.Font = new Font("한컴 고딕", 15F, FontStyle.Bold);
            finishDate_lb.Location = new Point(4, 134);
            finishDate_lb.Name = "finishDate_lb";
            finishDate_lb.Size = new Size(110, 26);
            finishDate_lb.TabIndex = 5;
            finishDate_lb.Text = "FinishDate";
            
            // content_lb
            content_lb.AutoSize = true;
            content_lb.Font = new Font("한컴 고딕", 15F, FontStyle.Bold);
            content_lb.Location = new Point(4, 44);
            content_lb.Name = "content_lb";
            content_lb.Size = new Size(86, 26);
            content_lb.TabIndex = 4;
            content_lb.Text = "Content";
            
            // title_lb
            title_lb.AutoSize = true;
            title_lb.Font = new Font("한컴 고딕", 15F, FontStyle.Bold);
            title_lb.Location = new Point(3, 6);
            title_lb.Name = "title_lb";
            title_lb.Size = new Size(47, 26);
            title_lb.TabIndex = 3;
            title_lb.Text = "title";

            Panel panel4 = new Panel();

            if (evenOdd %2==0)
                panel4.BackColor = Color.FromArgb(((int)(((byte)(255)))), ((int)(((byte)(255)))), ((int)(((byte)(192)))));
            else
                panel4.BackColor = Color.FromArgb(((int)(((byte)(255)))), ((int)(((byte)(224)))), ((int)(((byte)(192)))));

            Label nameLabel = new Label();
            nameLabel.Text = "할사람 : "+todo.name.ToString();
            nameLabel.AutoSize = true;
            nameLabel.Location = new Point(140, 50);
            nameLabel.Font = new Font("한컴 고딕", 12F);

            panel4.Controls.Add(nameLabel);
            panel4.Controls.Add(compete_checkbox);
            panel4.Controls.Add(finishDate_lb_value);
            panel4.Controls.Add(content_lb_value);
            panel4.Controls.Add(title_lb_value);
            panel4.Controls.Add(finishDate_lb);
            panel4.Controls.Add(content_lb);
            panel4.Controls.Add(title_lb);
            panel4.Location = new Point(panelx, panely);
            panel4.Name = "panel4";
            panel4.Size = new Size(270, 220);
            panel4.TabIndex = 1;
            panel4.ResumeLayout(false);
            panel4.PerformLayout();

            this.panel1.Controls.Add(panel4);

            this.label1.AutoSize = true;
            this.label1.Font = new Font("한컴 고딕", 21.75F, FontStyle.Bold, GraphicsUnit.Point, ((byte)(129)));
            this.label1.Location = new Point(12, 22);
            this.label1.Name = "label1";
            this.label1.Size = new Size(71, 38);
            this.label1.TabIndex = 0;
            this.label1.Text = "예약";

            this.panel1.Controls.Add(this.label1);
            #endregion
        }

        private void Compete_checkbox_Click(object sender, EventArgs e)
        {
            CheckBox cb = sender as CheckBox;
            MessageBox.Show($"눌렀음.....{cb.Tag}");
        }
    }
}
