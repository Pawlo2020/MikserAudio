using System;
using System.Collections.Generic;
using System.Windows.Forms;

namespace AudioMixer
{
    public partial class EqualizerWindow : Form
    {
        struct FrequencyChanger{
            public Label FrequencyLabel { get; set; }

            public TrackBar FrequencyScroll { get; set; }
        }

        AudioDisplay.Display _display;

        List<FrequencyChanger> FreqChangerList;

        AudioDisplay.FrequencyGenerator generator;

        public EqualizerWindow(int barsNumber, AudioDisplay.Display display)
        {
            generator = new AudioDisplay.FrequencyGenerator();

            _display = display;

            InitializeComponent();

            FreqChangerList = new List<FrequencyChanger> { new FrequencyChanger { FrequencyLabel = LFreq1, FrequencyScroll = Freq1},
                                                           new FrequencyChanger { FrequencyLabel = LFreq2, FrequencyScroll = Freq2},
                                                           new FrequencyChanger { FrequencyLabel = LFreq3, FrequencyScroll = Freq3},
                                                           new FrequencyChanger { FrequencyLabel = LFreq4, FrequencyScroll = Freq4},
                                                           new FrequencyChanger { FrequencyLabel = LFreq5, FrequencyScroll = Freq5},
                                                           new FrequencyChanger { FrequencyLabel = LFreq6, FrequencyScroll = Freq6},
                                                           new FrequencyChanger { FrequencyLabel = LFreq7, FrequencyScroll = Freq7},
                                                           new FrequencyChanger { FrequencyLabel = LFreq8, FrequencyScroll = Freq8},
                                                           new FrequencyChanger { FrequencyLabel = LFreq9, FrequencyScroll = Freq9},
                                                           new FrequencyChanger { FrequencyLabel = LFreq10, FrequencyScroll = Freq10}};

            for (int i = 0; i < barsNumber; i++)
            {
                List<string> frequencyList = new List<string>();

                switch (barsNumber)
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



                FreqChangerList[i].FrequencyLabel.Visible = true;
                FreqChangerList[i].FrequencyLabel.Text = frequencyList[i];

                FreqChangerList[i].FrequencyScroll.Visible = true;
            }
        }

        private void Freq1_Scroll(object sender, EventArgs e)
        {
            _display.EqualizerBars[0].Bar.SetValue(Freq1.Value);
        }

        private void Freq2_Scroll(object sender, EventArgs e)
        {
            _display.EqualizerBars[1].Bar.SetValue(Freq2.Value);
        }

        private void Freq3_Scroll(object sender, EventArgs e)
        {
            _display.EqualizerBars[2].Bar.SetValue(Freq3.Value);
        }

        private void Freq4_Scroll(object sender, EventArgs e)
        {
            _display.EqualizerBars[3].Bar.SetValue(Freq4.Value);
        }

        private void Freq5_Scroll(object sender, EventArgs e)
        {
            _display.EqualizerBars[4].Bar.SetValue(Freq5.Value);
        }

        private void Freq6_Scroll(object sender, EventArgs e)
        {
            _display.EqualizerBars[5].Bar.SetValue(Freq6.Value);
        }

        private void Freq7_Scroll(object sender, EventArgs e)
        {
            _display.EqualizerBars[6].Bar.SetValue(Freq7.Value);
        }

        private void Freq8_Scroll(object sender, EventArgs e)
        {
            _display.EqualizerBars[7].Bar.SetValue(Freq8.Value);
        }

        private void Freq9_Scroll(object sender, EventArgs e)
        {
            _display.EqualizerBars[8].Bar.SetValue(Freq9.Value);
        }

        private void Freq10_Scroll(object sender, EventArgs e)
        {
            _display.EqualizerBars[9].Bar.SetValue(Freq10.Value);
        }
    }
}
