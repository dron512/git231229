using Oracle.ManagedDataAccess.Client;
using System.Data;

namespace WinFormsApp1
{
    // class AA { }
    // class BB { }
    public partial class Form1 : Form
    {
        string connectionString = "Data Source=(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(HOST=192.168.0.38)(PORT=1521))(CONNECT_DATA=(SERVICE_NAME=xe)));User Id=hr;Password=1234;";

        OracleConnection conn;
        OracleCommand cmd;

        public Form1()
        {
            InitializeComponent();

            // 주석 처리 단축키 ctrl + k + c
            // mbox tab tab 
            // MessageBox.Show(strConnection);
        }

        private void button1_Click(object sender, EventArgs e)
        {
            Console.WriteLine("test");
            try
            {
                conn = new OracleConnection(connectionString);

                //cmd = new OracleCommand();
                //cmd.Connection = conn;

                conn.Open(); // database 열기

                DataSet dataSet = new DataSet();
                string sql = "select * from emp";

                OracleDataAdapter adapter = new OracleDataAdapter();
                adapter.SelectCommand = new OracleCommand(sql, conn);
                adapter.Fill(dataSet);

                // 추가 
                dataGridView1.DataSource = dataSet.Tables[0];

                conn.Close(); // database 닫기
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.StackTrace);
            }
            //MessageBox.Show("Test" +strConnection);
        }

        private void button2_Click(object sender, EventArgs e)
        {
            listView1.Items.Clear();

            conn = new OracleConnection(connectionString);
            conn.Open();

            string sql = "select * from emp";
            DataSet dataSet = new DataSet();
            OracleDataAdapter dataAdapter = new OracleDataAdapter();
            dataAdapter.SelectCommand = new OracleCommand(sql, conn);

            dataAdapter.Fill(dataSet);

            foreach (DataRow row in dataSet.Tables[0].Rows)
            {
                ListViewItem item = new ListViewItem(row["ename"].ToString());
                listView1.Items.Add(item);
                listBox1.Items.Add(row["ename"].ToString());
            }


            /*

            OracleCommand cmd = new OracleCommand(sql,conn);
            OracleDataReader dr = cmd.ExecuteReader();
            while (dr.Read())
            {
                ListViewItem item = new ListViewItem(new String[] { dr["ename"].ToString() });
                listView1.Items.Add(item);
                listBox1.Items.Add(dr["ename"].ToString());
            }
            dr.Close();
            */

            conn.Close();
        }
    }
}
