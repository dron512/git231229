using System;
using System.Collections.Generic;
using System.Reflection.PortableExecutable;
using System.Windows.Forms;
using MySql.Data.MySqlClient;
using Mysqlx.Crud;
using OrderForm;
using OrderForm.product_menu;
using static System.Windows.Forms.VisualStyles.VisualStyleElement;

namespace projecttest
{
    public partial class Form2 : Form
    {
        private Main_form main_Form;
        private DB db;
        public Form2(Main_form main_Form)
        {
            InitializeComponent();
            this.main_Form = main_Form;
            main_Form.Update_Total_Price();

            Lb_Pay_Price.Text = main_Form.Lb_Total_Price_P;

            db = new DB("127.0.0.1", "burgerking", "root", "1234");

        }

        #region order 테이블에 order_id와 order_time을 저장하는 쿼리문 Save_Order()


        // order 테이블에 order_id와 order_time을 저장하는 메서드
        private int Save_Order()
        {
            int orderId = 0; // 초기 주문 ID 설정 0으로 초기화
            try
            {
                if (db.OpenConnection())
                {
                    string query = $"INSERT INTO `order` (order_time) VALUES (@order_time)"; // order 테이블에있는 order_time 컬럼에 NOW를 넣으면 현재시간이 등록된다
                    MySqlCommand command = new MySqlCommand(query, db.GetConnection());
                    command.Parameters.AddWithValue("@order_time", DateTime.Now);
                    command.ExecuteNonQuery(); // 쿼리 실행문

                    // 새로 생성된 order_id 가져오기
                    query = "SELECT LAST_INSERT_ID()"; // MySQL에서 마지막으로 삽입된 자동 증가(primary key) 열의 값을 가져오는 쿼리
                    command = new MySqlCommand(query, db.GetConnection());
                    // command.ExecuteScalar() 메서드를 통해 쿼리를 실행하고
                    // 그 결과로 반환된 첫 번째 행의 첫 번째 열의 값을 가져온다
                    // 그다음 Convert.ToInt32()를 사용하여 정수로 변환한 다음 orderId 변수에 넣는다.
                    // 새로운 주문이 들어왔을때 생성된 order_id 값을 가져오는데 사용
                    orderId = Convert.ToInt32(command.ExecuteScalar());
                }
            }
            catch (MySqlException ex) // 예외처리
            {
                MessageBox.Show("주문을 처리하는 동안 오류가 발생했습니다: " + ex.Message);
            }
            finally
            {
                if (db != null)
                {
                    db.CloseConnection();
                }
            }
            return orderId;
        }
        #endregion



        #region 메뉴 이름을 기반으로 메뉴 ID를 가져오는 쿼리문 SelectInventoryForOrderMenu()


        public void SelectInventoryForOrderMenu(int orderId)
        {

            try
            {
                if (db.OpenConnection())
                {
                    string query = $"SELECT menu_id, quantity" +
                                    $"FROM order_menu " +
                                    $"WHERE order_id = '{orderId}'";
                    MySqlCommand command = new MySqlCommand(query, db.GetConnection());
                    command.ExecuteNonQuery();
                    MySqlDataReader reader = command.ExecuteReader();

                    while (reader.Read())
                    {
                        int menuId = reader.GetInt32("menu_id");
                        int quantity = reader.GetInt32("quantity");

                    }

                }

            }
            catch (MySqlException ex)
            {
                if (db != null)
                {
                    db.CloseConnection();
                }
            }

        }
        #endregion



        #region order_menu 테이블에 저장하는 쿼리문 Save_Order_Menu()


        // 주문된 메뉴 정보를 order_menu 테이블에 저장하는 메서드
        private void Save_Order_Menu(int orderId, int menuId, int quantity)
        {
            try
            {
                if (db.OpenConnection())
                {
                    // order_menu 테이블에 위에서 정의한 orderId, menuId, 새로 받을 quantity 정보를 저장한다
                    string query = $"INSERT INTO order_menu (order_id, menu_id, quantity) VALUES ({orderId}, {menuId}, {quantity})";
                    MySqlCommand command = new MySqlCommand(query, db.GetConnection());
                    command.ExecuteNonQuery(); // 쿼리 실행
                }

            }
            catch (MySqlException ex)
            {
                MessageBox.Show("주문 메뉴를 추가하는 동안 오류가 발생했습니다: " + ex.Message);
            }
            finally
            {
                if (db != null)
                {
                    db.CloseConnection();
                }
            }
        }
        #endregion



        #region inventory stock 수량 조절 메서드 UpdateInventoryStock()


        public void UpdateInventoryStock(int menuId, int quantity)
        {
            try
            {
                if (db.OpenConnection())
                {
                    string query = $"UPDATE inventory " +
                                    $"SET stock = stock - '{quantity}'" +
                                    $"WHERE menu_id = '{menuId}'";
                    MySqlCommand command = new MySqlCommand(query, db.GetConnection());
                    command.ExecuteNonQuery();
                }
            }
            catch (MySqlException ex)
            {
                MessageBox.Show("수량업데이트 도중 오류가 발생했습니다: " + ex.Message);
            }
            finally
            {
                if (db != null)
                {
                    db.CloseConnection();
                }
            }
        }
        #endregion

 

        #region payment 테이블 저장 쿼리문 AddPaymentToDatabase()


