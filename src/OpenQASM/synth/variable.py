class Variable:
    def __init__(self, id, expression, ttype=None):
        self.id = id
        self.expr = expression
        self.type = ttype
        if self.type == None:
            self._easy_typing()

    def _easy_typing(self):
        pass

class Integer:
    def __init__(self, id, value, bit=16, signed=False):
        self.id = id
        self.value = value
        self.bit = bit
        self.sign = signed

    def eval(self):
        return self.value

class Float:
    def __init__(self, id, value, value1=None, value2=None, bit=16, signed=False):
        self.id = id
        self.value = value
        self.bit = bit
        self.sign = signed
    
    def eval(self):
        return self.value

class Angle:
    def __init__(self, id, value, value1, value2, bit=16):
        self.id = id
        self.value = value
        self.value1 = value1
        self.value2 = value2
        self.bit = bit
    
    def eval(self):
        return self.value

class Complex:
    def __init__(self, id, a, b, im=True, bit=16):
        self.id = id
        self.a = a
        self.b = b
        self.im = im
        self.bit = bit

    def eval(self):
        return self.value
