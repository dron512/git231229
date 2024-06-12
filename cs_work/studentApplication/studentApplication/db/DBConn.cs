using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace studentApplication.conn
{
    public class DBConn
    {
        private static string uid = "sa"; // db접속아이디
        private static string password = "a123456!"; // db 접속패스워드
        private static string database = "student"; // db 이름
        private static string server = "localhost"; // 서버주소
        private static SqlConnection conn = null;

        public static SqlConnection getConn()
        {
            string connStr = $"SERVER = {server}; DATABASE = {database}; UID = {uid}; PASSWORD = {password};";

            conn = new SqlConnection(connStr);
            return conn;
        }

    }
}
