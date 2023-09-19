# def f1(func):
#     def wrapper():
#         print("Start")
#         func()
#         print("End")
#
#     return wrapper


#######################
# def f():
#     print("hello")

#######################
# f1(f)
# print(f1(f))
# f1(f)()
#######################
# x = f1(f)
# x()
#######################
# @f1
# def f():
#     print("hello")
#
#
# f()
#######################

# @f1
# def f(a):
#     print(a)
#
#
# f("Hi")

"""
Traceback (most recent call last):
  File "/Users/sjy/dev/git/TIL_2022/python/decorator/decorator/decorator_test.py", line 35, in <module>
    f("Hi")
TypeError: wrapper() takes 0 positional arguments but 1 was given

-> 실제 구현체인 wrapper에 func() 에는 파라미터가 없어서 오류 발생

"""


# def f1(func):
#     def wrapper(*args, **kwargs):
#         print("Start")
#         func(*args, **kwargs)
#         print("End")
#
#     return wrapper
#
#
# @f1
# def f(a, b):
#     print(a, b)
#
#
# f("Hi", "world!")

#######################

def f1(func):
    def wrapper(*args, **kwargs):
        print("Start")
        val = func(*args, **kwargs)
        print("End")
        return val

    return wrapper


@f1
def add(x, y):
    return x + y


print(add(4, 6))
