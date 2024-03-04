using System;

namespace mdiproject.todo
{
    public class Todo
    {
        public int idx { get; set; }
        public int user_idx { get; set; }
        public string title { get; set; }
        public string content { get; set; }
        public DateTime finishdate { get; set; }
    }
}
