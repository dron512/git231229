using System.Windows.Forms;
using WinFormsApp6.aaa;
using static System.Windows.Forms.VisualStyles.VisualStyleElement;

namespace WinFormsApp6
{
    public class Person
    {
        public string Name { get; set; }
        public int Age { get; set; }
        public string Address { get; set; }
    }
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
            //ListView listView = new ListView();

            listView1.Dock = DockStyle.Fill;
            listView1.View = View.Details; // View를 Details로 설정하여 열 헤더를 사용

            listView1.Columns.Add("Name", 100);
            listView1.Columns.Add("Age", 50);
            listView1.Columns.Add("Address", 150);

            // Person 객체 추가
            Person person1 = new Person { Name = "John", Age = 30, Address = "123 Main St" };
            ListViewItem item1 = new ListViewItem(person1.Name);
            item1.SubItems.Add(person1.Age.ToString());
            item1.SubItems.Add(person1.Address);
            listView1.Items.Add(item1);

            Person person2 = new Person { Name = "Alice", Age = 25, Address = "456 Elm St" };
            ListViewItem item2 = new ListViewItem(person2.Name);
            item2.SubItems.Add(person2.Age.ToString());
            item2.SubItems.Add(person2.Address);
            listView1.Items.Add(item2);

            // 폼에 ListView 추가
            //Controls.Add(listView1);
        }

        private void button1_Click(object sender, EventArgs e)
        {
            Hide();
            MessageBox.Show("form2");
            Form2 frm2 = new Form2();
            frm2.Show();
            //new Form2().Show();
            Show();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            Hide();
            MessageBox.Show("form3");
            Form3 frm3 = new Form3();
            frm3.ShowDialog();
            //new Form3().ShowDialog();
            Show();
        }
    }
}
