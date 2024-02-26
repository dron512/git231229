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
        private int autoid = 0;

        public Form1()
        {
            InitializeComponent();
            comboBox1.Items.AddRange(new object[] { "남자", "여자" });
            comboBox1.SelectedIndex = 0;

            dataGridView1.ReadOnly = true;
            dataGridView1.AutoSizeColumnsMode = DataGridViewAutoSizeColumnsMode.Fill;
            dataGridView1.AllowUserToAddRows = false;

            select();
        }

        private void select()
        {
            CRUD.con.Open();

            OracleDataAdapter oracleDataAdapter = new OracleDataAdapter();
            string sql = "select * from tb_smart_crud";

            OracleCommand oracleCommand = new OracleCommand(sql, CRUD.con);
            oracleDataAdapter.SelectCommand = oracleCommand;

            DataSet dataSet = new DataSet();
            oracleDataAdapter.Fill(dataSet);

            dataGridView1.DataSource = dataSet.Tables[0];

            CRUD.con.Close();
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
            
            CRUD.con.Open();
            CRUD.cmd = new OracleCommand(sql, CRUD.con);
            CRUD.cmd.Parameters.Clear();
            CRUD.cmd.Parameters.Add(":firstName", firstNameTextBox.Text);
            CRUD.cmd.Parameters.Add(":lastName", lastNameTextBox.Text);
            CRUD.cmd.Parameters.Add(":gender", gender);

            CRUD.cmd.ExecuteNonQuery();
            CRUD.con.Close();

            MessageBox.Show("저장되었습니다.");
            select();
        }

        private void button4_Click(object sender, EventArgs e)
        {
            select();
        }

        private void dataGridView1_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            this.autoid = int.Parse(dataGridView1.CurrentRow.Cells[0].Value.ToString());

            string firstName = dataGridView1.CurrentRow.Cells[1].Value.ToString();
            string lastName = dataGridView1.CurrentRow.Cells[2].Value.ToString();
            string gender = dataGridView1.CurrentRow.Cells[3].Value.ToString();

            firstNameTextBox.Text = firstName;
            lastNameTextBox.Text = lastName;

            button2.Text = $"UPDATE ({autoid})";
            button3.Text = $"DELETE ({autoid})";

            comboBox1.SelectedItem = gender;
        }

        #region update 버튼 누름
        private void button2_Click(object sender, EventArgs e)
        {


        }
        #endregion

        #region delete 버튼 누름
        private void button3_Click(object sender, EventArgs e)
        {


        }
        #endregion
    }
}
