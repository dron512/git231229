using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace mdiproject.user
{
    public partial class UserForm : Form
    {
        private static UserForm instance = null;
        private TodoDBManager userDBManager = new TodoDBManager();

        public static UserForm getInstance()
        {
            if (instance == null || instance.IsDisposed) {
                instance = new UserForm();
                return instance;
            }
            else
            {
                return instance;
            }
        }

        public UserForm()
        {
            InitializeComponent();
            LoadData();
        }

        private void LoadData()
        {
            DataTable dt = userDBManager.select();
            if(dt != null)
            {
                dataGridView1.DataSource = dt;
            }
        }

        // 삽입기능 만들어야함
        private void button1_Click(object sender, EventArgs e)
        {
            Users users = new Users() { 
                            Name=TB_NAME.Text,
                            Addr=TB_ADDR.Text,
                            Email=TB_EMAIL.Text, 
                            Password=TB_PASSWORD.Text,
                        };
            bool result = userDBManager.insert(users);
            if (result) { 
                MessageBox.Show("저장이 완료되었습니다.");
                TB_PASSWORD.Text = "";
                TB_NAME.Text = "";
                TB_ADDR.Text = "";
                TB_EMAIL.Text = "";
                LoadData();
            }
            else
            {
                MessageBox.Show("저장이 실패했습니다.");
            }
        }

        // 수정기능 만들어야함
        private void button2_Click(object sender, EventArgs e)
        {

        }

        // 삭제기능 만들어야함
        private void button3_Click(object sender, EventArgs e)
        {

        }

        // 조회기능 만들어야함
        private void button4_Click(object sender, EventArgs e)
        {
            LoadData();
        }
    }
}
