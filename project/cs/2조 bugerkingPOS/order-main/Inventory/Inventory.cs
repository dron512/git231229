using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using MySql.Data.MySqlClient;
using OrderForm;
using WindowsFormsApp3;

namespace jjc
{
    public partial class Inventory : Form
    {
        String Connection = "datasource=127.0.0.1;port=3306;Database=burgerking;Uid=root;Pwd=1234";
        public Inventory()
        {
            InitializeComponent();
            dataSelect();
        }

        public void dataSelect()    // 전체 재고를 보여준다
        {
            MySqlConnection conn = new MySqlConnection(Connection);

            try
            {
                conn.Open();

                // columns 초기화
                inventory_dataGridView.Columns.Clear();

                // DataGridView에 칼럼 
                inventory_dataGridView.Columns.Add("ID", "ID");
                inventory_dataGridView.Columns["ID"].Visible = false;
                inventory_dataGridView.Columns.Add("상품이름", "상품이름");
                inventory_dataGridView.Columns.Add("가격", "가격");
                inventory_dataGridView.Columns.Add("수량", "수량");

                MySqlCommand cmd = new MySqlCommand("SELECT inventory.inventory_id, menu.menu_name, menu.price, inventory.stock FROM " +
                   "inventory INNER JOIN menu ON inventory.menu_id = menu.menu_id ORDER BY menu.menu_name;", conn);

                MySqlDataReader reader = cmd.ExecuteReader();

                while (reader.Read())
                {
                    object[] row = {
                        reader["inventory_id"].ToString(),
                        reader["menu_name"].ToString(),
                        reader["price"].ToString(),
                        reader["stock"].ToString()
                    };
                    inventory_dataGridView.Rows.Add(row);
                }

                inventory_dataGridView.Columns["ID"].Width = 30;
                inventory_dataGridView.Columns["상품이름"].Width = 145;
                inventory_dataGridView.Columns["가격"].Width = 145;
                inventory_dataGridView.Columns["수량"].Width = 145;
            }
            catch (Exception ex)
            {
                // columns 초기화
                MessageBox.Show("Error: " + ex.Message);
            }
            finally
            {
                if (conn.State == ConnectionState.Open)
                    conn.Close();
            }
        }

        public void burger_Select()    // 사이드 메뉴를 보여준다
        {
            MySqlConnection conn = new MySqlConnection(Connection);

            try
            {
                conn.Open();

                // columns 초기화
                inventory_dataGridView.Columns.Clear();

                // DataGridView에 칼럼 
                inventory_dataGridView.Columns.Add("ID", "ID");
                inventory_dataGridView.Columns["ID"].Visible = false;
                inventory_dataGridView.Columns.Add("상품이름", "상품이름");
                inventory_dataGridView.Columns.Add("가격", "가격");
                inventory_dataGridView.Columns.Add("수량", "수량");

                MySqlCommand cmd = new MySqlCommand("SELECT inventory.inventory_id, menu.menu_name, menu.price, inventory.stock FROM " +
                    "inventory INNER JOIN menu ON inventory.menu_id=menu.menu_id WHERE menu.type='버거' ORDER BY menu.menu_name;", conn);
                MySqlDataReader reader = cmd.ExecuteReader();

                while (reader.Read())
                {
                    object[] row = {
                reader["inventory_id"].ToString(),
                reader["menu_name"].ToString(),
                reader["price"].ToString(),
                reader["stock"].ToString()
            };
                    inventory_dataGridView.Rows.Add(row);
                }

                inventory_dataGridView.Columns["ID"].Width = 30;
                inventory_dataGridView.Columns["상품이름"].Width = 160;
                inventory_dataGridView.Columns["가격"].Width = 150;
                inventory_dataGridView.Columns["수량"].Width = 150;
            }
            catch (Exception ex)
            {
                // 예외처리
                MessageBox.Show("Error: " + ex.Message);
            }
            finally
            {
                if (conn.State == ConnectionState.Open)
                    conn.Close();
            }
        }

