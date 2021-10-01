#!/usr/bin/python3
import sys
from antlr4 import *
from OpenQASM.qasm3Lexer import qasm3Lexer
from OpenQASM.qasm3Parser import qasm3Parser
#from OpenQASM.QEDAListener import QEDAListener as Listener
from OpenQASM.QEDAListener2 import QEDAListener as Listener
def main(argv):
    input_stream = FileStream(argv[1])
    lexer = qasm3Lexer(input_stream)
    stream = CommonTokenStream(lexer)
    parser = qasm3Parser(stream)
    tree = parser.program()
    listener = Listener(argv[1])
    walker = ParseTreeWalker()
    walker.walk(listener, tree)

if __name__ in '__main__':
    main(sys.argv)
