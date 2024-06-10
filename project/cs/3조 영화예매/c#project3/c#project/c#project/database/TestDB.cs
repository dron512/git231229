using Oracle.ManagedDataAccess.Client;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using static System.Windows.Forms.VisualStyles.VisualStyleElement.Window;

namespace c_project.database
{
    public class TestDB
    {
        public List<int> movieNumSelect(int option=0)
        {
            string sql = "";
            List<int> list = new List<int>();
            DB.openConnect();
            if (option == 0)
            {
                sql = "select 영화번호 from 영화";
            }
            else
            {
                sql = "select 영화번호 from (select * from 영화 order by 영화번호 desc) where rownum < 5";
            }
            
            OracleCommand cmd = new OracleCommand(sql, DB.conn);
            OracleDataReader rdr = cmd.ExecuteReader();

            while (rdr.Read())
            {
                list.Add(rdr.GetInt32(0));
            }

            DB.closeConnect();
            return list;
        }

        public List<string> movieInfo(int movieNum)
        {
            List<string> list = new List<string>();
            DB.openConnect();
            string sql = "select 영화명,상영등급,러닝타임,줄거리 from 영화 where 영화번호 = :movieNum";
            OracleCommand cmd = new OracleCommand(sql, DB.conn);
            cmd.Parameters.Add("movieNum",movieNum);
            OracleDataReader rdr = cmd.ExecuteReader();

            while (rdr.Read())
            {
                list.Add(rdr.GetString(0));
                list.Add(rdr.GetString(1));
                list.Add(rdr.GetString(2));
                list.Add(rdr.GetString(3));
            }

            DB.closeConnect();
            return list;
        }

        public List<int> timeTableIndex(int movieNum)
        {
            List<int> list = new List<int>();
            DB.openConnect();
            string sql = "select 시간표 from 시간표 where 영화번호 = :movieNum and to_char(시작시간,'yy/MM/dd') = to_char(sysdate+9/24,'yy/MM/dd') order by 시작시간";
            OracleCommand cmd = new OracleCommand(sql, DB.conn);
            cmd.Parameters.Add("movieNum", movieNum);
            OracleDataReader rdr = cmd.ExecuteReader();

            while (rdr.Read())
            {
                list.Add(int.Parse(rdr.GetString(0)));
            }

            DB.closeConnect();
            return list;
        }

        public List<string> movieDetale(int ttindex)
        {
            List<string> list = new List<string>();
            DB.openConnect();
            string sql = "select 영화명,상영등급,러닝타임,to_char(시작시간,'MM/dd hh24:mi'),상영관 from 시간표 a join 영화 b on a.영화번호 = b.영화번호 where 시간표 = :ttindex";
            OracleCommand cmd = new OracleCommand(sql, DB.conn);
            cmd.Parameters.Add("ttindex", ttindex);
            OracleDataReader rdr = cmd.ExecuteReader();

            while (rdr.Read())
            {
                list.Add(rdr.GetString(0));
                list.Add(rdr.GetString(1));
                list.Add(rdr.GetString(2));
                list.Add(rdr.GetString(3));
                list.Add(rdr.GetString(4));
            }

            DB.closeConnect();
            return list;
        }

        public DateTime movieStartTime(int ttindex)
        {
            DateTime startTime = new DateTime();
            DB.openConnect();
            string sql = "select 시작시간 from 시간표 where 시간표 = :ttindex";
            OracleCommand cmd = new OracleCommand(sql, DB.conn);
            cmd.Parameters.Add("ttindex", ttindex);
            OracleDataReader rdr = cmd.ExecuteReader();

            while (rdr.Read())
            {
                startTime = rdr.GetDateTime(0);
            }
            DB.closeConnect();
            return startTime;
        }

        public string currentSeat(int ttindex)
        {
            string currentSeat = "";
            DB.openConnect();
            string sql = "select count(확인) from 상영관 where 확인 = '0' and 시간표 = :ttindex";
            OracleCommand cmd = new OracleCommand(sql, DB.conn);
            cmd.Parameters.Add("ttindex", ttindex);
            OracleDataReader rdr = cmd.ExecuteReader();

            while (rdr.Read())
            {
                currentSeat = rdr.GetString(0);
            }

            DB.closeConnect();
            return currentSeat;
        }

        public List<string> seatInfo(int ttindex)
        {
            List<string> seatInfo = new List<string>();
            DB.openConnect();
            string sql = "select 좌석 from 상영관 where 시간표 = :ttindex and 확인 = '1'";
            OracleCommand cmd = new OracleCommand(sql, DB.conn);
            cmd.Parameters.Add(":ttindex", ttindex);
            OracleDataReader rdr = cmd.ExecuteReader();

            while (rdr.Read())
            {
                seatInfo.Add(rdr.GetInt32(0).ToString() + "번");
            }

            DB.closeConnect();
            return seatInfo;
        }

        public List<int> ticketPrice()
        {
            List<int> price = new List<int>();
            DB.openConnect();
            string sql = "select 가격 from price";
            OracleCommand cmd = new OracleCommand(sql, DB.conn);
            OracleDataReader rdr = cmd.ExecuteReader();

            while (rdr.Read())
            {
                price.Add(rdr.GetInt32(0));
            }

            DB.closeConnect();
            return price;
        }
    }
}
