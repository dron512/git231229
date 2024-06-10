namespace OrderForm
{
    partial class Main_form
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            Burger_Order_Listview = new ListView();
            columnHeader1 = new ColumnHeader();
            columnHeader2 = new ColumnHeader();
            columnHeader3 = new ColumnHeader();
            Btn_Whopper = new Button();
            Btn_Cancel_all = new Button();
            Btn_Cancel_Selection = new Button();
            Btn_Side_Menu = new Button();
            label1 = new Label();
            Lb_Total_Price = new Label();
            Btn_Payment = new Button();
            panel1 = new Panel();
            Btn_Drink_Menu = new Button();
            button1 = new Button();
            button2 = new Button();
            SuspendLayout();
            // 
            // Burger_Order_Listview
            // 
            Burger_Order_Listview.Columns.AddRange(new ColumnHeader[] { columnHeader1, columnHeader2, columnHeader3 });
            Burger_Order_Listview.Font = new Font("맑은 고딕", 12F, FontStyle.Regular, GraphicsUnit.Point, 129);
            Burger_Order_Listview.GridLines = true;
            Burger_Order_Listview.Location = new Point(40, 34);
            Burger_Order_Listview.Name = "Burger_Order_Listview";
            Burger_Order_Listview.Size = new Size(521, 375);
            Burger_Order_Listview.TabIndex = 0;
            Burger_Order_Listview.UseCompatibleStateImageBehavior = false;
            Burger_Order_Listview.View = View.Details;
            // 
            // columnHeader1
            // 
            columnHeader1.Text = "메뉴";
            columnHeader1.Width = 130;
            // 
            // columnHeader2
            // 
            columnHeader2.Text = "수량";
            // 
            // columnHeader3
            // 
            columnHeader3.Text = "가격";
            columnHeader3.Width = 100;
            // 
            // Btn_Whopper
            // 
            Btn_Whopper.BackColor = SystemColors.Highlight;
            Btn_Whopper.Font = new Font("맑은 고딕", 12F);
            Btn_Whopper.Location = new Point(600, 34);
            Btn_Whopper.Name = "Btn_Whopper";
            Btn_Whopper.Size = new Size(131, 68);
            Btn_Whopper.TabIndex = 1;
            Btn_Whopper.Text = "메인 메뉴";
            Btn_Whopper.UseVisualStyleBackColor = false;
            Btn_Whopper.Click += Btn_Main_Menu_Click;
            // 
            // Btn_Cancel_all
            // 
            Btn_Cancel_all.BackColor = Color.DarkBlue;
            Btn_Cancel_all.Font = new Font("맑은 고딕", 12F);
            Btn_Cancel_all.ForeColor = Color.White;
            Btn_Cancel_all.Location = new Point(751, 461);
            Btn_Cancel_all.Name = "Btn_Cancel_all";
            Btn_Cancel_all.Size = new Size(131, 68);
            Btn_Cancel_all.TabIndex = 2;
            Btn_Cancel_all.Text = "전체 취소";
            Btn_Cancel_all.UseVisualStyleBackColor = false;
            Btn_Cancel_all.Click += Btn_Cancel_all_Click;
            // 
            // Btn_Cancel_Selection
            // 
            Btn_Cancel_Selection.BackColor = Color.DarkBlue;
            Btn_Cancel_Selection.Font = new Font("맑은 고딕", 12F);
            Btn_Cancel_Selection.ForeColor = Color.White;
            Btn_Cancel_Selection.Location = new Point(600, 461);
            Btn_Cancel_Selection.Name = "Btn_Cancel_Selection";
            Btn_Cancel_Selection.Size = new Size(131, 68);
            Btn_Cancel_Selection.TabIndex = 3;
            Btn_Cancel_Selection.Text = "선택 취소";
            Btn_Cancel_Selection.UseVisualStyleBackColor = false;
            Btn_Cancel_Selection.Click += Btn_Cancel_Selection_Click;
            // 
            // Btn_Side_Menu
            // 
            Btn_Side_Menu.BackColor = SystemColors.Highlight;
            Btn_Side_Menu.Font = new Font("맑은 고딕", 12F);
            Btn_Side_Menu.Location = new Point(751, 34);
            Btn_Side_Menu.Name = "Btn_Side_Menu";
            Btn_Side_Menu.RightToLeft = RightToLeft.No;
            Btn_Side_Menu.Size = new Size(131, 68);
            Btn_Side_Menu.TabIndex = 4;
            Btn_Side_Menu.Text = "사이드 메뉴";
            Btn_Side_Menu.UseVisualStyleBackColor = false;
            Btn_Side_Menu.Click += Btn_Side_Menu_Click;
            // 
            // label1
            // 
            label1.BackColor = Color.LightGray;
            label1.BorderStyle = BorderStyle.FixedSingle;
            label1.Font = new Font("맑은 고딕", 14F, FontStyle.Bold);
            label1.Location = new Point(40, 408);
            label1.Name = "label1";
            label1.Size = new Size(94, 34);
            label1.TabIndex = 5;
            label1.Text = "총 금액";
            label1.TextAlign = ContentAlignment.MiddleCenter;
            // 
            // Lb_Total_Price
            // 
            Lb_Total_Price.BackColor = Color.White;
            Lb_Total_Price.BorderStyle = BorderStyle.FixedSingle;
            Lb_Total_Price.Font = new Font("맑은 고딕", 14F, FontStyle.Bold);
            Lb_Total_Price.Location = new Point(133, 408);
            Lb_Total_Price.Name = "Lb_Total_Price";
            Lb_Total_Price.Size = new Size(428, 34);
            Lb_Total_Price.TabIndex = 6;
            Lb_Total_Price.Text = "                 ";
            Lb_Total_Price.TextAlign = ContentAlignment.MiddleLeft;
            // 
            // Btn_Payment
            // 
            Btn_Payment.BackColor = Color.DarkBlue;
            Btn_Payment.Font = new Font("맑은 고딕", 12F);
            Btn_Payment.ForeColor = Color.White;
            Btn_Payment.Location = new Point(897, 461);
            Btn_Payment.Name = "Btn_Payment";
            Btn_Payment.Size = new Size(131, 68);
            Btn_Payment.TabIndex = 7;
            Btn_Payment.Text = "결제";
            Btn_Payment.UseVisualStyleBackColor = false;
            Btn_Payment.Click += Btn_Payment_Click;
            // 
            // panel1
            // 
            panel1.BackColor = Color.Azure;
            panel1.Location = new Point(600, 108);
            panel1.Name = "panel1";
            panel1.Size = new Size(428, 334);
            panel1.TabIndex = 8;
            // 
            // Btn_Drink_Menu
            // 
            Btn_Drink_Menu.BackColor = SystemColors.Highlight;
            Btn_Drink_Menu.Font = new Font("맑은 고딕", 12F);
            Btn_Drink_Menu.Location = new Point(897, 34);
            Btn_Drink_Menu.Name = "Btn_Drink_Menu";
            Btn_Drink_Menu.Size = new Size(131, 68);
            Btn_Drink_Menu.TabIndex = 9;
            Btn_Drink_Menu.Text = "음료";
            Btn_Drink_Menu.UseVisualStyleBackColor = false;
            Btn_Drink_Menu.Click += Btn_Drink_Menu_Click;
            // 
            // button1
            // 
            button1.BackColor = Color.DarkBlue;
            button1.Font = new Font("맑은 고딕", 12F);
            button1.ForeColor = Color.White;
            button1.Location = new Point(40, 462);
            button1.Name = "button1";
            button1.Size = new Size(131, 68);
            button1.TabIndex = 10;
            button1.Text = "재고관리";
            button1.UseVisualStyleBackColor = false;
            button1.Click += 재고관리;
            // 
            // button2
            // 
            button2.BackColor = Color.DarkBlue;
            button2.Font = new Font("맑은 고딕", 12F);
            button2.ForeColor = Color.White;
            button2.Location = new Point(185, 461);
            button2.Name = "button2";
            button2.Size = new Size(131, 68);
            button2.TabIndex = 11;
            button2.Text = "매출관리";
            button2.UseVisualStyleBackColor = false;
            button2.Click += 매출관리;
            // 
            // Main_form
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            AutoSize = true;
            BackColor = Color.Azure;
            ClientSize = new Size(1067, 568);
            Controls.Add(button1);
            Controls.Add(button2);
            Controls.Add(Btn_Drink_Menu);
            Controls.Add(panel1);
            Controls.Add(Btn_Payment);
            Controls.Add(Lb_Total_Price);
            Controls.Add(label1);
            Controls.Add(Btn_Side_Menu);
            Controls.Add(Btn_Cancel_Selection);
            Controls.Add(Btn_Cancel_all);
            Controls.Add(Btn_Whopper);
            Controls.Add(Burger_Order_Listview);
            Name = "Main_form";
            StartPosition = FormStartPosition.CenterScreen;
            Text = "주문";
            Load += Main_form_Load;
            ResumeLayout(false);
        }

        #endregion
        private ColumnHeader columnHeader1;
        private ColumnHeader columnHeader2;
        private ColumnHeader columnHeader3;
        private Button Btn_Whopper;
        private Button Btn_Cancel_all;
        private Button Btn_Cancel_Selection;
        private Button Btn_Side_Menu;
        private Label label1;
        private Label Lb_Total_Price;
        private Button Btn_Payment;
        private Panel panel1;
        private Button Btn_Drink_Menu;
        public ListView Burger_Order_Listview;
        private Button button1;
        private Button button2;
    }
}