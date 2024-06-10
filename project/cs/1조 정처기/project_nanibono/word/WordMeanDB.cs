using Oracle.ManagedDataAccess.Client;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace project_nanibono.word
{
    public class WordMeanDB
    {
        string strconn = "Data Source=(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(HOST=localhost)(PORT=1521))(CONNECT_DATA=(SERVICE_NAME=xe)));User Id=bono;Password=bono;";

        public void SelectWordMean(string wordMean)
        {
            OracleConnection oc = new OracleConnection(strconn);

            oc.Open();

            string sql = $"select * from word where word_mean = '{wordMean}'";
            OracleCommand cmd = new OracleCommand(sql, oc);
            OracleDataReader oracleDataReader = cmd.ExecuteReader();
            if (oracleDataReader.Read())
            {
                Console.WriteLine("행있음");
            }
            else
            {
                Console.WriteLine("행없음");
            }

            oc.Close();
        }
    }
}
