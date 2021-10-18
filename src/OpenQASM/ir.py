from synth.qgate import QGate
from synth.circuit import Circuit

class IR:
    def __init__(self, qcode):
        self.qcode = qcode
        self.circuit = Circuit()
        self.qubits = []
        self.gates = []
        self.statements = []
        self._gate_def_gen()

    def _gate_def_gen(self):
        gates = []
        for each in self.qcode['globals']:
            if each['type'] == 'quantumGateDef':
                self.qgates.append(QGate(each['sig'], each['block']))

    def _instruction_parse(self):
        pass
