using System;
using System.IO;

namespace ex0220_File_입출력.file
{
    public class FileControl
    {
        string filepath = "data.txt";

        public void write(string text)
        {
            Console.WriteLine($"write {text}");
            File.WriteAllText(filepath, text);
        }

        public void read()
        {
            Console.WriteLine("read");
            string text = File.ReadAllText(filepath);
            Console.WriteLine($"text = {text}");
        }
    }
}
