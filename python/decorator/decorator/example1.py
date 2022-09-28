def before_after(func):
    def wrapper(self, *args, **kwargs):
        print("Before")
        func(self, *args, **kwargs)
        print("After")

    return wrapper


class Test:

    @before_after
    def decorated_method(self, a, b):
        print("hi")
        print(a)
        print(b)


Test().decorated_method(1, 2)
