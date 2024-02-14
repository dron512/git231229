namespace WinFormsApp6
{
    partial class MusicLogin
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(MusicLogin));
            pictureBox1 = new PictureBox();
            label1 = new Label();
            textBox1 = new TextBox();
            button1 = new Button();
            label2 = new Label();
            label3 = new Label();
            textBox2 = new TextBox();
            label4 = new Label();
            label5 = new Label();
            button2 = new Button();
            button3 = new Button();
            ((System.ComponentModel.ISupportInitialize)pictureBox1).BeginInit();
            SuspendLayout();
            // 
            // pictureBox1
            // 
            pictureBox1.BackgroundImage = (Image)resources.GetObject("pictureBox1.BackgroundImage");
            pictureBox1.BackgroundImageLayout = ImageLayout.Zoom;
            pictureBox1.Dock = DockStyle.Right;
            pictureBox1.Location = new Point(439, 0);
            pictureBox1.Name = "pictureBox1";
            pictureBox1.Size = new Size(307, 423);
            pictureBox1.TabIndex = 0;
            pictureBox1.TabStop = false;
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Font = new Font("Century Gothic", 21.75F, FontStyle.Bold);
            label1.Location = new Point(41, 53);
            label1.Name = "label1";
            label1.Size = new Size(150, 36);
            label1.TabIndex = 1;
            label1.Text = "Login First";
            // 
            // textBox1
            // 
            textBox1.Font = new Font("Century Gothic", 21.75F, FontStyle.Bold);
            textBox1.Location = new Point(225, 104);
            textBox1.Name = "textBox1";
            textBox1.Size = new Size(187, 43);
            textBox1.TabIndex = 2;
            // 
            // button1
            // 
            button1.BackColor = Color.Crimson;
            button1.FlatAppearance.BorderSize = 0;
            button1.FlatStyle = FlatStyle.Flat;
            button1.Font = new Font("Century Gothic", 21.75F, FontStyle.Bold);
            button1.ForeColor = Color.White;
            button1.Location = new Point(287, 247);
            button1.Name = "button1";
            button1.Size = new Size(125, 45);
            button1.TabIndex = 3;
            button1.Text = "Login";
            button1.UseVisualStyleBackColor = false;
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Font = new Font("Century Gothic", 21.75F, FontStyle.Bold);
            label2.Location = new Point(41, 107);
            label2.Name = "label2";
            label2.Size = new Size(169, 36);
            label2.TabIndex = 4;
            label2.Text = "User Name";
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Font = new Font("Century Gothic", 21.75F, FontStyle.Bold);
            label3.Location = new Point(54, 178);
            label3.Name = "label3";
            label3.Size = new Size(146, 36);
            label3.TabIndex = 6;
            label3.Text = "Password";
            // 
            // textBox2
            // 
            textBox2.Font = new Font("Century Gothic", 21.75F, FontStyle.Bold);
            textBox2.Location = new Point(225, 171);
            textBox2.Name = "textBox2";
            textBox2.Size = new Size(187, 43);
            textBox2.TabIndex = 5;
            // 
            // label4
            // 
            label4.AutoSize = true;
            label4.Font = new Font("Century Gothic", 21.75F, FontStyle.Regular, GraphicsUnit.Point, 0);
            label4.Location = new Point(12, 352);
            label4.Name = "label4";
            label4.Size = new Size(369, 36);
            label4.TabIndex = 6;
            label4.Text = "Don't Have an Account?";
            // 
            // label5
            // 
            label5.AutoSize = true;
            label5.Font = new Font("Century Gothic", 21.75F, FontStyle.Bold);
            label5.ForeColor = Color.Red;
            label5.Location = new Point(301, 316);
            label5.Name = "label5";
            label5.Size = new Size(111, 36);
            label5.TabIndex = 7;
            label5.Text = "SignUp";
            // 
            // button2
            // 
            button2.BackgroundImage = (Image)resources.GetObject("button2.BackgroundImage");
            button2.FlatAppearance.BorderSize = 0;
            button2.FlatStyle = FlatStyle.Flat;
            button2.Location = new Point(287, 37);
            button2.Name = "button2";
            button2.Size = new Size(43, 33);
            button2.TabIndex = 8;
            button2.UseVisualStyleBackColor = true;
            // 
            // button3
            // 
            button3.FlatAppearance.BorderSize = 0;
            button3.FlatStyle = FlatStyle.Flat;
            button3.ForeColor = Color.OrangeRed;
            button3.Location = new Point(633, 12);
            button3.Name = "button3";
            button3.Size = new Size(101, 33);
            button3.TabIndex = 9;
            button3.Text = "종료버튼";
            button3.UseVisualStyleBackColor = true;
            button3.Click += button3_Click;
            // 
            // MusicLogin
            // 
            AutoScaleDimensions = new SizeF(13F, 25F);
            AutoScaleMode = AutoScaleMode.Font;
            BackColor = Color.White;
            ClientSize = new Size(746, 423);
            Controls.Add(button3);
            Controls.Add(button2);
            Controls.Add(label5);
            Controls.Add(label4);
            Controls.Add(label3);
            Controls.Add(textBox2);
            Controls.Add(label2);
            Controls.Add(button1);
            Controls.Add(textBox1);
            Controls.Add(label1);
            Controls.Add(pictureBox1);
            Font = new Font("Century Gothic", 15.75F, FontStyle.Bold, GraphicsUnit.Point, 0);
            FormBorderStyle = FormBorderStyle.None;
            Margin = new Padding(6, 5, 6, 5);
            Name = "MusicLogin";
            StartPosition = FormStartPosition.CenterScreen;
            Text = "MusicLogin";
            ((System.ComponentModel.ISupportInitialize)pictureBox1).EndInit();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private PictureBox pictureBox1;
        private Label label1;
        private TextBox textBox1;
        private Button button1;
        private Label label2;
        private Label label3;
        private TextBox textBox2;
        private Label label4;
        private Label label5;
        private Button button2;
        private Button button3;
    }
}