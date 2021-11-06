import warnings

class Instruction:
    def __init__(self, instruction):
        self.instruction = instruction['instruction']
        self.ttype = instruction['type']
        self.exps = None
        self.mods = None
        if 'exps' in self.instruction:
          self.exps = self.instruction['exps']
        if 'mods' in self.instruction:
          self.mods = self.instruction['mods']
        self.ids = []
        self.get_ids()

    def get_ids(self):
      if 'indexIdList' in self.instruction:
        print(self.instruction)
        for each in self.instruction['indexIdList']:
          id = {
            'name':None,
            'value':None
          }
          if each['exprList']!=None:
            self.ids.append(each['id'])
          else:
            # id is an input with a set value
            # This does not compute for quantum 
            # gate defintions, but isn't
            # explicitly spelled out in the qasm
            # specifications so let's warn the user
            # for now.
            warnings.warn("""An expression list was found for 
            gate definition {} which is not currently supported by
            QEDA. Please manually validate this circuit.""".format(self.name))
      elif 'id' in self.instruction:
          self.ids.append(self.instruction['id'])
      else:
        print("NO ID FOUND", self.instruction)
"""
self.instruction = xx
self.type = 'quantumInstruction'
self.mods = []
self.ids = ['a']
  {
    'type': 'quantumGateDef',
    'sig': {
      'name': 'y',
      'ids': [
        
      ],
      'params': [
        'a'
      ]
    },
    'block': {
      'type': 'quantumBlock',
      'stmts': [
        {
          'type': 'quantum',
          'instruction': {
            'type': 'quantumInstruction',
            'instruction': {
              'name': 'U',
              'mods': [
                
              ],
              'exps': [
                3.141519
              ],
              'ids': [
                {
                  'id': 'a',
                  'exprList': [
                  ]
                }
              ]
            }
          }
        }
      ],
      'loops': []
    }
  },"""