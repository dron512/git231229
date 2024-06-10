namespace WindowsFormsApp3
{
    partial class sale_payment
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
            listView1 = new ListView();
            columnHeader2 = new ColumnHeader();
            columnHeader3 = new ColumnHeader();
            columnHeader4 = new ColumnHeader();
            columnHeader5 = new ColumnHeader();
            Today_payment = new Button();
            label1 = new Label();
            monthCalendar1 = new MonthCalendar();
            button2 = new Button();
            label2 = new Label();
            label3 = new Label();
            textBox2 = new TextBox();
            textBox1 = new TextBox();
            backgroundWorker1 = new System.ComponentModel.BackgroundWorker();
            button1 = new Button();
            helpProvider1 = new HelpProvider();
            label4 = new Label();
            SuspendLayout();
            // 
            // listView1
            // 
            listView1.Columns.AddRange(new ColumnHeader[] { columnHeader2, columnHeader3, columnHeader4, columnHeader5 });
            listView1.Font = new Font("맑은 고딕", 12F, FontStyle.Regular, GraphicsUnit.Point, 129);
            listView1.GridLines = true;
            listView1.Location = new Point(40, 34);
            listView1.Margin = new Padding(3, 4, 3, 4);
            listView1.Name = "listView1";
            listView1.Size = new Size(726, 375);
            listView1.TabIndex = 0;
            listView1.UseCompatibleStateImageBehavior = false;
            listView1.View = View.Details;
            // 
            // columnHeader2
            // 
            columnHeader2.Text = "주문번호";
            columnHeader2.Width = 100;
            // 
            // columnHeader3
            // 
            columnHeader3.Text = "결제방법";
            columnHeader3.Width = 100;
            // 
            // columnHeader4
            // 
            columnHeader4.Text = "결제금액";
            columnHeader4.Width = 100;
            // 
            // columnHeader5
            // 
            columnHeader5.Text = "결제시간";
            columnHeader5.Width = 200;
            // 
            // Today_payment
            // 
            Today_payment.BackColor = SystemColors.Highlight;
            Today_payment.Font = new Font("맑은 고딕", 15F);
            Today_payment.ForeColor = Color.Black;
            Today_payment.Location = new Point(808, 336);
            Today_payment.Margin = new Padding(3, 4, 3, 4);
            Today_payment.Name = "Today_payment";
            Today_payment.Size = new Size(220, 106);
            Today_payment.TabIndex = 1;
            Today_payment.Text = "오늘매출";
            Today_payment.UseVisualStyleBackColor = false;
            Today_payment.Click += Today_Payment_Click;
            // 
            // label1
            // 
            label1.BackColor = Color.LightGray;
            label1.BorderStyle = BorderStyle.FixedSingle;
            label1.Font = new Font("맑은 고딕", 14F, FontStyle.Bold);
            label1.Location = new Point(40, 408);
            label1.Name = "label1";
            label1.Size = new Size(94, 34);
            label1.TabIndex = 4;
            label1.Text = "총 합계";
            label1.TextAlign = ContentAlignment.MiddleCenter;
            // 
            // monthCalendar1
            // 
            monthCalendar1.Location = new Point(808, 156);
            monthCalendar1.Margin = new Padding(9, 11, 9, 11);
            monthCalendar1.Name = "monthCalendar1";
            monthCalendar1.TabIndex = 10;
            monthCalendar1.DateSelected += monthCalendar1_DateSelected;
            // 
            // button2
            // 
            button2.BackColor = Color.DarkBlue;
            button2.Font = new Font("맑은 고딕", 12F);
            button2.ForeColor = Color.White;
            button2.Location = new Point(179, 464);
            button2.Margin = new Padding(3, 4, 3, 4);
            button2.Name = "button2";
            button2.Size = new Size(131, 68);
            button2.TabIndex = 13;
            button2.Text = "재고관리";
            button2.UseVisualStyleBackColor = false;
            button2.Click += 재고관리;
            // 
            // label2
            // 
            label2.BackColor = Color.LightGray;
            label2.BorderStyle = BorderStyle.FixedSingle;
            label2.Font = new Font("맑은 고딕", 12F, FontStyle.Regular, GraphicsUnit.Point, 129);
            label2.Location = new Point(808, 34);
            label2.Name = "label2";
            label2.Size = new Size(220, 30);
            label2.TabIndex = 11;
            label2.Text = "현금합계";
            label2.TextAlign = ContentAlignment.MiddleCenter;
            // 
            // label3
            // 
            label3.BackColor = Color.LightGray;
            label3.BorderStyle = BorderStyle.FixedSingle;
            label3.Font = new Font("맑은 고딕", 12F, FontStyle.Regular, GraphicsUnit.Point, 129);
            label3.Location = new Point(808, 90);
            label3.Name = "label3";
            label3.Size = new Size(220, 30);
            label3.TabIndex = 12;
            label3.Text = "카드합계";
            label3.TextAlign = ContentAlignment.MiddleCenter;
            // 
            // textBox2
            // 
            textBox2.Font = new Font("맑은 고딕", 12F, FontStyle.Bold, GraphicsUnit.Point, 129);
            textBox2.Location = new Point(808, 119);
            textBox2.Margin = new Padding(3, 4, 3, 4);
            textBox2.Name = "textBox2";
            textBox2.Size = new Size(220, 29);
            textBox2.TabIndex = 8;
            textBox2.TextAlign = HorizontalAlignment.Center;
            // 
            // textBox1
            // 
            textBox1.Font = new Font("맑은 고딕", 12F, FontStyle.Bold);
            textBox1.Location = new Point(808, 63);
            textBox1.Margin = new Padding(3, 4, 3, 4);
            textBox1.Name = "textBox1";
            textBox1.Size = new Size(220, 29);
            textBox1.TabIndex = 7;
            textBox1.TextAlign = HorizontalAlignment.Center;
            // 
            // button1
            // 
            button1.BackColor = Color.DarkBlue;
            button1.Font = new Font("맑은 고딕", 12F);
            button1.ForeColor = Color.White;
            button1.Location = new Point(40, 464);
            button1.Name = "button1";
            button1.Size = new Size(131, 68);
            button1.TabIndex = 16;
            button1.Text = "주문";
            button1.UseVisualStyleBackColor = false;
            button1.Click += button1_Click;
            // 
            // label4
            // 
            label4.BackColor = Color.White;
            label4.BorderStyle = BorderStyle.FixedSingle;
            label4.Font = new Font("맑은 고딕", 14F, FontStyle.Bold);
            label4.Location = new Point(133, 408);
            label4.Name = "label4";
            label4.Size = new Size(633, 34);
            label4.TabIndex = 17;
            label4.TextAlign = ContentAlignment.MiddleLeft;
            // 
            // sale_payment
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            BackColor = Color.Azure;
            ClientSize = new Size(1067, 568);
            Controls.Add(label4);
            Controls.Add(monthCalendar1);
            Controls.Add(button1);
            Controls.Add(textBox2);
            Controls.Add(button2);
            Controls.Add(textBox1);
            Controls.Add(label2);
            Controls.Add(label3);
            Controls.Add(label1);
            Controls.Add(Today_payment);
            Controls.Add(listView1);
            Margin = new Padding(3, 4, 3, 4);
            Name = "sale_payment";
            StartPosition = FormStartPosition.CenterScreen;
            Text = "매출관리";
            Load += sale_payment_Load;
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private System.Windows.Forms.ListView listView1;
        private System.Windows.Forms.Button Today_payment;
        private System.Windows.Forms.ColumnHeader columnHeader2;
        private System.Windows.Forms.ColumnHeader columnHeader3;
        private System.Windows.Forms.ColumnHeader columnHeader4;
        private System.Windows.Forms.ColumnHeader columnHeader5;
        
        private System.Windows.Forms.Label label1;
        
        private System.Windows.Forms.MonthCalendar monthCalendar1;
        private System.Windows.Forms.Button button2;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.TextBox textBox2;
        private System.Windows.Forms.TextBox textBox1;
        private System.ComponentModel.BackgroundWorker backgroundWorker1;
        private System.Windows.Forms.HelpProvider helpProvider1;
        private Button button1;
        private Label label4;
    }
}

