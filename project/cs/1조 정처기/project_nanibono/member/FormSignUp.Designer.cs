namespace project_nanibono
{
    partial class FormSignUp
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
            pictureBox1 = new PictureBox();
            textBox1 = new TextBox();
            textBox2 = new TextBox();
            textBox3 = new TextBox();
            button1 = new Button();
            label4 = new Label();
            label5 = new Label();
            label1 = new Label();
            label2 = new Label();
            loginButton = new Button();
            label6 = new Label();
            label3 = new Label();
            label7 = new Label();
            ((System.ComponentModel.ISupportInitialize)pictureBox1).BeginInit();
            SuspendLayout();
            // 
            // pictureBox1
            // 
            pictureBox1.BackgroundImage = Properties.Resources.bonoImg;
            pictureBox1.Dock = DockStyle.Top;
            pictureBox1.Location = new Point(0, 0);
            pictureBox1.Name = "pictureBox1";
            pictureBox1.Size = new Size(800, 84);
            pictureBox1.TabIndex = 0;
            pictureBox1.TabStop = false;
            // 
            // textBox1
            // 
            textBox1.Location = new Point(274, 183);
            textBox1.Name = "textBox1";
            textBox1.Size = new Size(265, 23);
            textBox1.TabIndex = 4;
            // 
            // textBox2
            // 
            textBox2.Location = new Point(274, 221);
            textBox2.Name = "textBox2";
            textBox2.Size = new Size(265, 23);
            textBox2.TabIndex = 5;
            // 
            // textBox3
            // 
            textBox3.Location = new Point(274, 259);
            textBox3.Name = "textBox3";
            textBox3.Size = new Size(265, 23);
            textBox3.TabIndex = 6;
            // 
            // button1
            // 
            button1.BackColor = Color.FromArgb(224, 244, 255);
            button1.FlatAppearance.BorderSize = 0;
            button1.FlatStyle = FlatStyle.Flat;
            button1.Font = new Font("맑은 고딕", 9F, FontStyle.Bold, GraphicsUnit.Point, 129);
            button1.ForeColor = Color.FromArgb(57, 167, 255);
            button1.Location = new Point(548, 183);
            button1.Name = "button1";
            button1.Size = new Size(73, 23);
            button1.TabIndex = 7;
            button1.Text = "중복 체크";
            button1.UseVisualStyleBackColor = false;
            button1.Click += button1_Click;
            // 
            // label4
            // 
            label4.AutoSize = true;
            label4.BackColor = SystemColors.ControlLightLight;
            label4.Font = new Font("휴먼둥근헤드라인", 27.75F, FontStyle.Regular, GraphicsUnit.Point, 129);
            label4.ForeColor = Color.FromArgb(57, 167, 255);
            label4.Location = new Point(317, 105);
            label4.Name = "label4";
            label4.Size = new Size(165, 39);
            label4.TabIndex = 13;
            label4.Text = "회원가입";
            // 
            // label5
            // 
            label5.AutoSize = true;
            label5.Font = new Font("맑은 고딕", 12F);
            label5.ForeColor = Color.FromArgb(57, 167, 255);
            label5.Location = new Point(231, 182);
            label5.Name = "label5";
            label5.Size = new Size(25, 21);
            label5.TabIndex = 14;
            label5.Text = "ID";
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Font = new Font("맑은 고딕", 12F);
            label1.ForeColor = Color.FromArgb(57, 167, 255);
            label1.Location = new Point(222, 222);
            label1.Name = "label1";
            label1.Size = new Size(34, 21);
            label1.TabIndex = 15;
            label1.Text = "PW";
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Font = new Font("맑은 고딕", 12F);
            label2.ForeColor = Color.FromArgb(57, 167, 255);
            label2.Location = new Point(200, 262);
            label2.Name = "label2";
            label2.Size = new Size(56, 21);
            label2.TabIndex = 16;
            label2.Text = "NAME";
            // 
            // loginButton
            // 
            loginButton.BackColor = Color.FromArgb(224, 244, 255);
            loginButton.FlatAppearance.BorderSize = 0;
            loginButton.FlatStyle = FlatStyle.Flat;
            loginButton.Font = new Font("맑은 고딕", 9F, FontStyle.Bold, GraphicsUnit.Point, 129);
            loginButton.ForeColor = Color.FromArgb(57, 167, 255);
            loginButton.Location = new Point(341, 338);
            loginButton.Name = "loginButton";
            loginButton.Size = new Size(105, 37);
            loginButton.TabIndex = 17;
            loginButton.Text = "SIGN UP";
            loginButton.UseVisualStyleBackColor = false;
            // 
            // label6
            // 
            label6.AutoSize = true;
            label6.Font = new Font("맑은 고딕", 9F, FontStyle.Bold, GraphicsUnit.Point, 129);
            label6.ForeColor = Color.Red;
            label6.Location = new Point(252, 187);
            label6.Name = "label6";
            label6.Size = new Size(12, 15);
            label6.TabIndex = 19;
            label6.Text = "*";
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Font = new Font("맑은 고딕", 9F, FontStyle.Bold, GraphicsUnit.Point, 129);
            label3.ForeColor = Color.Red;
            label3.Location = new Point(252, 227);
            label3.Name = "label3";
            label3.Size = new Size(12, 15);
            label3.TabIndex = 19;
            label3.Text = "*";
            // 
            // label7
            // 
            label7.AutoSize = true;
            label7.Font = new Font("맑은 고딕", 9F, FontStyle.Bold, GraphicsUnit.Point, 129);
            label7.ForeColor = Color.Red;
            label7.Location = new Point(252, 267);
            label7.Name = "label7";
            label7.Size = new Size(12, 15);
            label7.TabIndex = 19;
            label7.Text = "*";
            // 
            // FormSignUp
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            BackColor = SystemColors.ControlLightLight;
            ClientSize = new Size(800, 450);
            Controls.Add(label7);
            Controls.Add(label3);
            Controls.Add(label6);
            Controls.Add(loginButton);
            Controls.Add(label2);
            Controls.Add(label1);
            Controls.Add(label5);
            Controls.Add(label4);
            Controls.Add(button1);
            Controls.Add(textBox3);
            Controls.Add(textBox2);
            Controls.Add(textBox1);
            Controls.Add(pictureBox1);
            Name = "FormSignUp";
            Text = "FormSignUp";
            Load += FormSignUp_Load;
            ((System.ComponentModel.ISupportInitialize)pictureBox1).EndInit();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private PictureBox pictureBox1;
        private TextBox textBox1;
        private TextBox textBox2;
        private TextBox textBox3;
        private Button button1;
        private Label label4;
        private Label label5;
        private Label label1;
        private Label label2;
        private Button loginButton;
        private Label label6;
        private Label label3;
        private Label label7;
    }
}