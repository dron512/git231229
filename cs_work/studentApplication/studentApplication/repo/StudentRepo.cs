using studentApplication.conn;
using studentApplication.model;
using System.Collections.Generic;
using System.Data.SqlClient;

namespace studentApplication.repo
{
    public class StudentRepo
    {
        private SqlConnection sqlConnection;
        private SqlCommand sqlCommand;
        
        public StudentRepo() {
            sqlConnection = DBConn.getConn();
            SqlCommand sqlCommand = new SqlCommand();
            sqlCommand.Connection = sqlConnection;
        }

        public List<StudentModel> FindAll()
        {
            List<StudentModel> list = new List<StudentModel>();

            list.Add(
                new StudentModel() { 
                    Idx = 0,
                    Name = "홍길동",
                    Math = 90,
                    Eng = 80,
                    Kor = 70
                } 
            );

            return list;
        }
    }
}
