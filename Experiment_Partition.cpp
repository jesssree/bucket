
#include <iostream>
#include <algorithm>
#include <vector>


using namespace std;
void PrintList(vector<int> &array)
{
    for_each(array.begin(), array.end(), [](int num){cout << num << endl;});
}
void swap(int &value1, int &value2)
{
    int temp = value1;
    value1 = value2;
    value2 = temp;
}
int partition(vector<int> &array, int start, int finish)
{
    //7, 3, 9, 2, 0, 1, 8, 4, 6, 5
    /*
     0, 3, 9, 2, 7, 1, 8, 4, 6, 5
     */
    cout << "start: " << start << endl;
    cout << "finish: " << finish << endl;
    int pivotValue, pivotIndex, mid;
    mid = (start+finish)/2;
   
    swap(array[start], array[mid]);
    pivotIndex = start;
    pivotValue = array[start];
    for (int i = start +1 ; i<= finish; i++)
    {
        cout << "If " << array[i] << " is < than " <<  array[pivotIndex] << " " ;
        if(array[i] < array[pivotIndex])
        {
            cout << "Yes -> swap" << endl;
            pivotIndex++;
            swap(array[pivotIndex], array[i]);
            for (int i= 0; i< array.size(); i++)
                cout << array[i] << " " ;
            cout << endl << endl;
           
        }
        else
            cout << "NO" << endl;
        
        
    }
    swap(array[start], array[pivotIndex]);
    for (int i= 0; i< array.size(); i++)
        cout << array[i] << " " ;
    cout << endl;
    cout << "pivotIndex: " << pivotIndex << endl;
    return pivotIndex;
}
void quickSort(vector<int> &array, int start, int finish)
{
    
    int pivot;
    if (start < finish)
    {
        pivot = partition(array, start, finish);
        cout << "pivot returned is " << pivot << endl;
        quickSort(array, start, pivot-1);
        quickSort(array, pivot+1, finish);
    }
    
}

int main()
{
    vector<int> list = {7, 3, 9, 2, 0, 1, 8, 4, 6, 5};
    for (int i= 0; i< list.size(); i++)
        cout << list[i] << " " ;
    cout << endl << endl;
    //PrintList(list);
    quickSort(list, 0, 9);
    cout << endl;
    for (int i= 0; i< list.size(); i++)
        cout << list[i] << " " ;
    
    
}