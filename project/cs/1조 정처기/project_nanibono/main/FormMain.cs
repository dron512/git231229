using Oracle.ManagedDataAccess.Client;
using project_nanibono.word;

namespace project_nanibono
{
    public partial class FormMain : Form
    {
        private WordSearch wordSearch = new WordSearch();

        public FormMain()
        {
            InitializeComponent();
            
            wordSearchResult1.Visible = false;  // �ܾ�˻���� ����� ���� ��Ʈ�� �����
            menuPanel.Visible = false;          // �޴��г� �����

            // �ܾ�˻� ����� ���� ��Ʈ��
            Controls.Add(wordSearch);               // ��Ʈ�ѿ� ����
            wordSearch.Visible = true;              // �ܾ�˻� ����� ���� ��Ʈ�� ���̰� �ϱ�
            wordSearch.Location = new Point(0, 54); // ������ ��� �������ֱ�

            // �ܾ�˻� ����� ���� ��Ʈ�� ��ư Ŭ�� �̺�Ʈ
            wordSearch.SearchButtonClicked += wordSearch1_SearchButtonClicked;
        }

        public void ShowPanelAndControl2()
        {
            wordSearch.Visible = false;       // ����� ���� ��Ʈ��1 ���̱�
            menuPanel.Visible = true;         // �г� ���̱�
            wordSearchResult1.Visible = true; // ����� ���� ��Ʈ��2 ���̱�
        }

        private void wordSearch1_SearchButtonClicked(object sender, EventArgs e)
        {
            ShowPanelAndControl2(); // �˻� ��ư�� Ŭ���ϸ� �гΰ� ����� ���� ��Ʈ��2�� ������
        }

        #region ����
        private void searchTerm_Click(object sender, EventArgs e)
        {

            /*WordDB wordDB = new WordDB();
            Word result = wordDB.SelectWord(searchBox.Text);

            if (result != null) { 
                Hide();
                new FormResult(result).ShowDialog();
                Show();
            }
            else
            {
                MessageBox.Show("�˻��Ǵ� ����� �����ϴ�.");
            }*/
            // + ����â ����� 


            // 1. �� database�� word Table �� word attribute�� ������ ���
            // 2. �������� ���� ���  

            //  FormResult�� label1�� �ش� word�� ��������
            //  FormResult�� label2�� word Table �� world_MEAN�� �����´�. 

            //         string searchTerm = searchBox.Text;
            //      if ((searchTerm)) // �� ������
            //       {
            //         Search(searchTerm);
            //       FormResult formResult = new FormResult();
            //     formResult.Show();
            //   this.Hide();
            //       }
        }
        #endregion
    }
}
