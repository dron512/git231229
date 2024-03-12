using mdiproject.database;
using Oracle.ManagedDataAccess.Client;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace mdiproject.todo
{
    public class TodoDBManager
    {
        public TodoDBManager() { }
        public bool insert(Todo todo)
        {
            try { 
                OracleConnection conn = DBINFO.openConnect();

                string sql = "INSERT INTO TODO "+
                        "(IDX, USERS_IDX, TITLE, CONTENT, FINISHDATE) "+
                        "VALUES "+
                        "(todoidx.nextval, :useridx, :title, :content, :finishdate) ";
                OracleCommand cmd = new OracleCommand( sql, conn );
                cmd.Parameters.Add(":useridx", todo.user_idx);
                cmd.Parameters.Add(":title", todo.title);
                cmd.Parameters.Add(":content", todo.content);
                cmd.Parameters.Add(":finishdate", todo.finishdate);
                cmd.ExecuteNonQuery();

                DBINFO.closeConnect();
                return true;
            } 
            catch (Exception e)
            {
                Console.WriteLine(e.StackTrace);
                Console.WriteLine(e.Message);
                return false;
            }
        }
        public bool update(String idx)
        {
            try
            {
                OracleConnection conn = DBINFO.openConnect();

                string sql = " UPDATE TODO SET STATUS = 'C' WHERE idx = :idx";
                OracleCommand cmd = new OracleCommand(sql, conn);
                cmd.Parameters.Add(":idx", idx);
                cmd.ExecuteNonQuery();

                DBINFO.closeConnect();
                return true;
            }
            catch (Exception e)
            {
                Console.WriteLine(e.StackTrace);
                Console.WriteLine(e.Message);
                return false;
            }
        }
        public void delete(Todo todo)
        {

        }
        public DataTable select(string status="")
        {
            try { 
                OracleConnection con = DBINFO.openConnect();
                string sql = "";
                if (status.Equals("c"))
                {
                    sql = " select a.idx, a.title, a.content, a.finishdate, b.name " +
                                    "   from todo a, users b " +
                                    "   where a.users_idx = b.idx and a.status ='C' " +
                                    " order by a.idx desc";
                }
                else { 
                    sql = " select a.idx, a.title, a.content, a.finishdate, b.name " +
                                    "   from todo a, users b " +
                                    "   where a.users_idx = b.idx and a.status is null " +
                                    " order by a.idx desc";
                }
                OracleDataAdapter adapter = new OracleDataAdapter();
                DataSet ds = new DataSet();

                OracleCommand oracleCommand = new OracleCommand(sql, con);
                adapter.SelectCommand = oracleCommand;

                adapter.Fill(ds);

                DBINFO.closeConnect();
                return ds.Tables[0];
            }catch(Exception e)
            {
                MessageBox.Show(e.StackTrace);
                MessageBox.Show(e.Message);
                return null;
            }
            
        }
    }
}
