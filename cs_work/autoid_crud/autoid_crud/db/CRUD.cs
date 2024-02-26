using Oracle.ManagedDataAccess.Client;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace autoid_crud.db
{
    public class CRUD
    {
        private static string getConnection()
        {
            string dbstr = "Data Source=(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(HOST=192.168.0.38)(PORT=1521))(CONNECT_DATA=(SERVICE_NAME=xe)));User Id=hr;Password=1234;";

            return dbstr;
        }

        public static OracleConnection con = new OracleConnection(getConnection());
        public static OracleCommand cmd = new OracleCommand();
        public static string sql = "";

    }
}
