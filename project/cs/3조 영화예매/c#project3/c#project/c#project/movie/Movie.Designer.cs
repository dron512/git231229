namespace c_project.movie
{
    partial class Movie
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
            this.components = new System.ComponentModel.Container();
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Movie));
            this.moviename = new System.Windows.Forms.Label();
            this.movieage = new System.Windows.Forms.Label();
            this.moviestory = new System.Windows.Forms.Label();
            this.Time = new System.Windows.Forms.Label();
            this.movietime = new System.Windows.Forms.Label();
            this.axWindowsMediaPlayer1 = new AxWMPLib.AxWindowsMediaPlayer();
            this.button2 = new System.Windows.Forms.Button();
            this.timer1 = new System.Windows.Forms.Timer(this.components);
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            this.panel6 = new System.Windows.Forms.Panel();
            this.panel3 = new System.Windows.Forms.Panel();
            this.pictureBox7 = new System.Windows.Forms.PictureBox();
            this.label7 = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.axWindowsMediaPlayer1)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox7)).BeginInit();
            this.SuspendLayout();
            // 
            // moviename
            // 
            this.moviename.AutoSize = true;
            this.moviename.Font = new System.Drawing.Font("Microsoft Sans Serif", 20.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(129)));
            this.moviename.ForeColor = System.Drawing.Color.OrangeRed;
            this.moviename.Location = new System.Drawing.Point(83, 458);
            this.moviename.Name = "moviename";
            this.moviename.Size = new System.Drawing.Size(92, 39);
            this.moviename.TabIndex = 2;
            this.moviename.Text = "영화명";
            // 
            // movieage
            // 
            this.movieage.AutoSize = true;
            this.movieage.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(129)));
            this.movieage.ForeColor = System.Drawing.Color.Silver;
            this.movieage.Location = new System.Drawing.Point(87, 502);
            this.movieage.Name = "movieage";
            this.movieage.Size = new System.Drawing.Size(51, 29);
            this.movieage.TabIndex = 4;
            this.movieage.Text = "연령";
            // 
            // moviestory
            // 
            this.moviestory.AutoEllipsis = true;
            this.moviestory.AutoSize = true;
            this.moviestory.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(129)));
            this.moviestory.ForeColor = System.Drawing.Color.White;
            this.moviestory.Location = new System.Drawing.Point(89, 587);
            this.moviestory.Name = "moviestory";
            this.moviestory.Size = new System.Drawing.Size(70, 29);
            this.moviestory.TabIndex = 5;
            this.moviestory.Text = "스토리";
            // 
            // Time
            // 
            this.Time.AutoSize = true;
            this.Time.Font = new System.Drawing.Font("Microsoft Sans Serif", 21.75F);
            this.Time.ForeColor = System.Drawing.Color.OrangeRed;
            this.Time.Location = new System.Drawing.Point(563, 22);
            this.Time.Name = "Time";
            this.Time.Size = new System.Drawing.Size(112, 42);
            this.Time.TabIndex = 7;
            this.Time.Text = "00:00";
            // 
            // movietime
            // 
            this.movietime.AutoSize = true;
            this.movietime.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(129)));
            this.movietime.ForeColor = System.Drawing.Color.Silver;
            this.movietime.Location = new System.Drawing.Point(85, 538);
            this.movietime.Name = "movietime";
            this.movietime.Size = new System.Drawing.Size(89, 29);
            this.movietime.TabIndex = 8;
            this.movietime.Text = "상영시간";
            // 
            // axWindowsMediaPlayer1
            // 
            this.axWindowsMediaPlayer1.Enabled = true;
            this.axWindowsMediaPlayer1.Location = new System.Drawing.Point(-1, 83);
            this.axWindowsMediaPlayer1.Name = "axWindowsMediaPlayer1";
            this.axWindowsMediaPlayer1.OcxState = ((System.Windows.Forms.AxHost.State)(resources.GetObject("axWindowsMediaPlayer1.OcxState")));
            this.axWindowsMediaPlayer1.Size = new System.Drawing.Size(690, 345);
            this.axWindowsMediaPlayer1.TabIndex = 9;
            // 
            // button2
            // 
            this.button2.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(25)))), ((int)(((byte)(25)))), ((int)(((byte)(25)))));
            this.button2.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.button2.Font = new System.Drawing.Font("Microsoft Sans Serif", 26.25F, System.Drawing.FontStyle.Bold);
            this.button2.ForeColor = System.Drawing.Color.OrangeRed;
            this.button2.Location = new System.Drawing.Point(0, 786);
            this.button2.Name = "button2";
            this.button2.Size = new System.Drawing.Size(690, 125);
            this.button2.TabIndex = 11;
            this.button2.Text = "에매하기";
            this.button2.UseVisualStyleBackColor = false;
            this.button2.Click += new System.EventHandler(this.button2_Click);
            // 
            // timer1
            // 
            this.timer1.Tick += new System.EventHandler(this.timer1_Tick);
            // 
            // pictureBox1
            // 
            this.pictureBox1.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(25)))), ((int)(((byte)(25)))), ((int)(((byte)(25)))));
            this.pictureBox1.Image = ((System.Drawing.Image)(resources.GetObject("pictureBox1.Image")));
            this.pictureBox1.Location = new System.Drawing.Point(14, 807);
            this.pictureBox1.Name = "pictureBox1";
            this.pictureBox1.Size = new System.Drawing.Size(75, 75);
            this.pictureBox1.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pictureBox1.TabIndex = 49;
            this.pictureBox1.TabStop = false;
            this.pictureBox1.Click += new System.EventHandler(this.pictureBox1_Click);
            // 
            // panel6
            // 
            this.panel6.BackColor = System.Drawing.Color.OrangeRed;
            this.panel6.ForeColor = System.Drawing.Color.Coral;
            this.panel6.Location = new System.Drawing.Point(-1, 902);
            this.panel6.Name = "panel6";
            this.panel6.Size = new System.Drawing.Size(714, 20);
            this.panel6.TabIndex = 50;
            // 
            // panel3
            // 
            this.panel3.BackColor = System.Drawing.Color.OrangeRed;
            this.panel3.ForeColor = System.Drawing.Color.Coral;
            this.panel3.Location = new System.Drawing.Point(88, 573);
            this.panel3.Name = "panel3";
            this.panel3.Size = new System.Drawing.Size(500, 3);
            this.panel3.TabIndex = 51;
            // 
            // pictureBox7
            // 
            this.pictureBox7.Image = ((System.Drawing.Image)(resources.GetObject("pictureBox7.Image")));
            this.pictureBox7.Location = new System.Drawing.Point(1, -2);
            this.pictureBox7.Name = "pictureBox7";
            this.pictureBox7.Size = new System.Drawing.Size(88, 82);
            this.pictureBox7.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pictureBox7.TabIndex = 53;
            this.pictureBox7.TabStop = false;
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Font = new System.Drawing.Font("Microsoft Sans Serif", 18F);
            this.label7.ForeColor = System.Drawing.Color.White;
            this.label7.Location = new System.Drawing.Point(97, 26);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(207, 36);
            this.label7.TabIndex = 52;
            this.label7.Text = "SOOP 동성로점";
            // 
            // Movie
            // 
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.None;
            this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(25)))), ((int)(((byte)(25)))), ((int)(((byte)(25)))));
            this.ClientSize = new System.Drawing.Size(690, 920);
            this.Controls.Add(this.pictureBox7);
            this.Controls.Add(this.label7);
            this.Controls.Add(this.panel3);
            this.Controls.Add(this.panel6);
            this.Controls.Add(this.pictureBox1);
            this.Controls.Add(this.button2);
            this.Controls.Add(this.axWindowsMediaPlayer1);
            this.Controls.Add(this.movietime);
            this.Controls.Add(this.Time);
            this.Controls.Add(this.moviestory);
            this.Controls.Add(this.movieage);
            this.Controls.Add(this.moviename);
            this.ForeColor = System.Drawing.Color.OrangeRed;
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            this.Name = "Movie";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Movie1";
            ((System.ComponentModel.ISupportInitialize)(this.axWindowsMediaPlayer1)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox7)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion
        private System.Windows.Forms.Label moviename;
        private System.Windows.Forms.Label movieage;
        private System.Windows.Forms.Label moviestory;
        private System.Windows.Forms.Label Time;
        private System.Windows.Forms.Label movietime;
        private AxWMPLib.AxWindowsMediaPlayer axWindowsMediaPlayer1;
        private System.Windows.Forms.Button button2;
        private System.Windows.Forms.Timer timer1;
        private System.Windows.Forms.PictureBox pictureBox1;
        private System.Windows.Forms.Panel panel6;
        private System.Windows.Forms.Panel panel3;
        private System.Windows.Forms.PictureBox pictureBox7;
        private System.Windows.Forms.Label label7;
    }
}