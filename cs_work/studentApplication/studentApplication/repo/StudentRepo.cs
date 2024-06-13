using studentApplication.conn;
using studentApplication.model;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;

namespace studentApplication.repo
{
    public class StudentRepo
    {
        private SqlConnection sqlConnection;
        private SqlCommand sqlCommand;

        public StudentRepo()
        {
            sqlConnection = DBConn.getConn();
            sqlCommand = new SqlCommand();
            sqlCommand.Connection = sqlConnection;
        }

        public List<StudentModel> FindAll()
        {
            List<StudentModel> list = new List<StudentModel>();

            sqlCommand.CommandText = "exec sp_student_select";
            sqlConnection.Open();

            using (SqlDataReader sdr = sqlCommand.ExecuteReader())
            {
                while (sdr.Read())
                {
                    list.Add(
                        new StudentModel()
                        {
                            Idx = (int)sdr["idx"],
                            Name = (string)sdr["name"],
                            Math = (int)sdr["math"],
                            Eng = (int)sdr["eng"],
                            Kor = (int)sdr["kor"]
                        }
                    );
                }
            }

            sqlConnection.Close();
            //list.Add(
            //    new StudentModel() { 
            //        Idx = 0,
            //        Name = "홍길동",
            //        Math = 90,
            //        Eng = 80,
            //        Kor = 70
            //    } 
            //);

            return list;
        }


    }
}
