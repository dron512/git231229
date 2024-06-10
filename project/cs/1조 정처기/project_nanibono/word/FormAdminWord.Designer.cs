namespace project_nanibono.word
{
    partial class FormAdminWord
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
            label4 = new Label();
            closeBtn = new Button();
            successBtn = new Button();
            textBox_groupNo = new TextBox();
            label_groupNo = new Label();
            textBox_category = new TextBox();
            label_category = new Label();
            textBox_wordMean = new TextBox();
            label__wordMean = new Label();
            textBox_word = new TextBox();
            label_word = new Label();
            label8 = new Label();
            panel1 = new Panel();
            panel2 = new Panel();
            SuspendLayout();
            // 
            // label4
            // 
            label4.AutoSize = true;
            label4.Font = new Font("휴먼둥근헤드라인", 27.75F, FontStyle.Regular, GraphicsUnit.Point, 129);
            label4.Location = new Point(306, 9);
            label4.Name = "label4";
            label4.Size = new Size(184, 39);
            label4.TabIndex = 143;
            label4.Text = "단어 등록";
            // 
            // closeBtn
            // 
            closeBtn.BackColor = Color.FromArgb(135, 196, 255);
            closeBtn.FlatAppearance.BorderSize = 0;
            closeBtn.FlatStyle = FlatStyle.Flat;
            closeBtn.Font = new Font("맑은 고딕", 11.25F, FontStyle.Bold);
            closeBtn.ForeColor = Color.White;
            closeBtn.Location = new Point(404, 400);
            closeBtn.Name = "closeBtn";
            closeBtn.Size = new Size(212, 38);
            closeBtn.TabIndex = 151;
            closeBtn.Text = "닫기";
            closeBtn.UseVisualStyleBackColor = false;
            // 
            // successBtn
            // 
            successBtn.BackColor = Color.FromArgb(135, 196, 255);
            successBtn.FlatAppearance.BorderSize = 0;
            successBtn.FlatStyle = FlatStyle.Flat;
            successBtn.Font = new Font("맑은 고딕", 11.25F, FontStyle.Bold);
            successBtn.ForeColor = Color.White;
            successBtn.Location = new Point(186, 400);
            successBtn.Name = "successBtn";
            successBtn.Size = new Size(212, 38);
            successBtn.TabIndex = 150;
            successBtn.Text = "처리완료";
            successBtn.UseVisualStyleBackColor = false;
            // 
            // textBox_groupNo
            // 
            textBox_groupNo.Location = new Point(249, 91);
            textBox_groupNo.Name = "textBox_groupNo";
            textBox_groupNo.Size = new Size(339, 23);
            textBox_groupNo.TabIndex = 161;
            // 
            // label_groupNo
            // 
            label_groupNo.AutoSize = true;
            label_groupNo.Font = new Font("맑은 고딕", 9.75F, FontStyle.Bold);
            label_groupNo.Location = new Point(204, 96);
            label_groupNo.Name = "label_groupNo";
            label_groupNo.Size = new Size(34, 17);
            label_groupNo.TabIndex = 160;
            label_groupNo.Text = "분류";
            // 
            // textBox_category
            // 
            textBox_category.Location = new Point(249, 131);
            textBox_category.Name = "textBox_category";
            textBox_category.Size = new Size(339, 23);
            textBox_category.TabIndex = 159;
            // 
            // label_category
            // 
            label_category.AutoSize = true;
            label_category.Font = new Font("맑은 고딕", 9.75F, FontStyle.Bold);
            label_category.Location = new Point(178, 135);
            label_category.Name = "label_category";
            label_category.Size = new Size(60, 17);
            label_category.TabIndex = 158;
            label_category.Text = "카테고리";
            // 
            // textBox_wordMean
            // 
            textBox_wordMean.Location = new Point(249, 211);
            textBox_wordMean.Multiline = true;
            textBox_wordMean.Name = "textBox_wordMean";
            textBox_wordMean.Size = new Size(339, 154);
            textBox_wordMean.TabIndex = 157;
            // 
            // label__wordMean
            // 
            label__wordMean.AutoSize = true;
            label__wordMean.Font = new Font("맑은 고딕", 9.75F, FontStyle.Bold);
            label__wordMean.Location = new Point(176, 213);
            label__wordMean.Name = "label__wordMean";
            label__wordMean.Size = new Size(60, 17);
            label__wordMean.TabIndex = 156;
            label__wordMean.Text = "단어설명";
            // 
            // textBox_word
            // 
            textBox_word.Location = new Point(249, 171);
            textBox_word.Name = "textBox_word";
            textBox_word.Size = new Size(339, 23);
            textBox_word.TabIndex = 155;
            // 
            // label_word
            // 
            label_word.AutoSize = true;
            label_word.Font = new Font("맑은 고딕", 9.75F, FontStyle.Bold);
            label_word.Location = new Point(189, 176);
            label_word.Name = "label_word";
            label_word.Size = new Size(47, 17);
            label_word.TabIndex = 152;
            label_word.Text = "단어명";
            // 
            // label8
            // 
            label8.BackColor = Color.FromArgb(224, 244, 255);
            label8.BorderStyle = BorderStyle.Fixed3D;
            label8.Location = new Point(198, 62);
            label8.Name = "label8";
            label8.Size = new Size(400, 2);
            label8.TabIndex = 165;
            // 
            // panel1
            // 
            panel1.BackgroundImage = Properties.Resources.bonoback;
            panel1.Dock = DockStyle.Left;
            panel1.Location = new Point(0, 0);
            panel1.Name = "panel1";
            panel1.Size = new Size(170, 450);
            panel1.TabIndex = 166;
            // 
            // panel2
            // 
            panel2.BackgroundImage = Properties.Resources.bonoback;
            panel2.Dock = DockStyle.Right;
            panel2.Location = new Point(630, 0);
            panel2.Name = "panel2";
            panel2.Size = new Size(170, 450);
            panel2.TabIndex = 167;
            // 
            // FormAdminWord
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            BackColor = SystemColors.ButtonHighlight;
            ClientSize = new Size(800, 450);
            Controls.Add(panel2);
            Controls.Add(panel1);
            Controls.Add(label8);
            Controls.Add(textBox_groupNo);
            Controls.Add(label_groupNo);
            Controls.Add(textBox_category);
            Controls.Add(label_category);
            Controls.Add(textBox_wordMean);
            Controls.Add(label__wordMean);
            Controls.Add(textBox_word);
            Controls.Add(label_word);
            Controls.Add(closeBtn);
            Controls.Add(successBtn);
            Controls.Add(label4);
            Name = "FormAdminWord";
            Text = "FormAdminWord";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion
        private Label label4;
        private Button closeBtn;
        private Button successBtn;
        private TextBox textBox_groupNo;
        private Label label_groupNo;
        private TextBox textBox_category;
        private Label label_category;
        private TextBox textBox_wordMean;
        private Label label__wordMean;
        private TextBox textBox_word;
        private Label label_word;
        private Label label8;
        private Panel panel1;
        private Panel panel2;
    }
}