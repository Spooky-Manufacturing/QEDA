class Translator:
    """Translator
    The translator class is used to translate the Intermediate Representation (QCode) into
    an easier to parse circuit definition (QCirc) for use by the Synthesizer
    """
    def __init__(self, qubits, bits, declarations, constants, functions, statements):
        self.qubits = qubits
        self.bits = bits
        self.declarations = declarations
        self.constants = constants
        self.func = functions
        self.stmt = statements
        self.CIRC = {}
        self.gen_bits()
        self.gen_qubits()
        self.parse_subroutines()
        self.parse_statements()

    def gen_bits(self):
        """
        Generates the bits in QCircuit
        """
        for bit in self.bits:
            if 'designator' in bit:
                self.CIRC[str(bit['id'])] = {}
                for i in range(int(bit['designator'])):
                    self.CIRC[str(bit['id'])][str(i)] = []
            else:
                self.CIRC[bit['id']] = []

    def gen_qubits(self):
        """
        Generates the qubits in QCircuit
        """
        for qubit in self.qubits:
            if 'designators' in qubit:
                i = 0
                if len(qubit['designators']) > 0:
                    self.CIRC[str(qubit['id'])] = { }
                    for each in qubit['designators']:
                        self.CIRC[str(qubit['id'])][str(i)] = []
                        i+=1
                else:
                    self.CIRC[str(qubit['id'])] = []
            elif 'designator' in qubit:
                self.CIRC[str(qubit['id'])] = {}
                for i in range(qubit['designator']):
                    self.CIRC[str(qubit['id'])][str(i)] = []
            else:
                self.CIRC[str(qubit['id'])] = []

    def _in_circuit(self, id):
        """
        checks if a given id defined in circuit
        """
        if id in self.CIRC:
            return True
        return

    def _apply_to_id_index(self, id, index, op, mods=None, exps=None):
        """Applies a given gate to an index of an id"""
        id = id[0]
        if type(mods) == type([]):
            if len(mods) > 0:
                raise Warning("Modifiers are not currently supported.")

        if not self._in_circuit(id['id']):
            self.CIRC[id['id']]={}
        if str(index) not in self.CIRC[id['id']]:
            self.CIRC[id['id']][str(index)] = []
        self.CIRC[id['id']][str(index)].append(op)

    def _apply_to_ids(self, idList, op, mods=None, exps=None):
        """Applies a given gate to a list of ids"""
        if type(mods) == type([]):
            if len(mods) > 0:
                raise Warning("Modifiers are not currently supported.")
        if len(idList) > 1:
            for id in idList:
                expr = id['exprList']
                if not self._in_circuit(id['id']):
                    self.CIRC[id['id']]={}
                for each in expr:
                    i=0
                    if str(i) not in self.CIRC[id['id']]:
                        self.CIRC[id['id']][str(i)] = []
                    self.CIRC[id['id']][str(i)].append(op)
                    i+= 1
        elif len(idList) > 0:
            # Gate should be applied to all ids
            id = idList[0]['id']
            for key in self.CIRC[id]:
                self.CIRC[id][key].append(op)
        else:
            for key in self.CIRC.keys():
                for each in self.CIRC[key]:
                    self.CIRC[key][each].append(op)

    def _parse_instruction(self, ids, instruction):
        """
        parses an instruction statement
        """
        if instruction['type'] == 'quantumReset':
            self._apply_to_ids(ids, 'RESET')
        elif instruction['type'] == 'quantumGateCall':
            name = instruction['name']
            mods = instruction['mods']
            exps = instruction['exps']
            self._apply_to_ids(ids, name, mods, exps)
        elif instruction['type'] == 'quantumBarrier':
            self._apply_to_ids(ids, 'BARRIER')

    def _parse_alias(self, alias, n=0):
        """
        Parses an alias statement
        """
        print("Alias statements are unsupported at this time. {}".format(alias))

    def _parse_assignment(self, assign, n=0):
        """Parses an assignment statement"""
        if 'type' in assign:
            if assign['type'] == 'quantumMeasurementAssignment':
                # Get the input ID
                inputs = assign['qmeas']['indexIdList']
                outputs = assign['indexIdList']
                if not outputs:
                    outputs = []
                # check if we have multiple ids
                if len(inputs) > 1:
                    pass
                elif 'range' in inputs[0].keys():
                    r = range(inputs[0]['range']['exp1'], inputs[0]['range']['exp2'], inputs[0]['range']['exp3'] or 1)
                    # Apply measure to each key
                    for out in outputs:
                        for i in r:
                            if str(i) in self.CIRC[out['id']]:
                                self._apply_to_id_index([out], i, 'MEASURE_' + str(i) + '_OUT')
                    for each in inputs:
                        for i in r:
                            if str(i) in self.CIRC[each['id']]:
                                self._apply_to_id_index([each], i, 'MEASURE_' + str(i))
                else:
                    print(inputs)
    """
                # get the output IDS
                ids = assign['indexIdList']
                if not ids:
                    ids = []
                for id in ids:
                    self._apply_to_ids([id], 'MEASURE' + str(id) + '.OUT')
#                self._apply_to_ids(ids, 'MEASURE'+str(n)+'.OUT')
                # get the input IDs
                ids = assign['qmeas']['indexIdList']
                for id in ids:
                    self._apply_to_ids([id], 'MEASURE'+str(id))
            elif assign['type'] == 'classicalAssignment':
                print("Classical Assignment {}".format(assign))
    """

    def _parse_expression(self, expression):
        print("Expression statements are unsupported at this time. {}".format(expression))

    def _parse_loop(self, loop):
        print("LOOPING {}".format(loop))
        pass

    def _parse_statement(self, stmt, n=0):
        """
        Parses a single statement
        """
        if stmt['type'] in 'quantumInstruction':
            ids = stmt['instruction']['indexIdList']
            self._parse_instruction(ids, stmt['instruction'])    

        elif stmt['type'] in 'assignmentStatement':
            self._parse_assignment(stmt['assign'])

        elif stmt['type'] in 'loopStatement':
            op = stmt['sig']['op']
            expr = None
            if 'expr' in stmt['sig']:
                expr = stmt['sig']['expr']
            block = stmt['block']
            #print(op, expr, block)
            i = 0
            if 'while' in op:
                while expr:
                    for each in block:
                        self.parse_statements(each)
        elif stmt['type'] in 'expressionStatement':
            self._parse_expression(stmt['expr'])
        elif stmt['type'] in 'aliasStatement':
            self._parse_alias(stmt)
        elif stmt['type'] in 'timingStatement':
            self._parse_alias(stmt)
        else:
            print(stmt['type'], "ADD SUPPORT FOR THIS")

    def _parse_timing(self, timing):
        print("Timing statements are unsupported at this time. {}".format(timing))

    def parse_subroutines(self):
        print("Parsing subroutines")
        for each in self.func:
            pass#rint(each)
        pass

    def parse_statements(self):
        """
        Parses the statements
        """
        print("Parsing statements")
        i = 0
        for stmt in self.stmt:
            #print(stmt)
            i+=1
            self._parse_statement(stmt, i)