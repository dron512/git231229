namespace jjc
{
    partial class Inventory
    {
        /// <summary>
        /// 필수 디자이너 변수입니다.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// 사용 중인 모든 리소스를 정리합니다.
        /// </summary>
        /// <param name="disposing">관리되는 리소스를 삭제해야 하면 true이고, 그렇지 않으면 false입니다.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form 디자이너에서 생성한 코드

        /// <summary>
        /// 디자이너 지원에 필요한 메서드입니다. 
        /// 이 메서드의 내용을 코드 편집기로 수정하지 마세요.
        /// </summary>
        private void InitializeComponent()
        {
            DataGridViewCellStyle dataGridViewCellStyle1 = new DataGridViewCellStyle();
            DataGridViewCellStyle dataGridViewCellStyle2 = new DataGridViewCellStyle();
            label1 = new Label();
            button1 = new Button();
            button2 = new Button();
            stock_label = new Label();
            inventory_dataGridView = new DataGridView();
            update_button = new Button();
            addstock_textBox = new TextBox();
            addstock_label = new Label();
            burgerButton = new Button();
            sideButton = new Button();
            drinkButton = new Button();
            stockchange_button = new Button();
            selectButton = new Button();
            currentstock_label = new Label();
            ((System.ComponentModel.ISupportInitialize)inventory_dataGridView).BeginInit();
            SuspendLayout();
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Font = new Font("굴림", 20.25F, FontStyle.Bold, GraphicsUnit.Point, 129);
            label1.Location = new Point(854, 88);
            label1.Margin = new Padding(2, 0, 2, 0);
            label1.Name = "label1";
            label1.Size = new Size(124, 27);
            label1.TabIndex = 3;
            label1.Text = "재고관리";
            // 
            // button1
            // 
            button1.BackColor = Color.DarkBlue;
            button1.Font = new Font("맑은 고딕", 12F);
            button1.ForeColor = Color.White;
            button1.Location = new Point(40, 464);
            button1.Margin = new Padding(2);
            button1.Name = "button1";
            button1.Size = new Size(131, 68);
            button1.TabIndex = 4;
            button1.Text = "주문";
            button1.UseVisualStyleBackColor = false;
            button1.Click += 주문;
            // 
            // button2
            // 
            button2.BackColor = Color.DarkBlue;
            button2.Font = new Font("맑은 고딕", 12F);
            button2.ForeColor = Color.White;
            button2.Location = new Point(179, 464);
            button2.Margin = new Padding(2);
            button2.Name = "button2";
            button2.Size = new Size(131, 68);
            button2.TabIndex = 5;
            button2.Text = "매출관리";
            button2.UseVisualStyleBackColor = false;
            button2.Click += 매출관리;
            // 
            // stock_label
            // 
            stock_label.BackColor = Color.LightGray;
            stock_label.BorderStyle = BorderStyle.FixedSingle;
            stock_label.Font = new Font("맑은 고딕", 12F);
            stock_label.Location = new Point(804, 134);
            stock_label.Name = "stock_label";
            stock_label.Size = new Size(220, 30);
            stock_label.TabIndex = 6;
            stock_label.Text = "현재수량";
            stock_label.TextAlign = ContentAlignment.MiddleCenter;
            // 
            // inventory_dataGridView
            // 
            dataGridViewCellStyle1.Alignment = DataGridViewContentAlignment.MiddleLeft;
            dataGridViewCellStyle1.BackColor = SystemColors.Control;
            dataGridViewCellStyle1.Font = new Font("맑은 고딕", 12F);
            dataGridViewCellStyle1.ForeColor = SystemColors.WindowText;
            dataGridViewCellStyle1.SelectionBackColor = SystemColors.Highlight;
            dataGridViewCellStyle1.SelectionForeColor = SystemColors.HighlightText;
            dataGridViewCellStyle1.WrapMode = DataGridViewTriState.True;
            inventory_dataGridView.ColumnHeadersDefaultCellStyle = dataGridViewCellStyle1;
            inventory_dataGridView.ColumnHeadersHeightSizeMode = DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            dataGridViewCellStyle2.Alignment = DataGridViewContentAlignment.MiddleLeft;
            dataGridViewCellStyle2.BackColor = SystemColors.Window;
            dataGridViewCellStyle2.Font = new Font("맑은 고딕", 12F);
            dataGridViewCellStyle2.ForeColor = SystemColors.ControlText;
            dataGridViewCellStyle2.SelectionBackColor = SystemColors.Highlight;
            dataGridViewCellStyle2.SelectionForeColor = SystemColors.HighlightText;
            dataGridViewCellStyle2.WrapMode = DataGridViewTriState.False;
            inventory_dataGridView.DefaultCellStyle = dataGridViewCellStyle2;
            inventory_dataGridView.Location = new Point(40, 88);
            inventory_dataGridView.Margin = new Padding(3, 4, 3, 4);
            inventory_dataGridView.Name = "inventory_dataGridView";
            inventory_dataGridView.RowTemplate.Height = 23;
            inventory_dataGridView.Size = new Size(726, 355);
            inventory_dataGridView.TabIndex = 8;
            inventory_dataGridView.CellClick += inventory_dataGridView_CellClick;
            inventory_dataGridView.CellContentClick += inventory_dataGridView_CellContentClick;
            // 
            // update_button
            // 
            update_button.BackColor = Color.Silver;
            update_button.FlatStyle = FlatStyle.Popup;
            update_button.Font = new Font("맑은 고딕", 12F);
            update_button.ForeColor = Color.Black;
            update_button.Location = new Point(960, 240);
            update_button.Margin = new Padding(3, 4, 3, 4);
            update_button.Name = "update_button";
            update_button.Size = new Size(64, 32);
            update_button.TabIndex = 9;
            update_button.Text = "입력";
            update_button.UseVisualStyleBackColor = false;
            update_button.Click += updateButton_Click;
            // 
            // addstock_textBox
            // 
            addstock_textBox.Font = new Font("맑은 고딕", 14F, FontStyle.Bold);
            addstock_textBox.Location = new Point(804, 240);
            addstock_textBox.Margin = new Padding(3, 4, 3, 4);
            addstock_textBox.Name = "addstock_textBox";
            addstock_textBox.Size = new Size(158, 32);
            addstock_textBox.TabIndex = 11;
            addstock_textBox.TextAlign = HorizontalAlignment.Center;
            // 
            // addstock_label
            // 
            addstock_label.BackColor = Color.LightGray;
            addstock_label.BorderStyle = BorderStyle.FixedSingle;
            addstock_label.Font = new Font("맑은 고딕", 12F);
            addstock_label.Location = new Point(804, 211);
            addstock_label.Name = "addstock_label";
            addstock_label.Size = new Size(220, 30);
            addstock_label.TabIndex = 10;
            addstock_label.Text = "수량변경";
            addstock_label.TextAlign = ContentAlignment.MiddleCenter;
            // 
            // burgerButton
            // 
            burgerButton.BackColor = SystemColors.Highlight;
            burgerButton.Font = new Font("맑은 고딕", 12F);
            burgerButton.Location = new Point(169, 34);
            burgerButton.Name = "burgerButton";
            burgerButton.Size = new Size(123, 46);
            burgerButton.TabIndex = 17;
            burgerButton.Text = "버거";
            burgerButton.UseVisualStyleBackColor = false;
            burgerButton.Click += burgerButton_Click;
            // 
            // sideButton
            // 
            sideButton.BackColor = SystemColors.Highlight;
            sideButton.Font = new Font("맑은 고딕", 12F);
            sideButton.Location = new Point(294, 34);
            sideButton.Name = "sideButton";
            sideButton.Size = new Size(123, 46);
            sideButton.TabIndex = 17;
            sideButton.Text = "사이드";
            sideButton.UseVisualStyleBackColor = false;
            sideButton.Click += sideButton_Click;
            // 
            // drinkButton
            // 
            drinkButton.BackColor = SystemColors.Highlight;
            drinkButton.Font = new Font("맑은 고딕", 12F);
            drinkButton.Location = new Point(421, 34);
            drinkButton.Name = "drinkButton";
            drinkButton.Size = new Size(123, 46);
            drinkButton.TabIndex = 17;
            drinkButton.Text = "음료";
            drinkButton.UseVisualStyleBackColor = false;
            drinkButton.Click += drinkButton_Click;
            // 
            // stockchange_button
            // 
            stockchange_button.BackColor = SystemColors.Highlight;
            stockchange_button.Font = new Font("맑은 고딕", 12F);
            stockchange_button.ForeColor = Color.Black;
            stockchange_button.Location = new Point(804, 383);
            stockchange_button.Name = "stockchange_button";
            stockchange_button.Size = new Size(220, 60);
            stockchange_button.TabIndex = 18;
            stockchange_button.Text = "재고 변동 확인";
            stockchange_button.UseVisualStyleBackColor = false;
            stockchange_button.Click += stockchange_button_Click;
            // 
            // selectButton
            // 
            selectButton.BackColor = SystemColors.Highlight;
            selectButton.Font = new Font("맑은 고딕", 12F);
            selectButton.Location = new Point(40, 34);
            selectButton.Name = "selectButton";
            selectButton.RightToLeft = RightToLeft.No;
            selectButton.Size = new Size(123, 46);
            selectButton.TabIndex = 19;
            selectButton.Text = "전체";
            selectButton.UseVisualStyleBackColor = false;
            selectButton.Click += selectButton_Click;
            // 
            // currentstock_label
            // 
            currentstock_label.BackColor = Color.White;
            currentstock_label.BorderStyle = BorderStyle.FixedSingle;
            currentstock_label.Font = new Font("맑은 고딕", 14F, FontStyle.Bold);
            currentstock_label.Location = new Point(804, 163);
            currentstock_label.Name = "currentstock_label";
            currentstock_label.Size = new Size(220, 29);
            currentstock_label.TabIndex = 12;
            currentstock_label.Text = " ";
            currentstock_label.TextAlign = ContentAlignment.MiddleCenter;
            // 
            // Inventory
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            BackColor = Color.Azure;
            ClientSize = new Size(1067, 568);
            Controls.Add(button2);
            Controls.Add(button1);
            Controls.Add(selectButton);
            Controls.Add(stockchange_button);
            Controls.Add(drinkButton);
            Controls.Add(sideButton);
            Controls.Add(burgerButton);
            Controls.Add(currentstock_label);
            Controls.Add(addstock_textBox);
            Controls.Add(addstock_label);
            Controls.Add(update_button);
            Controls.Add(inventory_dataGridView);
            Controls.Add(stock_label);
            Controls.Add(label1);
            Margin = new Padding(2);
            Name = "Inventory";
            StartPosition = FormStartPosition.CenterScreen;
            Text = "재고관리";
            Load += Form1_Load;
            ((System.ComponentModel.ISupportInitialize)inventory_dataGridView).EndInit();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.Button button2;
        private System.Windows.Forms.Label stock_label;
        private System.Windows.Forms.DataGridView inventory_dataGridView;
        private System.Windows.Forms.Button update_button;
        private System.Windows.Forms.TextBox addstock_textBox;
        private System.Windows.Forms.Label addstock_label;
        private Button burgerButton;
        private Button sideButton;
        private Button drinkButton;
        private Button stockchange_button;
        private Button selectButton;
        private Label currentstock_label;
    }
}

