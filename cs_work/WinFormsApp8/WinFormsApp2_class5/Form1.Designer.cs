namespace WinFormsApp2_class5
{
    partial class Form1
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        ///  Clean up any resources being used.
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
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            components = new System.ComponentModel.Container();
            button1 = new Button();
            textBox1 = new TextBox();
            imageList1 = new ImageList(components);
            textBox2 = new TextBox();
            button2 = new Button();
            textBox3 = new TextBox();
            button3 = new Button();
            button4 = new Button();
            textBox4 = new TextBox();
            SuspendLayout();
            // 
            // button1
            // 
            button1.Font = new Font("배달의민족 도현", 14.2499981F, FontStyle.Bold);
            button1.Location = new Point(222, 312);
            button1.Name = "button1";
            button1.Size = new Size(133, 31);
            button1.TabIndex = 1;
            button1.Text = "자동차추가";
            button1.UseVisualStyleBackColor = true;
            button1.Click += button1_Click;
            // 
            // textBox1
            // 
            textBox1.Font = new Font("배달의민족 도현", 14.2499981F, FontStyle.Bold);
            textBox1.Location = new Point(35, 312);
            textBox1.Name = "textBox1";
            textBox1.Size = new Size(181, 31);
            textBox1.TabIndex = 3;
            textBox1.KeyUp += textBox1_KeyUp;
            // 
            // imageList1
            // 
            imageList1.ColorDepth = ColorDepth.Depth32Bit;
            imageList1.ImageSize = new Size(16, 16);
            imageList1.TransparentColor = Color.Transparent;
            // 
            // textBox2
            // 
            textBox2.Font = new Font("배달의민족 도현", 14.2499981F, FontStyle.Bold);
            textBox2.Location = new Point(35, 359);
            textBox2.Name = "textBox2";
            textBox2.Size = new Size(181, 31);
            textBox2.TabIndex = 2;
            // 
            // button2
            // 
            button2.Font = new Font("배달의민족 도현", 14.2499981F, FontStyle.Bold);
            button2.Location = new Point(222, 359);
            button2.Name = "button2";
            button2.Size = new Size(133, 31);
            button2.TabIndex = 5;
            button2.Text = "자동차추가";
            button2.UseVisualStyleBackColor = true;
            // 
            // textBox3
            // 
            textBox3.Font = new Font("배달의민족 도현", 14.2499981F, FontStyle.Bold);
            textBox3.Location = new Point(35, 407);
            textBox3.Name = "textBox3";
            textBox3.Size = new Size(181, 31);
            textBox3.TabIndex = 7;
            // 
            // button3
            // 
            button3.Font = new Font("배달의민족 도현", 14.2499981F, FontStyle.Bold);
            button3.Location = new Point(222, 407);
            button3.Name = "button3";
            button3.Size = new Size(133, 31);
            button3.TabIndex = 9;
            button3.Text = "자동차추가";
            button3.UseVisualStyleBackColor = true;
            // 
            // button4
            // 
            button4.Font = new Font("배달의민족 도현", 14.2499981F, FontStyle.Bold);
            button4.Location = new Point(555, 311);
            button4.Name = "button4";
            button4.Size = new Size(133, 31);
            button4.TabIndex = 1;
            button4.Text = "자동차추가";
            button4.UseVisualStyleBackColor = true;
            button4.Click += button1_Click;
            // 
            // textBox4
            // 
            textBox4.Font = new Font("배달의민족 도현", 14.2499981F, FontStyle.Bold);
            textBox4.Location = new Point(368, 311);
            textBox4.Name = "textBox4";
            textBox4.Size = new Size(181, 31);
            textBox4.TabIndex = 3;
            textBox4.KeyUp += textBox1_KeyUp;
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(709, 450);
            Controls.Add(textBox3);
            Controls.Add(button3);
            Controls.Add(textBox2);
            Controls.Add(button2);
            Controls.Add(textBox4);
            Controls.Add(textBox1);
            Controls.Add(button4);
            Controls.Add(button1);
            Name = "Form1";
            Text = "Form1";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Button button1;
        private TextBox textBox1;
        private ImageList imageList1;
        private TextBox textBox2;
        private Button button2;
        private TextBox textBox3;
        private Button button3;
        private Button button4;
        private TextBox textBox4;
    }
}
