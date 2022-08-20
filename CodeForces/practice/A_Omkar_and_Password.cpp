#include <bits/stdc++.h>

using namespace std;

#ifdef LOCAL
#include "algo/debug.h"
#else
#define debug(...) 42
#endif

int minv(vector<int> arr, int index)
{
    vector<int> oarr(arr);
    debug(arr, index);
    bool allSame = adjacent_find(arr.begin(), arr.end(), std::not_equal_to<>()) == arr.end();
    if (allSame || arr.size() == 1)
    {
        return arr.size();
    }
    if ((index + 1) < arr.size() && arr.at(index) != arr.at(index + 1))
    {
        arr.at(index) = arr.at(index) + arr.at(index + 1);
        arr.erase(arr.begin() + index + 1);
        debug(arr);
    }
    int min = arr.size();
    for (int i = 0; i < arr.size() - 1; i++)
    {
        debug(arr, min, i);
        if (arr.at(i) != arr.at(i + 1))
        {
            debug(arr, min, i);

            int mint = minv(arr, i);
            if (mint < min)
            {
                min = mint;
            }
        }
    }

    return min;
}

int main()
{
    int t;
    cin >> t;

    while (t--)
    {
        int n;
        cin >> n;
        vector<int> arr;
        for (size_t i = 0; i < n; i++)
        {
            int temp;
            cin >> temp;
            arr.push_back(temp);
        }
        int out = n;


          if((adjacent_find(arr.begin(), arr.end(), std::not_equal_to<>()) == arr.end())) {
                    cout << n << endl;
        } else {
            cout << 1 << endl;
        }

        // for (size_t j = 0; j < n; j++)
        // {
        //     int i = j;
        //     vector<int> cloneArr(arr);
        //     // debug(cloneArr);
        //     while(i+1 < cloneArr.size() &&  cloneArr.at(i) != cloneArr.at(i + 1)){
        //         // debug(i, cloneArr);
        //         if((adjacent_find(arr.begin(), arr.end(), std::not_equal_to<>()) == arr.end())) {
        //             break;
        //         }
        //         cloneArr.at(i) = cloneArr.at(i) + cloneArr.at(i + 1);
        //         cloneArr.erase(cloneArr.begin() + i + 1); 
        //         //   debug(cloneArr);
        //     }
        //     debug(cloneArr);
        //     while(i-1 >= 0 &&  cloneArr.at(i) != cloneArr.at(i - 1)){
        //         if((adjacent_find(arr.begin(), arr.end(), std::not_equal_to<>()) == arr.end())) {
        //             break;
        //         }
        //         cloneArr.at(i) = cloneArr.at(i) + cloneArr.at(i - 1);
        //         cloneArr.erase(cloneArr.begin() + i - 1); 
        //         i--;
        //     }

        //        debug(cloneArr);
        //     if(cloneArr.size() < out) {
        //         out = cloneArr.size();
        //     }
        //     if(out == 1) {
        //         break;
        //     }
        // }
        

        //recursive
        // for (size_t i = 0; i < n; i++)
        // {
        //     int size = minv(arr, i);
        //     if (size < out)
        //     {
        //         out = size;
        //     }
        // }

        // cout << out << endl;
    }

    // while (t--)
    // {
    //     int n;
    //     cin >> n;
    //     vector<int> arrm;
    //     for (size_t i = 0; i < n; i++)
    //     {
    //         int temp;
    //         cin >> temp;
    //         arrm.push_back(temp);
    //     }

    //     int min = arrm.size();
    //     for (size_t startIndex = 0; startIndex < 2; startIndex++)
    //     {
    //         vector<int> arr(arrm);
    //         int index = startIndex;
    //         while (index < (arr.size() - 1) && arr.at(index) != arr.at(index + 1))
    //         {
    //             debug(arr.at(index), arr.at(index + 1));
    //             arr.at(index) = arr.at(index) + arr.at(index + 1);
    //             arr.erase(arr.begin() + index + 1);
    //             if (arr.size() <= 2)
    //             {
    //                 break;
    //             }
    //         }
    //         while (adjacent_find(arr.begin(), arr.end(), std::not_equal_to<>()) != arr.end())
    //         {
    //             for (int k = 0; k < arr.size() - 1; k++)
    //             {
    //                 debug(arr.at(k), arr.at(k + 1));
    //                 arr.at(k) = arr.at(k) + arr.at(k + 1);
    //                 arr.erase(arr.begin() + k + 1);
    //                 if (arr.size() <= 2)
    //                 {
    //                     break;
    //                 }
    //             }
    //         }
    //         if(arr.size() < min ) {
    //             min = arr.size();
    //         }
    //         if(min == 1) {

    //             break;
    //         }
    //     }

    //     cout << min << endl;

    // for (int j = 0; j < n - 1; j++)
    // {
    //     debug(arr);
    //     while (j < (arr.size() - 1) && arr.at(j) != arr.at(j + 1))
    //     {
    //         debug(arr.at(j), arr.at(j+1));
    //         arr.at(j) = arr.at(j) + arr.at(j + 1);
    //         arr.erase(arr.begin() + j + 1);
    //         if (arr.size() <= 2)
    //         {
    //             break;
    //         }
    //     }
    // }
    // if(arr.at(0) != arr.at(1)){
    //     cout <<  arr.size() - 1  << endl;
    // } else {
    // cout << arr.size() << endl;
    // }
    // }
    return 0;
}