#include <bits/stdc++.h>
using namespace std;

int modular(int base, unsigned int exp)
{
    unsigned int mod = 998244353;
    int x = 1;
    int i;
    int power = base % mod;

    for (i = 0; i < sizeof(int) * 8; i++)
    {
        int least_sig_bit = 0x00000001 & (exp >> i);
        if (least_sig_bit)
            x = (x * power) % mod;
        power = (power * power) % mod;
    }

    return x;
}

int main()
{
    // Write C++ code here
    int t;
    cin >> t;
    while (t--)
    {
        int n, m, k;
        cin >> n;
        cin >> m;
        cin >> k;
        int odd = ceil(m / 2.0);
        int even = m - odd;
        unsigned long ans = modular(n, k) * modular(odd, n);
        for (int i = n - 1; i > 0; i--)
        {
            ans += (modular(i, k) * modular(odd, i) * modular(even, (n - i)) * n);
        }
        cout << ans << endl;
    }
    return 0;
}