using System;
using System.Data;
using System.Windows.Forms;
using MySql.Data.MySqlClient;

namespace CSMySQL_SMART_CRUD_V
{
    class CRUD
    {
        private static string getConnectionString()
        {
            string host = "server=192.168.0.38;";
            string port = "port=3306;";
            string db = "Database=jjc;";
            string user = "user=root;";
            string pass = "password=1234";

            string conString = string.Format("{0}{1}{2}{3}{4}",host,port,db,user,pass);

            return conString;
        }
        public static MySqlConnection con = new MySqlConnection(getConnectionString());
        public static MySqlCommand cmd = default(MySqlCommand);
        public static string sql = string.Empty;

        public static DataTable PerformCRUD(MySqlCommand com)
        {
            MySqlDataAdapter da = default(MySqlDataAdapter);
            DataTable dt = new DataTable();

            try
            {
                da = new MySqlDataAdapter();
                da.SelectCommand = com;
                da.Fill(dt);
            }
            catch (Exception ex)
            {
                MessageBox.Show("An error occured: "+ ex.Message, "Perform CRUD Operation failed",
                    MessageBoxButtons.OK, MessageBoxIcon.Error);
                dt = null;
            }
            return dt;
        }
    }
}

// https://youtu.be/tvd6tnQcDGA?si=JRcjk_iF59sTo1n-