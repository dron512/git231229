namespace WinFormsApp1
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
            button1 = new Button();
            button2 = new Button();
            listBox1 = new ListBox();
            dataGridView1 = new DataGridView();
            listView1 = new ListView();
            ((System.ComponentModel.ISupportInitialize)dataGridView1).BeginInit();
            SuspendLayout();
            // 
            // button1
            // 
            button1.Font = new Font("한컴 말랑말랑 Bold", 20.2499962F, FontStyle.Bold);
            button1.Location = new Point(270, 393);
            button1.Name = "button1";
            button1.Size = new Size(130, 50);
            button1.TabIndex = 0;
            button1.Text = "버튼";
            button1.UseVisualStyleBackColor = true;
            button1.Click += button1_Click;
            // 
            // button2
            // 
            button2.Font = new Font("한컴 말랑말랑 Bold", 20.2499962F, FontStyle.Bold);
            button2.Location = new Point(678, 393);
            button2.Name = "button2";
            button2.Size = new Size(130, 50);
            button2.TabIndex = 1;
            button2.Text = "조회";
            button2.UseVisualStyleBackColor = true;
            button2.Click += button2_Click;
            // 
            // listBox1
            // 
            listBox1.FormattingEnabled = true;
            listBox1.ItemHeight = 15;
            listBox1.Location = new Point(50, 18);
            listBox1.Name = "listBox1";
            listBox1.Size = new Size(174, 349);
            listBox1.TabIndex = 2;
            // 
            // dataGridView1
            // 
            dataGridView1.ColumnHeadersHeightSizeMode = DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            dataGridView1.Location = new Point(454, 18);
            dataGridView1.Name = "dataGridView1";
            dataGridView1.Size = new Size(354, 350);
            dataGridView1.TabIndex = 3;
            // 
            // listView1
            // 
            listView1.Location = new Point(251, 12);
            listView1.Name = "listView1";
            listView1.Size = new Size(173, 355);
            listView1.TabIndex = 4;
            listView1.UseCompatibleStateImageBehavior = false;
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(843, 475);
            Controls.Add(listView1);
            Controls.Add(dataGridView1);
            Controls.Add(listBox1);
            Controls.Add(button2);
            Controls.Add(button1);
            Name = "Form1";
            Text = "Form1";
            ((System.ComponentModel.ISupportInitialize)dataGridView1).EndInit();
            ResumeLayout(false);
        }

        #endregion

        private Button button1;
        private Button button2;
        private ListBox listBox1;
        private DataGridView dataGridView1;
        private ListView listView1;
    }
}
