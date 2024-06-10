using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace project_nanibono.main
{
    public partial class FormAdminMain : Form
    {
        public FormAdminMain()
        {
            InitializeComponent();

            // 메인으로 회원관리 사용자 정의를 보이게 만듦
            SidePanel.Height = button_user.Height;
            SidePanel.Top = button_user.Top;
            adminMemberManagement1.BringToFront();
            button_user.ForeColor = Color.FromArgb(57, 167, 255);
        }

        private void button_Click(object sender, EventArgs e)
        {
            Button clickedButton = (Button)sender;
            clickedButton.ForeColor = Color.FromArgb(57, 167, 255);
            SidePanel.Height = clickedButton.Height;
            SidePanel.Top = clickedButton.Top;

            if(clickedButton.Text.Equals("⋆⁺₊⋆회원관리⋆⁺₊⋆") || clickedButton.Text.Trim().Equals("먼시험보노 관 리 자"))
            {
                button_word.ForeColor = Color.FromArgb(135, 196, 255);
                button_request.ForeColor = Color.FromArgb(135, 196, 255);
                button_user.ForeColor = Color.FromArgb(57, 167, 255);
                adminMemberManagement1.BringToFront();
            } else if(clickedButton.Text.Equals("⋆⁺₊⋆단어관리⋆⁺₊⋆"))
            {
                button_user.ForeColor = Color.FromArgb(135, 196, 255);
                button_request.ForeColor = Color.FromArgb(135, 196, 255);
                adminWordManagement1.BringToFront();
            } else if(clickedButton.Text.Equals("⋆⁺₊⋆요청관리⋆⁺₊⋆"))
            {
                button_user.ForeColor = Color.FromArgb(135, 196, 255);
                button_word.ForeColor = Color.FromArgb(135, 196, 255);
                adminRequestManagement1.BringToFront();
            }
        }
    }
}
