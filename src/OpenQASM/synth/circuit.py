class Circuit:
    def __init__(self):
        self.qubits = [
            {
            'id':'q0',
            'gates':[]
            },
            {
                
            }
        ]

    def add_qubit(self, qubit):
        x = {
            'id':qubit['id']
        }
        self.qubits.append(x)

    def add_qregister(self, qregister):
        qubit = 0
        for qubit in range(qubit, len(int(qubit['designators']))):
            x={
                'id':qregister['id']+str(qubit)
            }
            self.qubits.append(x)

    def add_bit(self, bit):
        pass

    def add_register(self, bit):
        pass

    def add_qgate(self, qubit, qgate):
        gate_added = False
        for q in self.qubits:
            if q['id'] == qubit:
                q['gates'].append(qgate)
                gate_added = True
                break
        if not gate_added:
            x = {
                'id':q,
                'gates':[qgate]
            }
            self.qubits.append(x)