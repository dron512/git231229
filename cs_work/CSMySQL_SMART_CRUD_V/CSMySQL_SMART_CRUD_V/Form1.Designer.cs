namespace CSMySQL_SMART_CRUD_V
{
    partial class Form1
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
            this.panel1 = new System.Windows.Forms.Panel();
            this.searchButton = new System.Windows.Forms.Button();
            this.label1 = new System.Windows.Forms.Label();
            this.keywordTextBox = new System.Windows.Forms.TextBox();
            this.firstname = new System.Windows.Forms.Label();
            this.lastname = new System.Windows.Forms.Label();
            this.gender = new System.Windows.Forms.Label();
            this.firstNameTextBox = new System.Windows.Forms.TextBox();
            this.lastNameTextBox = new System.Windows.Forms.TextBox();
            this.genderComboBox = new System.Windows.Forms.ComboBox();
            this.insertButton = new System.Windows.Forms.Button();
            this.updateButton = new System.Windows.Forms.Button();
            this.deleteButton = new System.Windows.Forms.Button();
            this.dataGridView1 = new System.Windows.Forms.DataGridView();
            this.statusStrip1 = new System.Windows.Forms.StatusStrip();
            this.toolStripStatusLabel1 = new System.Windows.Forms.ToolStripStatusLabel();
            this.panel1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).BeginInit();
            this.statusStrip1.SuspendLayout();
            this.SuspendLayout();
            // 
            // panel1
            // 
            this.panel1.BackColor = System.Drawing.Color.DodgerBlue;
            this.panel1.Controls.Add(this.searchButton);
            this.panel1.Controls.Add(this.label1);
            this.panel1.Controls.Add(this.keywordTextBox);
            this.panel1.Dock = System.Windows.Forms.DockStyle.Top;
            this.panel1.Location = new System.Drawing.Point(0, 0);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(791, 100);
            this.panel1.TabIndex = 0;
            this.panel1.Paint += new System.Windows.Forms.PaintEventHandler(this.panel1_Paint);
            // 
            // searchButton
            // 
            this.searchButton.Location = new System.Drawing.Point(691, 27);
            this.searchButton.Name = "searchButton";
            this.searchButton.Size = new System.Drawing.Size(75, 23);
            this.searchButton.TabIndex = 2;
            this.searchButton.Text = "Search";
            this.searchButton.UseVisualStyleBackColor = true;
            this.searchButton.Click += new System.EventHandler(this.searchButton_Click);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("굴림", 15.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(129)));
            this.label1.ForeColor = System.Drawing.SystemColors.ControlLightLight;
            this.label1.Location = new System.Drawing.Point(30, 29);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(371, 21);
            this.label1.TabIndex = 0;
            this.label1.Text = "C# : MySQL/MariaDB : SMART CRUD";
            // 
            // keywordTextBox
            // 
            this.keywordTextBox.ImeMode = System.Windows.Forms.ImeMode.HangulFull;
            this.keywordTextBox.Location = new System.Drawing.Point(415, 29);
            this.keywordTextBox.Name = "keywordTextBox";
            this.keywordTextBox.Size = new System.Drawing.Size(239, 21);
            this.keywordTextBox.TabIndex = 1;
            // 
            // firstname
            // 
            this.firstname.AutoSize = true;
            this.firstname.Location = new System.Drawing.Point(22, 150);
            this.firstname.Name = "firstname";
            this.firstname.Size = new System.Drawing.Size(75, 12);
            this.firstname.TabIndex = 3;
            this.firstname.Text = "First Name :";
            // 
            // lastname
            // 
            this.lastname.AutoSize = true;
            this.lastname.Location = new System.Drawing.Point(22, 180);
            this.lastname.Name = "lastname";
            this.lastname.Size = new System.Drawing.Size(75, 12);
            this.lastname.TabIndex = 4;
            this.lastname.Text = "Last Name :";
            // 
            // gender
            // 
            this.gender.AutoSize = true;
            this.gender.Location = new System.Drawing.Point(22, 210);
            this.gender.Name = "gender";
            this.gender.Size = new System.Drawing.Size(54, 12);
            this.gender.TabIndex = 5;
            this.gender.Text = "Gender :";
            // 
            // firstNameTextBox
            // 
            this.firstNameTextBox.ImeMode = System.Windows.Forms.ImeMode.HangulFull;
            this.firstNameTextBox.Location = new System.Drawing.Point(103, 147);
            this.firstNameTextBox.Name = "firstNameTextBox";
            this.firstNameTextBox.Size = new System.Drawing.Size(201, 21);
            this.firstNameTextBox.TabIndex = 6;
            this.firstNameTextBox.TextChanged += new System.EventHandler(this.firstNameTextBox_TextChanged);
            // 
            // lastNameTextBox
            // 
            this.lastNameTextBox.ImeMode = System.Windows.Forms.ImeMode.HangulFull;
            this.lastNameTextBox.Location = new System.Drawing.Point(103, 177);
            this.lastNameTextBox.Name = "lastNameTextBox";
            this.lastNameTextBox.Size = new System.Drawing.Size(201, 21);
            this.lastNameTextBox.TabIndex = 7;
            // 
            // genderComboBox
            // 
            this.genderComboBox.FormattingEnabled = true;
            this.genderComboBox.ImeMode = System.Windows.Forms.ImeMode.Hangul;
            this.genderComboBox.Items.AddRange(new object[] {
            "Male",
            "Female"});
            this.genderComboBox.Location = new System.Drawing.Point(103, 207);
            this.genderComboBox.Name = "genderComboBox";
            this.genderComboBox.Size = new System.Drawing.Size(201, 20);
            this.genderComboBox.TabIndex = 9;
            this.genderComboBox.SelectedIndexChanged += new System.EventHandler(this.comboBox1_SelectedIndexChanged);
            // 
            // insertButton
            // 
            this.insertButton.Location = new System.Drawing.Point(326, 145);
            this.insertButton.Name = "insertButton";
            this.insertButton.Size = new System.Drawing.Size(121, 82);
            this.insertButton.TabIndex = 10;
            this.insertButton.Text = "INSERT";
            this.insertButton.UseVisualStyleBackColor = true;
            this.insertButton.Click += new System.EventHandler(this.insertButton_Click);
            // 
            // updateButton
            // 
            this.updateButton.Location = new System.Drawing.Point(460, 145);
            this.updateButton.Name = "updateButton";
            this.updateButton.Size = new System.Drawing.Size(121, 82);
            this.updateButton.TabIndex = 11;
            this.updateButton.Text = "UPDATE()";
            this.updateButton.UseVisualStyleBackColor = true;
            this.updateButton.Click += new System.EventHandler(this.updateButton_Click);
            // 
            // deleteButton
            // 
            this.deleteButton.Location = new System.Drawing.Point(603, 145);
            this.deleteButton.Name = "deleteButton";
            this.deleteButton.Size = new System.Drawing.Size(121, 82);
            this.deleteButton.TabIndex = 12;
            this.deleteButton.Text = "DELETE()";
            this.deleteButton.UseVisualStyleBackColor = true;
            this.deleteButton.Click += new System.EventHandler(this.deleteButton_Click);
            // 
            // dataGridView1
            // 
            this.dataGridView1.AllowUserToAddRows = false;
            this.dataGridView1.AllowUserToDeleteRows = false;
            this.dataGridView1.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridView1.ImeMode = System.Windows.Forms.ImeMode.Hangul;
            this.dataGridView1.Location = new System.Drawing.Point(24, 247);
            this.dataGridView1.Name = "dataGridView1";
            this.dataGridView1.ReadOnly = true;
            this.dataGridView1.RowTemplate.Height = 23;
            this.dataGridView1.Size = new System.Drawing.Size(700, 293);
            this.dataGridView1.TabIndex = 13;
            this.dataGridView1.CellClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.dataGridView1_CellClick);
            this.dataGridView1.CellContentClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.dataGridView1_CellContentClick);
            // 
            // statusStrip1
            // 
            this.statusStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.toolStripStatusLabel1});
            this.statusStrip1.Location = new System.Drawing.Point(0, 556);
            this.statusStrip1.Name = "statusStrip1";
            this.statusStrip1.Size = new System.Drawing.Size(791, 22);
            this.statusStrip1.TabIndex = 14;
            this.statusStrip1.Text = "statusStrip1";
            // 
            // toolStripStatusLabel1
            // 
            this.toolStripStatusLabel1.ForeColor = System.Drawing.Color.Crimson;
            this.toolStripStatusLabel1.Name = "toolStripStatusLabel1";
            this.toolStripStatusLabel1.Size = new System.Drawing.Size(110, 17);
            this.toolStripStatusLabel1.Text = "Number of row(s) :";
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(791, 578);
            this.Controls.Add(this.statusStrip1);
            this.Controls.Add(this.dataGridView1);
            this.Controls.Add(this.deleteButton);
            this.Controls.Add(this.updateButton);
            this.Controls.Add(this.insertButton);
            this.Controls.Add(this.genderComboBox);
            this.Controls.Add(this.lastNameTextBox);
            this.Controls.Add(this.firstNameTextBox);
            this.Controls.Add(this.gender);
            this.Controls.Add(this.lastname);
            this.Controls.Add(this.firstname);
            this.Controls.Add(this.panel1);
            this.Name = "Form1";
            this.Text = "Form1";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.panel1.ResumeLayout(false);
            this.panel1.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).EndInit();
            this.statusStrip1.ResumeLayout(false);
            this.statusStrip1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Panel panel1;
        private System.Windows.Forms.Button searchButton;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox keywordTextBox;
        private System.Windows.Forms.Label firstname;
        private System.Windows.Forms.Label lastname;
        private System.Windows.Forms.Label gender;
        private System.Windows.Forms.TextBox firstNameTextBox;
        private System.Windows.Forms.TextBox lastNameTextBox;
        private System.Windows.Forms.ComboBox genderComboBox;
        private System.Windows.Forms.Button insertButton;
        private System.Windows.Forms.Button updateButton;
        private System.Windows.Forms.Button deleteButton;
        private System.Windows.Forms.DataGridView dataGridView1;
        private System.Windows.Forms.StatusStrip statusStrip1;
        private System.Windows.Forms.ToolStripStatusLabel toolStripStatusLabel1;
    }
}

