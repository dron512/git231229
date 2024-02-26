using autoid_crud.db;
using Oracle.ManagedDataAccess.Client;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace autoid_crud
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
            comboBox1.Items.AddRange(new object[] { "남자", "여자" });
        }


        private void insert(object sender, EventArgs e)
        {
            if (string.IsNullOrEmpty(firstNameTextBox.Text.Trim())
                || string.IsNullOrEmpty(lastNameTextBox.Text.Trim()))
            {
                MessageBox.Show("이름을 입력하세요", "경고", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }
            string gender = "남자";

            if( comboBox1.SelectedItem != null)
            {
                gender = comboBox1.SelectedItem.ToString();
            }

            string sql = $"insert into tb_smart_crud " +
                $"values " +
                $"(TB_SMART_SEQ.nextval, " +
                $":firstName," +
                $":lastName," +
                $":gender)";
            //string sql =$"insert into tb_smart_crud " +
            //    $"values " +
            //    $"(TB_SMART_SEQ.nextval, " +
            //    $"'{firstNameTextBox.Text}'," +
            //    $"'{lastNameTextBox.Text}'," +
            //    $"'{gender}')";

            CRUD.con.Open();
            CRUD.cmd = new OracleCommand(sql,CRUD.con);
            CRUD.cmd.Parameters.Clear();
            CRUD.cmd.Parameters.Add(":firstName", firstNameTextBox.Text);
            CRUD.cmd.Parameters.Add(":lastName", lastNameTextBox.Text);
            CRUD.cmd.Parameters.Add(":gender", gender);

            CRUD.cmd.ExecuteNonQuery();
            CRUD.con.Close();

            MessageBox.Show("저장되었습니다.");

        }
    }
}
