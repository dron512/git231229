using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace project_nanibono.word
{
    public partial class WordSearch : UserControl
    {
        public event EventHandler SearchButtonClicked;
        //private FormMain formMain;

        public WordSearch()
        {
            InitializeComponent();
        }
        private void searchButton_Click(object sender, EventArgs e)
        {
            OnSearchButtonClicked(EventArgs.Empty);
            /*formMain = new FormMain();
            formMain.ShowPanelAndControl2();*/
        }

        protected virtual void OnSearchButtonClicked(EventArgs e)
        {
            SearchButtonClicked?.Invoke(this, e);
        }

    }
}
