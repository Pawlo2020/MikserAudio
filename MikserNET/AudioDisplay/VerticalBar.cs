using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace AudioDisplay
{
    public partial class VerticalBar : UserControl
    {

        int _value;

        public VerticalBar()
        {
            InitializeComponent();
        }

        protected override void OnPaint(PaintEventArgs e)
        {
            Brush brush = new SolidBrush(Color.White);

            var value = 100 - _value;

            e.Graphics.FillRectangle(brush, new RectangleF(0,0,Size.Width,(Size.Height*value)/100));
        }

        public void SetValue(int value)
        {
            _value = value;
            Invalidate();
        }

        public void SetBackground(Color color)
        {
            BackColor = color;
            Invalidate();
        }  
    }
}
