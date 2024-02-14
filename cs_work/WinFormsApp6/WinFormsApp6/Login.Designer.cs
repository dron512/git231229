namespace WinFormsApp6
{
    partial class Login
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Login));
            textBox1 = new TextBox();
            textBox2 = new TextBox();
            label1 = new Label();
            label2 = new Label();
            button1 = new Button();
            SuspendLayout();
            // 
            // textBox1
            // 
            textBox1.Font = new Font("휴먼둥근헤드라인", 20.25F, FontStyle.Bold);
            textBox1.Location = new Point(159, 69);
            textBox1.Name = "textBox1";
            textBox1.Size = new Size(169, 39);
            textBox1.TabIndex = 0;
            // 
            // textBox2
            // 
            textBox2.Font = new Font("휴먼둥근헤드라인", 20.25F, FontStyle.Bold);
            textBox2.Location = new Point(159, 135);
            textBox2.Name = "textBox2";
            textBox2.Size = new Size(169, 39);
            textBox2.TabIndex = 1;
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.BackColor = Color.Transparent;
            label1.Font = new Font("휴먼둥근헤드라인", 20.25F, FontStyle.Bold);
            label1.Location = new Point(56, 72);
            label1.Name = "label1";
            label1.Size = new Size(96, 28);
            label1.TabIndex = 2;
            label1.Text = "아이디";
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.BackColor = Color.Transparent;
            label2.Font = new Font("휴먼둥근헤드라인", 20.25F, FontStyle.Bold);
            label2.Location = new Point(28, 138);
            label2.Name = "label2";
            label2.Size = new Size(124, 28);
            label2.TabIndex = 3;
            label2.Text = "패스워드";
            // 
            // button1
            // 
            button1.BackColor = Color.Transparent;
            button1.Font = new Font("휴먼둥근헤드라인", 20.25F, FontStyle.Bold);
            button1.Location = new Point(354, 69);
            button1.Name = "button1";
            button1.Size = new Size(130, 105);
            button1.TabIndex = 4;
            button1.Text = "로그인";
            button1.UseVisualStyleBackColor = false;
            button1.Click += button1_Click;
            // 
            // Login
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            BackgroundImage = (Image)resources.GetObject("$this.BackgroundImage");
            BackgroundImageLayout = ImageLayout.Zoom;
            ClientSize = new Size(534, 241);
            Controls.Add(button1);
            Controls.Add(label2);
            Controls.Add(label1);
            Controls.Add(textBox2);
            Controls.Add(textBox1);
            Name = "Login";
            Text = "Login";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private TextBox textBox1;
        private TextBox textBox2;
        private Label label1;
        private Label label2;
        private Button button1;
    }
}