        private void AddPaymentToDatabase(string payment_method, int orderId)
        {
            try
            {
                if (db.OpenConnection())
                {

                    string query = "INSERT INTO payment(payment_method, payment_amount, payment_time, order_id) " +
                           "VALUES (@payment_method, @payment_amount, @payment_time, @order_id)";
                    MySqlCommand command = new MySqlCommand(query, db.GetConnection());

                    command.Parameters.AddWithValue("@order_id", orderId);
                    command.Parameters.AddWithValue("@payment_method", payment_method);
                    command.Parameters.AddWithValue("@payment_amount", Lb_Pay_Price.Text);
                    command.Parameters.AddWithValue("@payment_time", DateTime.Now);

                    command.ExecuteNonQuery();
                }

            }
            catch (Exception ex)
            {
                MessageBox.Show("Error: " + ex.Message);
            }
            finally
            {
                if (db != null)
                {
                    db.CloseConnection();
                }
            }
        }
        #endregion



        #region menu_id 와 menu_name 불러오는 쿼리문 GetAllMenuIds()


        Dictionary<string, int> GetAllMenuIds()
        {
            Dictionary<string, int> menuIdMap = new Dictionary<string, int>();

            try
            {
                if (db.OpenConnection())
                {
                    string query = "SELECT menu_id, menu_name FROM menu";
                    MySqlCommand command = new MySqlCommand(query, db.GetConnection());
                    command.ExecuteNonQuery();
                    MySqlDataReader reader = command.ExecuteReader();

                    while (reader.Read())
                    {
                        int menuId = reader.GetInt32("menu_id");
                        string menuName = reader.GetString("menu_name");
                        menuIdMap.Add(menuName, menuId);
                    }

                }

            }
            catch (MySqlException ex)
            {
                if (db != null)
                {
                    db.CloseConnection();
                }
            }

            return menuIdMap;
        }
        #endregion



        #region 현금결제 버튼 클릭 이벤트


        // 현금결제 버튼 클릭 이벤트
        private void button1_Click(object sender, EventArgs e)
        {
            try
            {
                if (db.OpenConnection())
                {
                    int orderId = Save_Order(); // Save_Order 메서드를 호출한다
                    AddPaymentToDatabase("현금", orderId);
                    MessageBox.Show("결제 완료 되었습니다.");

                    if (orderId > 0) // 0보다 클때
                    {
                        Dictionary<string, int> menuIdMap = GetAllMenuIds();
                        // 각 메뉴별로 주문된 수량과 메뉴 ID를 가져와서 order_menu 테이블에 저장
                        foreach (ListViewItem item in main_Form.Burger_Order_Listview.Items)
                        {
                            string menuName = item.SubItems[0].Text;
                            int quantity = int.Parse(item.SubItems[1].Text);

                            // 메뉴 이름으로부터 메뉴 ID를 가져오는 메서드 호출
                            int menuId = menuIdMap[menuName];
                            SelectInventoryForOrderMenu(orderId);

                            // order_menu 테이블에 주문 정보 저장
                            Save_Order_Menu(orderId, menuId, quantity);

                            UpdateInventoryStock(menuId, quantity);

                            
                        }


                        MessageBox.Show("주문이 성공적으로 완료되었습니다.");
                        // 주문 완료 후 ListView 초기화
                        main_Form.Burger_Order_Listview.Items.Clear();
                        main_Form.Update_Total_Price();

                    }
                    else
                    {
                        MessageBox.Show("주문을 처리하는 동안 오류가 발생했습니다.");
                    }
                }

            }
            catch (Exception ex)
            {
                MessageBox.Show("데이터베이스 연결 오류: " + ex.Message);
            }
            finally
            {
                if (db != null)
                {
                    db.CloseConnection();
                }
            }

            this.Close();

        }
        #endregion



        #region 카드결제 버튼클릭 이벤트


        private void button2_Click(object sender, EventArgs e)
        {
            try
            {
                if (db.OpenConnection())
                {
                    int orderId = Save_Order(); // Save_Order 메서드를 호출한다
                    AddPaymentToDatabase("카드", orderId);
                    MessageBox.Show("결제 완료 되었습니다.");

                    if (orderId > 0) // 0보다 클때
                    {
                        Dictionary<string, int> menuIdMap = GetAllMenuIds();
                        // 각 메뉴별로 주문된 수량과 메뉴 ID를 가져와서 order_menu 테이블에 저장
                        foreach (ListViewItem item in main_Form.Burger_Order_Listview.Items)
                        {
                            string menuName = item.SubItems[0].Text;
                            int quantity = int.Parse(item.SubItems[1].Text);

                            // 메뉴 이름으로부터 메뉴 ID를 가져오는 메서드 호출
                            int menuId = menuIdMap[menuName];
                            SelectInventoryForOrderMenu(orderId);
                            // order_menu 테이블에 주문 정보 저장
                            Save_Order_Menu(orderId, menuId, quantity);

                            UpdateInventoryStock(menuId, quantity);
                            
                        }


                        MessageBox.Show("주문이 성공적으로 완료되었습니다.");
                        // 주문 완료 후 ListView 초기화
                        main_Form.Burger_Order_Listview.Items.Clear();
                        main_Form.Update_Total_Price();
                    }
                    else
                    {
                        MessageBox.Show("주문을 처리하는 동안 오류가 발생했습니다.");
                    }
                }

            }
            catch (Exception ex)
            {
                MessageBox.Show("데이터베이스 연결 오류: " + ex.Message);
            }
            finally
            {
                if (db != null)
                {
                    db.CloseConnection();
                }
            }

            this.Close();
        }
        #endregion




        private void Form2_Load(object sender, EventArgs e)
        {

        }
    }
}



