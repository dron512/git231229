namespace project_nanibono.word
{
    partial class WordSearch
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
            comboBox1 = new ComboBox();
            textBox1 = new TextBox();
            button1 = new Button();
            label1 = new Label();
            label2 = new Label();
            button2 = new Button();
            pictureBox1 = new PictureBox();
            pictureBox2 = new PictureBox();
            ((System.ComponentModel.ISupportInitialize)pictureBox1).BeginInit();
            ((System.ComponentModel.ISupportInitialize)pictureBox2).BeginInit();
            SuspendLayout();
            // 
            // comboBox1
            // 
            comboBox1.FormattingEnabled = true;
            comboBox1.Location = new Point(124, 184);
            comboBox1.Name = "comboBox1";
            comboBox1.Size = new Size(121, 23);
            comboBox1.TabIndex = 0;
            // 
            // textBox1
            // 
            textBox1.Location = new Point(251, 183);
            textBox1.Name = "textBox1";
            textBox1.Size = new Size(289, 23);
            textBox1.TabIndex = 1;
            // 
            // button1
            // 
            button1.BackColor = Color.FromArgb(224, 244, 255);
            button1.FlatAppearance.BorderSize = 0;
            button1.FlatStyle = FlatStyle.Flat;
            button1.Font = new Font("맑은 고딕", 9F, FontStyle.Bold);
            button1.ForeColor = Color.FromArgb(135, 196, 255);
            button1.Location = new Point(546, 184);
            button1.Name = "button1";
            button1.Size = new Size(103, 23);
            button1.TabIndex = 2;
            button1.Text = "Search";
            button1.UseVisualStyleBackColor = false;
            button1.Click += searchButton_Click;
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.BackColor = SystemColors.ControlLightLight;
            label1.Font = new Font("휴먼둥근헤드라인", 21.75F);
            label1.ForeColor = Color.FromArgb(135, 196, 255);
            label1.Location = new Point(317, 71);
            label1.Name = "label1";
            label1.Size = new Size(158, 30);
            label1.TabIndex = 3;
            label1.Text = "먼시험보노";
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.BackColor = SystemColors.ControlLightLight;
            label2.Font = new Font("휴먼둥근헤드라인", 21.75F);
            label2.ForeColor = Color.FromArgb(135, 196, 255);
            label2.Location = new Point(314, 101);
            label2.Name = "label2";
            label2.Size = new Size(161, 30);
            label2.TabIndex = 4;
            label2.Text = "사      전";
            // 
            // button2
            // 
            button2.BackColor = Color.FromArgb(135, 196, 255);
            button2.FlatAppearance.BorderSize = 0;
            button2.FlatStyle = FlatStyle.Flat;
            button2.Font = new Font("맑은 고딕", 9F, FontStyle.Bold);
            button2.ForeColor = Color.White;
            button2.Location = new Point(335, 245);
            button2.Name = "button2";
            button2.Size = new Size(127, 40);
            button2.TabIndex = 5;
            button2.Text = "LOGIN";
            button2.UseVisualStyleBackColor = false;
            // 
            // pictureBox1
            // 
            pictureBox1.Image = Properties.Resources.bnonono_preview_smll;
            pictureBox1.Location = new Point(247, 62);
            pictureBox1.Name = "pictureBox1";
            pictureBox1.Size = new Size(64, 69);
            pictureBox1.SizeMode = PictureBoxSizeMode.CenterImage;
            pictureBox1.TabIndex = 6;
            pictureBox1.TabStop = false;
            // 
            // pictureBox2
            // 
            pictureBox2.Image = Properties.Resources.bnonono_preview_smll;
            pictureBox2.Location = new Point(481, 62);
            pictureBox2.Name = "pictureBox2";
            pictureBox2.Size = new Size(64, 69);
            pictureBox2.SizeMode = PictureBoxSizeMode.CenterImage;
            pictureBox2.TabIndex = 7;
            pictureBox2.TabStop = false;
            // 
            // WordSearch
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            BackColor = SystemColors.ControlLightLight;
            Controls.Add(pictureBox2);
            Controls.Add(pictureBox1);
            Controls.Add(button2);
            Controls.Add(label2);
            Controls.Add(label1);
            Controls.Add(button1);
            Controls.Add(textBox1);
            Controls.Add(comboBox1);
            ForeColor = SystemColors.ControlText;
            Name = "WordSearch";
            Size = new Size(800, 396);
            ((System.ComponentModel.ISupportInitialize)pictureBox1).EndInit();
            ((System.ComponentModel.ISupportInitialize)pictureBox2).EndInit();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private ComboBox comboBox1;
        private TextBox textBox1;
        private Button button1;
        private Label label1;
        private Label label2;
        private Button button2;
        private PictureBox pictureBox1;
        private PictureBox pictureBox2;
    }
}
