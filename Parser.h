#ifndef PARSER_H
#define PARSER_H
#include <vector>

using namespace std;

class Parser
{
private:
    vector<string>two; /*holding strings of 1 and 0*/
    vector<string>basket; /*holding strings of 1 and 0s, 00 and 11 are in separate elements*/
public:
    Parser() {}
    vector<string> get_two ()
    {
        return two;
    }
    vector<string> get_basket ()
    {
        return basket;
    }
    vector<string> MainParser(string b)
    {
        parser_10(b); //populate vector<string>two
        parser_string(); //populate vector<string>basket
        return basket;
    }
    void parser_10(string binary)
    {
        stringstream iss(binary);
        char c;
        int i = 0;
        string tempstring;
        while (iss)
        {
            iss >> c;
            tempstring = c;
            iss >> c;
            tempstring +=c;
            two.push_back(tempstring);
            //cout << two.at(i) << "("<<i<<")" << "\t";
            i++;
        }
    }
    void parser_string()
    {
        int i = 0; //for two element
        while (i<two.size())
        {
            if (two.at(i)!="00" && two.at(i) != "11")
            {
                if(basket.empty()) //for the first one
                {
                    basket.push_back(two.at(i));
                }
                else if (basket.back() == "00" || basket.back() == "11")
                {
                    basket.push_back(two.at(i));
                }
                else if (basket.back() != "00" && basket.back() != "11")
                {
                    basket.back() += two.at(i);
                }
            }
            else if (two.at(i)=="00" || two.at(i) == "11")
            {
                basket.push_back(two.at(i));
            }
            i++;
        }
    }





};

#endif // PARSER_H
