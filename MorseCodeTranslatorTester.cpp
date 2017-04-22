#include <iostream>
#include <vector>
#include <algorithm>
#include <fstream>
#include <sstream>
#include <bitset>
#include "Parser.h"
#include "Translator.h"


using namespace std;

string file();

int main()
{
    string final;
    /*************Reading from File******************/
    string longbistring = file();
    //cout << "Binary String: " << longbistring << endl;
    
    
    /*************Parsing****************************/
    Parser divider;
    vector<string> basket = divider.MainParser(longbistring);
    
    //    cout << "In main......" << endl;
    //    for (int i = 0; i<basket.size(); i++)
    //    {
    //        cout << basket.at(i) << "("<<i<<")" << "\t";
    //    }
    //    cout << "In main......" << endl;
    
    
    /*************Translating***********************/
    Translator decoder;
    for (int m = 0; m<basket.size(); m++)
    {
        final += decoder.translates(basket.at(m));
    }
    cout << "Translation: " << final << endl;
    
}


string file ()
{
    char c;
    string longbinary;
    ifstream file("Morse.bin", ios::binary);
    while (!file.eof())
    {
        file >> c;
        bitset<8> b = c;
        longbinary += b.to_string();
    }
    return longbinary;
}


