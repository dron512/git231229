using jjc;
using MySql.Data.MySqlClient;
using OrderForm.product_menu;
using projecttest;


using WindowsFormsApp3;

namespace OrderForm
{
    public partial class Main_form : Form
    {
        private DB db;
        public Main_form()
        {
            InitializeComponent();

            db = new DB("127.0.0.1", "burgerking", "root", "1234");

        }

        #region 각 메뉴(메인,사이드,드링크)페이지 열기

        private void Add_Form_To_Panel(Form form) // Form타입의 매개변수 form을 입력받는 메소드
        {
            // 전달받은 폼을 패널에 추가하고 화면에 표시.
            form.TopLevel = false; // 폼을 부를때 TopLevel이면 다른패널에서 못씀, 그래서 false로 정의
            form.FormBorderStyle = FormBorderStyle.None; // form의 테두리 없애기
            form.Dock = DockStyle.Fill; // 패널에 꽉차게 하기
            panel1.Controls.Clear(); // 이미 추가된 폼이 있으면 제거.
            panel1.Controls.Add(form); // 패널에 추가
            form.Show(); // 화면에 표시
        }
        private void Btn_Main_Menu_Click(object sender, EventArgs e) // 메인 메뉴 버튼을 누르면 버거 폼 불러오기
        {
            // OrderForm.Main 네임스페이스의 Burger 클래스에 접근하여 인스턴스를 생성.
            OrderForm.product_menu.Burger burger = new OrderForm.product_menu.Burger(this);

            // burger을 패널에 추가하고 화면에 표시.
            Add_Form_To_Panel(burger);
        }
        private void Btn_Side_Menu_Click(object sender, EventArgs e) // 메인 메뉴 버튼을 누르면 사이드 폼 불러오기
        {
            OrderForm.product_menu.Side side = new OrderForm.product_menu.Side(this);
            Add_Form_To_Panel(side);
        }
        private void Btn_Drink_Menu_Click(object sender, EventArgs e) // 메인 메뉴 버튼을 누르면 드링크 폼 불러오기
        {
            OrderForm.product_menu.Drink drink = new OrderForm.product_menu.Drink(this);
            Add_Form_To_Panel(drink);
        }
        #endregion



        #region 메뉴 선택하면 listview에 보여주기

        public void Load_Products_calum(int menu_id)
        {
            try
            {
                if (db.OpenConnection())
                {
                    Console.WriteLine("db접속된거");
                    string query = $"SELECT m.menu_name, i.stock, m.price " +
                                $"FROM menu m " +
                                $"INNER JOIN inventory i ON m.menu_id = i.menu_id " +
                                $"WHERE m.menu_id = '{menu_id}'";
                    MySqlCommand command = new MySqlCommand(query, db.GetConnection());
                    MySqlDataReader reader = command.ExecuteReader();

                    // ListView에 데이터 추가
                    while (reader.Read())
                    {
                        string productName = reader.GetString("menu_name");
                        int productPrice = reader.GetInt32("price");

                        ListViewItem existingItem = Burger_Order_Listview.FindItemWithText(productName);


                        if (existingItem != null)
                        {
                            // 이미 존재하는 제품인 경우 price와 quantity를 증가시킴
                            int currentQuantity = int.Parse(existingItem.SubItems[1].Text); // 현재 quantity 가져오기
                            int newQuantity = currentQuantity + 1; // quantity 증가
                            existingItem.SubItems[1].Text = newQuantity.ToString(); // 증가된 quantity 설정

                            int currentPrice = int.Parse(existingItem.SubItems[2].Text); // 현재 price 가져오기

                        }
                        else
                        {
                            // 새로운 제품인 경우 ListView에 추가
                            ListViewItem item = new ListViewItem(productName);
                            item.SubItems.Add("1"); // quantity를 항상 1로 설정
                            item.SubItems.Add(productPrice.ToString());
                            Burger_Order_Listview.Items.Add(item);
                        }
                        Update_Total_Price();
                    }

                    reader.Close();
                }

            }
            catch (Exception ex)
            {
                MessageBox.Show("데이터베이스 연결 오류: " + ex.Message);
            }
            finally
            {
                // DB 연결 닫기
                if (db != null)
                {
                    db.CloseConnection();
                }
            }

        }
        #endregion



        #region listview 목록 삭제하기

        private void Delete_Selected_Menu()
        {
            if (Burger_Order_Listview.SelectedItems.Count > 0)
            {
                ListViewItem selectedItem = Burger_Order_Listview.SelectedItems[0]; // SelectedItems[0]는 메뉴이름, 메뉴이름을 선택하고 목록을 삭제한다
                int currentQuantity = int.Parse(selectedItem.SubItems[1].Text);
                if (currentQuantity > 1)
                {
                    // quantity가 1 이상인 경우 quantity를 감소시킴
                    currentQuantity--;
                    selectedItem.SubItems[1].Text = currentQuantity.ToString();
                }
                else
                {
                    // quantity가 1인 경우 ListView에서 행을 제거함
                    Burger_Order_Listview.Items.Remove(selectedItem);
                }

                Update_Total_Price();
            }
            else
            {
                MessageBox.Show("취소할 제품을 선택하세요.");
            }
        }
        private void Btn_Cancel_all_Click(object sender, EventArgs e) // 주문 취소를 누르면 listView를 초기화 해준다 (전체 삭제 버튼)
        {
            Burger_Order_Listview.Items.Clear();
            Update_Total_Price();
        }
        private void Btn_Cancel_Selection_Click(object sender, EventArgs e) // 선택 삭제 버튼
        {
            Delete_Selected_Menu();
        }
        #endregion



        #region 총 금액 계산

        public void Update_Total_Price()
        {
            int totalPrice = 0;

            foreach (ListViewItem item in Burger_Order_Listview.Items)
            {
                int quantity = int.Parse(item.SubItems[1].Text); // 제품의 수량
                int price = int.Parse(item.SubItems[2].Text); // 제품의 가격
                totalPrice += quantity * price;// 가격 * 수량을 총 가격에 더함
            }

            Lb_Total_Price.Text = totalPrice.ToString(); // 총 금액을 Label에 표시

        }
        public string Lb_Total_Price_P
        {
            get { return Lb_Total_Price.Text; }
        }

        #endregion



        #region 결제버튼 누르면 Form2 호출하기

        private void Btn_Payment_Click(object sender, EventArgs e) // 결제 버튼 클릭 이벤트
        {
            Form2 form2 = new Form2(this);
            form2.ShowDialog();

        }
        #endregion



        #region 매출관리 버튼, 재고관리 버튼 이벤트


        private void 매출관리(object sender, EventArgs e)
        {
            sale_payment sale_Payment = new sale_payment();
            sale_Payment.Show();
            this.Hide();
        }

        private void 재고관리(object sender, EventArgs e)
        {
            Inventory inventory = new Inventory();
            inventory.Show();
            this.Hide();
        }
        #endregion

        private void Main_form_Load(object sender, EventArgs e)
        {

        }
    }
}
