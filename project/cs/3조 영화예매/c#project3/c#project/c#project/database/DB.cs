using Oracle.ManagedDataAccess.Client;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace c_project.database
{
    public class DB
    {
        public static string dbstr = "data source = 112.218.211.194; user id = khj; password = 1234;";
        public static OracleConnection conn = null;
        public static OracleConnection openConnect()
        {
            if (conn == null)
            {
                conn = new OracleConnection(dbstr);
                conn.Open();
            }
            else
            {
                conn.Open();
            }
            return conn;
        }
        public static void closeConnect()
        {
            if (conn != null)
            {
                conn.Close();
                conn.Dispose();
                conn = null;
            }
        }
    }
}
