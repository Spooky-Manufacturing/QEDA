#!/usr/bin/python3
"""Usage:
qeda PATH [-s] [-p] [-c] [--callback=url]

Arguments:
    PATH    destination path

Options:
    -h --help       Show this help message and exit
    --version       Show version and exit
    -s --schematic  Build Schematics
    -p --pcb        Build PCB
    -c --calculate  Calculate Success Propabilities
    --callback=URL  Callback URL to notify when finished
"""
from docopt import docopt

class QEDA:
    def __init__(self, args):
        self.callback = args['--callback'] or None
        self.calc = args['--calculate'] or False
        self.pcb = args['--pcb'] or False
        self.schema = args['--schematic'] or False
        self.qfile = args['PATH'] or ""
    
    def Callback(self):
        """Used to notify the callback URL"""
        pass

    def CalculateProbabilities(self):
        pass

    def GenerateSchematic(self):
        pass

    def GeneratePCB(self):
        pass

    def ParseQFile(self):
        pass

if __name__ in '__main__':
    args = docopt(__doc__, version='0.0.1')
    x = QEDA(args)
    print(x.qfile, x.callback, x.calc, x.pcb, x.schema)