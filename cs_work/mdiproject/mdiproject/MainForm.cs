using mdiproject.test;
using mdiproject.todo;
using mdiproject.user;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace mdiproject
{
    public partial class MainForm : Form
    {
        public MainForm()
        {
            InitializeComponent();
            this.IsMdiContainer = true;
        }

        private void 사용자관리ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            UserForm userForm = UserForm.getInstance();
            userForm.MdiParent = this;
            userForm.Show();
        }

        private void 할일관리ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            TodoForm todoForm = TodoForm.getInstance();
            todoForm.MdiParent = this;
            todoForm.Show();
        }

        private void 종료ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Dispose();
        }

        private void 테스트ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            TestForm testForm = TestForm.getInstance();
            testForm.MdiParent = this;
            testForm.Show();
        }
    }
}
