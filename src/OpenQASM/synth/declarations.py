class Declaration:
    def __init__(self, decl):
        self.decl = decl
        self.type = decl['type']
    def parse_type(self):
        x = self.type
        if x == "classic":
            print("Classical Declaration")
            a = Declaration(self.decl)
            a.type = x["ctype"]
            return x.parse_type()
        elif x == "noDesignator":
            print("No Designator Declaration")
        elif x == "single":
            print("Single Designator Declaration")
        elif x == "bit":
            print("Bit Declaration")
        elif x == "register": 
            print("Register Declaration")
        elif x == "complex":
            print("Complex Declaration")
        elif x == "constant":
            print("Constant Declaration")
        elif x == "quantum": 
            print("Quantum Declaration")
