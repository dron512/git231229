using Oracle.ManagedDataAccess.Client;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace project_nanibono.member
{
    public class MemberDB
    {
        string strconn = "Data Source=(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(HOST=localhost)(PORT=1521))(CONNECT_DATA=(SERVICE_NAME=xe)));User Id=bono;Password=bono;";

        public void SelectMember(string id, string pw)
        {
            OracleConnection oc = new OracleConnection(strconn);

            oc.Open();

            string sql = $"select * from Member where id = '{id}' and pw = '{pw}'";
            OracleCommand cmd = new OracleCommand(sql, oc);
            OracleDataReader oracleDataReader = cmd.ExecuteReader();
            if (oracleDataReader.Read())
            {
                // 아이디 비번있음, 로그인 성공! -> 메인으로 돌아감 
                // 메인: 로그인 버튼 사라지고 알림 아이콘 생김
                Console.WriteLine("행있");

                FormMain formMain = new FormMain();
                formMain.Show();
                // this.Hide();
            }
            else
            {
                // 로그인 실패 -> 회원가입? , 비번아디찾기..?
                Console.WriteLine("행없");

                FormSignUp formSignUp = new FormSignUp();
                formSignUp.Show();
                // this.Hide();
            }

            oc.Close();
        }
    }
}
