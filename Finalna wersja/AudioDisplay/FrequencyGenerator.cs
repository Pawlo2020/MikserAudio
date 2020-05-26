using System.Collections.Generic;

namespace AudioDisplay
{
    /// <summary>
    /// Programowa reprezentacja generatora częstotliwości
    /// </summary>
    public class FrequencyGenerator
    {
        /// <summary>
        /// Lista przechowująca wartości częstotliwości
        /// </summary>
        List<string> frequencyList;

        /// <summary>
        /// Inicjalizacja generatora częstotliwości
        /// </summary>
        public FrequencyGenerator()
        {
            frequencyList = new List<string>();
        }

        /// <summary>
        /// Generowanie częstotliwości dla czterosłupkowego wyświetlacza
        /// </summary>
        public List<string> FrequencyFour()
        {
            frequencyList.Clear();

            frequencyList.Add("80");
            frequencyList.Add("240");
            frequencyList.Add("750");
            frequencyList.Add("2200");
            frequencyList.Add("6600");
            return frequencyList;
        }

        /// <summary>
        /// Generowanie częstotliwości dla pięciosłupkowego wyświetlacza
        /// </summary>
        public List<string> FrequencyFive()
        {
            frequencyList.Clear();

            frequencyList.Add("32");
            frequencyList.Add("500");
            frequencyList.Add("2k");
            frequencyList.Add("5k");
            frequencyList.Add("8k");
            return frequencyList;
        }

        /// <summary>
        /// Generowanie częstotliwości dla sześciosłupkowego wyświetlacza
        /// </summary>
        public List<string> FrequencySix()
        {
            frequencyList.Clear();

            frequencyList.Add("32");
            frequencyList.Add("250");
            frequencyList.Add("500");
            frequencyList.Add("2k");
            frequencyList.Add("5k");
            frequencyList.Add("8k");
            return frequencyList;
        }

        /// <summary>
        /// Generowanie częstotliwości dla siedmiosłupkowego wyświetlacza
        /// </summary>
        public List<string> FrequencySeven()
        {
            frequencyList.Clear();

            frequencyList.Add("32");
            frequencyList.Add("250");
            frequencyList.Add("500");
            frequencyList.Add("1500");
            frequencyList.Add("3k");
            frequencyList.Add("5k");
            frequencyList.Add("8k");
            return frequencyList;
        }

        /// <summary>
        /// Generowanie częstotliwości dla ośmiosłupkowego wyświetlacza
        /// </summary>
        public List<string> FrequencyEight()
        {
            frequencyList.Clear();

            frequencyList.Add("32");
            frequencyList.Add("64");
            frequencyList.Add("130");
            frequencyList.Add("270");
            frequencyList.Add("650");
            frequencyList.Add("2k");
            frequencyList.Add("6k");
            frequencyList.Add("14k");
            return frequencyList;
        }

        /// <summary>
        /// Generowanie częstotliwości dla dziewięciosłupkowego wyświetlacza
        /// </summary>
        public List<string> FrequencyNine()
        {
            frequencyList.Clear();

            frequencyList.Add("32");
            frequencyList.Add("64");
            frequencyList.Add("130");
            frequencyList.Add("270");
            frequencyList.Add("650");
            frequencyList.Add("1k");
            frequencyList.Add("2k");
            frequencyList.Add("8k");
            frequencyList.Add("14k");
            return frequencyList;
        }

        /// <summary>
        /// Generowanie częstotliwości dla dziesięciosłupkowego wyświetlacza
        /// </summary>
        public List<string> FrequencyTen()
        {
            frequencyList.Clear();

            frequencyList.Add("32");
            frequencyList.Add("64");
            frequencyList.Add("130");
            frequencyList.Add("270");
            frequencyList.Add("650");
            frequencyList.Add("1k");
            frequencyList.Add("2k");
            frequencyList.Add("4k");
            frequencyList.Add("8k");
            frequencyList.Add("16k");
            return frequencyList;
        }
    }
}