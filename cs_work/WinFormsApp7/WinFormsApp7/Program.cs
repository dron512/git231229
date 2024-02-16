namespace WinFormsApp7
{
    class Animal
    {
        // ���� �޼���� ����
        public virtual void MakeSound()
        {
            Console.WriteLine("������ �Ҹ��� ���� �ֽ��ϴ�.");
        }
    }
    class Dog : Animal
    {
        // �θ� Ŭ������ ���� �޼��带 �������̵�
        public new void MakeSound()
        {
            Console.WriteLine("�۸�");
        }
    }

    // ����� Ŭ����
    class Cat : Animal
    {
        // �θ� Ŭ������ ���� �޼��带 �������̵�
        public override void MakeSound()
        {
            Console.WriteLine("�߿�");
        }
    }

    internal static class Program
    {
        /// <summary>
        ///  The main entry point for the application.
        /// </summary>
        [STAThread]
        static void Main()
        {
            // To customize application configuration such as set high DPI settings or default font,
            // see https://aka.ms/applicationconfiguration.
            ApplicationConfiguration.Initialize();
            Application.Run(new Form1());

            
        }
    }
}