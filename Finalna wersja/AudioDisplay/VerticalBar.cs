using System.Drawing;
using System.Windows.Forms;

namespace AudioDisplay
{
    /// <summary>
    /// Programowa reprezentacja pojedynczego słupka dla miksera audio
    /// </summary>
    public partial class VerticalBar : UserControl
    {
        /// <summary>
        /// Składowa prywatna - aktualna wartość słupka
        /// </summary>
         int Value { get; set; }

        /// <summary>
        /// Inicjalizacja słupka
        /// </summary>
        public VerticalBar()
        {
            InitializeComponent();
        }

        /// <summary>
        /// Zdarzenie rysowania palety graficznej
        /// </summary>
        protected override void OnPaint(PaintEventArgs e)
        {
            Brush brush = new SolidBrush(Color.White);

            var value = 100 - Value;

            e.Graphics.FillRectangle(brush, new RectangleF(0,0,Size.Width,(Size.Height*value)/100));
        }

        /// <summary>
        /// Metoda odpowiedzialna za ustawienie wartości słupka
        /// </summary>
        public void SetValue(int newValue)
        {
            Value = newValue;
            Invalidate();
        }

        /// <summary>
        /// Metoda odpowiedzialna za ustawienie koloru tła słupka
        /// </summary>
        public void SetBackground(Color color)
        {
            BackColor = color;
            Invalidate();
        }  
    }
}