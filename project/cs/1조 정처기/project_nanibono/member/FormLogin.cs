using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

using Oracle.ManagedDataAccess.Client;
using System;
using System.Data;
using System.Windows.Forms;
using project_nanibono.member;

namespace project_nanibono
{
    public partial class FormLogin : Form
    {
        string strConnection = "DATA SOURCE = localhost; User Id = bono; Password=bono";

        OracleConnection conn;
        OracleCommand cmd;

        public FormLogin()
        {
            InitializeComponent();
        }

        private void loginButton_Click(object sender, EventArgs e)
        {
            MemberDB memberDB = new MemberDB();
            memberDB.SelectMember(idTextBox.Text, pwTextBox.Text);
            // 메인으로?
            FormMain formMain = new FormMain();
            formMain.Show();
            this.Hide();
        }
        
        private void SignUpButton_Click(object sender, EventArgs e)
        {
            // 회원가입 페이지로 이동

            //FormSignUp formSignUp = new FormSignUp();
            // formSignUp.Show();
            //this.Hide();
        }

        private void exitButton_Click(object sender, EventArgs e)
        {
            // 프로그램 종료
            Application.Exit();
        }


        #region 공백
        private void label1_Click(object sender, EventArgs e)
        {
        }
        private void FormLogin_Load(object sender, EventArgs e)
        {
        }

        //       private void form3_load(object sender, eventargs e)
        //      {
        //    }

        private void pwTextBox_TextChanged(object sender, EventArgs e)
        {
        }

        private void idTextBox_TextChanged(object sender, EventArgs e)
        {
        }

        //     private void idTextBox_TextChanged(object sender, EventArgs e)
        //   {

        // }
        #endregion
    }
}
