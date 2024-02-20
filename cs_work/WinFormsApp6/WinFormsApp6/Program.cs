using WinFormsApp6.member;

namespace WinFormsApp6
{
    internal static class Program
    {
        [STAThread]
        static void Main()
        {
            ApplicationConfiguration.Initialize();
            Application.Run(new MainForm("Å×½ºÆ®","1234"));
        }
    }
}