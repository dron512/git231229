namespace project_nanibono.request
{
    partial class AdminMemberManagement
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

        #region 구성 요소 디자이너에서 생성한 코드

        /// <summary> 
        /// 디자이너 지원에 필요한 메서드입니다. 
        /// 이 메서드의 내용을 코드 편집기로 수정하지 마세요.
        /// </summary>
        private void InitializeComponent()
        {
            comboBox_search = new ComboBox();
            textBox_search = new TextBox();
            dataGridView1 = new DataGridView();
            label1 = new Label();
            button_requestSearch = new Button();
            ((System.ComponentModel.ISupportInitialize)dataGridView1).BeginInit();
            SuspendLayout();
            // 
            // comboBox_search
            // 
            comboBox_search.FormattingEnabled = true;
            comboBox_search.Location = new Point(3, 50);
            comboBox_search.Name = "comboBox_search";
            comboBox_search.Size = new Size(149, 23);
            comboBox_search.TabIndex = 9;
            // 
            // textBox_search
            // 
            textBox_search.Location = new Point(158, 50);
            textBox_search.Name = "textBox_search";
            textBox_search.Size = new Size(413, 23);
            textBox_search.TabIndex = 8;
            // 
            // dataGridView1
            // 
            dataGridView1.AllowUserToAddRows = false;
            dataGridView1.AllowUserToDeleteRows = false;
            dataGridView1.BackgroundColor = SystemColors.ControlLightLight;
            dataGridView1.BorderStyle = BorderStyle.Fixed3D;
            dataGridView1.ColumnHeadersHeightSizeMode = DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            dataGridView1.GridColor = SystemColors.ActiveBorder;
            dataGridView1.Location = new Point(3, 79);
            dataGridView1.Name = "dataGridView1";
            dataGridView1.ReadOnly = true;
            dataGridView1.RightToLeft = RightToLeft.No;
            dataGridView1.Size = new Size(649, 359);
            dataGridView1.TabIndex = 6;
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Font = new Font("휴먼둥근헤드라인", 20.25F, FontStyle.Regular, GraphicsUnit.Point, 129);
            label1.ForeColor = Color.FromArgb(57, 167, 255);
            label1.Location = new Point(-1, 8);
            label1.Name = "label1";
            label1.Size = new Size(120, 28);
            label1.TabIndex = 5;
            label1.Text = "회원관리";
            // 
            // button_requestSearch
            // 
            button_requestSearch.BackColor = Color.FromArgb(135, 196, 255);
            button_requestSearch.FlatAppearance.BorderSize = 0;
            button_requestSearch.FlatStyle = FlatStyle.Flat;
            button_requestSearch.Font = new Font("맑은 고딕", 9F, FontStyle.Bold, GraphicsUnit.Point, 129);
            button_requestSearch.ForeColor = Color.White;
            button_requestSearch.Location = new Point(577, 50);
            button_requestSearch.Name = "button_requestSearch";
            button_requestSearch.Size = new Size(75, 23);
            button_requestSearch.TabIndex = 18;
            button_requestSearch.Text = "Search";
            button_requestSearch.UseVisualStyleBackColor = false;
            // 
            // AdminMemberManagement
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            BackColor = SystemColors.ButtonHighlight;
            Controls.Add(button_requestSearch);
            Controls.Add(comboBox_search);
            Controls.Add(textBox_search);
            Controls.Add(dataGridView1);
            Controls.Add(label1);
            Name = "AdminMemberManagement";
            Size = new Size(655, 450);
            ((System.ComponentModel.ISupportInitialize)dataGridView1).EndInit();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private ComboBox comboBox_search;
        private TextBox textBox_search;
        private DataGridView dataGridView1;
        private Label label1;
        private Button button_requestSearch;
    }
}