        public void side_Select()    // 사이드 메뉴를 보여준다
        {
            MySqlConnection conn = new MySqlConnection(Connection);

            try
            {
                conn.Open();

                // columns 초기화
                inventory_dataGridView.Columns.Clear();

                // DataGridView에 칼럼 넣기
                inventory_dataGridView.Columns.Add("ID", "ID");
                inventory_dataGridView.Columns["ID"].Visible = false;
                inventory_dataGridView.Columns.Add("상품이름", "상품이름");
                inventory_dataGridView.Columns.Add("가격", "가격");
                inventory_dataGridView.Columns.Add("수량", "수량");

                MySqlCommand cmd = new MySqlCommand("SELECT inventory.inventory_id, menu.menu_name, menu.price, inventory.stock FROM " +
                    "inventory INNER JOIN menu ON inventory.menu_id=menu.menu_id WHERE menu.type='사이드' ORDER BY menu.menu_name;", conn);
                MySqlDataReader reader = cmd.ExecuteReader();

                while (reader.Read())
                {
                    object[] row = {
                reader["inventory_id"].ToString(),
                reader["menu_name"].ToString(),
                reader["price"].ToString(),
                reader["stock"].ToString()
            };
                    inventory_dataGridView.Rows.Add(row);
                }

                inventory_dataGridView.Columns["ID"].Width = 30;
                inventory_dataGridView.Columns["상품이름"].Width = 160;
                inventory_dataGridView.Columns["가격"].Width = 150;
                inventory_dataGridView.Columns["수량"].Width = 150;
            }
            catch (Exception ex)
            {
                // 예외처리
                MessageBox.Show("Error: " + ex.Message);
            }
            finally
            {
                if (conn.State == ConnectionState.Open)
                    conn.Close();
            }
        }

        public void drink_Select()    // 음료 메뉴를 보여준다
        {
            MySqlConnection conn = new MySqlConnection(Connection);

            try
            {
                conn.Open();

                // 칼럼 초기화
                inventory_dataGridView.Columns.Clear();

                // DataGridView에 칼럼 넣기
                inventory_dataGridView.Columns.Add("ID", "ID");
                inventory_dataGridView.Columns["ID"].Visible = false;
                inventory_dataGridView.Columns.Add("상품이름", "상품이름");
                inventory_dataGridView.Columns.Add("가격", "가격");
                inventory_dataGridView.Columns.Add("수량", "수량");

                MySqlCommand cmd = new MySqlCommand("SELECT inventory.inventory_id, menu.menu_name, menu.price, inventory.stock FROM " +
                    "inventory INNER JOIN menu ON inventory.menu_id=menu.menu_id WHERE menu.type='음료' ORDER BY menu.menu_name;", conn);
                MySqlDataReader reader = cmd.ExecuteReader();

                while (reader.Read())
                {
                    object[] row = {
                reader["inventory_id"].ToString(),
                reader["menu_name"].ToString(),
                reader["price"].ToString(),
                reader["stock"].ToString()
            };
                    inventory_dataGridView.Rows.Add(row);
                }

                inventory_dataGridView.Columns["ID"].Width = 70;
                inventory_dataGridView.Columns["상품이름"].Width = 160;
                inventory_dataGridView.Columns["가격"].Width = 150;
                inventory_dataGridView.Columns["수량"].Width = 150;
            }
            catch (Exception ex)
            {
                // 예외처리
                MessageBox.Show("Error: " + ex.Message);
            }
            finally
            {
                if (conn.State == ConnectionState.Open)
                    conn.Close();
            }
        }

        public void stockChangeSelect()    // 전체 재고를 보여준다
        {
            MySqlConnection conn = new MySqlConnection(Connection);

            try
            {
                conn.Open();

                // columns 
                inventory_dataGridView.Columns.Clear();

                // DataGridView에 칼럼 
                inventory_dataGridView.Columns.Add("history_id", "history_id");
                inventory_dataGridView.Columns["history_id"].Visible = false;
                inventory_dataGridView.Columns.Add("menu_id", "menu_id");
                inventory_dataGridView.Columns["menu_id"].Visible = false;
                inventory_dataGridView.Columns.Add("상품이름", "상품이름");
                inventory_dataGridView.Columns.Add("변동량", "변동량");
                inventory_dataGridView.Columns.Add("시간", "시간");

                MySqlCommand cmd = new MySqlCommand("SELECT * " +
                                                    "FROM inventory_history order by time desc;", conn);

                MySqlDataReader reader = cmd.ExecuteReader();

                while (reader.Read())
                {
                    object[] row = {
                reader["history_id"].ToString(),
                reader["menu_id"].ToString(),
                reader["menu_name"].ToString(),
                reader["change_quantity"].ToString(),
                reader["time"].ToString(),
            };
                    inventory_dataGridView.Rows.Add(row);
                }

                inventory_dataGridView.Columns["상품이름"].Width = 155;
                inventory_dataGridView.Columns["변동량"].Width = 155;
                inventory_dataGridView.Columns["시간"].Width = 150;
            }
            catch (Exception ex)
            {
                // columns 초기화
                MessageBox.Show("Error: " + ex.Message);
            }
            finally
            {
                if (conn.State == ConnectionState.Open)
                    conn.Close();
            }
        }


