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
    public partial class Display: UserControl
    {

        public List<BarModel> EqualizerBars;

        public struct BarModel{
            public Label BarName { get; set; }

            public VerticalBar Bar { get; set; }
        }

        public Color BorderColor { get; set; }


        private FrequencyGenerator generator;


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

        private void pictureBox1_Click(object sender, EventArgs e)
        {

        }

        private void panel1_Paint(object sender, PaintEventArgs e)
        {
            ControlPaint.DrawBorder(e.Graphics, this.ClientRectangle, BorderColor, ButtonBorderStyle.Solid);
        }

        public void SetBorderColor(Color color)
        {
            BorderColor = color;
            Invalidate();
        }

        private void UserControl1_SizeChanged(object sender, EventArgs e)
        {
            foreach(var bar in EqualizerBars)
            {
                bar.Bar.Invalidate();
            }
            VolumeBar.Invalidate();
            BassBar.Invalidate();
        }

        public void SetBackgroundColor(Color colorValue)
        {
            BackColor = colorValue;
        }

        public void SetBarColor(Color colorValue)
        {
            foreach(var bar in EqualizerBars)
            {
                bar.Bar.SetBackground(colorValue);
            }

            BassBar.SetBackground(colorValue);
            VolumeBar.SetBackground(colorValue);
        }

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
