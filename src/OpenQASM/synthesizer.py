"""
Synthesizes the code.
"""
from OpenQASM.QAST import Header
from OpenQASM.synth.builtins import GATES
from OpenQASM.synth.qgate import QGate
from OpenQASM.synth.instruction import Instruction
from OpenQASM.synth.builtins import Function, Loop, Variable
from .kicad.schematic import Schematic
from .kicad.pcb import PCB
from .kicad.footprint import Footprint
from .kicad.symbol import Symbol

class Synthesizer:
    """Synthesizer

    qcode - JSON formatted QCode IR
    """
    def __init__(self, header, globs, locs, debug=False):
        self.header = header
        self.globals = globs
        self.locals = locs
        self.gatedefs = []
        self.vars = []
        self.instructions = []
        self.pcb = PCB()
        self.schema = Schematic()
        self.dbg = debug
        
        if(self.dbg):
            self.build_all_test()

    def build_all_test(self):
        print("Starting synthesis")
        #print(self.header, self.globals, self.locals)
        # Parse the globals
        self.global_parse()
        # Parse the locals
        self.local_parse()



    def global_parse(self):
        """Parses self.globals into gate and variables lists"""
        for each in self.globals:
            if each != None and each['type'] == 'quantumGateDef':
                if each['sig']['name'] in GATES:
                    print("Using built-in gate {}".format(each['sig']['name']))

                else:
                    print("Defining QGate {}".format(each['sig']['name']))
                    self.gatedefs.append(QGate(each['sig'], each['block']))
        for each in self.gatedefs:
            print(each.name)
            print(each.ids)
            print(each.params)
            for stmt in each.statements:
                print(stmt.instruction)

    def local_parse(self):
        """Parses self.locals into bits/qubits"""
        print(len(self.locals))
        for each in self.locals:
            if each != None:
                if each['type'] == 'classicalDeclaration':
                    print('classical declaration')
                elif each['type'] == 'quantumInstruction':
                    print("quantum instruction")
                    self.instructions.append(Instruction(each))
                elif each['type'] == 'assignment':
                    print("assignment")
                elif each['type'] == 'loop':
                    Loop
                    print("loop")
                elif each['type'] == 'timing':
                    print("Timing")
                elif each['type'] == 'expression':
                    print("Expression")
                elif each['type'] == 'alias':
                    print("Alias")
                else:
                    print(each['type'])
                    print(each)
        for each in self.instructions:
            print(each, each.type, each.exps, each.ids)


    def build_all(self):
        pass

    def add_gate_schema(self):
        pass

    def add_gate_pcb(self):
        pass

    def build_schematic(self):
        """
        Builds a schematic from self.qcode
        """
        pass

    def build_pcb(self):
        """
        Builds a pcb from self.qcode
        """
        pass