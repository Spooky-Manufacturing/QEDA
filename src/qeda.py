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
import sys
from docopt import docopt
from antlr4 import *
from OpenQASM.qasm3Lexer import qasm3Lexer
from OpenQASM.qasm3Parser import qasm3Parser
from QEDAListener import QEDAListener

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

    def _getFileStream(self):
        self.input_stream = FileStream(self.qfile)

    def _getTokenStream(self):
        self.lexer = qasm3Lexer(self.input_stream)

    def _getParser(self):
        self.parser = qasm3Parser(self.lexer)

    def _getTree(self):
        self.tree = parser.program()

    def _getListener(self):
        self.listener = QEDAListener()

    def _getWalker(self):
        self.walker = ParseTreeWalker()

    def Walk(self):
        self.walker.walk(self.listener, self.tree)

    def ParseQFile(self):
        try:
            self._getFileStream()
            self._getTokenStream()
            self._getParser()
            self._getTree()
            self._getListener()
            self._getWalker()
            self.Walk()
        except Exception as e:
            pass

if __name__ in '__main__':
    args = docopt(__doc__, version='0.0.1')
    x = QEDA(args)
    print(x.qfile, x.callback, x.calc, x.pcb, x.schema)