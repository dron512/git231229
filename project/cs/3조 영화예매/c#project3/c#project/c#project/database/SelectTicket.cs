using Oracle.ManagedDataAccess.Client;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace c_project.database
{
    public class SelectTicket
    {
        public List<String> CheckMovieData(String checknumber)
        {
            string connectionString = DB.dbstr;
            List<String> ticketdata = new List<String>();
            using (OracleConnection connection = DB.openConnect())
            {
                try
                {
                    string sql = "select * from 예매 where 예매번호 = :ticketnumber OR 전화번호 = :ticketnumber";
                    using (OracleCommand command = new OracleCommand(sql, connection))
                    {
                        command.Parameters.Add(":ticketnumber", checknumber);

                        using (OracleDataReader reader = command.ExecuteReader())
                        {
                            if (reader.HasRows)
                            {
                                while (reader.Read())
                                {
                                    for (int i = 0; i < reader.FieldCount; i++)
                                    {
                                        ticketdata.Add(reader.GetString(i));
                                    }
                                }
                            }
                            else
                            {
                                MessageBox.Show("존재하지 않는 번호입니다");
                                return null;
                            }

                        }
                    }
                }
                catch (Exception ex)
                {
                    Console.WriteLine("Error: " + ex.Message);
                }
                finally
                {
                    DB.closeConnect();
                }
            }
            return ticketdata;
        }
        public void DeleteTicket(String ticketnumber)
        {
            string connectionString = DB.dbstr;
            using (OracleConnection connection = DB.openConnect())
            {
                try
                {
                    string sql = "DELETE FROM 예매 WHERE 예매번호 = :ticketnumber";
                    using (OracleCommand command = new OracleCommand(sql, connection))
                    {
                        command.Parameters.Add(":ticketnumber", ticketnumber);

                        int rowsAffected = command.ExecuteNonQuery();

                        if (rowsAffected > 0)
                        {
                            MessageBox.Show("예매가 취소 되었습니다");
                        }
                        else
                        {
                            MessageBox.Show("존재하지 않는 번호입니다");
                            MessageBox.Show("번호를 확인해주세요");
                        }
                    }
                }
                catch (Exception ex)
                {
                    Console.WriteLine("Error: " + ex.Message);
                }
                finally
                {
                    DB.closeConnect();
                }
            }
        }
        public int Coupon(String couponnumber)
        {
            string connectionString = DB.dbstr;
            int discount = 0;
            using (OracleConnection connection = DB.openConnect())
            {
                try
                {
                    string sql = "select discount from 쿠폰 where coupon = :coupon";
                    using (OracleCommand command = new OracleCommand(sql, connection))
                    {
                        command.Parameters.Add(":coupon", couponnumber);

                        using (OracleDataReader reader = command.ExecuteReader())
                        {
                            if (reader.Read())
                            {
                                discount = reader.GetInt32(0);
                                return discount;
                                Console.WriteLine(discount);
                            }
                            else
                            {
                                MessageBox.Show("존재하지 않는 번호입니다");
                                return 0;
                            }

                        }
                    }
                }
                catch (Exception ex)
                {
                    Console.WriteLine("Error: " + ex.Message);
                }
                finally
                {
                    DB.closeConnect();
                }
            }
            return discount;
        }
    }
}
