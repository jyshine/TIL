Big-O

- 알고리즘의 성능을 수학적으로 표현해주는 표기법
- 시간과 공간 복잡도를 표현할 수 있다.
- 데이터나 사용자 증가율에 따른 알고리즘의 성능을 예측
- 상수와 같은 숫자들은 모두 1 이다.



표기법

O(1) contant time

입력 데이터와 상관없이 언제나 일정한 시간이 걸리는 알고리즘
```
def constant_time(n: list):
    return True if n[0] == 0 else False
```

O(n) linear time 
입력 데이터 크기에 비례해서 처리 시간이 걸리는 알고리즘
```
def linear_time(n: list):
    for i in n:
        print(i)
```

O(n²)  quadratic time
n² 은 면적 가로 n이 늘어날 때마다 세로 n이 증가하는 알고리즘
```
def quadratic_time(items):
    for item in items:
        for item2 in items:
            print(item, ' ', item)

```

O(nm)	quadratic time
n을 m 만큼 처리하는 알고리즘
```
def quadratic_time2(items, items2):
    for item in items:
        for item2 in items2:
            print(item, ' ', item2)

```

O(n³) polynomial / cubic time
n³ 은 큐빅 n²을 n만큼 반복하는 알고리즘 
```
def cubic_time(n):
    for i in n:
        for j in n:
            for k in n:
                print(i, ' ', j, ' ', k)

```


O(2ⁿ)  exponential time
Fibonacci numbers
1,1,2,3,5,8 ,… 

```
# Python program to display the Fibonacci sequence

def recur_fibo(n):
   if n <= 1:
       return n
   else:
       return(recur_fibo(n-1) + recur_fibo(n-2))

nterms = 10

# check if the number of terms is valid
if nterms <= 0:
   print("Plese enter a positive integer")
else:
   print("Fibonacci sequence:")
   for i in range(nterms):
       print(recur_fibo(i))
```


O(mⁿ) exponential time
 m개씩 n번 늘어나는 알고리즘

O(㏒ n) binary search
```
# Binary Search in python


def binarySearch(array, x, low, high):

    # Repeat until the pointers low and high meet each other
    while low <= high:

        mid = low + (high - low)//2

        if array[mid] == x:
            return mid

        elif array[mid] < x:
            low = mid + 1

        else:
            high = mid - 1

    return -1


array = [3, 4, 5, 6, 7, 8, 9]
x = 4

result = binarySearch(array, x, 0, len(array)-1)

if result != -1:
    print("Element is present at index " + str(result))
else:
    print("Not found")
```


O(sqrt(n))
square root



























 #알고리즘