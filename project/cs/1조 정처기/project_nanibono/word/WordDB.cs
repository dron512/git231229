using Oracle.ManagedDataAccess.Client;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace project_nanibono.word
{
    public class WordDB
    {
        string strconn = "Data Source=(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(HOST=localhost)(PORT=1521))(CONNECT_DATA=(SERVICE_NAME=xe)));User Id=bono;Password=bono;";

        public Word SelectWord(string word)
        {
            OracleConnection oc = null;
            try
            {
                oc = new OracleConnection(strconn);

                oc.Open();

                string sql = $"select * from word where word = '{word}'";
                OracleCommand cmd = new OracleCommand(sql, oc);
                OracleDataReader oracleDataReader = cmd.ExecuteReader();
                if (oracleDataReader.Read())
                {
                    Word selectWord= new Word();
                    selectWord.word_no = oracleDataReader.GetString("word_no");
                    selectWord.word = oracleDataReader.GetString("word");
                    selectWord.word_mean = oracleDataReader.GetString("word_mean");
                    Console.WriteLine("행있음");
                    return selectWord;
                }
                else
                {
                    //db에 없음...
                    Console.WriteLine("행없음");
                    return null;
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.StackTrace);
                return null;
            }
            finally
            {
                oc.Close();
            }

        }
    }
}
