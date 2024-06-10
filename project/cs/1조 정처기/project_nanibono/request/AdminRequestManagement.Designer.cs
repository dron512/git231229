namespace project_nanibono.request
{
    partial class AdminRequestManagement
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
            button_requestSearch = new Button();
            comboBox_requestRyn = new ComboBox();
            comboBox_processDivision = new ComboBox();
            label3 = new Label();
            label2 = new Label();
            dataGridView2 = new DataGridView();
            dataGridView1 = new DataGridView();
            label1 = new Label();
            label4 = new Label();
            label5 = new Label();
            ((System.ComponentModel.ISupportInitialize)dataGridView2).BeginInit();
            ((System.ComponentModel.ISupportInitialize)dataGridView1).BeginInit();
            SuspendLayout();
            // 
            // button_requestSearch
            // 
            button_requestSearch.BackColor = Color.FromArgb(135, 196, 255);
            button_requestSearch.FlatAppearance.BorderSize = 0;
            button_requestSearch.FlatStyle = FlatStyle.Flat;
            button_requestSearch.Font = new Font("맑은 고딕", 9F, FontStyle.Bold, GraphicsUnit.Point, 129);
            button_requestSearch.ForeColor = Color.White;
            button_requestSearch.Location = new Point(579, 16);
            button_requestSearch.Name = "button_requestSearch";
            button_requestSearch.Size = new Size(75, 23);
            button_requestSearch.TabIndex = 17;
            button_requestSearch.Text = "Search";
            button_requestSearch.UseVisualStyleBackColor = false;
            // 
            // comboBox_requestRyn
            // 
            comboBox_requestRyn.FormattingEnabled = true;
            comboBox_requestRyn.Location = new Point(452, 16);
            comboBox_requestRyn.Name = "comboBox_requestRyn";
            comboBox_requestRyn.Size = new Size(121, 23);
            comboBox_requestRyn.TabIndex = 16;
            // 
            // comboBox_processDivision
            // 
            comboBox_processDivision.FormattingEnabled = true;
            comboBox_processDivision.Location = new Point(325, 16);
            comboBox_processDivision.Name = "comboBox_processDivision";
            comboBox_processDivision.Size = new Size(121, 23);
            comboBox_processDivision.TabIndex = 15;
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.FlatStyle = FlatStyle.Flat;
            label3.Font = new Font("맑은 고딕", 9F, FontStyle.Bold);
            label3.Location = new Point(18, 253);
            label3.Name = "label3";
            label3.Size = new Size(67, 15);
            label3.TabIndex = 14;
            label3.Text = "삭제요청건";
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.FlatStyle = FlatStyle.Flat;
            label2.Font = new Font("맑은 고딕", 9F, FontStyle.Bold);
            label2.Location = new Point(17, 53);
            label2.Name = "label2";
            label2.Size = new Size(67, 15);
            label2.TabIndex = 13;
            label2.Text = "수정요청건";
            // 
            // dataGridView2
            // 
            dataGridView2.AllowUserToAddRows = false;
            dataGridView2.AllowUserToDeleteRows = false;
            dataGridView2.AutoSizeColumnsMode = DataGridViewAutoSizeColumnsMode.AllCells;
            dataGridView2.BackgroundColor = Color.White;
            dataGridView2.BorderStyle = BorderStyle.Fixed3D;
            dataGridView2.ColumnHeadersHeightSizeMode = DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            dataGridView2.GridColor = Color.White;
            dataGridView2.Location = new Point(3, 269);
            dataGridView2.Name = "dataGridView2";
            dataGridView2.ReadOnly = true;
            dataGridView2.Size = new Size(649, 169);
            dataGridView2.TabIndex = 12;
            // 
            // dataGridView1
            // 
            dataGridView1.AllowUserToAddRows = false;
            dataGridView1.AllowUserToDeleteRows = false;
            dataGridView1.AutoSizeColumnsMode = DataGridViewAutoSizeColumnsMode.AllCells;
            dataGridView1.BackgroundColor = Color.White;
            dataGridView1.BorderStyle = BorderStyle.Fixed3D;
            dataGridView1.ColumnHeadersHeightSizeMode = DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            dataGridView1.GridColor = Color.White;
            dataGridView1.Location = new Point(3, 71);
            dataGridView1.Name = "dataGridView1";
            dataGridView1.ReadOnly = true;
            dataGridView1.Size = new Size(649, 169);
            dataGridView1.TabIndex = 11;
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Font = new Font("휴먼둥근헤드라인", 20.25F, FontStyle.Regular, GraphicsUnit.Point, 129);
            label1.ForeColor = Color.FromArgb(57, 167, 255);
            label1.Location = new Point(-1, 8);
            label1.Name = "label1";
            label1.Size = new Size(120, 28);
            label1.TabIndex = 10;
            label1.Text = "요청관리";
            // 
            // label4
            // 
            label4.AutoSize = true;
            label4.ForeColor = Color.FromArgb(57, 167, 255);
            label4.Location = new Point(1, 53);
            label4.Name = "label4";
            label4.Size = new Size(19, 15);
            label4.TabIndex = 18;
            label4.Text = "☁︎";
            // 
            // label5
            // 
            label5.AutoSize = true;
            label5.ForeColor = Color.FromArgb(57, 167, 255);
            label5.Location = new Point(2, 253);
            label5.Name = "label5";
            label5.Size = new Size(19, 15);
            label5.TabIndex = 18;
            label5.Text = "☁︎";
            // 
            // AdminRequestManagement
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            BackColor = SystemColors.ControlLightLight;
            Controls.Add(label5);
            Controls.Add(label4);
            Controls.Add(button_requestSearch);
            Controls.Add(comboBox_requestRyn);
            Controls.Add(comboBox_processDivision);
            Controls.Add(label3);
            Controls.Add(label2);
            Controls.Add(dataGridView2);
            Controls.Add(dataGridView1);
            Controls.Add(label1);
            Name = "AdminRequestManagement";
            Size = new Size(655, 450);
            ((System.ComponentModel.ISupportInitialize)dataGridView2).EndInit();
            ((System.ComponentModel.ISupportInitialize)dataGridView1).EndInit();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Button button_requestSearch;
        private ComboBox comboBox_requestRyn;
        private ComboBox comboBox_processDivision;
        private Label label3;
        private Label label2;
        private DataGridView dataGridView2;
        private DataGridView dataGridView1;
        private Label label1;
        private Label label4;
        private Label label5;
    }
}
