using System;
using System.Collections.Generic;
using System.Drawing;
using System.Windows.Forms;

namespace AudioDisplay
{
    /// <summary>
    /// Programowa reprezentacja wyświetlacza do miksera audio
    /// </summary>
    public partial class Display: UserControl
    {
        /// <summary>
        /// Lista przechowująca słupki
        /// </summary>
        public List<BarModel> EqualizerBars { get; set; }

        /// <summary>
        /// Obiektowy model słupka
        /// </summary>
        public struct BarModel{
            //Właściwość słupka - label (nazwa)
            public Label BarName { get; set; }

            //Właściwość słupka - kształt
            public VerticalBar Bar { get; set; }
        }

        /// <summary>
        /// Właściwość koloru tła
        /// </summary>
        public Color BorderColor { get; set; }

        /// <summary>
        /// Generator częstotliwości
        /// </summary>
        private FrequencyGenerator generator;

        /// <summary>
        /// Inicjalizuje komponent miksera audio oraz przypisuje słupki z wartościami częstotliwości
        /// </summary>
        public Display()
        {
            generator = new FrequencyGenerator();
            InitializeComponent();

            EqualizerBars = new List<BarModel>() { new BarModel { Bar = Freq1, BarName = LFreq1 } ,
                                                   new BarModel { Bar = Freq2, BarName = LFreq2 },
                                                   new BarModel { Bar = Freq3, BarName = LFreq3 },
                                                   new BarModel { Bar = Freq4, BarName = LFreq4 },
                                                   new BarModel { Bar = Freq5, BarName = LFreq5 },
                                                   new BarModel { Bar = Freq6, BarName = LFreq6 },
                                                   new BarModel { Bar = Freq7, BarName = LFreq7 },
                                                   new BarModel { Bar = Freq8, BarName = LFreq8 },
                                                   new BarModel { Bar = Freq9, BarName = LFreq9 },
                                                   new BarModel { Bar = Freq10, BarName = LFreq10 } };
            BassBar.SetValue(50);

            Freq9.SetValue(50);
        }

        /// <summary>
        /// Zdarzenie obsługujące przerysowanie komponentu wraz z określonym kolorem ramki
        /// </summary>
        private void MixerPaint(object sender, PaintEventArgs e)
        {
            ControlPaint.DrawBorder(e.Graphics, this.ClientRectangle, BorderColor, ButtonBorderStyle.Solid);
        }

        /// <summary>
        /// Metoda odpowiedzialna za zmianę tła obramowania komponentu
        /// </summary>
        public void SetBorderColor(Color color)
        {
            BorderColor = color;
            Invalidate();
        }

        /// <summary>
        /// Zdarzenie odpowiedzialne za zmianę rozmiaru miksera audio
        /// </summary>
        private void MixerSizeChanged(object sender, EventArgs e)
        {
            foreach(var bar in EqualizerBars)
            {
                bar.Bar.Invalidate();
            }
            VolumeBar.Invalidate();
            BassBar.Invalidate();
        }

        /// <summary>
        /// Metoda odpowiedzialna za zmianę koloru tła miksera audio
        /// </summary>
        public void SetBackgroundColor(Color colorValue)
        {
            BackColor = colorValue;
        }

        /// <summary>
        /// Metoda odpowiedzialna za zmianę koloru tła miksera audio
        /// </summary>
        public void SetBarColor(Color colorValue)
        {
            foreach(var bar in EqualizerBars)
            {
                bar.Bar.SetBackground(colorValue);
            }

            BassBar.SetBackground(colorValue);
            VolumeBar.SetBackground(colorValue);
        }

        /// <summary>
        /// Metoda odpowiedzialna za zmianę liczby słupków miksera audio
        /// </summary>
        public void UpdateNumberOfBars(int v)
        {
            List<string> frequencyList = new List<string>();

            switch (v)
            {
                case 4:
                    frequencyList = generator.FrequencyFour();
                     break;
                case 5:
                    frequencyList = generator.FrequencyFive();
                    break;
                case 6:
                    frequencyList = generator.FrequencySix();
                    break;
                case 7:
                    frequencyList = generator.FrequencySeven();
                    break;
                case 8:
                    frequencyList = generator.FrequencyEight();
                    break;
                case 9:
                    frequencyList = generator.FrequencyNine();
                    break;
                case 10:
                    frequencyList = generator.FrequencyTen();
                    break;
            }

            for (int i =0; i<EqualizerBars.Count; ++i)
            {
                if (i < v)
                {
                    EqualizerBars[i].Bar.Visible = true;
                    EqualizerBars[i].BarName.Visible = true;

                    EqualizerBars[i].BarName.Text = frequencyList[i];
                }
                else
                {
                    EqualizerBars[i].Bar.Visible = false;
                    EqualizerBars[i].BarName.Visible = false;
                }
            }
        }
    }
}