namespace c_project.seat
{
    partial class MovieSeat1
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(MovieSeat1));
            this.time1 = new System.Windows.Forms.Label();
            this.Time = new System.Windows.Forms.Label();
            this.moviename = new System.Windows.Forms.Label();
            this.timer1 = new System.Windows.Forms.Timer(this.components);
            this.next = new System.Windows.Forms.Button();
            this.disabledtotal = new System.Windows.Forms.Label();
            this.oldtotal = new System.Windows.Forms.Label();
            this.teentotal = new System.Windows.Forms.Label();
            this.adulttotal = new System.Windows.Forms.Label();
            this.label7 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.disabledplus = new System.Windows.Forms.Button();
            this.disabledminus = new System.Windows.Forms.Button();
            this.oldplus = new System.Windows.Forms.Button();
            this.oldminus = new System.Windows.Forms.Button();
            this.teenplus = new System.Windows.Forms.Button();
            this.teenminus = new System.Windows.Forms.Button();
            this.adultplus = new System.Windows.Forms.Button();
            this.adultminus = new System.Windows.Forms.Button();
            this.label6 = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.movietheater = new System.Windows.Forms.Label();
            this.movieage = new System.Windows.Forms.Label();
            this.starttime = new System.Windows.Forms.Label();
            this.mmovietime = new System.Windows.Forms.Label();
            this.panel4 = new System.Windows.Forms.Panel();
            this.label8 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.checklastseat = new System.Windows.Forms.Label();
            this.choice = new System.Windows.Forms.Label();
            this.home = new System.Windows.Forms.Button();
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            this.pictureBox5 = new System.Windows.Forms.PictureBox();
            this.panel4.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox5)).BeginInit();
            this.SuspendLayout();
            // 
            // time1
            // 
            this.time1.AutoSize = true;
            this.time1.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(64)))), ((int)(((byte)(64)))), ((int)(((byte)(64)))));
            this.time1.Font = new System.Drawing.Font("Microsoft Sans Serif", 11.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(129)));
            this.time1.ForeColor = System.Drawing.Color.Transparent;
            this.time1.Location = new System.Drawing.Point(11, 131);
            this.time1.Name = "time1";
            this.time1.Size = new System.Drawing.Size(122, 24);
            this.time1.TabIndex = 0;
            this.time1.Text = "00:00~00:00";
            // 
            // Time
            // 
            this.Time.AutoSize = true;
            this.Time.Font = new System.Drawing.Font("Pretendard", 20.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Time.ForeColor = System.Drawing.Color.OrangeRed;
            this.Time.Location = new System.Drawing.Point(562, 32);
            this.Time.Name = "Time";
            this.Time.Size = new System.Drawing.Size(86, 33);
            this.Time.TabIndex = 2;
            this.Time.Text = "00:00";
            // 
            // moviename
            // 
            this.moviename.AutoSize = true;
            this.moviename.Font = new System.Drawing.Font("Pretendard", 24F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.moviename.ForeColor = System.Drawing.Color.Transparent;
            this.moviename.Location = new System.Drawing.Point(268, 32);
            this.moviename.Name = "moviename";
            this.moviename.Size = new System.Drawing.Size(129, 38);
            this.moviename.TabIndex = 21;
            this.moviename.Text = "영화제목";
            // 
            // timer1
            // 
            this.timer1.Tick += new System.EventHandler(this.timer1_Tick);
            // 
            // next
            // 
            this.next.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(25)))), ((int)(((byte)(25)))), ((int)(((byte)(25)))));
            this.next.Dock = System.Windows.Forms.DockStyle.Bottom;
            this.next.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.next.Font = new System.Drawing.Font("Pretendard SemiBold", 21.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.next.ForeColor = System.Drawing.Color.OrangeRed;
            this.next.Location = new System.Drawing.Point(0, 805);
            this.next.Name = "next";
            this.next.Size = new System.Drawing.Size(690, 115);
            this.next.TabIndex = 55;
            this.next.Text = "선택완료";
            this.next.UseVisualStyleBackColor = false;
            this.next.Click += new System.EventHandler(this.next_Click);
            // 
            // disabledtotal
            // 
            this.disabledtotal.AutoSize = true;
            this.disabledtotal.Font = new System.Drawing.Font("Pretendard", 21.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(129)));
            this.disabledtotal.ForeColor = System.Drawing.Color.White;
            this.disabledtotal.Location = new System.Drawing.Point(391, 727);
            this.disabledtotal.Name = "disabledtotal";
            this.disabledtotal.Size = new System.Drawing.Size(34, 35);
            this.disabledtotal.TabIndex = 73;
            this.disabledtotal.Text = "0";
            // 
            // oldtotal
            // 
            this.oldtotal.AutoSize = true;
            this.oldtotal.Font = new System.Drawing.Font("Pretendard", 21.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(129)));
            this.oldtotal.ForeColor = System.Drawing.Color.White;
            this.oldtotal.Location = new System.Drawing.Point(391, 639);
            this.oldtotal.Name = "oldtotal";
            this.oldtotal.Size = new System.Drawing.Size(34, 35);
            this.oldtotal.TabIndex = 72;
            this.oldtotal.Text = "0";
            // 
            // teentotal
            // 
            this.teentotal.AutoSize = true;
            this.teentotal.Font = new System.Drawing.Font("Pretendard", 21.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(129)));
            this.teentotal.ForeColor = System.Drawing.Color.White;
            this.teentotal.Location = new System.Drawing.Point(391, 557);
            this.teentotal.Name = "teentotal";
            this.teentotal.Size = new System.Drawing.Size(34, 35);
            this.teentotal.TabIndex = 71;
            this.teentotal.Text = "0";
            // 
            // adulttotal
            // 
            this.adulttotal.AutoSize = true;
            this.adulttotal.Font = new System.Drawing.Font("Pretendard", 21.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(129)));
            this.adulttotal.ForeColor = System.Drawing.Color.White;
            this.adulttotal.Location = new System.Drawing.Point(391, 473);
            this.adulttotal.Name = "adulttotal";
            this.adulttotal.Size = new System.Drawing.Size(34, 35);
            this.adulttotal.TabIndex = 70;
            this.adulttotal.Text = "0";
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Font = new System.Drawing.Font("Pretendard SemiBold", 20.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(129)));
            this.label7.ForeColor = System.Drawing.Color.White;
            this.label7.Location = new System.Drawing.Point(134, 729);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(84, 33);
            this.label7.TabIndex = 69;
            this.label7.Text = "장애인";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Font = new System.Drawing.Font("Pretendard SemiBold", 20.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(129)));
            this.label4.ForeColor = System.Drawing.Color.White;
            this.label4.Location = new System.Drawing.Point(134, 648);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(84, 33);
            this.label4.TabIndex = 68;
            this.label4.Text = "노약자";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Pretendard SemiBold", 20.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(129)));
            this.label2.ForeColor = System.Drawing.Color.White;
            this.label2.Location = new System.Drawing.Point(134, 566);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(84, 33);
            this.label2.TabIndex = 67;
            this.label2.Text = "청소년";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("Pretendard SemiBold", 20.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(129)));
            this.label3.ForeColor = System.Drawing.Color.White;
            this.label3.Location = new System.Drawing.Point(137, 482);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(79, 33);
            this.label3.TabIndex = 66;
            this.label3.Text = "성   인";
            // 
            // disabledplus
            // 
            this.disabledplus.Font = new System.Drawing.Font("굴림", 18F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(129)));
            this.disabledplus.Location = new System.Drawing.Point(488, 721);
            this.disabledplus.Name = "disabledplus";
            this.disabledplus.Size = new System.Drawing.Size(50, 50);
            this.disabledplus.TabIndex = 65;
            this.disabledplus.Text = "+";
            this.disabledplus.UseVisualStyleBackColor = true;
            this.disabledplus.Click += new System.EventHandler(this.disabledplus_Click_1);
            // 
            // disabledminus
            // 
            this.disabledminus.Font = new System.Drawing.Font("굴림", 18F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(129)));
            this.disabledminus.Location = new System.Drawing.Point(271, 718);
            this.disabledminus.Name = "disabledminus";
            this.disabledminus.Size = new System.Drawing.Size(50, 50);
            this.disabledminus.TabIndex = 64;
            this.disabledminus.Text = "-";
            this.disabledminus.UseVisualStyleBackColor = true;
            this.disabledminus.Click += new System.EventHandler(this.disabledminus_Click_1);
            // 
            // oldplus
            // 
            this.oldplus.Font = new System.Drawing.Font("굴림", 18F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(129)));
            this.oldplus.Location = new System.Drawing.Point(488, 637);
            this.oldplus.Name = "oldplus";
            this.oldplus.Size = new System.Drawing.Size(50, 50);
            this.oldplus.TabIndex = 63;
            this.oldplus.Text = "+";
            this.oldplus.UseVisualStyleBackColor = true;
            this.oldplus.Click += new System.EventHandler(this.oldplus_Click_1);
            // 
            // oldminus
            // 
            this.oldminus.Font = new System.Drawing.Font("굴림", 18F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(129)));
            this.oldminus.Location = new System.Drawing.Point(271, 637);
            this.oldminus.Name = "oldminus";
            this.oldminus.Size = new System.Drawing.Size(50, 50);
            this.oldminus.TabIndex = 62;
            this.oldminus.Text = "-";
            this.oldminus.UseVisualStyleBackColor = true;
            this.oldminus.Click += new System.EventHandler(this.oldminus_Click_1);
            // 
            // teenplus
            // 
            this.teenplus.Font = new System.Drawing.Font("굴림", 18F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(129)));
            this.teenplus.Location = new System.Drawing.Point(488, 555);
            this.teenplus.Name = "teenplus";
            this.teenplus.Size = new System.Drawing.Size(50, 50);
            this.teenplus.TabIndex = 61;
            this.teenplus.Text = "+";
            this.teenplus.UseVisualStyleBackColor = true;
            this.teenplus.Click += new System.EventHandler(this.teenplus_Click_1);
            // 
            // teenminus
            // 
            this.teenminus.Font = new System.Drawing.Font("굴림", 18F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(129)));
            this.teenminus.Location = new System.Drawing.Point(271, 555);
            this.teenminus.Name = "teenminus";
            this.teenminus.Size = new System.Drawing.Size(50, 50);
            this.teenminus.TabIndex = 60;
            this.teenminus.Text = "-";
            this.teenminus.UseVisualStyleBackColor = true;
            this.teenminus.Click += new System.EventHandler(this.teenminus_Click_1);
            // 
            // adultplus
            // 
            this.adultplus.Font = new System.Drawing.Font("굴림", 18F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(129)));
            this.adultplus.Location = new System.Drawing.Point(488, 471);
            this.adultplus.Name = "adultplus";
            this.adultplus.Size = new System.Drawing.Size(50, 50);
            this.adultplus.TabIndex = 59;
            this.adultplus.Text = "+";
            this.adultplus.UseVisualStyleBackColor = true;
            this.adultplus.Click += new System.EventHandler(this.adultplus_Click_1);
            // 
            // adultminus
            // 
            this.adultminus.Font = new System.Drawing.Font("굴림", 18F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(129)));
            this.adultminus.Location = new System.Drawing.Point(271, 471);
            this.adultminus.Name = "adultminus";
            this.adultminus.Size = new System.Drawing.Size(50, 50);
            this.adultminus.TabIndex = 58;
            this.adultminus.Text = "-";
            this.adultminus.UseVisualStyleBackColor = true;
            this.adultminus.Click += new System.EventHandler(this.adultminus_Click_1);
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Font = new System.Drawing.Font("Pretendard SemiBold", 20.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(129)));
            this.label6.ForeColor = System.Drawing.Color.White;
            this.label6.Location = new System.Drawing.Point(238, 413);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(228, 33);
            this.label6.TabIndex = 57;
            this.label6.Text = "인원을 선택해주세요";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Pretendard SemiBold", 20.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.ForeColor = System.Drawing.Color.White;
            this.label1.Location = new System.Drawing.Point(127, 17);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(84, 33);
            this.label1.TabIndex = 4;
            this.label1.Text = "영화명";
            this.label1.Visible = false;
            // 
            // movietheater
            // 
            this.movietheater.AutoSize = true;
            this.movietheater.Font = new System.Drawing.Font("Pretendard SemiBold", 15.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(129)));
            this.movietheater.ForeColor = System.Drawing.Color.White;
            this.movietheater.Location = new System.Drawing.Point(373, 21);
            this.movietheater.Name = "movietheater";
            this.movietheater.Size = new System.Drawing.Size(43, 25);
            this.movietheater.TabIndex = 8;
            this.movietheater.Text = "0관";
            this.movietheater.Visible = false;
            // 
            // movieage
            // 
            this.movieage.AutoSize = true;
            this.movieage.Font = new System.Drawing.Font("Pretendard SemiBold", 15.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(129)));
            this.movieage.ForeColor = System.Drawing.Color.White;
            this.movieage.Location = new System.Drawing.Point(254, 21);
            this.movieage.Name = "movieage";
            this.movieage.Size = new System.Drawing.Size(48, 25);
            this.movieage.TabIndex = 9;
            this.movieage.Text = "연령";
            this.movieage.Visible = false;
            // 
            // starttime
            // 
            this.starttime.AutoSize = true;
            this.starttime.Font = new System.Drawing.Font("Pretendard SemiBold", 15.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(129)));
            this.starttime.ForeColor = System.Drawing.Color.White;
            this.starttime.Location = new System.Drawing.Point(132, 99);
            this.starttime.Name = "starttime";
            this.starttime.Size = new System.Drawing.Size(70, 25);
            this.starttime.TabIndex = 32;
            this.starttime.Text = "00:00";
            this.starttime.Visible = false;
            // 
            // mmovietime
            // 
            this.mmovietime.AutoSize = true;
            this.mmovietime.Font = new System.Drawing.Font("Pretendard SemiBold", 15.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(129)));
            this.mmovietime.ForeColor = System.Drawing.Color.White;
            this.mmovietime.Location = new System.Drawing.Point(132, 64);
            this.mmovietime.Name = "mmovietime";
            this.mmovietime.Size = new System.Drawing.Size(70, 25);
            this.mmovietime.TabIndex = 33;
            this.mmovietime.Text = "00:00";
            this.mmovietime.Visible = false;
            // 
            // panel4
            // 
            this.panel4.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(40)))), ((int)(((byte)(40)))), ((int)(((byte)(40)))));
            this.panel4.Controls.Add(this.label8);
            this.panel4.Controls.Add(this.label5);
            this.panel4.Controls.Add(this.checklastseat);
            this.panel4.Controls.Add(this.choice);
            this.panel4.Controls.Add(this.mmovietime);
            this.panel4.Controls.Add(this.starttime);
            this.panel4.Controls.Add(this.movieage);
            this.panel4.Controls.Add(this.movietheater);
            this.panel4.Controls.Add(this.label1);
            this.panel4.Controls.Add(this.pictureBox5);
            this.panel4.Location = new System.Drawing.Point(0, 245);
            this.panel4.Name = "panel4";
            this.panel4.Size = new System.Drawing.Size(690, 141);
            this.panel4.TabIndex = 56;
            // 
            // label8
            // 
            this.label8.AutoSize = true;
            this.label8.Font = new System.Drawing.Font("Pretendard SemiBold", 15.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label8.ForeColor = System.Drawing.Color.White;
            this.label8.Location = new System.Drawing.Point(495, 98);
            this.label8.Name = "label8";
            this.label8.Size = new System.Drawing.Size(118, 25);
            this.label8.TabIndex = 37;
            this.label8.Text = "선택된 인원 :";
            this.label8.Visible = false;
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Font = new System.Drawing.Font("Pretendard SemiBold", 15.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label5.ForeColor = System.Drawing.Color.White;
            this.label5.Location = new System.Drawing.Point(495, 61);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(118, 25);
            this.label5.TabIndex = 36;
            this.label5.Text = "남은좌석 수 :";
            this.label5.Visible = false;
            // 
            // checklastseat
            // 
            this.checklastseat.AutoSize = true;
            this.checklastseat.Font = new System.Drawing.Font("Pretendard", 18F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(129)));
            this.checklastseat.ForeColor = System.Drawing.Color.White;
            this.checklastseat.Location = new System.Drawing.Point(619, 60);
            this.checklastseat.Name = "checklastseat";
            this.checklastseat.Size = new System.Drawing.Size(29, 29);
            this.checklastseat.TabIndex = 35;
            this.checklastseat.Text = "0";
            this.checklastseat.Visible = false;
            // 
            // choice
            // 
            this.choice.AutoSize = true;
            this.choice.Font = new System.Drawing.Font("Pretendard", 18F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(129)));
            this.choice.ForeColor = System.Drawing.Color.White;
            this.choice.Location = new System.Drawing.Point(619, 95);
            this.choice.Name = "choice";
            this.choice.Size = new System.Drawing.Size(29, 29);
            this.choice.TabIndex = 34;
            this.choice.Text = "0";
            this.choice.Visible = false;
            // 
            // home
            // 
            this.home.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(25)))), ((int)(((byte)(25)))), ((int)(((byte)(25)))));
            this.home.BackgroundImage = global::c_project.Properties.Resources.home;
            this.home.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.home.FlatAppearance.BorderSize = 0;
            this.home.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.home.Location = new System.Drawing.Point(604, 836);
            this.home.Name = "home";
            this.home.Size = new System.Drawing.Size(56, 56);
            this.home.TabIndex = 49;
            this.home.UseVisualStyleBackColor = false;
            this.home.Click += new System.EventHandler(this.home_Click);
            // 
            // pictureBox1
            // 
            this.pictureBox1.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.pictureBox1.Image = global::c_project.Properties.Resources.back2;
            this.pictureBox1.Location = new System.Drawing.Point(29, 836);
            this.pictureBox1.Name = "pictureBox1";
            this.pictureBox1.Size = new System.Drawing.Size(56, 56);
            this.pictureBox1.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pictureBox1.TabIndex = 48;
            this.pictureBox1.TabStop = false;
            this.pictureBox1.Click += new System.EventHandler(this.pictureBox1_Click);
            // 
            // pictureBox5
            // 
            this.pictureBox5.Image = ((System.Drawing.Image)(resources.GetObject("pictureBox5.Image")));
            this.pictureBox5.Location = new System.Drawing.Point(0, 0);
            this.pictureBox5.Name = "pictureBox5";
            this.pictureBox5.Size = new System.Drawing.Size(106, 141);
            this.pictureBox5.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pictureBox5.TabIndex = 28;
            this.pictureBox5.TabStop = false;
            this.pictureBox5.Visible = false;
            // 
            // MovieSeat1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(25)))), ((int)(((byte)(25)))), ((int)(((byte)(25)))));
            this.ClientSize = new System.Drawing.Size(690, 920);
            this.Controls.Add(this.home);
            this.Controls.Add(this.disabledtotal);
            this.Controls.Add(this.oldtotal);
            this.Controls.Add(this.teentotal);
            this.Controls.Add(this.adulttotal);
            this.Controls.Add(this.label7);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.disabledplus);
            this.Controls.Add(this.disabledminus);
            this.Controls.Add(this.oldplus);
            this.Controls.Add(this.oldminus);
            this.Controls.Add(this.teenplus);
            this.Controls.Add(this.teenminus);
            this.Controls.Add(this.adultplus);
            this.Controls.Add(this.adultminus);
            this.Controls.Add(this.label6);
            this.Controls.Add(this.pictureBox1);
            this.Controls.Add(this.moviename);
            this.Controls.Add(this.Time);
            this.Controls.Add(this.panel4);
            this.Controls.Add(this.next);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            this.Name = "MovieSeat1";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "MovieSeat1";
            this.panel4.ResumeLayout(false);
            this.panel4.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox5)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label time1;
        private System.Windows.Forms.Label Time;
        private System.Windows.Forms.Label moviename;
        private System.Windows.Forms.PictureBox pictureBox1;
        private System.Windows.Forms.Timer timer1;
        private System.Windows.Forms.Button home;
        private System.Windows.Forms.Button next;
        private System.Windows.Forms.Label disabledtotal;
        private System.Windows.Forms.Label oldtotal;
        private System.Windows.Forms.Label teentotal;
        private System.Windows.Forms.Label adulttotal;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Button disabledplus;
        private System.Windows.Forms.Button disabledminus;
        private System.Windows.Forms.Button oldplus;
        private System.Windows.Forms.Button oldminus;
        private System.Windows.Forms.Button teenplus;
        private System.Windows.Forms.Button teenminus;
        private System.Windows.Forms.Button adultplus;
        private System.Windows.Forms.Button adultminus;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label movietheater;
        private System.Windows.Forms.Label movieage;
        private System.Windows.Forms.PictureBox pictureBox5;
        private System.Windows.Forms.Label starttime;
        private System.Windows.Forms.Label mmovietime;
        private System.Windows.Forms.Panel panel4;
        private System.Windows.Forms.Label label8;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label checklastseat;
        private System.Windows.Forms.Label choice;
    }
}