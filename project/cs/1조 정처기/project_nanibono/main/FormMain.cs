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
            
            wordSearchResult1.Visible = false;  // 단어검색결과 사용자 정의 컨트롤 숨기기
            menuPanel.Visible = false;          // 메뉴패널 숨기기

            // 단어검색 사용자 정의 컨트롤
            Controls.Add(wordSearch);               // 컨트롤에 삽입
            wordSearch.Visible = true;              // 단어검색 사용자 정의 컨트롤 보이게 하기
            wordSearch.Location = new Point(0, 54); // 보여줄 장소 조정해주기

            // 단어검색 사용자 정의 컨트롤 버튼 클릭 이벤트
            wordSearch.SearchButtonClicked += wordSearch1_SearchButtonClicked;
        }

        public void ShowPanelAndControl2()
        {
            wordSearch.Visible = false;       // 사용자 정의 컨트롤1 보이기
            menuPanel.Visible = true;         // 패널 보이기
            wordSearchResult1.Visible = true; // 사용자 정의 컨트롤2 보이기
        }

        private void wordSearch1_SearchButtonClicked(object sender, EventArgs e)
        {
            ShowPanelAndControl2(); // 검색 버튼을 클릭하면 패널과 사용자 정의 컨트롤2를 보여줌
        }

        #region 공백
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
                MessageBox.Show("검색되는 결과가 없습니다.");
            }*/
            // + 메인창 숨기기 


            // 1. 용어가 database의 word Table 속 word attribute에 존재할 경우
            // 2. 존재하지 않을 경우  

            //  FormResult의 label1에 해당 word를 가져오고
            //  FormResult의 label2에 word Table 속 world_MEAN을 가져온다. 

            //         string searchTerm = searchBox.Text;
            //      if ((searchTerm)) // 용어가 있을때
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
