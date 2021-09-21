class QCode():
    def __init__(self):
        self.version = "v0.0.1"
        self.functions = []
        self.registers =[]
        self.quantum_registers = []
        self.gates = []
        pass

    def AddFunction(self, name):
        """Adds the function to QCode"""
        self.functions.append(Function(name))
        pass

    def AddRegister(self, registerName, numBits):
        """Adds a register"""
        self.registers.append(Register(registerName, numBits))
        pass

    def AddQRegister(self, registerName, numQubits):
        """Adds a quantum register"""
        self.quantum_registers.append(QRegister(registerName, numQubits))
        pass

    def AddGate(self, gateName, **kwargs):
        """Adds a new gate to QCode"""
        self.gates.append(Gate(len(self.gates), gateName, **kwargs))
        pass

    def EvaluateQCode(self):
        """Evaluates qcode tree to validate"""
        pass
    
    def ReturnFullQCode(self):
        """Returns the full qcode object 
                (You probably want GetSynthable() )
        """
        return {
        "registers": self.registers,
        "quantum-registers": self.quantum_registers,
        "functions": self.functions,
        "gates": self.gates
        }

    def GetSynthable(self):
        """Parses QCode and returns a synthesizable dictionary for circuit generation"""
        #qcode = self.ReturnFullQCode()
        ops = {}
        for i in range(self.gates):
            ops[self.gates[i].id] = self.gates[i]
        sorted_keys = sorted(ops.keys())
        sorted_ops = {}
        i = 0
        for key in sorted_keys:
            for each in ops[key].op:
                sorted_ops[i] = each
                i+=1
        return sorted_ops

class Function:
    def __init__(self, name):
        self.name = name

class Register:
    def __init__(self, name, bits):
        self.bits = bits
        self.name = name

class QRegister:
    def __init__(self, name, bits):
        self.bits = bits,
        self.name = name

class Gate:
    def __init__(self, gateId, name, inputs=None, outputs=None, ttype="UNITARY", ordered_operations={}):
        self.id = gateId
        self.name = name
        self.inputs = inputs
        self.outputs = outputs
        self.ttype = ttype
        self.op = ordered_operations