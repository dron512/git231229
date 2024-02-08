using Oracle.ManagedDataAccess.Client;

namespace WinFormsApp3
{
    public partial class Form1 : Form
    {
        string connectionString = "Data Source=(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(HOST=192.168.0.38)(PORT=1521))(CONNECT_DATA=(SERVICE_NAME=xe)));User Id=hr;Password=1234;";

        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            listBox1.Items.Clear();
            /*
             * OracleDataAdapter -> select Close
             * OracleDataReader -> Close
             */
            OracleConnection conn = new OracleConnection(connectionString);
            conn.Open();
            OracleCommand cmd = new OracleCommand("select * from 학생", conn);
            OracleDataReader reader = cmd.ExecuteReader();
            while (reader.Read())
            {
                listBox1.Items.Add(
                                    reader.GetString(0) + "\t" +
                                    reader.GetString(1) + "\t" +
                                    reader.GetString(2) + "\t" +
                                    reader.GetString(3) + "\t" +
                                    reader.GetString(4)
                                );
                //MessageBox.Show(reader["학번"].ToString());
            }
            reader.Close();
            conn.Close();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            listBox1.Items.Add("문자열입니다.");
        }

        private void button3_Click(object sender, EventArgs e)
        {
            listBox1.Items.Insert(0, "문자열추가");
        }
    }
}
