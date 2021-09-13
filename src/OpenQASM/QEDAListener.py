from antlr4 import *
from OpenQASM.qasm3Listener import qasm3Listener
import os


def INCLUDE(file):
    f = os.getcwd() + '/' + file.getText().split('"')[1]
    input_stream = FileStream(fileName=f, encoding='utf-8')
    #open(f, 'r')
    # tokenize
    lexer = Lexer(input_stream)
    stream = CommonTokenStream(lexer)
    parser = qasm3Parser(stream)
    tree = parser.program()
    listener = qasm3Listener()
    walker = ParseTreeWalker()
    walker.walk(listener, tree)
    return listener

class QEDAListener(qasm3Listener):
    def __init__(self):
        super()

    
