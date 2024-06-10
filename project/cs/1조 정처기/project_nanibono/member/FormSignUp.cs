using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace project_nanibono
{
    public partial class FormSignUp : Form
    {
        public FormSignUp()
        {
            InitializeComponent();
        }
        private void button2_Click(object sender, EventArgs e)
        {
            // 회원가입 완료 후 로그인 페이지로 이동
            FormLogin formLogin = new FormLogin();
            formLogin.Show();
            this.Hide();
        }
        #region 공백
        private void FormSignUp_Load(object sender, EventArgs e)
        {
            //pictureBox1.Image = Properties.Resources.bonoImg;
        }

        private void label2_Click(object sender, EventArgs e)
        {
        }

        private void button1_Click(object sender, EventArgs e)
        {
            // 회원가입 시 아이디 중복체크
        }
        #endregion
    }
}
