from .instruction import Instruction
#from synthesizer import Synthesizer

class QGate:
    """
    Quantum Gate class

    used for generating quantum logic gate,
    footprints and symbols based on gate definition.
    """
    def __init__(self, signature, block):
        self.name = signature['name']
        self.ids = signature['ids']
        self.params = signature['params']
        self.block = block
        self.statements = [] # basically the internal
        # of the qgate. Only needed if flag is set to allow
        # internal gate generation, otherwise all you need
        # is inputs/outputs
        self.parse_stmts()
        self.internal = self._build_internal()
        self.symbol = self._build_symbol()
        self.fp = self._build_fp()

    def parse_stmts(self):
        for each in self.block['stmts']:
            if each['type']=='quantum':
                self.statements.append(Instruction(each['instruction']))
            elif each['type']=='timing':
                pass

    def _build_internal(self):
        """
        Builds the internal circuitry (schematic and pcb)
        """
#        synth = Synthesizer(self.block)
        pass

    def _build_symbol(self):
        pass

    def _build_fp(self):
        pass