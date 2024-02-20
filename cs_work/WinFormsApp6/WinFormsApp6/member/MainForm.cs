﻿using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WinFormsApp6.member
{
    public partial class MainForm : Form
    {
        public MainForm(string id, string password)
        {
            InitializeComponent();

            label1.Text = id;
            label2.Text = password;

            Button btn = userControl11.GetButton();
            btn.Click += Btn_Click;
        }

        private void Btn_Click(object? sender, EventArgs e)
        {
            Console.WriteLine( "테스트");
        }

        private void button1_Click(object sender, EventArgs e)
        {
            userControl11.BringToFront();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            userControl21.BringToFront();
        }
    }
}
