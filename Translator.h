#ifndef TRANSLATOR_H
#define TRANSLATOR_H
#include <vector>
using namespace std;

class Translator
{
public:
    Translator() {}
    string translates(string key)
    {
        vector<string> binarystring;
        binarystring.push_back("11");
        binarystring.push_back("00");
        binarystring.push_back("1001");
        binarystring.push_back("01101010");
        binarystring.push_back("01100110");
        binarystring.push_back("011010");
        binarystring.push_back("10");
        binarystring.push_back("10100110");
        binarystring.push_back("010110");
        binarystring.push_back("10101010");
        binarystring.push_back("1010");
        binarystring.push_back("10010101");
        binarystring.push_back("011001");
        binarystring.push_back("10011010");
        binarystring.push_back("0101");
        binarystring.push_back("0110");
        binarystring.push_back("010101");
        binarystring.push_back("10010110");
        binarystring.push_back("01011001");
        binarystring.push_back("100110");
        binarystring.push_back("101010");
        binarystring.push_back("01");
        binarystring.push_back("101001");
        binarystring.push_back("10101001");
        binarystring.push_back("100101");
        binarystring.push_back("01101001");
        binarystring.push_back("01100101");
        binarystring.push_back("01011010");
        binarystring.push_back("0101010101");
        binarystring.push_back("1001010101");
        binarystring.push_back("1010010101");
        binarystring.push_back("1010100101");
        binarystring.push_back("1010101001");
        binarystring.push_back("1010101010");
        binarystring.push_back("0110101010");
        binarystring.push_back("0101101010");
        binarystring.push_back("0101011010");
        binarystring.push_back("0101010110");
        binarystring.push_back("100101100110");
        binarystring.push_back("010101101010");
        binarystring.push_back("010110100101");
        binarystring.push_back("10101001101001");
        binarystring.push_back("0110101001");
        binarystring.push_back("011001100101");
        binarystring.push_back("100110011001");
        binarystring.push_back("101001011010");
        binarystring.push_back("0110100110");
        binarystring.push_back("100101010110");

        vector<string> translatedstring;
        translatedstring.push_back(" ");
        translatedstring.push_back("");
        translatedstring.push_back("A");
        translatedstring.push_back("B");
        translatedstring.push_back("C");
        translatedstring.push_back("D");
        translatedstring.push_back("E");
        translatedstring.push_back("F");
        translatedstring.push_back("G");
        translatedstring.push_back("H");
        translatedstring.push_back("I");
        translatedstring.push_back("J");
        translatedstring.push_back("K");
        translatedstring.push_back("L");
        translatedstring.push_back("M");
        translatedstring.push_back("N");
        translatedstring.push_back("O");
        translatedstring.push_back("P");
        translatedstring.push_back("Q");
        translatedstring.push_back("R");
        translatedstring.push_back("S");
        translatedstring.push_back("T");
        translatedstring.push_back("U");
        translatedstring.push_back("V");
        translatedstring.push_back("W");
        translatedstring.push_back("X");
        translatedstring.push_back("Y");
        translatedstring.push_back("Z");
        translatedstring.push_back("0");
        translatedstring.push_back("1");
        translatedstring.push_back("2");
        translatedstring.push_back("3");
        translatedstring.push_back("4");
        translatedstring.push_back("5");
        translatedstring.push_back("6");
        translatedstring.push_back("7");
        translatedstring.push_back("8");
        translatedstring.push_back("9");
        translatedstring.push_back("@");
        translatedstring.push_back(":");
        translatedstring.push_back(",");
        translatedstring.push_back("$");
        translatedstring.push_back("=");
        translatedstring.push_back("!");
        translatedstring.push_back(".");
        translatedstring.push_back("?");
        translatedstring.push_back("/");
        translatedstring.push_back("'");

        for (int i = 0; i<binarystring.size();i++)
        {
            if (key == binarystring.at(i))
            {
                return translatedstring.at(i);
            }
        }
        return 0;
    }
};

#endif // TRANSLATOR_H
