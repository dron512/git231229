namespace WinFormsApp7
{
    class Animal
    {
        // 가상 메서드로 선언
        public virtual void MakeSound()
        {
            Console.WriteLine("동물이 소리를 내고 있습니다.");
        }
    }
    class Dog : Animal
    {
        // 부모 클래스의 가상 메서드를 오버라이딩
        public new void MakeSound()
        {
            Console.WriteLine("멍멍");
        }
    }

    // 고양이 클래스
    class Cat : Animal
    {
        // 부모 클래스의 가상 메서드를 오버라이딩
        public override void MakeSound()
        {
            Console.WriteLine("야옹");
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