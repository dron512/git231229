using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace mdiproject.user
{
    public partial class UserForm : Form
    {
        private static UserForm instance = null;

        public static UserForm getInstance()
        {
            if (instance == null || instance.IsDisposed) {
                instance = new UserForm();
                return instance;
            }
            else
            {
                return instance;
            }
        }

        public UserForm()
        {
            InitializeComponent();
        }
    }
}
