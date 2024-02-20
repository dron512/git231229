using System;
using System.Collections.Generic;
using System.IO;

namespace ex0220_File_입출력.file
{
    public class FileControl
    {
        string filepath = "data.txt";

        public void write(string text, List<string> list)
        {
            //Console.WriteLine($"write {text}");
            //File.WriteAllText(filepath, text);
            foreach (var item in list)
            {
                Console.WriteLine(item);
            }
            File.WriteAllLines(filepath, list);
        }

        public List<string> read()
        {
            List<string> list = new List<string>(File.ReadAllLines(filepath));
            return list;
            //Console.WriteLine("read");
            //string text = File.ReadAllText(filepath);
            //Console.WriteLine($"text = {text}");
        }
    }
}
