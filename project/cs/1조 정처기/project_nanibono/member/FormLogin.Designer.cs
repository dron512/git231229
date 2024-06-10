namespace project_nanibono
{
    partial class FormLogin
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
            components = new System.ComponentModel.Container();
            nanibonoBox = new PictureBox();
            iconBox = new PictureBox();
            label2 = new Label();
            label3 = new Label();
            idTextBox = new TextBox();
            pwTextBox = new TextBox();
            loginButton = new Button();
            label4 = new Label();
            SignUpButton = new Button();
            notifyIcon1 = new NotifyIcon(components);
            homeButton = new Button();
            label1 = new Label();
            label5 = new Label();
            ((System.ComponentModel.ISupportInitialize)nanibonoBox).BeginInit();
            ((System.ComponentModel.ISupportInitialize)iconBox).BeginInit();
            SuspendLayout();
            // 
            // nanibonoBox
            // 
            nanibonoBox.BackColor = Color.FromArgb(224, 244, 255);
            nanibonoBox.BackgroundImage = Properties.Resources._0057;
            nanibonoBox.BackgroundImageLayout = ImageLayout.Stretch;
            nanibonoBox.Dock = DockStyle.Right;
            nanibonoBox.Location = new Point(434, 0);
            nanibonoBox.Name = "nanibonoBox";
            nanibonoBox.Size = new Size(366, 450);
            nanibonoBox.TabIndex = 0;
            nanibonoBox.TabStop = false;
            // 
            // iconBox
            // 
            iconBox.BackColor = Color.FromArgb(52, 199, 243);
            iconBox.Dock = DockStyle.Top;
            iconBox.Location = new Point(0, 0);
            iconBox.Name = "iconBox";
            iconBox.Size = new Size(434, 47);
            iconBox.TabIndex = 1;
            iconBox.TabStop = false;
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Font = new Font("맑은 고딕", 12F);
            label2.ForeColor = Color.FromArgb(57, 167, 255);
            label2.Location = new Point(96, 195);
            label2.Name = "label2";
            label2.Size = new Size(35, 21);
            label2.TabIndex = 3;
            label2.Text = "ID :";
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Font = new Font("맑은 고딕", 12F);
            label3.ForeColor = Color.FromArgb(57, 167, 255);
            label3.Location = new Point(87, 226);
            label3.Name = "label3";
            label3.Size = new Size(44, 21);
            label3.TabIndex = 4;
            label3.Text = "PW :";
            // 
            // idTextBox
            // 
            idTextBox.Location = new Point(137, 193);
            idTextBox.Name = "idTextBox";
            idTextBox.Size = new Size(201, 23);
            idTextBox.TabIndex = 5;
            idTextBox.TextChanged += idTextBox_TextChanged;
            // 
            // pwTextBox
            // 
            pwTextBox.Location = new Point(137, 226);
            pwTextBox.Name = "pwTextBox";
            pwTextBox.Size = new Size(201, 23);
            pwTextBox.TabIndex = 6;
            // 
            // loginButton
            // 
            loginButton.BackColor = Color.FromArgb(224, 244, 255);
            loginButton.FlatAppearance.BorderSize = 0;
            loginButton.FlatStyle = FlatStyle.Flat;
            loginButton.Font = new Font("맑은 고딕", 9F, FontStyle.Bold);
            loginButton.ForeColor = Color.FromArgb(57, 167, 255);
            loginButton.Location = new Point(122, 273);
            loginButton.Name = "loginButton";
            loginButton.Size = new Size(105, 37);
            loginButton.TabIndex = 7;
            loginButton.Text = "LOGIN";
            loginButton.UseVisualStyleBackColor = false;
            loginButton.Click += loginButton_Click;
            // 
            // label4
            // 
            label4.AutoSize = true;
            label4.ForeColor = Color.FromArgb(135, 196, 255);
            label4.Location = new Point(96, 328);
            label4.Name = "label4";
            label4.Size = new Size(179, 15);
            label4.TabIndex = 8;
            label4.Text = "Do you wannabe a bonobono? ";
            // 
            // SignUpButton
            // 
            SignUpButton.FlatAppearance.BorderSize = 0;
            SignUpButton.FlatStyle = FlatStyle.Flat;
            SignUpButton.Font = new Font("맑은 고딕", 9F, FontStyle.Underline, GraphicsUnit.Point, 129);
            SignUpButton.ForeColor = Color.FromArgb(57, 167, 255);
            SignUpButton.Location = new Point(269, 322);
            SignUpButton.Name = "SignUpButton";
            SignUpButton.Size = new Size(69, 23);
            SignUpButton.TabIndex = 9;
            SignUpButton.Text = "SignUp";
            SignUpButton.UseVisualStyleBackColor = true;
            // 
            // notifyIcon1
            // 
            notifyIcon1.Text = "notifyIcon1";
            notifyIcon1.Visible = true;
            // 
            // homeButton
            // 
            homeButton.BackColor = Color.FromArgb(224, 244, 255);
            homeButton.FlatAppearance.BorderSize = 0;
            homeButton.FlatStyle = FlatStyle.Flat;
            homeButton.Font = new Font("맑은 고딕", 9F, FontStyle.Bold);
            homeButton.ForeColor = Color.FromArgb(57, 167, 255);
            homeButton.Location = new Point(233, 273);
            homeButton.Name = "homeButton";
            homeButton.Size = new Size(105, 37);
            homeButton.TabIndex = 11;
            homeButton.Text = "HOME";
            homeButton.UseVisualStyleBackColor = false;
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Font = new Font("휴먼둥근헤드라인", 21.75F, FontStyle.Regular, GraphicsUnit.Point, 129);
            label1.ForeColor = Color.FromArgb(57, 167, 255);
            label1.Location = new Point(184, 133);
            label1.Name = "label1";
            label1.Size = new Size(100, 30);
            label1.TabIndex = 12;
            label1.Text = "로그인";
            // 
            // label5
            // 
            label5.AutoSize = true;
            label5.BackColor = Color.White;
            label5.FlatStyle = FlatStyle.Flat;
            label5.Font = new Font("휴먼둥근헤드라인", 18F, FontStyle.Bold, GraphicsUnit.Point, 129);
            label5.ForeColor = Color.FromArgb(57, 167, 255);
            label5.Location = new Point(141, 91);
            label5.Name = "label5";
            label5.Size = new Size(189, 25);
            label5.TabIndex = 13;
            label5.Text = "먼 시 험 보 노";
            // 
            // FormLogin
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            BackColor = SystemColors.ControlLightLight;
            ClientSize = new Size(800, 450);
            Controls.Add(label5);
            Controls.Add(label1);
            Controls.Add(homeButton);
            Controls.Add(SignUpButton);
            Controls.Add(label4);
            Controls.Add(loginButton);
            Controls.Add(pwTextBox);
            Controls.Add(idTextBox);
            Controls.Add(label3);
            Controls.Add(label2);
            Controls.Add(iconBox);
            Controls.Add(nanibonoBox);
            Name = "FormLogin";
            Text = "Form3";
            Load += FormLogin_Load;
            ((System.ComponentModel.ISupportInitialize)nanibonoBox).EndInit();
            ((System.ComponentModel.ISupportInitialize)iconBox).EndInit();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private PictureBox nanibonoBox;
        private PictureBox iconBox;
        private Label label2;
        private Label label3;
        private TextBox idTextBox;
        private TextBox pwTextBox;
        private Button loginButton;
        private Label label4;
        private Button SignUpButton;
        private NotifyIcon notifyIcon1;
        private Button homeButton;
        private Label label1;
        private Label label5;
    }
}