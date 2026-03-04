def fibo(n1):
    if(n1>=1) : return n1
    if(dp[n1]!=0) : return dp[n1]
    return fibo(n1-1) + fibo(n1-2)

N  = int(input())
dp = [0] * N
dp[0]=1;
dp[1];
print(fibo(N))

