namespace project_nanibono.main
{
    partial class FormAdminMain
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
            panel1 = new Panel();
            SidePanel = new Panel();
            button_request = new Button();
            button_word = new Button();
            button_user = new Button();
            button1 = new Button();
            adminRequestManagement1 = new request.AdminRequestManagement();
            adminMemberManagement1 = new request.AdminMemberManagement();
            adminWordManagement1 = new word.AdminWordManagement();
            panel1.SuspendLayout();
            SuspendLayout();
            // 
            // panel1
            // 
            panel1.BackColor = Color.FromArgb(224, 244, 255);
            panel1.Controls.Add(SidePanel);
            panel1.Controls.Add(button_request);
            panel1.Controls.Add(button_word);
            panel1.Controls.Add(button_user);
            panel1.Controls.Add(button1);
            panel1.Dock = DockStyle.Left;
            panel1.Location = new Point(0, 0);
            panel1.Name = "panel1";
            panel1.Size = new Size(140, 450);
            panel1.TabIndex = 0;
            // 
            // SidePanel
            // 
            SidePanel.BackColor = Color.FromArgb(57, 167, 255);
            SidePanel.Location = new Point(0, 66);
            SidePanel.Name = "SidePanel";
            SidePanel.Size = new Size(7, 43);
            SidePanel.TabIndex = 1;
            // 
            // button_request
            // 
            button_request.FlatAppearance.BorderSize = 0;
            button_request.FlatStyle = FlatStyle.Flat;
            button_request.Font = new Font("휴먼둥근헤드라인", 11.25F);
            button_request.ForeColor = Color.FromArgb(135, 196, 255);
            button_request.Location = new Point(0, 158);
            button_request.Name = "button_request";
            button_request.Size = new Size(140, 43);
            button_request.TabIndex = 3;
            button_request.Text = "⋆⁺₊⋆요청관리⋆⁺₊⋆";
            button_request.UseVisualStyleBackColor = true;
            button_request.Click += button_Click;
            // 
            // button_word
            // 
            button_word.FlatAppearance.BorderSize = 0;
            button_word.FlatStyle = FlatStyle.Flat;
            button_word.Font = new Font("휴먼둥근헤드라인", 11.25F);
            button_word.ForeColor = Color.FromArgb(135, 196, 255);
            button_word.Location = new Point(0, 111);
            button_word.Name = "button_word";
            button_word.Size = new Size(140, 43);
            button_word.TabIndex = 2;
            button_word.Text = "⋆⁺₊⋆단어관리⋆⁺₊⋆";
            button_word.UseVisualStyleBackColor = true;
            button_word.Click += button_Click;
            // 
            // button_user
            // 
            button_user.FlatAppearance.BorderSize = 0;
            button_user.FlatStyle = FlatStyle.Flat;
            button_user.Font = new Font("휴먼둥근헤드라인", 11.25F);
            button_user.ForeColor = Color.FromArgb(135, 196, 255);
            button_user.Location = new Point(0, 66);
            button_user.Name = "button_user";
            button_user.Size = new Size(140, 43);
            button_user.TabIndex = 1;
            button_user.Text = "⋆⁺₊⋆회원관리⋆⁺₊⋆";
            button_user.UseVisualStyleBackColor = true;
            button_user.Click += button_Click;
            // 
            // button1
            // 
            button1.BackColor = Color.Transparent;
            button1.FlatAppearance.BorderSize = 0;
            button1.FlatStyle = FlatStyle.Flat;
            button1.Font = new Font("휴먼둥근헤드라인", 11.25F, FontStyle.Regular, GraphicsUnit.Point, 129);
            button1.ForeColor = Color.FromArgb(57, 167, 255);
            button1.Image = Properties.Resources.bnonono_smll_smll;
            button1.Location = new Point(0, 0);
            button1.Name = "button1";
            button1.Size = new Size(140, 58);
            button1.TabIndex = 1;
            button1.Text = "먼시험보노 관 리 자";
            button1.TextImageRelation = TextImageRelation.ImageBeforeText;
            button1.UseVisualStyleBackColor = false;
            button1.Click += button_Click;
            // 
            // adminRequestManagement1
            // 
            adminRequestManagement1.BackColor = SystemColors.ControlLightLight;
            adminRequestManagement1.Location = new Point(142, 0);
            adminRequestManagement1.Name = "adminRequestManagement1";
            adminRequestManagement1.Size = new Size(655, 450);
            adminRequestManagement1.TabIndex = 1;
            // 
            // adminMemberManagement1
            // 
            adminMemberManagement1.BackColor = SystemColors.ButtonHighlight;
            adminMemberManagement1.Location = new Point(142, 0);
            adminMemberManagement1.Name = "adminMemberManagement1";
            adminMemberManagement1.Size = new Size(655, 450);
            adminMemberManagement1.TabIndex = 4;
            // 
            // adminWordManagement1
            // 
            adminWordManagement1.BackColor = SystemColors.ButtonHighlight;
            adminWordManagement1.Location = new Point(142, 0);
            adminWordManagement1.Name = "adminWordManagement1";
            adminWordManagement1.Size = new Size(655, 450);
            adminWordManagement1.TabIndex = 4;
            // 
            // FormAdminMain
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            BackColor = SystemColors.ControlLightLight;
            ClientSize = new Size(800, 450);
            Controls.Add(adminWordManagement1);
            Controls.Add(adminMemberManagement1);
            Controls.Add(adminRequestManagement1);
            Controls.Add(panel1);
            Name = "FormAdminMain";
            Text = "FormAdminMain";
            panel1.ResumeLayout(false);
            ResumeLayout(false);
        }

        #endregion

        private Panel panel1;
        private Button button1;
        private Button button_request;
        private Button button_word;
        private Button button_user;
        private Panel SidePanel;
        private request.AdminRequestManagement adminRequestManagement1;
        private request.AdminMemberManagement adminMemberManagement1;
        private word.AdminWordManagement adminWordManagement1;
    }
}