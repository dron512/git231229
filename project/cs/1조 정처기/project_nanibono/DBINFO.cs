using Oracle.ManagedDataAccess.Client;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace project_nanibono
{
    public static class DBINFO
    {
        public static string getConnection() // db 연결하는 메서드
        {
            string dbstr = "DATA SOURCE=localhost; User Id=bono; Password=bono";

            // 각자 집에서 DB 연결할 때 쓸 string 변수
            //string dbstr = "DATA SOURCE=localhost; User Id=green; Password=1234";
            return dbstr;
        }
        public static OracleConnection con = new OracleConnection(getConnection());
        public static OracleCommand cmd = new OracleCommand();
        public static string sql = "";
    }
}