        private void inventory_dataGridView_CellClick(object sender, DataGridViewCellEventArgs e)   // 현재수량을 currentstock_label에 표시
        {
            if (e.RowIndex != -1)
            {
                currentstock_label.Text = Convert.ToString(inventory_dataGridView.CurrentRow.Cells[3].Value);
            }
        }

        private void updateButton_Click(object sender, EventArgs e)
        {
            MySqlConnection conn = new MySqlConnection(Connection);
            MySqlTransaction transaction = null;

            try
            {
                conn.Open();

                transaction = conn.BeginTransaction();

                if (inventory_dataGridView.Rows.Count == 0)
                {
                    MessageBox.Show("수정할 상품을 선택하세요.");
                    return;
                }

                if (string.IsNullOrEmpty(addstock_textBox.Text.Trim()))
                {
                    MessageBox.Show("수정할 수량을 입력하세요.", "입력", MessageBoxButtons.OK, MessageBoxIcon.Information);
                    return;
                }

                string menuName = Convert.ToString(inventory_dataGridView.CurrentRow.Cells["상품이름"].Value);
                string inventoryId = Convert.ToString(inventory_dataGridView.CurrentRow.Cells["ID"].Value);
                int quantityToAdd = Convert.ToInt32(addstock_textBox.Text.Trim());

                // inventory 테이블 업데이트
                string updateSql = "UPDATE inventory SET stock = stock + @stock WHERE inventory_id = @inventory_id;";
                MySqlCommand updateCmd = new MySqlCommand(updateSql, conn, transaction);
                updateCmd.Parameters.AddWithValue("@stock", quantityToAdd);
                updateCmd.Parameters.AddWithValue("@inventory_id", inventoryId);

                updateCmd.ExecuteNonQuery();

                // inventory_history 테이블 업데이트
                string insertHistorySql = "INSERT INTO inventory_history (menu_id, menu_name, change_quantity, time) " +
                                          "VALUES (@menu_id, @menu_name, @change_quantity, @time);";
                MySqlCommand insertHistoryCmd = new MySqlCommand(insertHistorySql, conn, transaction);

                string selectMenuIdSql = "SELECT menu_id FROM menu WHERE menu_name = @menu_name;";
                MySqlCommand selectMenuIdCmd = new MySqlCommand(selectMenuIdSql, conn, transaction);
                selectMenuIdCmd.Parameters.AddWithValue("@menu_name", menuName);

                // menu_name 바탕으로 menu_id를 가져오기
                int menuId = Convert.ToInt32(selectMenuIdCmd.ExecuteScalar());

                insertHistoryCmd.Parameters.AddWithValue("@menu_id", menuId);
                insertHistoryCmd.Parameters.AddWithValue("@menu_name", menuName);
                insertHistoryCmd.Parameters.AddWithValue("@change_quantity", quantityToAdd);
                insertHistoryCmd.Parameters.AddWithValue("@time", DateTime.Now);

                insertHistoryCmd.ExecuteNonQuery();

                transaction.Commit();

                // MessageBox 메시지에 menuName을 사용
                string message = $"'{menuName}'이(가) {quantityToAdd} 만큼 추가되었습니다.";
                MessageBox.Show(message, "업데이트 완료", MessageBoxButtons.OK, MessageBoxIcon.Information);

                dataSelect();
            }
            catch (Exception ex)
            {
                MessageBox.Show("오류: " + ex.Message);

                try
                {
                    transaction?.Rollback();
                }
                catch (Exception rollbackEx)
                {
                    MessageBox.Show("Rollback 오류: " + rollbackEx.Message);
                }
            }
            finally
            {
                if (conn.State == ConnectionState.Open)
                    conn.Close();
            }
        }

        #region 공란
        private void inventory_dataGridView_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }
        private void Form1_Load(object sender, EventArgs e)
        {

        }
        #endregion


        private void 매출관리(object sender, EventArgs e)
        {
            sale_payment sale_Payment = new sale_payment();
            sale_Payment.Show();
            this.Hide();
        }

        private void 주문(object sender, EventArgs e)
        {
            Main_form main_Form = new Main_form();
            main_Form.Show();
            this.Hide();
        }

        private void burgerButton_Click(object sender, EventArgs e)
        {
            burger_Select();
        }

        private void sideButton_Click(object sender, EventArgs e)
        {
            side_Select();
        }

        private void drinkButton_Click(object sender, EventArgs e)
        {
            drink_Select();
        }

        private void selectButton_Click(object sender, EventArgs e)
        {
            dataSelect();
        }

        private void stockchange_button_Click(object sender, EventArgs e)
        {
            stockChangeSelect();
        }

        private void allStock_button_Click(object sender, EventArgs e)
        {

        }


    }
}
