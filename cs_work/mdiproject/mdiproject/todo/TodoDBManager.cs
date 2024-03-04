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
        public void update(Todo todo)
        {

        }
        public void delete(Todo todo)
        {

        }
        public DataTable select()
        {
            try { 
                OracleConnection con = DBINFO.openConnect();

                string sql = "select * from todo";

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
