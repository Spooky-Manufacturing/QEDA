class Component:
    def __init__(self):
        self.name = None
        self.footprint = None
        self.qid = None
        self.successProbability = 0.9

    def set_probability(self):
        pass

    def get_component_from_libs(self, lib, component):
        pass

    def get_component_from_decomposition(self, unitary):
        pass

class QCode:
    def __init__(self):
        self.qubits = []
        pass

    def AddQubit(self, qubit=None):
        if(qubit == None):
            if(len(self.qubits)!=0):
                qubit = Qubit(qid=len(self.qubits)-1)
            else:
                qubit = Qubit(qid=0)
        try:
            qubit.left = self.qubits[len(self.qubits)-2]
            qubit.left.right = qubit
        qubit.right = self.qubits[len(self.qubits)] or None
        except Exception as e:
            print(e)
        self.qubits.append(qubit)

class Qubit:
    def __init__(self, qid=0, left=None, right=None):
        self.qid = qid
        self.left = left
        self.right = right
        self.components = {
            0:"SPS"
        }
    def calculate_probabilities(self):
        pass

