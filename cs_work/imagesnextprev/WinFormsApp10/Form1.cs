namespace WinFormsApp10
{
    public partial class Form1 : Form
    {
        private string[] imagePaths;
        private int currentIndex = 0; //멤버 변수 초기화

        public Form1()
        {
            InitializeComponent();
            LoadImagesFromFolder(@"D:\공유\코드리뷰\24-02-22\YourFolderPath"); // 여기에 폴더 경로를 지정합니다.
            DisplayImage();
        }
        private void LoadImagesFromFolder(string folderPath)
        {
            imagePaths = Directory.GetFiles(folderPath, "*.jpg");//폴더 안에 jpg파일만을 검색할 수 있게 도와준다.
        }
        //-----이미지를 파일에서 불러 올 수 있도록 -----
        private void DisplayImage()
        {
            pictureBox1.Image = Image.FromFile(imagePaths[currentIndex]); //이미지를 보여지게 한다. 
        }

   //----다음 버튼 클릭했을 때 다음 이미지가 나오게끔 -------
        private void Next_Click(object sender, EventArgs e)
        {
            if (currentIndex < imagePaths.Length - 1)
            {
                currentIndex++;
                DisplayImage();
            }

        }
        //------ 이전 버튼 클리했을 때 전의 이미지가 나오게끔----
        private void Previous_Click(object sender, EventArgs e)
        {
            if (currentIndex > 0)
            {
                currentIndex--;
                DisplayImage();
            }
        }
    }
}
