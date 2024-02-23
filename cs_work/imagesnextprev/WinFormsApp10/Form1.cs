namespace WinFormsApp10
{
    public partial class Form1 : Form
    {
        private string[] imagePaths;
        private int currentIndex = 0; //��� ���� �ʱ�ȭ

        public Form1()
        {
            InitializeComponent();
            LoadImagesFromFolder(@"D:\����\�ڵ帮��\24-02-22\YourFolderPath"); // ���⿡ ���� ��θ� �����մϴ�.
            DisplayImage();
        }
        private void LoadImagesFromFolder(string folderPath)
        {
            imagePaths = Directory.GetFiles(folderPath, "*.jpg");//���� �ȿ� jpg���ϸ��� �˻��� �� �ְ� �����ش�.
        }
        //-----�̹����� ���Ͽ��� �ҷ� �� �� �ֵ��� -----
        private void DisplayImage()
        {
            pictureBox1.Image = Image.FromFile(imagePaths[currentIndex]); //�̹����� �������� �Ѵ�. 
        }

   //----���� ��ư Ŭ������ �� ���� �̹����� �����Բ� -------
        private void Next_Click(object sender, EventArgs e)
        {
            if (currentIndex < imagePaths.Length - 1)
            {
                currentIndex++;
                DisplayImage();
            }

        }
        //------ ���� ��ư Ŭ������ �� ���� �̹����� �����Բ�----
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
